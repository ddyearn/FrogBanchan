package com.frog.frogbanchan.service;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import com.frog.frogbanchan.domain.*;

public interface FrogBanchanFacade {

    // UserService
    public void insertUser(Users users);

    public void updateUser(Users users);

    public void deleteUser(String username);

    public void insertHateTag(String username, String tag);

    public void deleteHateTagsByUsername(String username);

    public void deleteHateTagByUsernameAndTag(String username, String tag);

    public Users findUserByUsername(String username);

    public List<Users> findUsersByNickname(String nickname);

    public List<String> findUsernameList();

    public List<Team> findTeamsByUsername(String username);

    public List<Users> findUsersByTeamId(int teamId);

    public List<String> findTagsByUsername(String username);

    public List<String> findTagsByTag(String tag);

    // PlaceService
    public void insertPlace(Place place);

    public void updatePlace(Place place);

    public void deletePlace(String placeId);

    public Place findPlaceById(String placeId);

    public void insertAvailableTime(String placeId, Timestamp availableTime);

    public List<Timestamp> findCalendar(String placeId);

    public List<String> findAllPlaceIdList();

    public List<Place> findAllPlaceList();


    // ReservationService
    public void insertReservation(Reservation reservation);

    public void deleteReservation(int reservationId);

    public Reservation findReservation(String placeId, String username);

    public List<Timestamp> findReservedTime(String placeId);

    public List<Reservation> findReservationByUsername(String username);

    public List<Reservation> findReservationByPlaceId(String placeId);

    public List<Reservation> findReservationByReservationId(String reservationId);

    // MenuService
    public Menu findMenu(int menuId);

    public List<Menu> findMenuList();

    public List<Menu> findMenuListByTagList(Map<String, List<String>> tagList);

    public List<String> findMenuTagList(int menuId);

    public List<String> findAllTagList();

    public String findMenuByPlaceMenuId(int placeMenuId);

    // PlaceMenuService
    public void insertPlaceMenu(PlaceMenu placeMenu);

    public void updatePlaceMenu(PlaceMenu placeMenu);

    public void deletePlaceMenu(int placeMenuId);

    public PlaceMenu findPlaceMenu(int placeMenuId);

    public void deletePlaceMenuByPlaceId(String placeId);

    public List<PlaceMenu> findMenuListByPlaceId(String placeId);

    public List<Place> findPlaceListByMenu(int menuId);

    // HistoryService
    public History findHistory(int historyId);

    public List<History> findHistoryList(String username);

    public void insertHistory(History history);

    public void updateHistory(History history);

    public void deleteHistory(int historyId);

    public void deleteHistoryByUsername(String username);

    public Integer getHistoryMenu(String username);

    // TeamService
    public void insertTeam(Team team);

    public void updateTeam(Team team);

    public void addTeamMember(int teamId, String username);

    public void deleteTeam(int teamId);

    public void deleteTeamMember(int teamId, String username);

    public void quitTeam(int teamId);

    public Team findTeam(int teamId);

    public List<Team> findTeamList(String username);

    public int getNextId();

    public List<Users> findTeamMembers(int teamId);

    // PartyService
    public void insertParty(Party party);

    public void updateParty(Party party);

    public void deleteParty(int partyId);

    public Party findParty(int partyId);

    public List<Party> findPartyList();

    public void insertApply(Apply apply);

    public void deleteApply(int applyId);

    public void deleteApplyByPartyId(int partyId);

    public Apply findApplyByApplyId(int applyId);

    public List<Apply> findApplyByPartyId(int partyId);

    public List<Apply> findApplyList();
    
    public int getNextPartyId();

    public List<Party> findPartyByCreator(String creator);

    public List<Apply> findApplyByWriter(String writer);

}