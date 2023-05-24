package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.PartyDao;
import com.frog.frogbanchan.dao.mybatis.mapper.PartyMapper;
import com.frog.frogbanchan.domain.Party;
import com.frog.frogbanchan.domain.Apply;
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
    
 	public void insertApply(Apply apply) throws DataAccessException {
 		partyMapper.insertApply(apply);
 	}
 	
 	public void deleteApply(int applyId) throws DataAccessException {
 		partyMapper.deleteApply(applyId);
 	}

 	public void deleteApplyByPartyId(int partyId) throws DataAccessException {
 		partyMapper.deleteApply(partyId);
 	}

 	public Apply findApplyByApplyId(int applyId) throws DataAccessException {
 		return partyMapper.findApplyByApplyId(applyId);
 	}

 	public List<Apply> findApplyByPartyId(int partyId) throws DataAccessException {
 		return partyMapper.findApplyByPartyId(partyId);
 	}

 	public List<Apply> findApplyList() throws DataAccessException {
 		return partyMapper.findApplyList();
 	}

}