package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.MemberDao;
import com.frog.frogbanchan.dao.mybatis.mapper.MemberMapper;
import com.frog.frogbanchan.domain.Member;
import com.frog.frogbanchan.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisMemberDao implements MemberDao {

    @Autowired
    private MemberMapper memberMapper;

    public void insertMember(Member member) throws DataAccessException {
        memberMapper.insertMember(member);
    }

    public void updateMember(Member member) throws DataAccessException {
        memberMapper.updateMember(member);
    }

    public void deleteMember(String username) throws DataAccessException {
        memberMapper.deleteMember(username);
    }

    public Member findMemberByUsername(String username) throws DataAccessException {
        return memberMapper.findMemberByUsername(username);
    }

    public List<Member> findMembersByNickname(String nickname) throws DataAccessException {
        return memberMapper.findMembersByNickname(nickname);
    }
    public List<String> findUsernameList() throws DataAccessException {
        return memberMapper.findUsernameList();
    }

    public List<Member> findMembersByTeamId(int teamId) throws DataAccessException {
        return memberMapper.findMembersByTeamId(teamId);
    }

    public List<Team> findTeamsByUsername(String username) throws DataAccessException {
        return memberMapper.findTeamsByUsername(username);
    }
}
