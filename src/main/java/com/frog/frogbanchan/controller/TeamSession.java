package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TeamSession implements Serializable {

    private Team team;
    private List<Users> selectedMembers;
    private List<String> selectedTags;

    public TeamSession(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Users> getSelectedMembers() {
        return selectedMembers;
    }
    public void setSelectedMembers(List<Users> selectedMembers) {
        this.selectedMembers = selectedMembers;
    }

    public List<String> getSelectedTags() {
        return selectedTags;
    }
    public void setSelectedTags(List<String> selectedTags) {
        this.selectedTags = selectedTags;
    }

}
