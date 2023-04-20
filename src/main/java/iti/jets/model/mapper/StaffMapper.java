package iti.jets.model.mapper;

import iti.jets.model.dto.StaffDTO;
import iti.jets.repository.entity.Staff;

public class StaffMapper {

    public static StaffDTO toDTO(Staff staff) {
        StaffDTO dto = new StaffDTO();
        dto.setId(staff.getId());
        dto.setFirstName(staff.getFirstName());
        dto.setLastName(staff.getLastName());
        dto.setAddress(AddressMapper.toDTO(staff.getAddress()));
        dto.setEmail(staff.getEmail());
        dto.setStore(StoreMapper.toDTO(staff.getStore()));
        dto.setActive(staff.getActive());
        dto.setUsername(staff.getUsername());
        dto.setPassword(staff.getPassword());
        dto.setLastUpdate(staff.getLastUpdate());
        return dto;
    }

    public static Staff toEntity(StaffDTO dto) {
        Staff entity = new Staff();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(AddressMapper.toEntity(dto.getAddress()));
        entity.setEmail(dto.getEmail());
        entity.setStore(StoreMapper.toEntity(dto.getStore()));
        entity.setActive(dto.getActive());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setLastUpdate(dto.getLastUpdate());
        return entity;
    }
}
