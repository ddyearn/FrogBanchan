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

//    @Override
//    public void insertMember(Member member) throws DataAccessException {
//
//    }
//
//    @Override
//    public void updateMember(Member member) throws DataAccessException {
//
//    }
//
//    @Override
//    public void deleteMember(String username) throws DataAccessException {
//
//    }
//
//    @Override
//    public Member findMemberByUsername(String username) throws DataAccessException {
//        return null;
//    }
//
    public List<Member> findMembersByNickname(String nickname) throws DataAccessException {
        return memberMapper.findMembersByNickname(nickname);
    }
    public List<String> findUsernameList() throws DataAccessException {
        return memberMapper.findUsernameList();
    }

//    @Override
//    public List<Member> findMembersByTeamId(int teamId) throws DataAccessException {
//        return null;
//    }
//
//    @Override
//    public List<Team> findTeamsByUsername(String username) throws DataAccessException {
//        return null;
//    }
}
