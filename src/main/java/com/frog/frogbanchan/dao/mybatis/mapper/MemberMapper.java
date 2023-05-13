package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Member;
import com.frog.frogbanchan.domain.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface MemberMapper {

    void insertMember(Member member);

    // member 수정
    void updateMember(Member member);

    // member 탈퇴
    void deleteMember(String username);

    // ID로 member 객체 가져오기
    Member findMemberByUsername(String username);

    // team id로 팀 소속 멤버 리스트 가져오기
    List<Member> findMembersByTeamId(int teamId);

    // username으로 멤버가 속한 팀 리스트 가져오기
    List<Team> findTeamsByUsername(String username);

    // nickname으로 member 객체 가져오기
    List<Member> findMembersByNickname(String nickname);

    // 전체 member 가져오기
    List<String> findUsernameList();

}
