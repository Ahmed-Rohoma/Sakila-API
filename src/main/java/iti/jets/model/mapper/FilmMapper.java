package iti.jets.model.mapper;

import iti.jets.model.dto.FilmDTO;
import iti.jets.repository.entity.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmMapper {

    public static FilmDTO toDTO(Film film) {
        FilmDTO dto = new FilmDTO();
        dto.setId(film.getId());
        dto.setTitle(film.getTitle());
        dto.setDescription(film.getDescription());
        dto.setReleaseYear(film.getReleaseYear());
        dto.setLanguage(LanguageMapper.toDTO(film.getLanguage()));
        dto.setRentalDuration(film.getRentalDuration());
        dto.setRentalRate(film.getRentalRate().doubleValue());
        dto.setLength(film.getLength());
        dto.setReplacementCost(film.getReplacementCost().doubleValue());
        dto.setRating(film.getRating());
        dto.setSpecialFeatures(film.getSpecialFeatures());
        dto.setLastUpdate(film.getLastUpdate());
        return dto;
    }

    public static Film toEntity(FilmDTO dto) {
        Film film = new Film();
        // film.setId(dto.getId());
        film.setTitle(dto.getTitle());
        film.setDescription(dto.getDescription());
        film.setReleaseYear(dto.getReleaseYear());
        film.setLanguage(LanguageMapper.toEntity(dto.getLanguage()));
        film.setRentalDuration(dto.getRentalDuration());
        film.setRentalRate(dto.getRentalRate());
        film.setLength(dto.getLength());
        film.setReplacementCost(dto.getReplacementCost());
        film.setRating(dto.getRating());
        film.setSpecialFeatures(dto.getSpecialFeatures());
        film.setLastUpdate(dto.getLastUpdate());
        return film;
    }

    public static List<FilmDTO> toDTOList(List<Film> films) {
        List<FilmDTO> dtos = new ArrayList<>();
        for (Film film : films) {
            dtos.add(toDTO(film));
        }
        return dtos;
    }
}

