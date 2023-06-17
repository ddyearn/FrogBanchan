package com.frog.frogbanchan.dao.mybatis;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.frog.frogbanchan.dao.ReservationDao;
import com.frog.frogbanchan.dao.mybatis.mapper.ReservationMapper;
import com.frog.frogbanchan.domain.Reservation;

@Repository
public class MybatisReservationDao implements ReservationDao {

    @Autowired
    private ReservationMapper reservationMapper;

    // 예약처리
    public void insertReservation(Reservation reservation) throws DataAccessException {
        reservationMapper.insertReservation(reservation);
    };

    // 예약취소
    public void deleteReservation(int reservationId) throws DataAccessException {
        reservationMapper.deleteReservation(reservationId);
    };

    // 예약확인
    public Reservation findReservation(String placeId, String username) throws DataAccessException {
        return reservationMapper.findReservation(placeId, username);
    };

    // 예약된 시간 가져오기
    public List<Timestamp> findReservedTime(String placeId) throws DataAccessException {
        return reservationMapper.findReservedTime(placeId);
    };

    // 예약 유저네임으로 가져오기
    public List<Reservation> findReservationByUsername(String username) throws DataAccessException {
        return reservationMapper.findReservationByUsername(username);
    };

    // 예약 사업자id로 가져오기
    public List<Reservation> findReservationByPlaceId(String placeId) throws DataAccessException {
        return reservationMapper.findReservationByPlaceId(placeId);
    };

    // 예약 reservationid로 가져오기
    public List<Reservation> findReservationByReservationId(String reservationId) throws DataAccessException {
        return reservationMapper.findReservationByReservationId(reservationId);
    };

}
