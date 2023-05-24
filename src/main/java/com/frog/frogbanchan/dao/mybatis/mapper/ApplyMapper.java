package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Apply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyMapper {
    public void insertApply(Apply apply);

    public void deleteApply(int applyId);

    public void deleteAppliesByPartyId(int partyId);

    public Apply findApplyByApplyId(int applyId);

    public List<Apply> findAppliesByPartyId(int partyId);

    public List<Apply> findApplyList();
}
