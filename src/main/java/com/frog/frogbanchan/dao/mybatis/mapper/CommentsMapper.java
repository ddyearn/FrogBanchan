package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsMapper {
    public void insertComment(Comments comments);

    public void deleteComment(int commentId);

    public void deleteCommentsByPartyId(int partyId);

    public Comments findCommentByCommentId(int commentId);

    public List<Comments> findCommentsByPartyId(int partyId);

    public List<Comments> findCommentList();
}
