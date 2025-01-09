package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.form.LoginForm;

public interface UserRepository {
	User selectUser(LoginForm form);
}
