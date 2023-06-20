package com.frog.frogbanchan.dao.mybatis;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.frog.frogbanchan.dao.PlaceDao;
import com.frog.frogbanchan.dao.mybatis.mapper.PlaceMapper;
import com.frog.frogbanchan.domain.Place;

@Repository
public class MybatisPlaceDao implements PlaceDao {

    @Autowired
    private PlaceMapper placeMapper;

    // 사업자 최초가입
    public void insertPlace(Place place) throws DataAccessException {
        placeMapper.insertPlace(place);
    };

    // 가게수정 : 메뉴, 상호명, 주소 변경
    public void updatePlace(Place place) throws DataAccessException {
        placeMapper.updatePlace(place);
    };

    // 가게 삭제
    public void deletePlace(String placeId) throws DataAccessException {
        placeMapper.deletePlace(placeId);
    };

    // 가게 조회(myPageforPlace)
    public Place findPlaceById(String placeId) throws DataAccessException {
        return placeMapper.findPlaceById(placeId);
    };

    // 예약 가능 시간 체크
    public void insertAvailableTime(String placeId, Timestamp availableTime) throws DataAccessException {
        placeMapper.insertAvailableTime(placeId, availableTime);
    };

    // 캘린더 가져오기
    public List<Timestamp> findCalendar(String placeId) throws DataAccessException {
        return placeMapper.findCalendar(placeId);
    }

    public List<String> findAllPlaceIdList() throws DataAccessException {
        return placeMapper.findAllPlaceIdList();
    }

    public List<Place> findAllPlaceList() throws DataAccessException {
        return placeMapper.findAllPlaceList();
    }



}
