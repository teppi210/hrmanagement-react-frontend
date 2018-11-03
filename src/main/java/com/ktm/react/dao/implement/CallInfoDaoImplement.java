package com.ktm.react.dao.implement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.react.bean.InterviewCandidateBean;
import com.ktm.react.entity.CallInfoEntity;
import com.ktm.react.entity.CandidateEntity;
import com.ktm.react.entity.InterviewProcessEntity;
import com.ktm.react.entity.NcandidateEntity;
import com.ktm.react.services.CallInfoService;
import com.ktm.react.services.CandidateService;
import com.ktm.react.services.InterviewProcessService;
import com.ktm.react.services.NcandidateService;
import com.ktm.react.dao.CallInfoDao;

@Service
public class CallInfoDaoImplement implements CallInfoDao {

	
	@Autowired
	private CandidateService candidateImplement;
	@Autowired 
	private NcandidateService ncandidateImplement;
	@Autowired
	private CallInfoService callinfoImplement;
	@Autowired
	private InterviewProcessService interviewprocessImplement;
	
	@SuppressWarnings({"unused" })
	@Override
	public String getcallInfoStatusDetails(CallInfoEntity callinfoentity) throws Exception {
		NcandidateEntity ce=null;
		List<NcandidateEntity> list=null;
		CandidateEntity candidateentity=null;
		String errorString="";
		System.out.println("Call Info");
		try{
			System.out.println(callinfoentity.getCandidate_id());
			ce=ncandidateImplement.findUser(callinfoentity.getCandidate_id());
			System.out.println(ce.toString());
			CandidateEntity cae=new CandidateEntity();
			cae.setCandidate_id(ce.getNcandidate_id());
			cae.setCandidate_name(ce.getNcandidate_name());
			cae.setCandidate_age(ce.getNcandidate_age());
			cae.setCandidate_address(ce.getNcandidate_address());
			cae.setCandidate_emailid(ce.getNcandidate_emailid());
			cae.setCandidate_phoneno(ce.getNcandidate_phoneno());
			cae.setCandidate_qualification(ce.getNcandidate_qualification());
			cae.setCandidate_designation(ce.getNcandidate_designation());
			cae.setCandidate_resume(ce.getNcandidate_resume());
			cae.setCandidate_filepath(ce.getNcandidate_filepath());
			cae.setCreated_by(callinfoentity.getCreated_by());
			cae.setCreated_date(ce.getCreated_date());
			System.out.println(cae.toString());
			System.out.println(ce.getNcandidate_emailid());
			candidateentity=candidateImplement.findUserByEmailid(ce.getNcandidate_emailid());
			//System.out.println(candidateentity.toString());
			if(candidateentity == null){
				System.out.println("candidate null");
				candidateImplement.save(cae);
				callinfoImplement.save(callinfoentity);
				ncandidateImplement.delete(ce.getNcandidate_emailid());
				list= ncandidateImplement.findAll();
				errorString="Interview registered...";
				System.out.println("Interview registered.");
			}else{
				System.out.println("candidate not null");
				errorString="Already interview attened by candidate "+ce.getNcandidate_name()+"\n So cancelled the candidate application";
				ncandidateImplement.delete(ce.getNcandidate_emailid());
				System.out.println(ce.getNcandidate_id());
				list= ncandidateImplement.findAll();
			}
		}catch(Exception e){
			errorString = "Error: "+e;
			System.out.println(e);
		}
	
	return errorString;
	}
	
	@Override
	public ModelAndView getmodalcallInfoStatusDetails(CallInfoEntity callinfoentity) {
		ModelAndView mdv=new ModelAndView();
		String errorString = "";
		NcandidateEntity ce=null;
		List<NcandidateEntity> list= null;
		
		System.out.println("Call Info");
		try{
			System.out.println(callinfoentity.getCandidate_id());
			ce=ncandidateImplement.findUser(callinfoentity.getCandidate_id());
			System.out.println(ce.toString());
			CandidateEntity cae=new CandidateEntity();
			cae.setCandidate_id(ce.getNcandidate_id());
			cae.setCandidate_name(ce.getNcandidate_name());
			cae.setCandidate_age(ce.getNcandidate_age());
			cae.setCandidate_address(ce.getNcandidate_address());
			cae.setCandidate_emailid(ce.getNcandidate_emailid());
			cae.setCandidate_phoneno(ce.getNcandidate_phoneno());
			cae.setCandidate_qualification(ce.getNcandidate_qualification());
			cae.setCandidate_designation(ce.getNcandidate_designation());
			cae.setCandidate_resume(ce.getNcandidate_resume());
			cae.setCandidate_filepath(ce.getNcandidate_filepath());
			cae.setCreated_by(callinfoentity.getCreated_by());
			cae.setCreated_date(ce.getCreated_date());
			System.out.println(cae.toString());
			candidateImplement.save(cae);
			callinfoImplement.save(callinfoentity);
			ncandidateImplement.delete(ce.getNcandidate_emailid());
			list= ncandidateImplement.findAll();
			System.out.println("Interview registered.");
			
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			//ce=candidatedao.findUser(callinfoentity.getCandidate_id());
			mdv.addObject("successMessage", "Interview registered...");
			mdv.addObject("candidateDetail", list);
			mdv.setViewName("viewCandidate");
		}else{
			//throw new Exception("Already interview attened by candidate");
			mdv.addObject("successMessage",errorString);
			mdv.addObject("candidateDetail", list);
			mdv.addObject("callinfoentity",callinfoentity);
			mdv.setViewName("viewCandidate");
		}
	return mdv;
	}
	
