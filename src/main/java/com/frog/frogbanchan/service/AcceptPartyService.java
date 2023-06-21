package com.frog.frogbanchan.service;

import com.frog.frogbanchan.dao.*;
import com.frog.frogbanchan.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcceptPartyService {

    @Autowired
    private PartyDao partyDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private PlaceDao placeDao;
    
    public int acceptParty(Party party, List<String> partyMembers) {
    	Team team = new Team();
    	int teamId = teamDao.getNextId();
    	team.setTeamId(teamId);
    	
    	if (party.getPlaceId() != null && partyMembers != null) {
	    	// 식구 모집이 완료되면 식구원들과 함께 팀 생성
	    	Place place = placeDao.findPlaceById(party.getPlaceId());
	        String creator = party.getCreator();
	        
	    	team.setAddress(place.getAddress());
	    	team.setCreator(creator);
	        team.setName("식구" + party.getPartyId());
	        
	    	teamDao.insertTeam(team); 
	    	
	    	team = teamDao.findTeam(teamId);
	    	team.setTeamId(team.getTeamId());
	    	if (teamDao.findTeam(teamId) != null) {
		    	teamDao.addTeamMember(teamId, creator);
		    	for (String mem : partyMembers) {
		    		teamDao.addTeamMember(teamId, mem);
		    	}
		    	partyDao.deleteParty(party.getPartyId());
	    	}
        }
	    
    	return team.getTeamId();
    }
}