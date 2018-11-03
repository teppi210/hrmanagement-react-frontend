package com.ktm.react.controller;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktm.react.entity.CallInfoEntity;
import com.ktm.react.entity.CandidateEntity;
import com.ktm.react.entity.InterviewProcessEntity;
import com.ktm.react.bean.InterviewCandidateBean;
import com.ktm.react.dao.CallInfoDao;

@RequestMapping("interview")
@RestController
public class InterviewController {
	
	@Autowired
	private CallInfoDao callinfodao;
		
//	@GetMapping("callInfo")
//	public ModelAndView getCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
//		return callinfodao.getCandidateProfileDetails(candidate_id);
//	}

	@PostMapping("callInfoStatus")
	public String getcallInfoStatus(CallInfoEntity callinfoentity,HttpServletRequest request, HttpServletResponse response) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		callinfoentity.setCreated_by(1);
		callinfoentity.setCreated_date(date);
		System.out.println(callinfoentity.toString());
		return callinfodao.getcallInfoStatusDetails(callinfoentity);
	}

//	@PostMapping("modalcallInfoStatus")
//	public ModelAndView getmodalcallInfoStatus(CallInfoEntity callinfoentity,HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mdv=new ModelAndView();
//		HttpSession session = request.getSession();
//		UserEntity loginedUser = Myutils.getLoginedUser(session);
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//	    Date dateobj = new Date();
//	    String date=df.format(dateobj);
//		if(loginedUser == null){
//			System.out.println("CallInfo Illegal access....");
//			mdv.addObject("errorString", "Please Login...");
//			mdv.setViewName("index");
//		}else{
//			callinfoentity.setCreated_by(loginedUser.getHr_id());
//			callinfoentity.setCreated_date(date);
//			System.out.println(callinfoentity.toString());
//			mdv = callinfodao.getmodalcallInfoStatusDetails(callinfoentity);
//		}
//		return mdv;
//	}

	@GetMapping("candidate")
	public CandidateEntity getreAllocateInterviewProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		return callinfodao.getreAllocateInterviewInfoStatus(candidate_id);
	}
	
	@PostMapping("reAllocateInterview")
	public List<InterviewCandidateBean> getreAllocateInterviewInfoStatus(CallInfoEntity callinfoentity,HttpServletRequest request, HttpServletResponse response) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
			callinfoentity.setCreated_by(1);
			callinfoentity.setCreated_date(date);
			return callinfodao.getreAllocateInterviewInfoStatus(callinfoentity);
	}
	
	@GetMapping("interview")
	public List<InterviewCandidateBean> getinterview(HttpServletRequest request, HttpServletResponse response) {
			return callinfodao.getinterviewDetails();
		
	}
	
	@PostMapping("interviewprocesssave")
	public String setInterviewDetail(InterviewProcessEntity interviewprocessentity,HttpServletRequest request, HttpServletResponse response) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
			interviewprocessentity.setCreated_by(1);
			interviewprocessentity.setCreated_date(date);
			return callinfodao.setInterviewDetails(interviewprocessentity);
	}
	
	
}
