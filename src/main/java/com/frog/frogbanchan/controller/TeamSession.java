package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TeamSession implements Serializable {

    private Team team;
    private List<Users> selectedMember;

    public TeamSession(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Users> getSelectedMember() {
        return selectedMember;
    }
    public void setSelectedMember(List<Users> selectedMember) {
        this.selectedMember = selectedMember;
    }

}
