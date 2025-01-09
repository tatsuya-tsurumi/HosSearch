package com.example.demo.service;

import java.security.MessageDigest;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.form.LoginForm;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService {
	
	private final UserRepository repository;
	private final HttpSession session;

	@Override
	public boolean loginExecute(LoginForm form) {
		// インフラ層へ処理を依頼
		boolean result = false;
		
		User user = repository.selectUser(form);
		
		try {
			result = checkPassowrd(form.getPassword(), user.getPassword());
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		if(result) {
			String userId = user.getUserId();
			session.setAttribute("user", userId);
		}
		
		return result;
	}
	
	//ハッシュ値の比較
	public static boolean checkPassowrd(String pass, String hashedPass) throws Exception {
		
		//比較結果を返す
		return hashPassword(pass).equals(hashedPass);
	}
	
	//入力されたパスワードをハッシュ化
		public static String hashPassword(String password) throws Exception {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			return Base64.getEncoder().encodeToString(digest);
		}
}
