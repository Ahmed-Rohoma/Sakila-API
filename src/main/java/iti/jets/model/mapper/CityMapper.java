package iti.jets.model.mapper;

import iti.jets.model.dto.CityDTO;
import iti.jets.repository.entity.City;

public class CityMapper {
    public static CityDTO toDTO(City city) {
        CityDTO dto = new CityDTO();
        dto.setId(city.getId());
        dto.setCity(city.getCity());
        dto.setCountry(CountryMapper.toDTO(city.getCountry()));
        dto.setLastUpdate(city.getLastUpdate());
        return dto;
    }
    
    public static City toEntity(CityDTO dto) {
        City city = new City();
        city.setId(dto.getId());
        city.setCity(dto.getCity());
        city.setCountry(CountryMapper.toEntity(dto.getCountry()));
        city.setLastUpdate(dto.getLastUpdate());
        return city;
    }
}

