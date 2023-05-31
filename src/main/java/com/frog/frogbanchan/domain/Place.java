package com.frog.frogbanchan.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// import javax.persistence.Entity;
// import javax.persistence.Id;

// @Entity
@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class Place implements Serializable {
    // @Id
    private String placeId;
    private String password;
    private String name;
    private String address;
    private double totalScore;
    private Timestamp availableTime;

    public Place() {
    }

    public Place(String placeId, String name, String address) {
        this.placeId = placeId;
        this.name = name;
        this.address = address;
    }

    public Place(String placeId, String password, String name, String address) {
        this.placeId = placeId;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public Place(String placeId, String password, String name, String address, double totalScore) {
        this.placeId = placeId;
        this.password = password;
        this.name = name;
        this.address = address;
        this.totalScore = totalScore;
    }

    // gettersetter넣기

}
