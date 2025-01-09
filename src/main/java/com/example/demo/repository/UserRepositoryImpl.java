package com.example.demo.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.form.LoginForm;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
	
	private final JdbcTemplate jdbctemplate;

	@Override
	public User selectUser(LoginForm form) {
		//DBアクセスをして、ID・パスワードをUserに保存して返す
		String sql = "SELECT user_id, password FROM m_user WHERE user_id = ?";
		String userId = form.getUserId();
		
		Map<String, Object> list = jdbctemplate.queryForMap(sql, userId);
		
		User user = new User();
		user.setUserId((String)list.get("user_id"));
		user.setPassword((String) list.get("password"));
		
		return user;
	}

}
