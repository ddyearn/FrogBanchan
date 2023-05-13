package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.Comments;

public interface CommentsDao {
	// comment 삽입
	void insertComment(Comments comments) throws DataAccessException;
	// comment 삭제
	void deleteComment(int commentId) throws DataAccessException;

	// 특정 Party의 comment 삭제
	void deleteCommentsByPartyId(int partyId) throws DataAccessException;

	// comment id로 comment 객체 가져오기
	Comments findCommentByCommentId(int commentId) throws DataAccessException;

	// party id로 comment 객체 가져오기 (시간순 오름차순 정렬)
	List<Comments> findCommentsByPartyId(int partyId) throws DataAccessException;

	// 전체 comment 가져오기
	List<Comments> findCommentList() throws DataAccessException;

}