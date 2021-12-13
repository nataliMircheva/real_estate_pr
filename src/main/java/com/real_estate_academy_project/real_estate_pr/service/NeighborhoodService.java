package com.real_estate_academy_project.real_estate_pr.service;

import com.real_estate_academy_project.real_estate_pr.model.Neighborhood;

import java.util.Set;

public interface NeighborhoodService {

    Neighborhood save (Neighborhood neighborhood);
    Neighborhood findById (Long id);
    Neighborhood update (Neighborhood neighborhood, Long id);
    Neighborhood findByName (String name);
    void delete (Long id);
    Set<Neighborhood> findAll ();
}
