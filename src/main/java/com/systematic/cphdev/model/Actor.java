package com.systematic.cphdev.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Actor {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String gender;

    @ManyToMany(mappedBy = "actors")
    private List<StarWarsMovie> starWarsMovies;

    public String getFirstName() {
        return firstName;
    }

    public Actor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Actor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getId() {
        return id;
    }

    public Actor setId(int id) {
        this.id = id;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Actor setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public List<StarWarsMovie> getStarWarsMovies() {
        return starWarsMovies;
    }

    public Actor setStarWarsMovies(List<StarWarsMovie> starWarsMovie) {
        this.starWarsMovies = starWarsMovie;
        return this;
    }
}
