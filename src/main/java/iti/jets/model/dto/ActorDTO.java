package iti.jets.model.dto;

import java.util.Date;

public class ActorDTO {

    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
    
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}

