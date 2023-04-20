package iti.jets.model.mapper;

import java.util.stream.Collectors;

import iti.jets.model.dto.StoreDTO;
import iti.jets.repository.entity.Store;

public class StoreMapper {

    public static StoreDTO toDTO(Store store) {
        StoreDTO dto = new StoreDTO();
        dto.setId(store.getId());
        dto.setAddress(AddressMapper.toDTO(store.getAddress()));
        dto.setManager(StaffMapper.toDTO(store.getManagerStaff()));
        dto.setStaffList(store.getStaff().stream().map(StaffMapper::toDTO).collect(Collectors.toList()));
        dto.setLastUpdate(store.getLastUpdate());
        return dto;
    }

    public static Store toEntity(StoreDTO dto) {
        Store entity = new Store();
        entity.setId(dto.getId());
        entity.setAddress(AddressMapper.toEntity(dto.getAddress()));
        entity.setManagerStaff(StaffMapper.toEntity(dto.getManager()));
        entity.setStaff(dto.getStaffList().stream().map(StaffMapper::toEntity).collect(Collectors.toSet()));
        entity.setLastUpdate(dto.getLastUpdate());
        return entity;
    }
}

