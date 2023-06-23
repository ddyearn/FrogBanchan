package com.frog.frogbanchan.controller.place;

import com.frog.frogbanchan.controller.PlaceSession;
import com.frog.frogbanchan.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class DeletePlaceController {

    private WithdrawalService withdrawalService;
    @Autowired
    public void setWithdrawalService(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @RequestMapping("/place/delete")
    public String handleRequest(@SessionAttribute("placeSession") PlaceSession placeSession,
                                HttpSession session) throws Exception {

        String placeId = placeSession.getPlace().getPlaceId();
        withdrawalService.withdrawalPlace(placeId);
        session.removeAttribute("placeSession");

        return "redirect:/login";
    }
}
