package com.real_estate_academy_project.real_estate_pr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class NeighborhoodDto {

    private Long id;

   // @Range(min =1, max = 255, message = "must be between 1 and 255")
    private String name;
}
