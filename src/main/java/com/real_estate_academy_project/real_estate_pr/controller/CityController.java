package com.real_estate_academy_project.real_estate_pr.controller;

import com.real_estate_academy_project.real_estate_pr.converter.CityConverter;
import com.real_estate_academy_project.real_estate_pr.dto.CityDetachNeighborhoods;
import com.real_estate_academy_project.real_estate_pr.dto.CityDto;
import com.real_estate_academy_project.real_estate_pr.model.City;
import com.real_estate_academy_project.real_estate_pr.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private final CityService cityService;
    private final CityConverter cityConverter;

    public CityController(CityService cityService, CityConverter cityConverter) {
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }

    @PostMapping
    public ResponseEntity<CityDto> save (@RequestBody CityDto cityDto){
        City city = cityConverter.toCity(cityDto);
        City saveCity = cityService.save(city);
        CityDto responseCity = cityConverter.toCityDto(saveCity);

        return ResponseEntity.ok(responseCity);
    }

    @GetMapping(value = "/{id}")

    public ResponseEntity<CityDto> findById (@PathVariable Long id){
        City foundCity = cityService.findById(id);
        CityDto cityDto = cityConverter.toCityDto(foundCity);
        return ResponseEntity.ok(cityDto);
    }

    @PutMapping (value = "/{id}")

    public ResponseEntity<CityDto> updateCity (@RequestBody  CityDto cityDto,@PathVariable Long id){
        City foundCity = cityConverter.toCity(cityDto);
        City saveCity = cityService.update(foundCity, id);
        CityDto responseCityDto = cityConverter.toCityDto(saveCity);
        return ResponseEntity.ok(responseCityDto);
    }
    @PutMapping (value = "/detach")

    public ResponseEntity<HttpStatus> detachCity (@RequestBody CityDetachNeighborhoods cityDetachNeighborhoods){
        cityService.detachCityNeighborhoods(cityDetachNeighborhoods.getCityId(), cityDetachNeighborhoods.getNeighborhoodIds());
        return ResponseEntity.ok().build();
    }
}
