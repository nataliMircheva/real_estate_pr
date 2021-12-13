package com.real_estate_academy_project.real_estate_pr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CityDto {

    private Long id;
    private String name;
    private Set<Long> neighborhoodsIds;
}
