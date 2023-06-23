package com.frog.frogbanchan.controller.users;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class DeleteUserController {
	
    private WithdrawalService withdrawalService;
    @Autowired
    public void setWithdrawalService(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @RequestMapping("/user/delete")
    public String handleRequest(@SessionAttribute("userSession") UserSession userSession,
                                HttpSession session) throws Exception {

        String user = userSession.getUser().getUsername();
        withdrawalService.withdrawalUser(user);
        session.removeAttribute("userSession");

        return "redirect:/login";
    }


}
