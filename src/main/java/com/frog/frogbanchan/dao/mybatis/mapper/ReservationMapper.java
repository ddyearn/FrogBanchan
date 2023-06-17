package com.frog.frogbanchan.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.sql.Timestamp;
import java.util.List;

import com.frog.frogbanchan.domain.Reservation;

@Mapper
public interface ReservationMapper {

    // 예약처리
    void insertReservation(Reservation reservation);

    // 예약취소
    void deleteReservation(int reservationId);

    // 예약확인
    Reservation findReservation(String placeId, String username);

    // 예약된 시간 가져오기
    List<Timestamp> findReservedTime(String placeId);

    // 예약 유저네임으로 가져오기
    List<Reservation> findReservationByUsername(String username);

    // 예약 사업자id로 가져오기
    List<Reservation> findReservationByPlaceId(String placeId);

    // 예약 reservationid로 가져오기
    List<Reservation> findReservationByReservationId(String reservationId);

}
