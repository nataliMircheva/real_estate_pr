package com.real_estate_academy_project.real_estate_pr.service.impl;

import com.real_estate_academy_project.real_estate_pr.exception.DuplicateRecordException;
import com.real_estate_academy_project.real_estate_pr.exception.ResourceNotFoundException;
import com.real_estate_academy_project.real_estate_pr.model.City;
import com.real_estate_academy_project.real_estate_pr.model.Neighborhood;
import com.real_estate_academy_project.real_estate_pr.repository.CityRepository;
import com.real_estate_academy_project.real_estate_pr.service.CityService;
import com.real_estate_academy_project.real_estate_pr.service.NeighborhoodService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final NeighborhoodService neighborhoodService;

    public CityServiceImpl(CityRepository cityRepository, NeighborhoodService neighborhoodService) {
        this.cityRepository = cityRepository;
        this.neighborhoodService = neighborhoodService;
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("City with this %d does not exists",id)));
    }

    @Override
    public City save(City city) {
        try { Set<Neighborhood> neighborhoods = new HashSet<>();
            for (Neighborhood neighborhood : city.getNeighborhoods()) {
                Neighborhood foundNeighborhood = neighborhoodService.findById(neighborhood.getId());
                neighborhoods.add(foundNeighborhood);
            }
              return   cityRepository.save(City.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .neighborhoods(neighborhoods)
                        .build());


        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRecordException(String.format("City with name %d already exists",city));
        }

    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with name %d does not exists",name)));
    }

    @Override
    public City update(City city, Long id) {
        City foundCity = findById(id);
        City updatedCity = City.builder()
                .id(foundCity.getId())
                .name(city.getName())
                .neighborhoods(city.getNeighborhoods())
                .build();

        return cityRepository.save(updatedCity);
    }

    @Override
    public Set<City> findAll() {
        return new HashSet<>(cityRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void detachCityNeighborhoods(Long cityId, Set<Long> neighborhoodIds) {
        City foundCity = findById(cityId);
        foundCity.getNeighborhoods().removeIf(neighborhood -> neighborhoodIds.contains(neighborhood.getId()));
        cityRepository.save(foundCity);
    }
}
