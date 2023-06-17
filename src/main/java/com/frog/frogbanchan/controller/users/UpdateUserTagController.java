package com.frog.frogbanchan.controller.users;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UpdateUserTagController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @GetMapping("/user/tag")
    public String handleRequest1(@SessionAttribute("userSession") UserSession userSession,
                                 Model model) throws Exception {
        List<String> hateTagList = frogBanchan.findTagsByUsername(userSession.getUser().getUsername());
        model.addAttribute("hateTagList", hateTagList);

        return "/user/tagModify";
    }

    @PostMapping("/user/tag")
    public String handleRequest2(@SessionAttribute("userSession") UserSession userSession,
                                 @RequestParam("hateTags") String hateTags,
                                 Model model) throws Exception {
        String username = userSession.getUser().getUsername();
        List<String> newList = new ArrayList<>(Arrays.asList(hateTags.split(",")));
        model.addAttribute("hateList", newList);
        frogBanchan.deleteHateTagsByUsername(username);
        for (String tag : newList) {
            frogBanchan.insertHateTag(username, tag);
        }

        return "redirect:/user/tag";
    }


}
