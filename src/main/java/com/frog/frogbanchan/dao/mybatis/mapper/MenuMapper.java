package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {

    Menu findMenu(int menuId);

    List<Menu> findMenuList();

    List<Menu> findMenuListByTagList(Map<String, List<String>> tagList);

    List<String> findMenuTagList(int menuId);

    List<String> findAllTagList();

    String findMenuByPlaceMenuId(int placeMenuId);
}
