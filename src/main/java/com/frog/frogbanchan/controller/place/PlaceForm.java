package com.frog.frogbanchan.controller.place;

import com.frog.frogbanchan.domain.Place;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter @Setter @ToString
@SuppressWarnings("serial")
public class PlaceForm implements Serializable {

    private Place place;

    private String confirmPassword;

    public PlaceForm() {
    }
    public PlaceForm(Place place) {
        this.place = place;
    }

    public boolean isSamePasswordConfirmPassword() {
        if (place.getPassword() == null || confirmPassword == null)
            return false;
        return place.getPassword().equals(confirmPassword);
    }

    public boolean hasPassword() {
        return place.getPassword() != null && place.getPassword().trim().length() > 0;
    }

}
