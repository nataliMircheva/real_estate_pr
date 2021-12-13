package com.real_estate_academy_project.real_estate_pr.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = true,unique = true)
    private String name;

     @ManyToMany
     @JoinTable(name = "cities_neighborhoods", joinColumns =
     @JoinColumn(name = "city_id"),
     inverseJoinColumns = @JoinColumn(name = "neighborhood_id"))
     private Set<Neighborhood> neighborhoods;

}
