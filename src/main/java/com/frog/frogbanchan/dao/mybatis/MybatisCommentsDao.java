package com.frog.frogbanchan.dao.mybatis;

import com.frog.frogbanchan.dao.CommentsDao;
import com.frog.frogbanchan.dao.mybatis.mapper.CommentsMapper;
import com.frog.frogbanchan.domain.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisCommentsDao implements CommentsDao {
    @Autowired
    private CommentsMapper commentsMapper;

    public void insertComment(Comments comments) {
        commentsMapper.insertComment(comments);
    }

    public void deleteComment(int commentId) {
        commentsMapper.deleteComment(commentId);
    }

    public void deleteCommentsByPartyId(int partyId) {
        commentsMapper.deleteCommentsByPartyId(partyId);
    }

    public Comments findCommentByCommentId(int commentId) {
        return commentsMapper.findCommentByCommentId(commentId);
    }

    public List<Comments> findCommentsByPartyId(int partyId) {
        return commentsMapper.findCommentsByPartyId(partyId);
    }

    public List<Comments> findCommentList() {
        return commentsMapper.findCommentList();
    }
}
