package com.frog.frogbanchan.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.frog.frogbanchan.domain.Reservation;

public interface ReservationDao {

    // 예약처리
    void insertReservation(Reservation reservation) throws DataAccessException;

    // 예약취소
    void deleteReservation(int reservationId) throws DataAccessException;

    // 예약확인
    Reservation findReservation(String placeId, String username) throws DataAccessException;

    // 예약된 시간 가져오기
    List<Timestamp> findReservedTime(String placeId) throws DataAccessException;

    // 예약 유저네임으로 가져오기
    List<Reservation> findReservationByUsername(String username) throws DataAccessException;

    // 예약 사업자id로 가져오기
    List<Reservation> findReservationByPlaceId(String placeId) throws DataAccessException;

    // 예약 reservationid로 가져오기
    List<Reservation> findReservationByReservationId(String reservationId) throws DataAccessException;

}
