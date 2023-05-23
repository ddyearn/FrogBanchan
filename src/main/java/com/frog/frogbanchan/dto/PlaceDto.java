package com.frog.frogbanchan.dto;

import java.security.Timestamp;
import java.util.List;

public class PlaceDto {
    private String placeId;
    // private String password;
    // private String name;
    // private String address;
    // private double totalScore;
    // private List<PlaceMenu> menuList;
    private List<Timestamp> availableTime;
    // private List<Reservation> reservationList;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<Timestamp> getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(List<Timestamp> availableTime) {
        this.availableTime = availableTime;
    }

}
