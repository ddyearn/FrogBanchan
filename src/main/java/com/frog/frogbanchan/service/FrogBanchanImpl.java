
package com.frog.frogbanchan.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.frog.frogbanchan.dao.*;
import com.frog.frogbanchan.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FrogBanchanImpl implements FrogBanchanFacade {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private PlaceMenuDao placeMenuDao;
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private PartyDao partyDao;

    // -------------------------------------------------------------------------
    // Operation methods, implementing the PetStoreFacade interface
    // -------------------------------------------------------------------------

    // UserService
    public void insertUser(Users users) {
        usersDao.insertUser(users);
    }

    public void updateUser(Users users) {
        usersDao.updateUser(users);
    }

    public void deleteUser(String username) {
        usersDao.deleteUser(username);
    }

    public void insertHateTag(String username, String tag) {
        usersDao.insertHateTag(username, tag);
    }

    public void deleteHateTag(int tagId) {
        usersDao.deleteHateTag(tagId);
    }

    public Users findUserByUsername(String username) {
        return usersDao.findUserByUsername(username);
    }

    public List<Users> findUsersByNickname(String nickname) {
        return usersDao.findUsersByNickname(nickname);
    }

    public List<String> findUsernameList() {
        return usersDao.findUsernameList();
    }

    public List<Team> findTeamsByUsername(String username) {
        return usersDao.findTeamsByUsername(username);
    }

    public List<Users> findUsersByTeamId(int teamId) {
        return usersDao.findUsersByTeamId(teamId);
    }

    public List<String> findTagsByUsername(String username) {
        return usersDao.findTagsByUsername(username);
    }

    // PlaceService
    public void insertPlace(Place place) {
        placeDao.insertPlace(place);
    }

    public void updatePlace(Place place) {
        placeDao.updatePlace(place);
    }

    public void deletePlace(String placeId) {
        placeDao.deletePlace(placeId);
    }

    public Place findPlaceById(String placeId) {
        return placeDao.findPlaceById(placeId);
    }

    public void insertAvailableTime(String placeId, Timestamp availableTime) {
        placeDao.insertAvailableTime(placeId, availableTime);
    }

    public List<Timestamp> findCalendar(String placeId) {
        return placeDao.findCalendar(placeId);
    }

    // ReservationService
    public void insertReservation(Reservation reservation) {
        reservationDao.insertReservation(reservation);
    }

    public void deleteReservation(int reservationId) {
        reservationDao.deleteReservation(reservationId);
    }

    public Reservation findReservation(String placeId, String username) {
        return reservationDao.findReservation(placeId, username);
    }

    // MenuService
    public Menu findMenu(int menuId) {
        return menuDao.findMenu(menuId);
    }

    public List<Menu> findMenuList() {
        return menuDao.findMenuList();
    }

    public List<Menu> findMenuListByTagList(Map<String, List<String>> tagList) {
        return menuDao.findMenuListByTagList(tagList);
    }

    public List<String> findMenuTagList(int menuId) {
        return menuDao.findMenuTagList(menuId);
    }

    public List<String> findAllTagList() {
        return menuDao.findAllTagList();
    }

    public String findMenuByPlaceMenuId(int placeMenuId) { return menuDao.findMenuByPlaceMenuId(placeMenuId); }

    // PlaceMenuService
    public List<PlaceMenu> findMenuListByPlaceId(String placeId) {
        return placeMenuDao.findMenuListByPlaceId(placeId);
    }

    public List<Place> findPlaceListByMenu(int menuId) {
        return placeMenuDao.findPlaceListByMenu(menuId);
    }

    public PlaceMenu findPlaceMenu(int placeMenuId) { return placeMenuDao.findPlaceMenu(placeMenuId); }

    public void insertPlaceMenu(PlaceMenu placeMenu) {
        placeMenuDao.insertPlaceMenu(placeMenu);
    }

    public void updatePlaceMenu(PlaceMenu placeMenu) {
        placeMenuDao.updatePlaceMenu(placeMenu);
    }

    public void deletePlaceMenu(int placeMenuId) {
        placeMenuDao.deletePlaceMenu(placeMenuId);
    }

    public void deletePlaceMenuByPlaceId(String placeId) { placeMenuDao.deletePlaceMenuByPlaceId(placeId); }

    // HistoryService
    public History findHistory(int historyId) {
        return historyDao.findHistory(historyId);
    }

    public List<History> findHistoryList(String username) {
        return historyDao.findHistoryList(username);
    }

    public void insertHistory(History history) {
        historyDao.insertHistory(history);
    }

    public void updateHistory(History history) {
        historyDao.updateHistory(history);
    }

    public void deleteHistory(int historyId) {
        historyDao.deleteHistory(historyId);
    }

    public void deleteHistoryByUsername(String username) { historyDao.deleteHistoryByUsername(username);}

    public int getHistoryMenu(String username) { return historyDao.getHistoryMenu(username); }

    // TeamService
    public void insertTeam(Team team) {
        teamDao.insertTeam(team);
    }

    public void updateTeam(Team team) {
        teamDao.updateTeam(team);
    }

    public void addTeamMember(int teamId, String username) {
        teamDao.addTeamMember(teamId, username);
    }

    public void deleteTeam(int teamId) {
        teamDao.deleteTeam(teamId);
    }

    public void deleteTeamMember(int teamId, String username) {
        teamDao.deleteTeamMember(teamId, username);
    }

    public void quitTeam(int teamId) {
        teamDao.quitTeam(teamId);
    }

    public Team findTeam(int teamId) {
        return teamDao.findTeam(teamId);
    }

    public List<Team> findTeamList(String username) {
        return teamDao.findTeamList(username);
    }

    public List<Users> findTeamMembers(int teamId) {
        return teamDao.findTeamMembers(teamId);
    }

    public int getNextId() {
        return teamDao.getNextId();
    }

    // PartyService
    public void insertParty(Party party) {
        partyDao.insertParty(party);
    }

    public void updateParty(Party party) {
        partyDao.updateParty(party);
    }

    public void deleteParty(int party_id) {
        partyDao.deleteParty(party_id);
    }

    public Party findParty(int party_id) {
        return partyDao.findParty(party_id);
    }

    public List<Party> findPartyList() {
        return partyDao.findPartyList();
    }

    public void insertApply(Apply apply) {
        partyDao.insertApply(apply);
    }

    public void deleteApply(int applyId) {
        partyDao.deleteApply(applyId);
    }

    public void deleteApplyByPartyId(int partyId) {
        partyDao.deleteApplyByPartyId(partyId);
    }

    public Apply findApplyByApplyId(int applyId) {
        return partyDao.findApplyByApplyId(applyId);
    }

    public List<Apply> findApplyByPartyId(int partyId) {
        return partyDao.findApplyByPartyId(partyId);
    }

    public List<Apply> findApplyList() {
        return partyDao.findApplyList();
    }

}