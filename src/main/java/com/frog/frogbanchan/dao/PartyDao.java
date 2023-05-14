package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.Party;

public interface PartyDao {
	//식구 모집 등록
    void insertParty(Party party) throws DataAccessException;

    //식구 모집 수정
    void updateParty(Party party) throws DataAccessException;
    
    //식구 모집 삭제
    void deleteParty(int partyId) throws DataAccessException;   
    
    //식구 모집 조회
    Party findParty(int partyId) throws DataAccessException;
    
    // 식구 모집 리스트 조회
    List<Party> findPartyList() throws DataAccessException; 
}