package com.frog.frogbanchan.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import java.sql.Timestamp;
import com.frog.frogbanchan.domain.Place;

public interface PlaceDao {

    // 사업자 최초가입
    void insertPlace(Place place) throws DataAccessException;
    /*
     * INSERT INTO Place(place_id, password, name, address, menu_list)
     * VALUES (#{placeId}, #{password}, #{name}, #{address}, #{menuList})
     */

    // 가게수정 : 메뉴, 상호명, 주소 변경
    void updatePlace(Place place) throws DataAccessException;
    /*
     * UPDATE Place
     * SET name = #{name}
     * address = #{address}
     * menu_list =#{menuList}
     * WHERE place_id = #{placeId}
     */

    // 가게 삭제
    void deletePlace(String placeId) throws DataAccessException;
    /*
     * DELETE Place
     * WHERE place_id = #{placeId}
     */

    // 가게 조회(myPageforPlace)
    Place findPlaceById(String placeId) throws DataAccessException;
    /*
     * SELECT Place
     * WHERE place_id = #{placeId}
     */

    // 예약 가능 시간 체크
    void insertAvailableTime(String placeId, Timestamp availableTime) throws DataAccessException;
    /*
     * insert into Place(place_id, available_time)
     * values (#{placeId}, #{availableime})
     */

    // 캘린더 가져오기
    List<Timestamp> findCalendar(String placeId) throws DataAccessException;
    /*
     * SELECT Place
     * WHERE place_id = #{placeId}
     */

    // 사업자 아이디 목록
    List<String> findAllPlaceIdList() throws DataAccessException;

    // 모든 가게 찾기
    List<Place> findAllPlaceList() throws DataAccessException;

}