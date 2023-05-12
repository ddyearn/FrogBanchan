package com.frog.frogbanchan.service;

import java.util.List;
import java.sql.Timestamp;

import com.frog.frogbanchan.domain.Member;
//import com.frog.frogbanchan.domain.Place;
//import com.frog.frogbanchan.domain.Reservation;
//import com.frog.frogbanchan.domain.Menu;
//import com.frog.frogbanchan.domain.PlaceMenu;
//import com.frog.frogbanchan.domain.History;
import com.frog.frogbanchan.domain.Team;
//import com.frog.frogbanchan.domain.Party;
//import com.frog.frogbanchan.domain.Comments;

public interface FrogBanchanFacade {

    // MemberService
//    public void insertMember(Member member);
//
//    public void updateMember(Member member);
//
//    public void deleteMember(String username);
//
//    public Member findMemberByUsername(String username);

    public List<Member> findMembersByNickname(String nickname);

    public List<String> findUsernameList();

//    public List<Team> findTeamsByUsername(String username);
//
//    public List<Member> findMembersByTeamId(int teamId);

}