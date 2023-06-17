package com.frog.frogbanchan.controller.reservation;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.frog.frogbanchan.domain.Reservation;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class ReservationForm implements Serializable {

    private Reservation reservation;

    public ReservationForm() {
    }

    public ReservationForm(Reservation reservation) {
        this.reservation = reservation;
    }

}
