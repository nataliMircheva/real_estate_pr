package com.real_estate_academy_project.real_estate_pr.repository;

import com.real_estate_academy_project.real_estate_pr.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Long> {

    Optional<Neighborhood> findByName (String name);
}
