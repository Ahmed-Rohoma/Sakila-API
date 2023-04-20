package iti.jets.model.mapper;

import iti.jets.model.dto.CategoryDTO;
import iti.jets.repository.entity.Category;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setLastUpdate(category.getLastUpdate());
        return dto;
    }

    public static Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setLastUpdate(dto.getLastUpdate());
        return category;
    }

}
