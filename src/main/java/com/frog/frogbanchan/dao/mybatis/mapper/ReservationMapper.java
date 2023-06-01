package com.frog.frogbanchan.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.frog.frogbanchan.domain.Reservation;

@Mapper
public interface ReservationMapper {

    // 예약처리
    void insertReservation(Reservation reservation);

    // 예약취소
    void deleteReservation(int reservationId);

    // 예약확인
    Reservation findReservation(String placeId, String username);

}
