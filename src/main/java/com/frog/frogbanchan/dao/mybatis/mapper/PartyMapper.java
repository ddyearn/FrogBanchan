package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Party;
import com.frog.frogbanchan.domain.Apply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartyMapper {
	//식구 모집
    public void insertParty(Party party);
    
    public void updateParty(Party party);

    public void deleteParty(int party_id);
    
    public Party findParty(int party_id);

    public List<Party> findPartyList();
    
    //식구 신청
    public void insertApply(Apply apply);

    public void deleteApply(int applyId);

    public void deleteApplyByPartyId(int partyId);

    public Apply findApplyByApplyId(int applyId);

    public List<Apply> findApplyByPartyId(int partyId);

    public List<Apply> findApplyList();
  
}
