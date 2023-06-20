package com.frog.frogbanchan.dao.mybatis.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.frog.frogbanchan.domain.Place;
import org.springframework.dao.DataAccessException;

@Mapper
public interface PlaceMapper {

    // 사업자 최초가입
    void insertPlace(Place place);

    // 가게수정 : 메뉴, 상호명, 주소 변경
    void updatePlace(Place place);

    // 가게 삭제
    void deletePlace(String placeId);

    // 가게 조회(myPageforPlace)
    Place findPlaceById(String placeId);

    // 예약 가능 시간 체크
    void insertAvailableTime(@Param("placeId") String placeId,
            @Param("availableTime") Timestamp availableTime);

    // 캘린더 가져오기
    List<Timestamp> findCalendar(String placeId);

    List<String> findAllPlaceIdList();

    List<Place> findAllPlaceList();

}
