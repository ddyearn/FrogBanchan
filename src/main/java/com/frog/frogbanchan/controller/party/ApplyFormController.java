package com.frog.frogbanchan.controller.party;

import com.frog.frogbanchan.domain.Apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
public class ApplyFormController {
	private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }
	
    @ModelAttribute("applyForm")
    public ApplyForm createApplyForm() {
        return new ApplyForm();
    }
    
    @GetMapping
    public String showForm() {
		return "/party/view";
    }
    
	//식구 모집 신청
    @PostMapping("/apply/create/{partyId}")
	public String createApply(
			@SessionAttribute("userSession") UserSession userSession,
			@ModelAttribute("applyForm") ApplyForm applyForm,
			@PathVariable("partyId") int partyId, 
			HttpServletRequest request, HttpSession session) throws Exception {
    	Apply apply = applyForm.getApply();
    	apply.setWriter(userSession.getUser().getUsername());
    	apply.setPartyId(partyId);
    	
		frogBanchan.insertApply(apply);
		
		return "redirect:/party/view?partyId=" + partyId;
	}

	//식구 모집 신청 삭제
	@RequestMapping("/apply/delete/{partyId}")
	public String deleteApply(
			@ModelAttribute("applyForm") ApplyForm applyForm,
			@RequestParam("applyId") int applyId, 
			@PathVariable("partyId") int partyId,
			ModelMap model) throws Exception {
		frogBanchan.deleteApply(applyId);
		
		return "redirect:/party/view?partyId=" + partyId;
	}
}