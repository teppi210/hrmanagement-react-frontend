package com.ktm.react.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.react.bean.UserBean;
import com.ktm.react.dao.UserDao;

@RequestMapping("log")
@RestController
public class LoginController {

	@Autowired
	private UserDao userdao;
	
    @PostMapping("login")
    public int login(HttpServletRequest request, HttpServletResponse response,
    		UserBean user) {	
    	return userdao.loginUser(request, user);
    }    
    @GetMapping("profile")
    public ModelAndView getprofile(HttpServletRequest request, HttpServletResponse response) {
    	return userdao.profileDetail(request);
    }
    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
    	return userdao.logoutUser(request);
    }

}
