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
    private int placeMenuId;
    private String placeId;
    private int menuId;
    private String name;
    private int price;
    private String description;
    public PlaceMenu() {
    }

    public PlaceMenu(int placeMenuId, String placeId, int menuId, String name, int price, String description) {
        super();
        this.placeMenuId = placeMenuId;
        this.placeId = placeId;
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
