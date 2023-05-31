package com.frog.frogbanchan.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;

public interface TeamDao {
    //팀 조회
    Team findTeam(int teamId) throws DataAccessException; 

    //팀 리스트 조회
    List<Team> findTeamList(String username) throws DataAccessException;

    //팀원 리스트 조회
    List<Users> findTeamMembers(int teamId) throws DataAccessException;

    int getNextId() throws DataAccessException;
    //팀 생성
    void insertTeam(Team team) throws DataAccessException;

    //팀 정보 수정
    void updateTeam(Team team) throws DataAccessException;

    //팀원 추가(팀장 권한)
    void addTeamMember(int teamId, String username) throws DataAccessException;

    //팀원 삭제(팀장 권한)
    void deleteTeamMember(int teamId, String username) throws DataAccessException;

    //팀 삭제(팀장 권한)
    void deleteTeam(int teamId);

    //팀 나가기(멤버 권한)
    void quitTeam(int teamId) throws DataAccessException; 
}