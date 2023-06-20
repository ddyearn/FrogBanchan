package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.MenuDao;
import com.frog.frogbanchan.dao.mybatis.mapper.MenuMapper;
import com.frog.frogbanchan.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MybatisMenuDao implements MenuDao {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public Menu findMenu(int menuId) throws DataAccessException {
        return menuMapper.findMenu(menuId);
    }

    @Override
    public List<Menu> findMenuList() throws DataAccessException {
        return menuMapper.findMenuList();
    }

    @Override
    public List<Menu> findMenuListByTagList(Map<String, List<String>> tagList) throws DataAccessException {
        return menuMapper.findMenuListByTagList(tagList);
    }

    @Override
    public List<String> findMenuTagList(int menuId) throws DataAccessException {
        return menuMapper.findMenuTagList(menuId);
    }

    @Override
    public List<String> findAllTagList() throws DataAccessException {
        return menuMapper.findAllTagList();
    }

    @Override
    public String findMenuByPlaceMenuId(int placeMenuId) throws DataAccessException {
        return menuMapper.findMenuByPlaceMenuId(placeMenuId);
    }
}
