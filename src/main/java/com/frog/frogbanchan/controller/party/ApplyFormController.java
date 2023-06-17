package com.frog.frogbanchan.controller.party;

import com.frog.frogbanchan.domain.Party;
import com.frog.frogbanchan.domain.Apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import com.frog.frogbanchan.service.validator.ApplyFormValidator;
import com.frog.frogbanchan.service.validator.PartyFormValidator;

@Controller
public class ApplyFormController {
	private FrogBanchanFacade frogBanchan;
    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }
	
	//식구 모집 신청
    @PostMapping("/apply/create")
	public String createApply(
			HttpServletRequest request, HttpSession session,
			@RequestParam("content") String content) throws Exception {
    	Apply apply = new Apply();
    	apply.setContent(content);

		frogBanchan.insertApply(apply);
		
		return "redirect:/party/view";
	}

	//식구 모집 신청 삭제
	@RequestMapping("/apply/delete")
	public String deleteApply(
			@RequestParam("applyId") int applyId, 
			ModelMap model) throws Exception {
		frogBanchan.deleteApply(applyId);
		
		return "redirect:/party/view";
	}
}