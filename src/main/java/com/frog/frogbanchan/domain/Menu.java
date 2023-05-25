package com.frog.frogbanchan.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
@SuppressWarnings("serial")
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
