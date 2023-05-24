package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.Place;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PlaceSession implements Serializable {

    private Place place;

    public PlaceSession(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

}
