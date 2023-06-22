package com.frog.frogbanchan.service;

import com.frog.frogbanchan.dao.*;
import com.frog.frogbanchan.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WithdrawalService {

    @Autowired
    private UsersDao usersDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private PlaceMenuDao placeMenuDao;
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private PartyDao partyDao;

    public Users withdrawalUser(String username) {
        Users user = usersDao.findUserByUsername(username);

        // team 처리
        List<Team> teamList = teamDao.findTeamList(username);
        for (Team team : teamList) {
            teamDao.deleteTeamMember(team.getTeamId(), username);
            if (username.equals(team.getCreator())) {
                List<Users> memberList = teamDao.findTeamMembers(team.getTeamId());
                for (Users member : memberList) {
                    teamDao.deleteTeamMember(team.getTeamId(), member.getUsername());
                }
                teamDao.deleteTeam(team.getTeamId());
            }
        }

        // Apply 처리
        List<Apply> applyList = partyDao.findApplyByWriter(username);
        for (Apply apply : applyList) {
            partyDao.deleteApply(apply.getApplyId());
        }

        // party 처리
        List<Party> partyList = partyDao.findPartyByCreator(username);
        for (Party party : partyList) {
            partyDao.deleteApplyByPartyId(party.getPartyId());
            partyDao.deleteParty(party.getPartyId());
        }

        // reservation 처리
        List<Reservation> reservationList = reservationDao.findReservationByUsername(username);
        for (Reservation reservation : reservationList) {
            reservationDao.deleteReservation(reservation.getReservationId());
        }
        System.out.println(reservationDao.findReservationByUsername(username));

        // history 처리
        historyDao.deleteHistoryByUsername(username);

        // tag 처리
        usersDao.deleteHateTagsByUsername(username);

        // 회원 탈퇴
        usersDao.deleteUser(username);

        return user;
    }

    public Place withdrawalPlace(String placeId) {
        Place place = placeDao.findPlaceById(placeId);

        // history 처리
//        List<History> historyList = historyDao.findHistoryByPlaceId()

        // reservation 처리
        List<Reservation> reservationList = reservationDao.findReservationByPlaceId(placeId);
        for (Reservation reservation : reservationList) {
            reservationDao.deleteReservation(reservation.getReservationId());
        }

        // placeMenu 처리
        placeMenuDao.deletePlaceMenuByPlaceId(placeId);

        // 사업자 탈퇴
        placeDao.deletePlace(placeId);

        return place;
    }

}