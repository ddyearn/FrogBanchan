package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.HistoryDao;
import com.frog.frogbanchan.dao.mybatis.mapper.HistoryMapper;
import com.frog.frogbanchan.domain.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisHistoryDao implements HistoryDao {

    @Autowired
    private HistoryMapper historyMapper;


    @Override
    public void insertHistory(History history) throws DataAccessException {
        historyMapper.insertHistory(history);
    }

    @Override
    public void updateHistory(History history) throws DataAccessException {
        historyMapper.updateHistory(history);
    }

    @Override
    public void deleteHistory(int historyId) throws DataAccessException {
        historyMapper.deleteHistory(historyId);
    }

    @Override
    public History findHistory(int historyId) throws DataAccessException {
        return historyMapper.findHistory(historyId);
    }

    @Override
    public List<History> findHistoryList(String username) throws DataAccessException {
        return historyMapper.findHistoryList(username);
    }

    @Override
    public void deleteHistoryByUsername(String username) throws DataAccessException {
        historyMapper.deleteHistoryByUsername(username);
    }
}
