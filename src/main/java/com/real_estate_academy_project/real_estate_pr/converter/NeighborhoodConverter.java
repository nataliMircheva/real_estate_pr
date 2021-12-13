package com.real_estate_academy_project.real_estate_pr.converter;

import com.real_estate_academy_project.real_estate_pr.dto.NeighborhoodDto;
import com.real_estate_academy_project.real_estate_pr.model.Neighborhood;
import org.springframework.stereotype.Component;

@Component
public class NeighborhoodConverter {

    public NeighborhoodDto toNeighborhoodDto (Neighborhood neighborhood){
        return NeighborhoodDto.builder()
                .id(neighborhood.getId())
                .name(neighborhood.getName())
                .build();
    }

    public Neighborhood toNeighborhood (NeighborhoodDto neighborhoodDto){
        return Neighborhood.builder()
                .id(neighborhoodDto.getId())
                .name(neighborhoodDto.getName())
                .build();
    }


}
