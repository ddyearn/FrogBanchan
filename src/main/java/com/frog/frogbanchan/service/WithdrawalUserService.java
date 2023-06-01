package com.frog.frogbanchan.service;

import com.frog.frogbanchan.dao.*;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WithdrawalUserService {

    @Autowired
    private UsersDao usersDao;
//    @Autowired
//    private ReservationDao reservationDao;
//    @Autowired
//    private HistoryDao historyDao;
    @Autowired
    private TeamDao teamDao;
//    @Autowired
//    private PartyDao partyDao;

    public void withdrawal(String username) {
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
                // quit team
//                teamDao.quitTeam(team.getTeamId(), username);
            }
        }

//        reservationDao.findReservationByUsername(username);
//        historyDao.deleteHistoryByUsername(username);

        usersDao.deleteUser(username);

    }

}
