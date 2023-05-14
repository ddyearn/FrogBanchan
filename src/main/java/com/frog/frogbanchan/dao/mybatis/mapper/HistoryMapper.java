package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.History;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {

    void insertHistory(History history);

    void updateHistory(History history);

    void deleteHistory(int historyId);

    // history_id로 history 조회
    History findHistory(int historyId);

    List<History> findHistoryList(String username);


}
