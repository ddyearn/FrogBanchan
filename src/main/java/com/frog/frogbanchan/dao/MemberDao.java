package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.Member;
import com.frog.frogbanchan.domain.Team;

public interface MemberDao {
	// member 삽입
//	void insertMember(Member member) throws DataAccessException;
//	/* String query = "INSERT INTO MEMBER (USERNAME, PASSWORD, NAME, PHONE, EMAIL, NICKNAME, RESIDENT_NO) "
//								  + "VALUES (?, ?, ?, ?, ?, ?, ?)"
//	*/
//
//	// member 수정
//	void updateMember(Member member) throws DataAccessException;
//	/* String query = "UPDATE MEMBER SET PASSWORD = ?, NAME = ?, PHONE = ?, EMAIL = ?, NICKNAME = ?, RESIDENT_NO = ?"
//								  + "WHERE USERNAME = ?"
//	*/
//
//	// member 탈퇴
//  	void deleteMember(String username) throws DataAccessException;
//	/* String query = "DELETE FROM MEMBER"
//									+ "WHERE USERNAME = ?"
//	*/
//
//	// ID로 member 객체 가져오기
//	Member findMemberByUsername(String username) throws DataAccessException;
//	/* String query = "SELECT * "
//								  + "FROM MEMBER "
//									+ "WHERE USERNAME = ?"
//	*/

	// nickname으로 member 객체 가져오기
	List<Member> findMembersByNickname(String nickname) throws DataAccessException;

	// 전체 member 가져오기
	List<String> findUsernameList() throws DataAccessException;

//	// team id로 팀 소속 멤버 리스트 가져오기
//	List<Member> findMembersByTeamId(int teamId) throws DataAccessException;
//	/* String query = "SELECT * "
//								  + "FROM MEMBER JOIN PARTICIPATION ON MEMBER.USERNAME = PARTICIPATION.USERNAME "
//									+ "WHERE TEAM_ID = ?"
//	*/
//
//	// username으로 멤버가 속한 팀 리스트 가져오기
//	List<Team> findTeamsByUsername(String username) throws DataAccessException;
//	/* String query = "SELECT * "
//								  + "FROM TEAM JOIN PARTICIPATION ON TEAM.TEAM_ID = PARTICIPATION.TEAM_ID "
//									+ "WHERE USERNAME = ?"
//	*/

}