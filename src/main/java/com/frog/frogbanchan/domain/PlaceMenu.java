package com.frog.frogbanchan.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @ToString
@SuppressWarnings("serial")
public class PlaceMenu implements Serializable {
    @Id
    private int place_menu_id;
    private String place_id;
    private int menu_id;
    private String name;
    private int price;
    private String description;
    public PlaceMenu() {
    }

    public PlaceMenu(int place_menu_id, String place_id, int menu_id, String name, int price, String description) {
        super();
        this.place_menu_id = place_menu_id;
        this.place_id = place_id;
        this.menu_id = menu_id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
