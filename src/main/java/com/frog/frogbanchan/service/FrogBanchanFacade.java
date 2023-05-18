package com.frog.frogbanchan.service;

import java.util.List;
import java.sql.Timestamp;

import com.frog.frogbanchan.domain.*;

public interface FrogBanchanFacade {

    // MemberService
    public void insertMember(Member member);

    public void updateMember(Member member);

    public void deleteMember(String username);

    public Member findMemberByUsername(String username);

    public List<Member> findMembersByNickname(String nickname);

    public List<String> findUsernameList();

    public List<Team> findTeamsByUsername(String username);

    public List<Member> findMembersByTeamId(int teamId);

    // PlaceService
    public void insertPlace(Place place);

    public Place updatePlace(Place place);

    public void deletePlace(String placeId);

    public Place findPlaceById(String placeId);

    public void insertAvailableTime(String placeId, List<Timestamp> availableTime);

    public List<Timestamp> findCalendar(String placeId);

    //
    // // ReservationService
    // public void insertReservation(Reservation reservation);
    //
    // public Reservation findReservationByUsername(String placeId, String
    // username);
    //
    // public Reservation findReservationByDate(String placeId, Timestamp date);
    //
    // // MenuService
    // public Menu findMenu(int menu_id);
    //
    // public List<Menu> findMenuList();
    //
    // public List<Menu> findMenuListByTagList(List<String> likeTagList,
    // List<String> dislikeTagList);
    //
    // public List<String> findMenuTags(int menu_id);
    //
    // public List<String> findAllTag();
    //
    // // PlaceMenuService
    // public void insertPlaceMenu(PlaceMenu placeMenu);
    //
    // public void updatePlaceMenu(PlaceMenu placeMenu);
    //
    // public void deletePlaceMenu(int place_menu_id);
    //
    // public List<PlaceMenu> findMenuListByPlaceId(String place_id);
    //
    // public List<Place> findPlaceListByMenu(int menu_id);
    //
    // HistoryService
    public History findHistory(int historyId);

    public List<History> findHistoryList(String username);

    public void insertHistory(History history);

    public void updateHistory(History history);

    public void deleteHistory(int historyId);
    //
    // // TeamService
    // public void insertTeam(Team team);
    //
    // public void updateTeam(Team team);
    //
    // public void addTeamMember(int team_id, String username);
    //
    // public void deleteTeam(int team_id);
    //
    // public void deleteTeamMember(int team_id, String username);
    //
    // public void quitTeam(int team_id);
    //
    // public Team findTeam(int team_id);
    //
    // public List<Team> findTeamList(String username);
    //
    // public List<Member> findTeamMembers(int team_id);

    // // PartyService
    public void insertParty(Party party);

    public void deleteParty(int party_id);

    public Party findParty(int party_id);

    public List<Party> findPartyList();

    // CommentsService
    public void insertComment(Comments comments);

    public void deleteComment(int commentId);

    public void deleteCommentsByPartyId(int partyId);

    public Comments findCommentByCommentId(int commentId);

    public List<Comments> findCommentsByPartyId(int partyId);

    public List<Comments> findCommentList();

}