package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.PartyDao;
import com.frog.frogbanchan.dao.mybatis.mapper.PartyMapper;
import com.frog.frogbanchan.domain.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisPartyDao implements PartyDao {

    @Autowired
    private PartyMapper partyMapper;
    
    public void insertParty(Party party) throws DataAccessException {
    	partyMapper.insertParty(party);
    }

    public void updateParty(Party party) throws DataAccessException {
    	partyMapper.updateParty(party);
    }
    
    public void deleteParty(int partyId) throws DataAccessException {
        partyMapper.deleteParty(partyId);
    } 

    public Party findParty(int partyId) throws DataAccessException {
        return partyMapper.findParty(partyId);
    }

    public List<Party> findPartyList() throws DataAccessException {
    	return partyMapper.findPartyList();
    }

}