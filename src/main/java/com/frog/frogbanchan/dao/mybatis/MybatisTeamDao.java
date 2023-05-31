package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.TeamDao;
import com.frog.frogbanchan.dao.mybatis.mapper.TeamMapper;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisTeamDao implements TeamDao {
	
	@Autowired
	private TeamMapper teamMapper;
	
	public Team findTeam(int teamId) throws DataAccessException {
		return teamMapper.findTeam(teamId);
	}

    public List<Team> findTeamList(String username) throws DataAccessException {
    	return teamMapper.findTeamList(username);
    }

    public List<Users> findTeamMembers(int teamId) throws DataAccessException {
    	return teamMapper.findTeamMembers(teamId);
    }

    public int getNextId() throws DataAccessException {
    	return teamMapper.getNextId();
    }

    public void insertTeam(Team team) throws DataAccessException {
    	teamMapper.insertTeam(team);
    }

    public void updateTeam(Team team) throws DataAccessException {
    	teamMapper.updateTeam(team);
    }

    public void addTeamMember(int teamId, String username) throws DataAccessException {
    	teamMapper.addTeamMember(teamId, username);
    }

    public void deleteTeamMember(int teamId, String username) throws DataAccessException {
    	teamMapper.deleteTeamMember(teamId, username);
    }

    public void deleteTeam(int teamId) {
    	teamMapper.deleteTeam(teamId);
    }

    public void quitTeam(int teamId) throws DataAccessException {
    	teamMapper.quitTeam(teamId);
    }
}