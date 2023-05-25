package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.*;
import com.frog.frogbanchan.service.FrogBanchanImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestContoller {
    @Autowired
    private FrogBanchanImpl frogBanchan;

    @RequestMapping("/test/user")
    public ModelAndView userTest() {
        System.out.println(frogBanchan.findUsersByNickname("나메코"));
        System.out.println(frogBanchan.findUserByUsername("nameco"));
        System.out.println(frogBanchan.findTeamsByUsername("nameco"));
        // Users user = new Users("test", "test", "test", "test", "000-0000-0000",
        // "test", "0000000", "test");
        // frogBanchan.insertUser(user);
        // user.setName("test1");
        // frogBanchan.updateUser(user);
        // System.out.println(frogBanchan.findUserByUsername("test"));
        // frogBanchan.deleteUser("test");
        System.out.println(frogBanchan.findUsernameList());

        System.out.println();
        return new ModelAndView("th/test");
    }

    @RequestMapping("/test/team")
    public ModelAndView teamTest() {
    	System.out.println(frogBanchan.findTeam(101));
    	System.out.println(frogBanchan.findTeamList("naguri"));
    	System.out.println(frogBanchan.findTeamMembers(100));
    	//Team team = new Team(101, "나구리팀", "서울시 강남구 대치동", "naguri");
    	//frogBanchan.insertTeam(team);
    	//team.setName("나구리가지배한다");
    	//frogBanchan.updateTeam(team);
    	//System.out.println(frogBanchan.findTeam(126));
    	
    	//frogBanchan.addTeamMember(102, "naguri");
    	//System.out.println(frogBanchan.findTeamMembers(102));
    	//frogBanchan.quitTeam(102);
    	//System.out.println(frogBanchan.findTeamMembers(102));
    	//frogBanchan.deleteTeamMember(100, "naguri");
    	//System.out.println(frogBanchan.findTeam(100));
    	//System.out.println(frogBanchan.findTeamList("naguri"));
    	//frogBanchan.deleteTeam(126);
    	
    	return new ModelAndView("th/test");
    }
    
    @RequestMapping("/test/party")
    public ModelAndView partyTest() {
    	System.out.println(frogBanchan.findParty(1001));
    	System.out.println(frogBanchan.findPartyList());
    	frogBanchan.deleteApply(1000);
    	String time = "2023-05-31T18:15:00";
        LocalDateTime ldt = LocalDateTime.parse(time);
        Timestamp ts = Timestamp.valueOf(ldt);
        Party party = new Party(1111, "naguri", ts, "toritori", "test1");
        //frogBanchan.insertParty(party);
        //party.setContent("test2");
        //frogBanchan.updateParty(party);
        //frogBanchan.deleteParty(1003);
  
    	System.out.println(frogBanchan.findPartyList());
    	System.out.println(frogBanchan.findApplyByApplyId(5002));
        System.out.println(frogBanchan.findApplyList());
        System.out.println(frogBanchan.findApplyByPartyId(1001));
        Apply apply = new Apply(1, 1001, "nameco", "test");
//        frogBanchan.insertApply(apply);
        frogBanchan.deleteApply(5002);
        System.out.println(frogBanchan.findApplyList());

    	return new ModelAndView("th/test");
    }

    @RequestMapping("/test/history")
    public ModelAndView historyTest() {
        System.out.println(frogBanchan.findHistory(30000));
        System.out.println(frogBanchan.findHistoryList("yonzzang"));
        // History history = new History(30022, "naguri", 50000, "toritori", 1);
        // frogBanchan.insertHistory(history);
        // System.out.println(frogBanchan.findHistoryList("naguri"));
        // history.setScore(4);
        // frogBanchan.updateHistory(history);
        // System.out.println(frogBanchan.findHistoryList("naguri"));
        // frogBanchan.deleteHistory(30022);
        // System.out.println(frogBanchan.findHistoryList("naguri"));

        return new ModelAndView("th/test");
    }

    @RequestMapping("/test/menu")
    public ModelAndView menuTest() {
        System.out.println(frogBanchan.findMenu(10000));
        System.out.println(frogBanchan.findMenuList());
        List<String> likelist = new ArrayList<>();
        likelist.add("돼지고기");
        List<String> hatelist = new ArrayList<>();
        hatelist.add("치즈");
        Map<String, List<String>> tagList = new HashMap<>();
        tagList.put("like", likelist);
        tagList.put("dislike", hatelist);
        System.out.println(frogBanchan.findMenuListByTagList(tagList));
        System.out.println(frogBanchan.findMenuTagList(10000));
        System.out.println(frogBanchan.findAllTagList());

        return new ModelAndView("th/test");
    }
    @RequestMapping("/test/placeMenu")
    public ModelAndView placeMenuTest() {
        System.out.println(frogBanchan.findMenuListByPlaceId("toritori"));
        System.out.println(frogBanchan.findPlaceListByMenu(10000));
        PlaceMenu placeMenu = new PlaceMenu(0, "spring123", 10000, "짱돈까스", 12000, "소켓주세요");
//        frogBanchan.insertPlaceMenu(placeMenu);
//        System.out.println(frogBanchan.findMenuListByPlaceId("spring123"));
//        placeMenu.setDescription("소켓 내놓으라고");
//        placeMenu.setPlaceMenuId(50020);
//        frogBanchan.updatePlaceMenu(placeMenu);
//        System.out.println(frogBanchan.findMenuListByPlaceId("spring123"));
//        frogBanchan.deletePlaceMenu(50020);
//        frogBanchan.deletePlaceMenu(50021);
//        frogBanchan.deletePlaceMenu(50022);

        return new ModelAndView("th/test");
    }

    @RequestMapping("/test/place")
    public ModelAndView placeTest() {

        // System.out.println(frogBanchan.findPlaceById("toritori"));
        // Place place1 = new Place("testtest", "testt", "testt", "testt");
        // frogBanchan.insertPlace(place1);
        // Place place2 = new Place("testtest", "ud_test", "ud_test", "ud_test");
        // frogBanchan.updatePlace(place2);
        // frogBanchan.deletePlace("testtest");

        // Date date = new Date();
        // Timestamp timestamp = new Timestamp(date.getTime());
        // Timestamp timestamp1 = new Timestamp(date.getTime());
        // frogBanchan.insertAvailableTime("test1_id", timestamp);

        List<Timestamp> list = frogBanchan.findCalendar("toritori");
        System.out.println(list);

        return new ModelAndView("th/test");
    }

    @RequestMapping("/test/map")
    public ModelAndView mapTest() { return new ModelAndView("recommend/map");}

    @RequestMapping("/react")
    public String reactTest() {
        return "redirect:/react/index.html";
    }

}
