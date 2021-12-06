package com.real_estate_academy_project.real_estate_pr.service.impl;

import com.real_estate_academy_project.real_estate_pr.exception.DuplicateRecordException;
import com.real_estate_academy_project.real_estate_pr.exception.ResourceNotFoundException;
import com.real_estate_academy_project.real_estate_pr.model.Floor;
import com.real_estate_academy_project.real_estate_pr.repository.FloorRepository;
import com.real_estate_academy_project.real_estate_pr.service.FloorService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class FloorServiceImpl implements FloorService {
     private FloorRepository floorRepository;

    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }


    @Override
    public Floor save(Floor floor) {
        try {
         return  floorRepository.save(floor);
        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRecordException(String.format("Floor with number %d already exists",floor.getNumber()));
        }
    }

    @Override
    public Floor findByNumber(Integer number) {
        return floorRepository.findByNumber(number)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Floor with %d not found",number)));
    }

    @Override
    public Floor update(Floor floor, Long id) {
        Floor foundFloor = findById(id);
        Floor updateFloor = Floor.builder()
                .id(foundFloor.getId())
                .number(floor.getNumber())
                .build();
        return  save(updateFloor);
    }

    @Override
    public Floor findById(Long id) {
        return floorRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Floor with %d not found",id)));
    }

    @Override
    public void delete(Long id) {
        floorRepository.deleteById(id);
    }

    @Override
    public Set<Floor> findAll() {
        return new TreeSet<>(Comparator.comparing(Floor::getId));
    }
}
