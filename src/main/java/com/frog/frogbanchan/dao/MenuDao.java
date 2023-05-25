package com.frog.frogbanchan.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.Menu;

public interface MenuDao {
    //메뉴 조회
    Menu findMenu(int menuId) throws DataAccessException;
    //[SELECT * FROM MENU WHERE MENU_ID = ?]

    //메뉴 리스트 조회
    List<Menu> findMenuList() throws DataAccessException;
    //[SELECT * FROM MENU]

    //태그 리스트로 메뉴 리스트 조회
    List<Menu> findMenuListByTagList(Map<String, List<String>> tagList) throws DataAccessException;
    //[SELECT *
    // FROM MENU JOIN MENU_TAG ON MENU.MENU_ID = MENU_TAG.MENU_ID
    // WHERE MENU_TAG.TAG IN ? AND MENU_TAG.TAG NOT IN ?]

    //매뉴의 태그 리스트 조회
    List<String> findMenuTagList(int menuId) throws DataAccessException;
    //[SELECT TAG
    // FROM MENU_TAG
    // WHERE MENU_ID = ?]

    //모든 태그 리스트 조회
    List<String> findAllTagList() throws DataAccessException;
    //[SELECT DISTINCT TAG FROM MENU_TAG ]
}
