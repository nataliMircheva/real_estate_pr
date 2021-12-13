package com.real_estate_academy_project.real_estate_pr.repository;

import com.real_estate_academy_project.real_estate_pr.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName (String name);
}
