package com.frog.frogbanchan.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @ToString
public class Menu {
    @Id
    private int menuId;
    private String name;

    public Menu() {
    }
    public Menu(int menuId, String name) {
        super();
        this.menuId = menuId;
        this.name = name;
    }
}
