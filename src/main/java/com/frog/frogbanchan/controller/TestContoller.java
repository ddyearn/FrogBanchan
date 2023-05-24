package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.History;
import com.frog.frogbanchan.domain.Member;
import com.frog.frogbanchan.domain.Party;
import com.frog.frogbanchan.domain.Apply;
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

    @RequestMapping("/test/member")
    public ModelAndView memberTest() {
        System.out.println(frogBanchan.findMembersByNickname("나메코"));
        System.out.println(frogBanchan.findMemberByUsername("nameco"));
        System.out.println(frogBanchan.findTeamsByUsername("nameco"));
        Member member = new Member("test", "test", "test","test","000-0000-0000","test","0000000","test");
//        frogBanchan.insertMember(member);
//        member.setName("test1");
//        frogBanchan.updateMember(member);
//        System.out.println(frogBanchan.findMemberByUsername("test"));
//        frogBanchan.deleteMember("test");
        System.out.println(frogBanchan.findUsernameList());

        System.out.println();
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
        //frogBanchan.deleteHistory(30000);
        String time = "2023-05-31T18:15:00";
        LocalDateTime ldt = LocalDateTime.parse(time);
        Timestamp ts = Timestamp.valueOf(ldt);
        //History history = new History(30001, "naguri", ts, 10000, "toritori", 4);
        //frogBanchan.insertParty(party);
        //party.setContent("test2");
        //frogBanchan.updateParty(party);
        //frogBanchan.deleteParty(1003);
        System.out.println(frogBanchan.findHistoryList("yonzzang"));

        return new ModelAndView("th/test");
    }


}
