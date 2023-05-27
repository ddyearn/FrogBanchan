package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.UsersDao;
import com.frog.frogbanchan.dao.mybatis.mapper.UsersMapper;
import com.frog.frogbanchan.domain.Users;
import com.frog.frogbanchan.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisUsersDao implements UsersDao {

    @Autowired
    private UsersMapper usersMapper;

    public void insertUser(Users users) throws DataAccessException {
        usersMapper.insertUser(users);
    }

    public void updateUser(Users users) throws DataAccessException {
        usersMapper.updateUser(users);
    }

    public void deleteUser(String username) throws DataAccessException {
        usersMapper.deleteUser(username);
    }

    public void insertHateTag(String username, String tag) throws DataAccessException {
        usersMapper.insertHateTag(username, tag);
    }

    public void deleteHateTag(int tagId) throws DataAccessException {
        usersMapper.deleteHateTag(tagId);
    }

    public Users findUserByUsername(String username) throws DataAccessException {
        return usersMapper.findUserByUsername(username);
    }

    public List<Users> findUsersByNickname(String nickname) throws DataAccessException {
        return usersMapper.findUsersByNickname(nickname);
    }
    public List<String> findUsernameList() throws DataAccessException {
        return usersMapper.findUsernameList();
    }

    public List<Users> findUsersByTeamId(int teamId) throws DataAccessException {
        return usersMapper.findUsersByTeamId(teamId);
    }

    public List<Team> findTeamsByUsername(String username) throws DataAccessException {
        return usersMapper.findTeamsByUsername(username);
    }

    public List<String> findTagsByUsername(String username) throws DataAccessException {
        return usersMapper.findTagsByUsername(username);
    }

}
