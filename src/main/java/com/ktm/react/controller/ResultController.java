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

import com.ktm.react.entity.CallLetterEntity;
import com.ktm.react.entity.CertificateVerificationEntity;
import com.ktm.react.entity.EmployeeEntity;
import com.ktm.react.bean.InterviewCandidateBean;
import com.ktm.react.dao.CallInfoDao;
import com.ktm.react.dao.ResultDao;

@RequestMapping("res")
@RestController
public class ResultController {

	@Autowired
	private CallInfoDao callinfodao;
	@Autowired
	private ResultDao resultdao;
	
	@GetMapping("viewRoundName")
	public Iterable<InterviewCandidateBean> getRoundName(@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {
		return callinfodao.getRoundName(date);
	}
	
	@GetMapping("searchResult")
	public List<InterviewCandidateBean> searchresult(@RequestParam String date,@RequestParam int round_id,HttpServletRequest request, HttpServletResponse response) {
		return callinfodao.searchDetails(date,round_id);
	}
	
	@GetMapping("resultDetail")
	public InterviewCandidateBean getInterviewResultDetail(@RequestParam int candidate_id,@RequestParam int round_id,@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {
			return resultdao.getresultDetail(candidate_id,round_id,date);				
	}
	
	@GetMapping("selectedCandidates")
	public Iterable<InterviewCandidateBean> getSelectedCandidatesDetail(HttpServletRequest request, HttpServletResponse response) {
			return resultdao.getSelectedCandidatesDetail(746,1);				
		
	}
	
	@GetMapping("searchSelectedCandidateResult")
	public List<InterviewCandidateBean> searchSelectedCandidateResult(@RequestParam String date,HttpServletRequest request, HttpServletResponse response) {
				System.out.println(date);
				return resultdao.searchSelectedCandidateResultDetails(date);
	}
	
	@GetMapping("selectedCandidateDetail")
	public InterviewCandidateBean getSelectedCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
			return resultdao.getSelectedCandidateProfileDetails(candidate_id);
		
	}
	
	@GetMapping("callLetterReleaseDetail")
	public String setcallLetterReleaseDetail(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		return resultdao.setcallLetterReleaseDetail(candidate_id,1);
	}
	
	@PostMapping("callLetterAcceptanceInfoStatus")
	public String getcallLetterAcceptanceInfoStatus(CallLetterEntity callletterentity,HttpServletRequest request, HttpServletResponse response) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
			callletterentity.setCreated_by(1);
			callletterentity.setCreated_date(date);
			return resultdao.getcallLetterAcceptanceInfoStatus(callletterentity);
		}

	@GetMapping("acceptedCandidates")
	public List<InterviewCandidateBean> getAcceptedCandidatesDetail(HttpServletRequest request, HttpServletResponse response) {
		return resultdao.getAcceptedCandidatesDetail();				
		}
	
//	@GetMapping("candidateDetailAcceptance")
//	public ModelAndView getCandidateProfileAcceptance(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mdv=new ModelAndView();
//		// Check User has logged on
//		HttpSession session = request.getSession();
//		UserEntity loginedUser = Myutils.getLoginedUser(session);
//		if(loginedUser == null){
//			System.out.println("CandidateDetail Illegal access....");
//				mdv.addObject("errorString", "Please Login...");
//				mdv.setViewName("index");
//		}else{
//			mdv = candidatedao.getCandidateProfileDetailsAcceptance(candidate_id);				
//		}
//		return mdv;
//	}
	
	@GetMapping("callLetterRelease")
	public Iterable<InterviewCandidateBean> getCallLetterRelease(HttpServletRequest request, HttpServletResponse response) {
		return resultdao.getCallLetterRelease();
		
	}
	
	@GetMapping("releaseCandidateDetail")
	public InterviewCandidateBean getReleaseCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		return resultdao.getReleaseCandidateProfileDetails(candidate_id);
	}
	
	@PostMapping("certificateVerifyStatus")
	public String setcertificateVerifyStatus(CertificateVerificationEntity certificateVerifyentity,HttpServletRequest request, HttpServletResponse response) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
			certificateVerifyentity.setCreated_by(1);
			certificateVerifyentity.setCreated_date(date);
			return resultdao.setCertificateVerifyStatusDetails(certificateVerifyentity);
	}
	
	@GetMapping("employee")
	public Iterable<EmployeeEntity> getemployee(HttpServletRequest request, HttpServletResponse response) {
		return resultdao.getemployee();
	}
	
	@GetMapping("employeeDetail")
	public EmployeeEntity getemployeeDetail(@RequestParam int employee_id,HttpServletRequest request, HttpServletResponse response) {
		return resultdao.getemployeeDetail(employee_id);
	}
	
}
