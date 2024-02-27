package com.example.cinema.models;

public enum Rating {

    U("U"),
    PG("PG"),
    TWELVE_A("12A"),
    FIFTEEN("15"),
    EIGHTEEN("18");

    private String value;

    Rating(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }

}
