package iti.jets.model.mapper;

import iti.jets.model.dto.RentalDTO;
import iti.jets.repository.entity.Rental;

public class RentalMapper {
    public static RentalDTO toDTO(Rental rental) {
        RentalDTO dto = new RentalDTO();
        dto.setId(rental.getId());
        dto.setCustomer(CustomerMapper.toDTO(rental.getCustomer()));
        dto.setInventory(InventoryMapper.toDTO(rental.getInventory()));
        dto.setRentalDate(rental.getRentalDate());
        dto.setReturnDate(rental.getReturnDate());
        dto.setLastUpdate(rental.getLastUpdate());
        return dto;
    }

    public static Rental toEntity(RentalDTO dto) {
        Rental rental = new Rental();
        rental.setId(dto.getId());
        rental.setCustomer(CustomerMapper.toEntity(dto.getCustomer()));
        rental.setInventory(InventoryMapper.toEntity(dto.getInventory()));
        rental.setRentalDate(dto.getRentalDate());
        rental.setReturnDate(dto.getReturnDate());
        rental.setLastUpdate(dto.getLastUpdate());
        return rental;
    }
}
