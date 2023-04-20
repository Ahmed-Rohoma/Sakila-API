package iti.jets.model.mapper;

import iti.jets.model.dto.CountryDTO;
import iti.jets.repository.entity.Country;

public class CountryMapper {
    public static CountryDTO toDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setId(country.getId());
        dto.setCountry(country.getCountry());
        dto.setLastUpdate(country.getLastUpdate());
        return dto;
    }

    public static Country toEntity(CountryDTO dto) {
        Country country = new Country();
        country.setId(dto.getId());
        country.setCountry(dto.getCountry());
        country.setLastUpdate(dto.getLastUpdate());
        return country;
    }
}
