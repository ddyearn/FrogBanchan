package com.frog.frogbanchan.controller;

import com.frog.frogbanchan.domain.Comments;
import com.frog.frogbanchan.domain.Member;
import com.frog.frogbanchan.service.FrogBanchanImpl;
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

    @RequestMapping("/test/comments")
    public ModelAndView commentsTest() {
        System.out.println(frogBanchan.findCommentByCommentId(5002));
        System.out.println(frogBanchan.findCommentList());
        System.out.println(frogBanchan.findCommentsByPartyId(1001));
        Comments comments = new Comments(1, 1001, "nameco", "test");
//        frogBanchan.insertComment(comments);
        frogBanchan.deleteComment(5002);
        System.out.println(frogBanchan.findCommentList());


        return new ModelAndView("th/test");
    }




}
