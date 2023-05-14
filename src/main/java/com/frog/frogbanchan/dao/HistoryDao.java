package com.frog.frogbanchan.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.frog.frogbanchan.domain.History;


public interface HistoryDao {

    //히스토리 생성
    void insertHistory(History history) throws DataAccessException;
    // [INSERT INTO HISTORY (USERNAME, PLACE_ID) VALUES ...]

    //히스토리 수정
    void updateHistory(History history) throws DataAccessException;
    // [UPDATE HISTORY SET MENU_ID = ?, SCORE = ? WHERE USERNAME = ? AND RECORDED_DATE = ?]

    //히스토리 삭제
    void deleteHistory(int historyId) throws DataAccessException;
    // [DELETE FROME HISTORY WHERE USERNAME = ? AND RECORDED_DATE = ?]

    //히스토리 조회
    History findHistory(int historyId) throws DataAccessException;
    // [SELECT * FROM HISTORY WHERE HISTORY_ID = ?]

    //히스토리 리스트 조회
    List<History> findHistoryList(String username) throws DataAccessException;
    // [SELECT * FROM HISTORY WHERE USERNAME = ?]

}
