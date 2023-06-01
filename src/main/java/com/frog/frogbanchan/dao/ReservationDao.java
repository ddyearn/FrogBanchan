package com.frog.frogbanchan.dao;

import org.springframework.dao.DataAccessException;

import com.frog.frogbanchan.domain.Reservation;

public interface ReservationDao {

    // 예약처리
    void insertReservation(Reservation reservation) throws DataAccessException;

    // 예약취소
    void deleteReservation(int reservationId) throws DataAccessException;

    // 예약확인
    Reservation findReservation(String placeId, String username) throws DataAccessException;

}
