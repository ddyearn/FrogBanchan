package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {
	public Team findTeam(int teamId);

    public List<Team> findTeamList(String username);

    public List<Users> findTeamMembers(int teamId);
    
    public int getNextId();

    public void insertTeam(Team team);

    public void updateTeam(Team team);

    public void addTeamMember(int teamId, String username);

    public void deleteTeamMember(int teamId, String username);

    public void deleteTeam(int teamId);

    public void quitTeam(int teamId);
}