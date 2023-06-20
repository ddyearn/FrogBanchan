package com.frog.frogbanchan.service;

import com.frog.frogbanchan.dao.*;
import com.frog.frogbanchan.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParticipationService {

    @Autowired
    private UsersDao usersDao;
    @Autowired
    private TeamDao teamDao;
    
    public void createTeam(Team team, String creator) {
        // 팀 생성
        teamDao.insertTeam(team);

        // 팀장 participation 추가
        teamDao.addTeamMember(team.getTeamId(), creator);
    }
    
    public Team getParticipation(String username, String email, int teamId) {
    	Users user = usersDao.findUserByUsername(username);
    	
    	if (user != null && email.equals(user.getEmail())) {
			boolean isParticipated = false;
			List<Users> memberList = teamDao.findTeamMembers(teamId);
			for (Users mem : memberList) {
				if (username.equals(mem.getUsername())) {
					isParticipated = true;
					break;
				}
			}
			if (!isParticipated) {
				teamDao.addTeamMember(teamId, username);
			}
		}
    	
    	Team team = teamDao.findTeam(teamId);
    	
    	return team;
    }
    
    public void quitParticipation(int teamId, String username) {
    	teamDao.deleteTeamMember(teamId, username);
    }
    
    public void outParticipation(int teamId, String username) {
    	teamDao.deleteTeamMember(teamId, username);
    }
    
    public void deleteTeam(int teamId) {    	
    	List<Users> members = teamDao.findTeamMembers(teamId);
    	for (Users mem : members) {
    		teamDao.deleteTeamMember(teamId, mem.getUsername());
    	}
    	
    	teamDao.deleteTeam(teamId);
    }
}