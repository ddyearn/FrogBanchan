
package com.frog.frogbanchan.service;

import java.util.List;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frog.frogbanchan.dao.MemberDao;
//import com.frog.frogbanchan.dao.PlaceDao;
//import com.frog.frogbanchan.dao.ReservationDao;
//import com.frog.frogbanchan.dao.MenuDao;
//import com.frog.frogbanchan.dao.PlaceMenuDao;
//import com.frog.frogbanchan.dao.HistoryDao;
//import com.frog.frogbanchan.dao.TeamDao;
//import com.frog.frogbanchan.dao.PartyDao;
//import com.frog.frogbanchan.dao.CommentsDao;
import com.frog.frogbanchan.domain.Member;
//import com.frog.frogbanchan.domain.Place;
//import com.frog.frogbanchan.domain.Reservation;
//import com.frog.frogbanchan.domain.Menu;
//import com.frog.frogbanchan.domain.PlaceMenu;
//import com.frog.frogbanchan.domain.History;
//import com.frog.frogbanchan.domain.Team;
//import com.frog.frogbanchan.domain.Party;
//import com.frog.frogbanchan.domain.Comments;

@Service
@Transactional
public class FrogBanchanImpl implements FrogBanchanFacade {
    @Autowired
    private MemberDao memberDao;
//    @Autowired
//    private PlaceDao placeDao;
//    @Autowired
//    private ReservationDao reservationDao;
//    @Autowired
//    private MenuDao menuDao;
//    @Autowired
//    private PlaceMenuDao placeMenuDao;
//    @Autowired
//    private HistoryDao historyDao;
//    @Autowired
//    private TeamDao teamDao;
//    @Autowired
//    private PartyDao partyDao;
//    @Autowired
//    private CommentsDao commentsDao;

    // -------------------------------------------------------------------------
    // Operation methods, implementing the PetStoreFacade interface
    // -------------------------------------------------------------------------

    // MemberService
//    public void insertMember(Member member) {
//        memberDao.insertMember(member);
//    }
//
//    public void updateMember(Member member) {
//        memberDao.updateMember(member);
//    }
//
//    public void deleteMember(String username) {
//        memberDao.deleteMember(username);
//    }
//
//    public Member findMemberByUsername(String username) {
//        return memberDao.findMemberByUsername(username);
//    }

    public List<Member> findMembersByNickname(String nickname) {
        return memberDao.findMembersByNickname(nickname);
    }

    public List<String> findUsernameList() {
        return memberDao.findUsernameList();
    }
}