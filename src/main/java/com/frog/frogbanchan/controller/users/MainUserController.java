package com.frog.frogbanchan.controller.users;

import com.frog.frogbanchan.controller.TeamSession;
import com.frog.frogbanchan.controller.UserSession;
import com.frog.frogbanchan.domain.Party;
import com.frog.frogbanchan.domain.Place;
import com.frog.frogbanchan.domain.Reservation;
import com.frog.frogbanchan.domain.Team;
import com.frog.frogbanchan.service.FrogBanchanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("teamSession")
public class MainUserController {

    private FrogBanchanFacade frogBanchan;

    @Autowired
    public void setFrogBanchan(FrogBanchanFacade frogBanchan) {
        this.frogBanchan = frogBanchan;
    }

    @RequestMapping("/user/main")
    public ModelAndView handleRequest1(@SessionAttribute("userSession") UserSession userSession)
            throws Exception {
        ModelAndView mav = new ModelAndView("/user/mainForCommon");

        String user = userSession.getUser().getUsername();

        List<Team> teamList = frogBanchan.findTeamList(user);
        Map<Integer, Integer> teamMap = new HashMap<>();
        for (Team team : teamList) {
            teamMap.put(team.getTeamId(), frogBanchan.findTeamMembers(team.getTeamId()).size());
        }
        mav.addObject("teamList", teamList);
        mav.addObject("teamMap", teamMap);

        List<String> hateTagList = frogBanchan.findTagsByUsername(user);
        mav.addObject("hateTagList", hateTagList);

        return mav;
    }

    @RequestMapping("/user/myPage")
    public ModelAndView handleRequest2(@SessionAttribute("userSession") UserSession userSession)
            throws Exception {
        ModelAndView mav = new ModelAndView("/user/myPageForCommon");

        String user = userSession.getUser().getUsername();
        mav.addObject("user", userSession.getUser());
        mav.addObject("historyList", frogBanchan.findHistoryList(user));
        mav.addObject("reservationList", frogBanchan.findReservationByUsername(user));

        return mav;
    }

    @GetMapping("/user/reservation")
    public ModelAndView handleReservationList(@SessionAttribute("userSession") UserSession userSession)
            throws Exception {
        ModelAndView mav = new ModelAndView("/user/reservationList");

        String user = userSession.getUser().getUsername();
        mav.addObject("user", userSession.getUser());
        List<Reservation> reservationList = frogBanchan.findReservationByUsername(user);

        List<String> reservationDateList = new ArrayList<String>();
        List<String> reservationNameList = new ArrayList<String>();
        List<Integer> reservationIDList = new ArrayList<Integer>();

        for (Reservation reservation : reservationList) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(reservation.getReservationDate());
            reservationDateList.add(date);

            String id = reservation.getPlaceId();
            String placename = frogBanchan.findPlaceById(id).getName();
            reservationNameList.add(placename);
            reservationIDList.add(reservation.getReservationId());
        }
        mav.addObject("reservationDateList", reservationDateList);
        mav.addObject("reservationNameList", reservationNameList);
        mav.addObject("reservationIDList", reservationIDList);;

        return mav;
    }

    @RequestMapping("/team/main/{teamId}")
    public String handleRequest3(@PathVariable("teamId") int teamId,
            Model model) throws Exception {
        model.addAttribute(new TeamSession(frogBanchan.findTeam(teamId)));
        model.addAttribute("memberList", frogBanchan.findTeamMembers(teamId));
        model.addAttribute("team", frogBanchan.findTeam(teamId));

        return "/team/teamPage";
    }

    @RequestMapping("/user/place/list")
    public String handleRequest4(Model model) throws Exception {
        model.addAttribute("placeList", frogBanchan.findAllPlaceList());

        return "/user/placeList";
    }

    // 식구 리스트 조회
    @RequestMapping("/party/list")
    public ModelAndView handleRequest() throws Exception {
        List<Place> places = frogBanchan.findAllPlaceList();
        List<Party> partyList = frogBanchan.findPartyList();

        ModelAndView mav = new ModelAndView("/party/list");
        mav.addObject("partyList", partyList);
        mav.addObject("places", places);

        return mav;
    }

}
