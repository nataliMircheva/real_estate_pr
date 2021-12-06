package com.real_estate_academy_project.real_estate_pr.service;

import com.real_estate_academy_project.real_estate_pr.model.Floor;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface FloorService {

    Floor save (Floor floor);
    Floor findByNumber (Integer number);
    Floor update(Floor floor,Long id);
    Floor findById(Long id);
    void  delete(Long id);
    Set<Floor> findAll();
}
