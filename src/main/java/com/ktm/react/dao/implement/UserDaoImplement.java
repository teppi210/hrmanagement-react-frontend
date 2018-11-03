package com.ktm.react.dao.implement;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.react.bean.UserBean;
import com.ktm.react.entity.UserEntity;
import com.ktm.react.utils.Myutils;
import com.ktm.react.dao.UserDao;
import com.ktm.react.services.UserService;

@Service
public class UserDaoImplement implements UserDao{

	@Autowired
	private UserService userImplement;
	
	@Override
	public int loginUser(HttpServletRequest request,UserBean user) {
		// TODO Auto-generated method stub
		System.out.println("login");
		int n=0;
    	System.out.println("emailid "+user.getHr_emailid()+"\t"+"password "+user.getHr_password());
    	UserEntity ub=null;
    	if(user.getHr_emailid().equals("") || user.getHr_password().equals("")){
    		n=-1;
    	}else{
        	try{
	    		ub=(UserEntity) userImplement.getHrs(user.getHr_emailid(),user.getHr_password());
	    		System.out.println(ub.toString());
        	}catch(NullPointerException e){
    			n=-2;
    		}
    	}
    	if(n==0){
    		n=ub.getHr_id();
    	}
    	return n;
	}
	
	@Override
	public ModelAndView profileDetail(HttpServletRequest request){
		ModelAndView mdv=new ModelAndView();  	
    	String errorString = "";
    	UserEntity ub=null;
    	// Check User has logged on
    	HttpSession session = request.getSession();
		UserEntity loginedUser = Myutils.getLoginedUser(session);
	    
    	if(loginedUser == null){
    		System.out.println("Profile Illegal access....");
	    	errorString="Please Login...";
	    }else{
	    	System.out.println("profile");
		    System.out.println("logined user: "+loginedUser.getHr_emailid());
    		
	    	try{
	    		ub= userImplement.findUser(loginedUser.getHr_id());
	    		System.out.println("profile "+ub.getHr_emailid());
	    	}catch(Exception e){
	    		System.out.println(e);
	    	}
	    }
    	if(errorString.equals("")){
    		mdv.addObject("userDetail", ub);
    		mdv.setViewName("profile");
    	}else{
    		mdv.addObject("errorString",errorString);
			mdv.setViewName("index");
    	}
	    return mdv;
	}
	
	@Override
	public ModelAndView logoutUser(HttpServletRequest request) {
    	ModelAndView mdv=new ModelAndView();
    	try{
	    	System.out.println("logout");
	    	HttpSession session=request.getSession();
	        UserEntity loginedUser = Myutils.getLoginedUser(session);
	        session.removeAttribute(loginedUser.getHr_name());
	        session.invalidate();
	    	mdv.addObject("user",new UserBean());
	    	mdv.setViewName("index");
    	}catch(Exception e){
    		System.out.println(e);
    		try{
    			mdv.setViewName("index");
    		}catch(Exception e1){
    			System.out.println(e1);
    		}
    	}
    	return mdv;
    }
	

}
