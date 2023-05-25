package com.frog.frogbanchan.controller.party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frog.frogbanchan.service.FrogBanchanFacade;

@Controller
public class ListPartyController { 

	private FrogBanchanFacade frogbanchan;

	@Autowired
	public void setFrogbanchan(FrogBanchanFacade frogbanchan) {
		this.frogbanchan = frogbanchan;
	}

	@RequestMapping("/party/list.do")
	public ModelAndView handleRequest() throws Exception {
		return new ModelAndView("/party/list", "partyList", frogbanchan.findPartyList());
	}
}