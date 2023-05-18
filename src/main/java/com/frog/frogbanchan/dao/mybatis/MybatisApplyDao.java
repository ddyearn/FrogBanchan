package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.ApplyDao;
import com.frog.frogbanchan.dao.mybatis.mapper.ApplyMapper;
import com.frog.frogbanchan.domain.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisApplyDao implements ApplyDao {
    @Autowired
    private ApplyMapper applyMapper;

    public void insertApply(Apply apply) {
        applyMapper.insertApply(apply);
    }

    public void deleteApply(int applyId) {
        applyMapper.deleteApply(applyId);
    }

    public void deleteAppliesByPartyId(int partyId) {
        applyMapper.deleteAppliesByPartyId(partyId);
    }

    public Apply findApplyByApplyId(int applyId) {
        return applyMapper.findApplyByApplyId(applyId);
    }

    public List<Apply> findAppliesByPartyId(int partyId) {
        return applyMapper.findAppliesByPartyId(partyId);
    }

    public List<Apply> findApplyList() {
        return applyMapper.findApplyList();
    }
}
