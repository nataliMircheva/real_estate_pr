package com.real_estate_academy_project.real_estate_pr.controller;

import com.real_estate_academy_project.real_estate_pr.converter.FloorConverter;
import com.real_estate_academy_project.real_estate_pr.dto.FloorDto;
import com.real_estate_academy_project.real_estate_pr.model.Floor;
import com.real_estate_academy_project.real_estate_pr.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/floors")
public class FloorController {
    private final FloorConverter floorConverter;
    private final FloorService floorService;

    @Autowired
    public FloorController(FloorConverter floorConverter, FloorService floorService) {
        this.floorConverter = floorConverter;
        this.floorService = floorService;
    }

    @GetMapping
    public ResponseEntity<Set<FloorDto>> findAll() {

//        Set<FloorDto> floorDtos = new HashSet<>();
//        Set<Floor> floors = floorService.findAll();
//
//        for (Floor floor : floors) {
//
//            FloorDto floorDto = floorConverter.toFloorDto(floor);
//            floorDtos.add(floorDto);
//        }
//            return ResponseEntity.ok(floorDtos);
//        }

        //     } dvete sa ekvivalentni
        return ResponseEntity.ok(floorService.findAll()
                .stream()
                .map(floorConverter::toFloorDto)
                .collect(Collectors.toSet()));

    }
        @PostMapping
        public ResponseEntity<FloorDto> save (@RequestBody @Valid FloorDto floorDto){

            Floor floor = floorConverter.toFloor(floorDto);
            Floor savedFloor = floorService.save(floor);

            return ResponseEntity.ok(floorConverter.toFloorDto(savedFloor));


        }

        @DeleteMapping
        public ResponseEntity<HttpStatus> delete (@PathVariable Long id){
            floorService.delete(id);
            return ResponseEntity.ok().build();
        }

        @GetMapping(value = "/id/{id}")
        public ResponseEntity<FloorDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(floorConverter.toFloorDto(floorService.findById(id)));
        }

        @GetMapping(value = "/number/{number}")
    public ResponseEntity<FloorDto> findByNumber(@PathVariable Integer number){
        return ResponseEntity.ok(floorConverter.toFloorDto(floorService.findByNumber(number)));
        }

        @PutMapping(value = "/{id}")
    public ResponseEntity<FloorDto> update (@RequestBody @Valid FloorDto floorDto, @PathVariable Long id){
        Floor foundFloor = floorConverter.toFloor(floorDto);
        Floor updatedFloor = floorService.update(foundFloor, id);
        return ResponseEntity.ok(floorConverter.toFloorDto(updatedFloor));
        }

}