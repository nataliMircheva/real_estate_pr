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
public class FloorDto {
    @Range (min = -3, max = 164,message = "must be between -3 and 164")

  //  private Long id;
    private Integer number;

}
