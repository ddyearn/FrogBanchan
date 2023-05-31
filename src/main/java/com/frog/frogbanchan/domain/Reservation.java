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
public class Reservation implements Serializable {
    // @Id
    private String username;
    private String placeId;
    private Timestamp reservationDate;
    private int seat;

    public Reservation() {
    }

    public Reservation(String username, String placeId, Timestamp reservationDate, int seat) {
        this.username = username;
        this.placeId = placeId;
        this.reservationDate = reservationDate;
        this.seat = seat;
    }

}
