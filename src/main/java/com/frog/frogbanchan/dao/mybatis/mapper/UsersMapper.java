package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.domain.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface UsersMapper {

    void insertUser(Users users);

    // user 수정
    void updateUser(Users users);

    // user 탈퇴
    void deleteUser(String username);

    // hate tag 삽입
    void insertHateTag(String username, String tag);

    // hate tag 삭제
    void deleteHateTag(int tagId);

    // ID로 user 객체 가져오기
    Users findUserByUsername(String username);

    // team id로 팀 소속 멤버 리스트 가져오기
    List<Users> findUsersByTeamId(int teamId);

    // username으로 멤버가 속한 팀 리스트 가져오기
    List<Team> findTeamsByUsername(String username);

    // nickname으로 user 객체 가져오기
    List<Users> findUsersByNickname(String nickname);

    // 전체 user 가져오기
    List<String> findUsernameList();

    // hate tag list 가져오기
    List<String> findTagsByUsername(String username);

}
