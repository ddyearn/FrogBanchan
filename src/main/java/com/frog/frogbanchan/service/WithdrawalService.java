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
            List<Users> memberList = teamDao.findTeamMembers(team.getTeamId());
            if (memberList.size() == 1) {
                teamDao.deleteTeam(team.getTeamId());
            } else {
                if (username.equals(team.getCreator())) {
                    team.setCreator("deleted");
                    teamDao.updateTeam(team);
                }
                teamDao.deleteTeamMember(team.getTeamId(), username);
            }
        }

        // party 처리
//        partyDao.findPartyByCreator()

        // reservation 처리
        reservationDao.findReservationByUsername(username);

        // history 처리
        historyDao.deleteHistoryByUsername(username);

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