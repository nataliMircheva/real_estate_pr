package com.real_estate_academy_project.real_estate_pr.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "floors")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true,nullable = false)
    private Integer number;
}
