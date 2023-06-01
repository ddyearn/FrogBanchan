package com.frog.frogbanchan.controller.party;

import com.frog.frogbanchan.domain.Party;
import com.frog.frogbanchan.domain.Apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.validator.ApplyFormValidator;

@Controller
public class ApplyFormController {
	@Value("/party/apply")
	private String FORM_VIEW;
	@Value("/party/view")
	private String RESULT_VIEW;
	
	private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }
    
	//식구 모집 신청
	@RequestMapping(value="/apply/create", method=RequestMethod.POST)
	public ModelAndView partyApply(@RequestParam(value="partyId") int partyId, HttpServletRequest request, HttpSession session, Apply apply) {
		ModelAndView mav = new ModelAndView();
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
	    String writer = userSession.getUser().getUsername();
		
		apply.setWriter(writer);
		frogBanchan.insertApply(apply);
		mav.addObject("applyList", frogBanchan.findApplyByPartyId(partyId));
		mav.setViewName("applylist");
		
		return mav;
	}

	//식구 모집 신청 삭제
	@RequestMapping("/apply/delete")
	public String handleRequest(
			@RequestParam("partyId") int partyId,
			@RequestParam("applyId") int applyId, 
			ModelMap model) throws Exception {
		frogBanchan.deleteApply(applyId);
		
		return "redirect:/party/view";
	}
}