package com.real_estate_academy_project.real_estate_pr.converter;

import com.real_estate_academy_project.real_estate_pr.dto.FloorDto;
import com.real_estate_academy_project.real_estate_pr.model.Floor;
import org.springframework.stereotype.Component;

@Component
public class FloorConverter {

    public FloorDto toFloorDto (Floor floor){
        return FloorDto.builder()
                .number(floor.getNumber())
                .build();
    }

    public Floor toFloor(FloorDto floorDto){
        return Floor.builder()
                .number(floorDto.getNumber())
                .build();
    }
}
