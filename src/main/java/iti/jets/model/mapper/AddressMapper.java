package iti.jets.model.mapper;

import iti.jets.model.dto.AddressDTO;
import iti.jets.repository.entity.Address;

public class AddressMapper {
    public static AddressDTO toDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setAddress(address.getAddress());
        dto.setAddress2(address.getAddress2());
        dto.setDistrict(address.getDistrict());
        dto.setCity(CityMapper.toDTO(address.getCity()));
        dto.setPostalCode(address.getPostalCode());
        dto.setPhone(address.getPhone());
        dto.setLastUpdate(address.getLastUpdate());
        return dto;
    }

    public static Address toEntity(AddressDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setAddress(dto.getAddress());
        address.setAddress2(dto.getAddress2());
        address.setDistrict(dto.getDistrict());
        address.setCity(CityMapper.toEntity(dto.getCity()));
        address.setPostalCode(dto.getPostalCode());
        address.setPhone(dto.getPhone());
        address.setLastUpdate(dto.getLastUpdate());
        return address;
    }
}