	@Override
	public CandidateEntity getreAllocateInterviewInfoStatus(int candidate_id) {
		// TODO Auto-generated method stub
		CandidateEntity ce=null;
			System.out.println("reAllocateInterview");
			try{
				ce=candidateImplement.findUser(candidate_id);
			}catch(Exception e){
				System.out.println(e);
			}
		
		return ce;
	}

	@Override
	public List<InterviewCandidateBean> getreAllocateInterviewInfoStatus(CallInfoEntity callinfoentity) {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    List<InterviewCandidateBean> list= null;
		System.out.println("reAllocateInterviewInfo");
		try{
			System.out.println(callinfoentity.getCandidate_id());
			System.out.println(callinfoentity.toString());
			callinfoImplement.delete(callinfoentity.getCandidate_id());
			System.out.println(callinfoentity.toString());
			callinfoentity.setCandidate_status(0);
			callinfoImplement.save(callinfoentity);
			list = callinfoImplement.findInterview(df.format(dateobj));
			System.out.println("Interview registered.");
		}catch(Exception e){
			System.out.println(e);
		}
	return list;
	}
	
	@Override
	public List<InterviewCandidateBean> getinterviewDetails() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    List<InterviewCandidateBean> list= null;
			System.out.println("View Interview");
			try{
			    System.out.println(df.format(dateobj));
			    list = callinfoImplement.findInterview(df.format(dateobj));
			    System.out.println(list.toString());
			}catch(Exception e){
				System.out.println(e);
			}	
		return list;
	}

	@Override
	public String setInterviewDetails(InterviewProcessEntity interviewprocessentity) {
		String errorString = "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
		System.out.println("interview Process");
		System.out.println(interviewprocessentity.toString());
		System.out.println(df.format(dateobj)+"  "+date);
		try{
			interviewprocessentity.setInterview_date(df.format(dateobj));
			InterviewProcessEntity ipe=interviewprocessImplement.findInterviewDetail(interviewprocessentity.getCandidate_id(),interviewprocessentity.getRound_id(),interviewprocessentity.getInterview_date());
			if(ipe == null){
				interviewprocessImplement.save(interviewprocessentity);
				if(interviewprocessentity.getRound_statusid()==2){
					callinfoImplement.update(interviewprocessentity.getCandidate_id(),1);
				}
				if(interviewprocessentity.getRound_id()==746){
					callinfoImplement.update(interviewprocessentity.getCandidate_id(),1);
				}
			}else{
				errorString = "Already round details registered...";
			}
			System.out.println(interviewprocessentity.getCandidate_id());
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			return "Registered...";
		}else{
			return errorString;
		}
		
	}

	@Override
	public List<InterviewCandidateBean> searchDetails(String date,int round_id) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> rob=null;
		System.out.println("SearchResults");
		System.out.println("Designation Name: "+date+"round_id: "+round_id);
		   	try{
		  		rob=interviewprocessImplement.getSearchResult(date,round_id);
		   	}catch(NullPointerException e){
				System.out.println(e);
			}
		return rob;
	}

	@Override
	public Iterable<InterviewCandidateBean> getRoundName(String date) {
		// TODO Auto-generated method stub
		List<InterviewCandidateBean> list= null;
		System.out.println("View Interview");
		try{
		    System.out.println(date);
		    list = callinfoImplement.getRoundName(date);
		    System.out.println(list.toString());
		}catch(Exception e){
			System.out.println(e);
		}	
	return list;
	}
	
}
