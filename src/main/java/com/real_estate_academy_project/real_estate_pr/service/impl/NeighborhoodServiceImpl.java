package com.real_estate_academy_project.real_estate_pr.service.impl;

import com.real_estate_academy_project.real_estate_pr.exception.DuplicateRecordException;
import com.real_estate_academy_project.real_estate_pr.exception.ResourceNotFoundException;
import com.real_estate_academy_project.real_estate_pr.model.Neighborhood;
import com.real_estate_academy_project.real_estate_pr.repository.NeighborhoodRepository;
import com.real_estate_academy_project.real_estate_pr.service.NeighborhoodService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    @Override
    public Neighborhood save(Neighborhood neighborhood) {
        try {
            return neighborhoodRepository.save(neighborhood);
        }catch (DataIntegrityViolationException exception){
            throw  new DuplicateRecordException(String.format("Neighborhood with this name %d already exists",neighborhood.getName()));
        }

    }

    @Override
    public Neighborhood findById(Long id) {
        return neighborhoodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with id %d does not exists",id)));
    }

    @Override
    public Neighborhood update(Neighborhood neighborhood, Long id) {
        Neighborhood foundNeighborhood = findById(id);
        Neighborhood updatedNeighborhood = Neighborhood.builder()
                .id(foundNeighborhood.getId())
                .name(neighborhood.getName())
                .build();
        return save(updatedNeighborhood);
    }

    @Override
    public Neighborhood findByName(String name) {
        return neighborhoodRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with name %d does not exists",name)));
    }

    @Override
    public void delete(Long id) {
        neighborhoodRepository.deleteById(id);

    }

    @Override
    public Set<Neighborhood> findAll() {
        return new HashSet<>(neighborhoodRepository.findAll());
    }
}
