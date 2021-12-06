package com.real_estate_academy_project.real_estate_pr.repository;

import com.real_estate_academy_project.real_estate_pr.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FloorRepository extends JpaRepository<Floor, Long> {

     Optional<Floor> findByNumber (Integer number);
}
