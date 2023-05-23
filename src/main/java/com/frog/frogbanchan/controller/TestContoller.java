package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.*;
import com.frog.frogbanchan.service.FrogBanchanImpl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

    @RequestMapping("/test/party")
    public ModelAndView partyTest() {
        System.out.println(frogBanchan.findParty(1001));
        System.out.println(frogBanchan.findPartyList());
        frogBanchan.deleteAppliesByPartyId(1000);
        String time = "2023-05-31T18:15:00";
        LocalDateTime ldt = LocalDateTime.parse(time);
        Timestamp ts = Timestamp.valueOf(ldt);
        Party party = new Party(1111, "naguri", ts, "toritori", "test1");
        // frogBanchan.insertParty(party);
        // party.setContent("test2");
        // frogBanchan.updateParty(party);
        // frogBanchan.deleteParty(1003);
        System.out.println(frogBanchan.findPartyList());

        return new ModelAndView("th/test");
    }

    @RequestMapping("/test/apply")
    public ModelAndView ApplyTest() {
        System.out.println(frogBanchan.findApplyByApplyId(5002));
        System.out.println(frogBanchan.findApplyList());
        System.out.println(frogBanchan.findAppliesByPartyId(1001));
        // Apply apply = new Apply(1, 1001, "nameco", "test");
        // frogBanchan.insertApply(apply);
        // frogBanchan.deleteApply(5002);
        System.out.println(frogBanchan.findApplyList());

        return new ModelAndView("th/test");
    }

    @RequestMapping("/test/history")
    public ModelAndView historyTest() {
        System.out.println(frogBanchan.findHistory(30000));
        System.out.println(frogBanchan.findHistoryList("yonzzang"));
        // frogBanchan.deleteHistory(30000);
        String time = "2023-05-31T18:15:00";
        LocalDateTime ldt = LocalDateTime.parse(time);
        Timestamp ts = Timestamp.valueOf(ldt);
        // History history = new History(30001, "naguri", ts, 10000, "toritori", 4);
        // frogBanchan.insertParty(party);
        // party.setContent("test2");
        // frogBanchan.updateParty(party);
        // frogBanchan.deleteParty(1003);
        System.out.println(frogBanchan.findHistoryList("yonzzang"));

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

}
