package iti.jets.model.mapper;

import iti.jets.model.dto.LanguageDTO;
import iti.jets.repository.entity.Language;

public class LanguageMapper {

    public static LanguageDTO toDTO(Language language) {
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setLanguageId(language.getId());
        languageDTO.setName(language.getName());
        languageDTO.setLastUpdate(language.getLastUpdate());
        return languageDTO;
    }

    public static Language toEntity(LanguageDTO languageDTO) {
        if (languageDTO == null)
            return null;
        Language language = new Language();
        language.setId(languageDTO.getLanguageId());
        language.setName(languageDTO.getName());
        language.setLastUpdate(languageDTO.getLastUpdate());
        return language;
    }
}
