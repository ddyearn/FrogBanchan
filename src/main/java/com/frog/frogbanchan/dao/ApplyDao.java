package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.Apply;

public interface ApplyDao {
	// apply 삽입
	void insertApply(Apply apply) throws DataAccessException;
	// apply 삭제
	void deleteApply(int applyId) throws DataAccessException;

	// 특정 Party의 apply 삭제
	void deleteAppliesByPartyId(int partyId) throws DataAccessException;

	// apply id로 apply 객체 가져오기
	Apply findApplyByApplyId(int applyId) throws DataAccessException;

	// party id로 apply 객체 가져오기 (시간순 오름차순 정렬)
	List<Apply> findAppliesByPartyId(int partyId) throws DataAccessException;

	// 전체 apply 가져오기
	List<Apply> findApplyList() throws DataAccessException;

}