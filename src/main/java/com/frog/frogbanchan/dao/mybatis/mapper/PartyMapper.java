package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Party;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartyMapper {
	//식구 모집 등록
    void insertParty(Party party);
    
    //식구 모집 수정
    void updateParty(Party party);

    //식구 모집 삭제
    void deleteParty(int party_id);
    
    //식구 모집 조회
    Party findParty(int party_id);

    // 식구 모집 리스트 조회
    List<Party> findPartyList();
}
