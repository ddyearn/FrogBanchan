package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.Member;
import com.frog.frogbanchan.domain.Team;

public interface MemberDao {
	// member 삽입
	void insertMember(Member member) throws DataAccessException;

	// member 수정
	void updateMember(Member member) throws DataAccessException;

	// member 탈퇴
  	void deleteMember(String username) throws DataAccessException;

	// ID로 member 객체 가져오기
	Member findMemberByUsername(String username) throws DataAccessException;

	// nickname으로 member 객체 가져오기
	List<Member> findMembersByNickname(String nickname) throws DataAccessException;

	// 전체 member 가져오기
	List<String> findUsernameList() throws DataAccessException;

	// username으로 멤버가 속한 팀 리스트 가져오기
	List<Team> findTeamsByUsername(String username) throws DataAccessException;

	List<Member> findMembersByTeamId(int teamId) throws DataAccessException;

}