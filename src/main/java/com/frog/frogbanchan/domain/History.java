package com.frog.frogbanchan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class History implements Serializable {
    @Id
    private int historyId;
    private String username;
    private Timestamp recordedDate;
    private int menuId;
    private String placeId;
    private int score;

    public History() {
    }
    public History(int historyId, String username, Timestamp recordedDate, int menuId, String placeId, int score) {
        super();
        this.historyId = historyId;
        this.username = username;
        this.recordedDate = recordedDate;
        this.menuId = menuId;
        this.placeId = placeId;
        this.score = score;
    }

}
