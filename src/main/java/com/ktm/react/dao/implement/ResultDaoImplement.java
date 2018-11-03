package com.ktm.react.dao.implement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.react.bean.InterviewCandidateBean;
import com.ktm.react.entity.CallLetterEntity;
import com.ktm.react.entity.CandidateEntity;
import com.ktm.react.entity.CertificateVerificationEntity;
import com.ktm.react.entity.EmployeeEntity;
import com.ktm.react.dao.ResultDao;
import com.ktm.react.services.CallLetterReleaseService;
import com.ktm.react.services.CallLetterService;
import com.ktm.react.services.CandidateService;
import com.ktm.react.services.CertificateVerificationService;
import com.ktm.react.services.EmployeeService;
import com.ktm.react.services.InterviewProcessService;

@Service
public class ResultDaoImplement implements ResultDao{
	@Autowired
	private CandidateService candidateImplement;
	@Autowired
	private InterviewProcessService interviewprocessImplement;
	@Autowired
	private CallLetterReleaseService callletterreleaseImplement;
	@Autowired
	private CallLetterService callletterImplement;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CertificateVerificationService certificateverificationImplement;
	
	
	@Override
	public InterviewCandidateBean getresultDetail(int candidate_id,int round_id,String date) {
			InterviewCandidateBean ce=null;
			System.out.println("Call Info");
			try{
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    Date dateobj = new Date();
			    System.out.println(df.format(dateobj));
				ce=interviewprocessImplement.findInterviewUserRoundResult(candidate_id,round_id,date);
				System.out.println(ce.toString());
			}catch(Exception e){
				System.out.println(e);
			}
		return ce;
	}

	@Override
	public Iterable<InterviewCandidateBean> getSelectedCandidatesDetail(int round_id, int round_statusid) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> ce=null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));
			System.out.println("Selected Candidates");
			try{
				ce=interviewprocessImplement.findSelectedCandidates(round_id,round_statusid,df.format(dateobj));
				System.out.println(ce);
			}catch(Exception e){
				System.out.println(e);
			}
		return ce;
	}

	@Override
	public InterviewCandidateBean getSelectedCandidateProfileDetails(int candidate_id) {
		// TODO Auto-generated method stub
		InterviewCandidateBean ce=null;
			System.out.println("Selected Candidate Profile"+ candidate_id);
			try{
				ce=interviewprocessImplement.findSelectedCandidateProfileDetails(candidate_id);
				System.out.println(ce.toString());
			}catch(Exception e){
				System.out.println(e);
			}
		return ce;
	}

	@Override
	public String setcallLetterReleaseDetail(int candidate_id,int created_by) {
		// TODO Auto-generated method stub
		String errorString = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
			System.out.println("Call Info");
			try{
				callletterreleaseImplement.setcallLetterReleaseDetail(candidate_id,df.format(dateobj),created_by,df.format(dateobj));
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			if(errorString.equals("")){
				errorString=" Success";
			}else{
				errorString=" Allready Call Letter Released...";
			}		
		return errorString;
	}

	@Override
	public String getcallLetterAcceptanceInfoStatus(CallLetterEntity callletterentity) {
			String errorString = "";
			System.out.println("Call Letter Acceptance");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			System.out.println(df.format(dateobj));
			try{
				System.out.println(callletterentity.getCandidate_id());
				callletterImplement.save(callletterentity);
				callletterreleaseImplement.update(callletterentity.getCandidate_id(),1,callletterentity.getCreated_by(),callletterentity.getCreated_date());
				System.out.println("Interview registered.");
			}catch(Exception e){
				errorString = "Error occured...";
				System.out.println(e);
			}
			
		return errorString;
		
	}

	@Override
	public List<InterviewCandidateBean> getAcceptedCandidatesDetail() {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> ce=null;
			System.out.println("Accepted Candidates");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date dateobj = new Date();
		    System.out.println(df.format(dateobj));
			try{
				ce=callletterImplement.findAcceptedCandidates(df.format(dateobj));
				System.out.println(ce);
			}catch(Exception e){
				System.out.println(e);
			}
		return ce;
	}

	@Override
	public Iterable<InterviewCandidateBean> getCallLetterRelease() {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> ce=null;
		System.out.println("Call Letter Release Candidates");
			try{
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dateobj = new Date();
				System.out.println(df.format(dateobj));
				ce=callletterreleaseImplement.getCallLetterRelease(df.format(dateobj));
				System.out.println(ce.toString());
			}catch(Exception e){
				System.out.println(e);
			}
		
		return ce;
	}

	@Override
	public InterviewCandidateBean getReleaseCandidateProfileDetails(int candidate_id) {
		// TODO Auto-generated method stub
		InterviewCandidateBean ce=null;
			System.out.println("ReleaseCandidateProfileDetails");
			try{
				ce=interviewprocessImplement.findSelectedCandidateProfileDetails(candidate_id);
			}catch(Exception e){
				System.out.println(e);
			}
		return ce;
	}

	@Override
	public Iterable<EmployeeEntity> getemployee() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> list= null;
		System.out.println("View employee");
		try{
			list= employeeService.findAll();
			System.out.println(list.toString());
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}

	@Override
	public String setCertificateVerifyStatusDetails(CertificateVerificationEntity certificateVerifyentity) {
		String errorString = "";
		EmployeeEntity ee=new EmployeeEntity();
		CandidateEntity ce1=null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));
		System.out.println("Certificate Verify");
		try{
			System.out.println(certificateVerifyentity.getCandidate_id());
			certificateverificationImplement.save(certificateVerifyentity);
			ce1=candidateImplement.findUser(certificateVerifyentity.getCandidate_id());
			ee.setEmployee_name(ce1.getCandidate_name());
			ee.setEmployee_age(ce1.getCandidate_age());
			ee.setEmployee_address(ce1.getCandidate_address());
			ee.setEmployee_emailid(ce1.getCandidate_emailid());
			ee.setEmployee_phoneno(ce1.getCandidate_phoneno());
			ee.setEmployee_qualification(ce1.getCandidate_qualification());
			ee.setEmployee_designation(ce1.getCandidate_designation());
			ee.setEmployee_resume(ce1.getCandidate_resume());
			ee.setEmployee_filepath(ce1.getCandidate_filepath());
			ee.setCreated_by(certificateVerifyentity.getCreated_by());
			ee.setCreated_date(certificateVerifyentity.getCreated_date());
			employeeService.save(ee);
			System.out.println(ee);
			callletterImplement.update(certificateVerifyentity.getCandidate_id(),1,certificateVerifyentity.getCreated_by(),certificateVerifyentity.getCreated_date());
			System.out.println("Verification registered.");
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			errorString="Verification registered...";
		}else{
			errorString = "Error occured...";
		}
	return errorString;
	}

	@Override
	public List<InterviewCandidateBean> searchSelectedCandidateResultDetails(String date) {
		// TODO Auto-generated method stub
			List<InterviewCandidateBean> rob=null;
			System.out.println("searchSelectedCandidateResultDetails");
			System.out.println("date: "+date);
			   	try{
			   		String dates=date.toString();
			  		rob=interviewprocessImplement.findSelectedCandidates(746,1,dates);
			   	}catch(NullPointerException e){
					System.out.println();
				}
			
			
			return rob;

	}

	@Override
	public EmployeeEntity getemployeeDetail(int candidate_id) {
		// TODO Auto-generated method stub
		EmployeeEntity ce=null;
		System.out.println("ReleaseCandidateProfileDetails");
		try{
			ce=employeeService.findUser(candidate_id);
		}catch(Exception e){
			System.out.println(e);
		}
	return ce;
	}

}
