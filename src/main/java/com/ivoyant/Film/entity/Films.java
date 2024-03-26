package com.ivoyant.Film.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="film_info")

public class Films {
    @Id
    private int filmId;
    private String filmName;
    private String director;
    private int budget;
    public Films(){
    }



    public Films(int filmId, String filmName, String director, int budget) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.director = director;
        this.budget = budget;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
