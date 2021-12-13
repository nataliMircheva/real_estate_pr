package com.real_estate_academy_project.real_estate_pr.controller;

import com.real_estate_academy_project.real_estate_pr.converter.NeighborhoodConverter;
import com.real_estate_academy_project.real_estate_pr.dto.NeighborhoodDto;
import com.real_estate_academy_project.real_estate_pr.model.Neighborhood;
import com.real_estate_academy_project.real_estate_pr.service.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/neighborhoods")
public class NeighborhoodController {
    private final NeighborhoodService neighborhoodService;
    private final NeighborhoodConverter neighborhoodConverter;
@Autowired
    public NeighborhoodController(NeighborhoodService neighborhoodService,  NeighborhoodConverter neighborhoodConverter) {
        this.neighborhoodService = neighborhoodService;
        this.neighborhoodConverter = neighborhoodConverter;

    }

    @GetMapping
    public ResponseEntity<Set<NeighborhoodDto>> findAll(){
        return ResponseEntity.ok(neighborhoodService.findAll()
                .stream()
                .map(neighborhoodConverter::toNeighborhoodDto)
                .collect(Collectors.toSet()));
    }

    @GetMapping(value = "/{name}")

    public ResponseEntity<NeighborhoodDto> findByName (String name){
    return ResponseEntity.ok(neighborhoodConverter.toNeighborhoodDto(neighborhoodService.findByName(name)));
    }

    @PostMapping
    public  ResponseEntity<NeighborhoodDto> save (@RequestBody @Valid NeighborhoodDto neighborhoodDto){
    Neighborhood newNeighborhood = neighborhoodConverter.toNeighborhood(neighborhoodDto);
    Neighborhood saveNeighborhood = neighborhoodService.save(newNeighborhood);
    NeighborhoodDto neighborhoodDto1 = neighborhoodConverter.toNeighborhoodDto(saveNeighborhood);
    return ResponseEntity.ok(neighborhoodDto1);

    //ekvivalentni
   // return ResponseEntity.ok(neighborhoodConverter
         //   .toNeighborhoodDto(neighborhoodService
          //          .save(neighborhoodConverter.toNeighborhood(neighborhoodDto))));
    }

}
