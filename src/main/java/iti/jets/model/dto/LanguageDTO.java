package iti.jets.model.dto;

import java.util.Date;

public class LanguageDTO {

    private int languageId;
    private String name;
    private Date lastUpdate;

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date instant) {
        this.lastUpdate = instant;
    }

}
