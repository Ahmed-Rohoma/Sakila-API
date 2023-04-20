package iti.jets.model.mapper;

import iti.jets.model.dto.InventoryDTO;
import iti.jets.repository.entity.Inventory;

public class InventoryMapper {
    public static InventoryDTO toDTO(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();
        dto.setId(inventory.getId());
        dto.setFilm(FilmMapper.toDTO(inventory.getFilm()));
        dto.setStore(StoreMapper.toDTO(inventory.getStore()));
        dto.setLastUpdate(inventory.getLastUpdate());
        return dto;
    }
    
    public static Inventory toEntity(InventoryDTO dto) {
        Inventory inventory = new Inventory();
        inventory.setId(dto.getId());
        inventory.setFilm(FilmMapper.toEntity(dto.getFilm()));
        inventory.setStore(StoreMapper.toEntity(dto.getStore()));
        inventory.setLastUpdate(dto.getLastUpdate());
        return inventory;
    }
}

