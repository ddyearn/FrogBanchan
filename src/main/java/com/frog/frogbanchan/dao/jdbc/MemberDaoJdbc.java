package com.frog.frogbanchan.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class MemberDaoJdbc {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public MemberDaoJdbc(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

//	public Member findMemberByNickname(String nickname) throws SQLException {
//		String sql = "SELECT * "
//					+ "FROM MEMBER "
//					+ "WHERE NICKNAME = ?";
//		jdbcUtil.setSqlAndParameters(sql, new Object[] { nickname });	// JDBCUtil에 query문과 매개 변수 설정
//
//		Member member = new Member();
//
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
//			if (rs.next()) {
//				String username = rs.getString("username");
//				String password = rs.getString("password");
//				String name = rs.getString("name");
//				String phone = rs.getString("phone");
//				String email = rs.getString("email");
//				String residentNo = rs.getString("resident_no");
//				String address = rs.getString("address");
//				member = new Member(username, password, name, nickname, phone, email, residentNo, address);
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 반환
//		}
//		return member;
//	}

	public List<String> findUsernameList() throws SQLException {
		String query = "SELECT username FROM MEMBER";

		try {
			List<String> memberList = jdbcTemplate.query(
					query,
					new RowMapper<String>() {
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString("USERNAME");
						}
					});
			return memberList;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
