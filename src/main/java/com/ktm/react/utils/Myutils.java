package com.ktm.react.utils;

import javax.servlet.http.HttpSession;

import com.ktm.react.entity.UserEntity;

public class Myutils {

	// Store user info in Session.
    public static void storeLoginedUser(HttpSession session, UserEntity loginedUser) {
     	session.setAttribute("loginedUser", loginedUser);
    }
    // Get the user information stored in the session.
    public static UserEntity getLoginedUser(HttpSession session) {
    	UserEntity loginedUser = (UserEntity) session.getAttribute("loginedUser");
        return loginedUser;
    }
}
