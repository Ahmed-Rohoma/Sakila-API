package iti.jets.repository.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @Column(name = "language_id", columnDefinition = "TINYINT UNSIGNED not null")
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

    @OneToMany(mappedBy = "language")
    private Set<Film> films = new LinkedHashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setLastUpdate(Date date) {
        this.lastUpdate = date;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}