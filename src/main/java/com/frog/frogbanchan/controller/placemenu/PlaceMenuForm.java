package com.frog.frogbanchan.controller.placemenu;

import com.frog.frogbanchan.domain.PlaceMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
@SuppressWarnings("serial")
public class PlaceMenuForm implements Serializable {

    private PlaceMenu placeMenu;

    public PlaceMenu getPlaceMenu() {
        return placeMenu;
    }

    public void setPlaceMenu(PlaceMenu placeMenu) {
        this.placeMenu = placeMenu;
    }

    public PlaceMenuForm() {}
    public PlaceMenuForm(PlaceMenu placeMenu) {
        this.placeMenu = placeMenu;
    }

}