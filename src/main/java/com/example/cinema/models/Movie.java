package com.example.cinema.models;

import jakarta.persistence.*;

@Entity
@Table (name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private Rating rating;

    @Column(name = "duration")
    private int duration;

//    CONSTRUCTORS

    public Movie(String title, Rating rating, int duration) {
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public Movie() {
    }

//    GETTERS & SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
