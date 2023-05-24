package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.domain.Team;

public interface UsersDao {
	// user 삽입
	void insertUser(Users users) throws DataAccessException;

	// user 수정
	void updateUser(Users users) throws DataAccessException;

	// user 탈퇴
  	void deleteUser(String username) throws DataAccessException;

	// ID로 user 객체 가져오기
	Users findUserByUsername(String username) throws DataAccessException;

	// nickname으로 member 객체 가져오기
	List<Users> findUsersByNickname(String nickname) throws DataAccessException;

	// 전체 user 가져오기
	List<String> findUsernameList() throws DataAccessException;

	// username으로 user가 속한 팀 리스트 가져오기
	List<Team> findTeamsByUsername(String username) throws DataAccessException;

	List<Users> findUsersByTeamId(int teamId) throws DataAccessException;

}