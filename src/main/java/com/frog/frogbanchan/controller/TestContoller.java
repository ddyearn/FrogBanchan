package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.*;
import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.service.FrogBanchanImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        Users users = new Users("test", "test", "test", "test", "000-0000-0000", "test", "0000000", "test");
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
        frogBanchan.deleteComment(1000);
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

    @RequestMapping("/test/comments")
    public ModelAndView commentsTest() {
        System.out.println(frogBanchan.findCommentByCommentId(5002));
        System.out.println(frogBanchan.findCommentList());
        System.out.println(frogBanchan.findCommentsByPartyId(1001));
        Comments comments = new Comments(1, 1001, "nameco", "test");
        // frogBanchan.insertComment(comments);
        frogBanchan.deleteComment(5002);
        System.out.println(frogBanchan.findCommentList());

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
        System.out.println(frogBanchan.findPlaceById("toritori"));

        return new ModelAndView("th/test");
    }

}
