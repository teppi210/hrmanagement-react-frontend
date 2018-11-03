package com.ktm.react.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ktm.react.bean.UserBean;

public interface UserDao {
	
	int loginUser(HttpServletRequest request,UserBean user);
	ModelAndView profileDetail(HttpServletRequest request);
	ModelAndView logoutUser(HttpServletRequest request);

}
