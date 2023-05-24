package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.frog.frogbanchan.domain.Party;
import com.frog.frogbanchan.domain.Apply;

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
    
    // 식구 신청
 	void insertApply(Apply apply) throws DataAccessException;
 	
 	// 식구 신청 취소
 	void deleteApply(int applyId) throws DataAccessException;

 	//특정 Party의 신청 삭제
 	void deleteApplyByPartyId(int partyId) throws DataAccessException;

 	//apply id로 apply 객체 가져오기
 	Apply findApplyByApplyId(int applyId) throws DataAccessException;

 	//apply id로 apply 객체 가져오기 (시간순 오름차순 정렬)
 	List<Apply> findApplyByPartyId(int partyId) throws DataAccessException;

 	// 전체 apply 가져오기
 	List<Apply> findApplyList() throws DataAccessException;
}