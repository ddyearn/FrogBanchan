package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.PlaceMenuDao;
import com.frog.frogbanchan.dao.mybatis.mapper.PlaceMenuMapper;
import com.frog.frogbanchan.domain.Place;
import com.frog.frogbanchan.domain.PlaceMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MybatisPlaceMenuDao implements PlaceMenuDao {

    @Autowired
    private PlaceMenuMapper placeMenuMapper;

    @Override
    public void insertPlaceMenu(PlaceMenu placeMenu) throws DataAccessException {
        placeMenuMapper.insertPlaceMenu(placeMenu);
    }

    @Override
    public void updatePlaceMenu(PlaceMenu placeMenu) throws DataAccessException {
        placeMenuMapper.updatePlaceMenu(placeMenu);
    }

    @Override
    public void deletePlaceMenu(int placeMenuId) throws DataAccessException {
        placeMenuMapper.deletePlaceMenu(placeMenuId);
    }

    @Override
    public PlaceMenu findPlaceMenu(int placeMenuId) throws DataAccessException {
        return placeMenuMapper.findPlaceMenu(placeMenuId);
    }

    @Override
    public List<PlaceMenu> findMenuListByPlaceId(String placeId) throws DataAccessException {
        return placeMenuMapper.findMenuListByPlaceId(placeId);
    }

    @Override
    public List<Place> findPlaceListByMenu(int menuId) throws DataAccessException {
        return placeMenuMapper.findPlaceListByMenu(menuId);
    }

    @Override
    public void deletePlaceMenuByPlaceId(String placeId) throws DataAccessException {
        placeMenuMapper.deletePlaceMenuByPlaceId(placeId);
    }
}
