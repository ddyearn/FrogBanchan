package com.frog.frogbanchan.controller.team;

import com.frog.frogbanchan.domain.Team;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
@SuppressWarnings("serial")
public class TeamForm implements Serializable {

    private Team team;

    public TeamForm() {}
    public TeamForm(Team team) {
        this.team = team;
    }

}