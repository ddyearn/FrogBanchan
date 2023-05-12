package com.frog.frogbanchan.dao.mybatis.mapper;

import com.frog.frogbanchan.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    // nickname으로 member 객체 가져오기
    List<Member> findMembersByNickname(String nickname);

    // 전체 member 가져오기
    List<String> findUsernameList();

}
