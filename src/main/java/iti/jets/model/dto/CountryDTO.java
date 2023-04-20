package iti.jets.model.dto;

import java.util.Date;

public class CountryDTO {
    private int id;
    private String country;
    private Date lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date instant) {
        this.lastUpdate = instant;
    }

}
