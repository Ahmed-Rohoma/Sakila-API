package iti.jets.model.dto;

import java.util.Date;

public class FilmDTO {

    private int id;
    private String title;
    private String description;
    private int releaseYear;
    private LanguageDTO language;
    private LanguageDTO originalLanguage;
    private int rentalDuration;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private String rating;
    private String specialFeatures;
    private Date lastUpdate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public LanguageDTO getLanguage() {
        return language;
    }
    public void setLanguage(LanguageDTO language) {
        this.language = language;
    }
    public LanguageDTO getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(LanguageDTO originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public int getRentalDuration() {
        return rentalDuration;
    }
    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    public void setRentalRate(Double Double) {
        this.rentalRate = Double;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public double getReplacementCost() {
        return replacementCost;
    }
    public void setReplacementCost(Double Double) {
        this.replacementCost = Double;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getSpecialFeatures() {
        return specialFeatures;
    }
    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Date instant) {
        this.lastUpdate = instant;
    }

}

