package com.frog.frogbanchan.dao;

import org.springframework.dao.DataAccessException;

import com.frog.frogbanchan.domain.Reservation;

public interface ReservationDao {

    // 예약처리
    void insertReservation(Reservation reservation) throws DataAccessException;

    // 예약취소(매개변수로 도메인 전부 써야해서 객체로 설정)
    void deleteReservation(Reservation reservation) throws DataAccessException;

    // 예약확인
    Reservation findReservation(String placeId, String username) throws DataAccessException;

}
