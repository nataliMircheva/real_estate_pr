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
public class CityDetachNeighborhoods {

    private Long cityId;

    private Set<Long> neighborhoodIds;
}
