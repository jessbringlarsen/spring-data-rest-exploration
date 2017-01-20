package com.systematic.cphdev.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class StarWarsMovie {

    @Id
    private int id;
    private int year;
    private String title;


    private int rating;

    @ManyToMany
    private List<Actor> actors;

    public String getTitle() {
        return title;
    }

    public StarWarsMovie setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getId() {
        return id;
    }

    public StarWarsMovie setId(int id) {
        this.id = id;
        return this;
    }

    public int getYear() {
        return year;
    }

    public StarWarsMovie setYear(int year) {
        this.year = year;
        return this;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public StarWarsMovie setActors(List<Actor> actors) {
        this.actors = actors;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public StarWarsMovie setRating(int rating) {
        this.rating = rating;
        return this;
    }
}
