package com.real_estate_academy_project.real_estate_pr.service;

import com.real_estate_academy_project.real_estate_pr.model.City;

import java.util.Set;

public interface CityService {
    City findById (Long id);
    City save (City city);
    City findByName (String name);
    City update (City city, Long id);
    Set<City> findAll();
    void delete (Long id);
    void detachCityNeighborhoods (Long cityId, Set<Long> neighborhoodIds);
}
