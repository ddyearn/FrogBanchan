package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.PlaceMenu;
import com.frog.frogbanchan.domain.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMenuMapper {
    void insertPlaceMenu(PlaceMenu placeMenu);

    void updatePlaceMenu(PlaceMenu placeMenu);

    void deletePlaceMenu(int placeMenuId);

    PlaceMenu findPlaceMenu(int placeMenuId);

    List<PlaceMenu> findMenuListByPlaceId(String placeId);

    List<Place> findPlaceListByMenu(int menuId);

    void deletePlaceMenuByPlaceId(String placeId);
}
