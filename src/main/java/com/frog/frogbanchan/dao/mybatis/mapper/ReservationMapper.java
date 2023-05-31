package com.frog.frogbanchan.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.frog.frogbanchan.domain.Reservation;

@Mapper
public interface ReservationMapper {

    // 예약처리
    void insertReservation(Reservation reservation);

    // 예약취소(매개변수로 도메인 전부 써야해서 객체로 설정)
    void deleteReservation(Reservation reservation);

    // 예약확인
    Reservation findReservation(String placeId, String username);

}
