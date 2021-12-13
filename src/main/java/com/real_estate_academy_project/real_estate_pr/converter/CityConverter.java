package com.real_estate_academy_project.real_estate_pr.converter;

import com.real_estate_academy_project.real_estate_pr.dto.CityDto;
import com.real_estate_academy_project.real_estate_pr.model.City;
import com.real_estate_academy_project.real_estate_pr.model.Neighborhood;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityConverter {

    public CityDto toCityDto (City city){
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .neighborhoodsIds(city.getNeighborhoods()
                        .stream()
                        .map(Neighborhood::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public City toCity (CityDto cityDto){
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .neighborhoods(cityDto.getNeighborhoodsIds()
                        .stream()
                        .map((neighborhoodId) -> Neighborhood.builder().id(neighborhoodId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
