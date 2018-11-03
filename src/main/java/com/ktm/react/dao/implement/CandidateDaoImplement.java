package com.ktm.react.dao.implement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ktm.react.entity.DesignationEntity;
import com.ktm.react.entity.InterviewrRoundEntity;
import com.ktm.react.entity.NcandidateEntity;
import com.ktm.react.dao.CandidateDao;
import com.ktm.react.services.DesignationService;
import com.ktm.react.services.InterviewRoundService;
import com.ktm.react.services.NcandidateService;

@Service
public class CandidateDaoImplement implements CandidateDao{

	@Autowired 
	private NcandidateService ncandidateService;
	@Autowired
	private DesignationService designationService;
	@Autowired
	private InterviewRoundService interviewroundService;

	@Override
	public List<NcandidateEntity> viewCandidateDetails() {
		List<NcandidateEntity> list= null;
			System.out.println("View Candidate");
			try{
				list= ncandidateService.findAll();
				System.out.println(list.toString());
			}catch(Exception e){
				System.out.println(e);
			}	
		return list;
	}
	
	@Override
	public List<NcandidateEntity> searchDetails(String search) {
		// TODO Auto-generated method stub
		List<NcandidateEntity> ub=null;
			System.out.println("Search candidates");
			System.out.println("Designation Name: "+search);
			try{
	    		ub=ncandidateService.getSearch(search);
	    		System.out.println(ub.toString());
	    	}catch(NullPointerException e){
				System.out.println(e);
			}
		return ub;
	}

	@Override
	public NcandidateEntity getCandidateProfileDetails(int candidate_id) {
			NcandidateEntity ce=null;
			System.out.println("Candidate Detail");
			try{
				ce=ncandidateService.findUser(candidate_id);
				System.out.println(ce);
			}catch(Exception e){
				System.out.println(e);
			}
		return ce;
	}
	
	
	@Override
	public String setaddCandidates(HttpServletRequest request, NcandidateEntity user) {
		// TODO Auto-generated method stub
		String errorString = "";
		String successMessage="";
		System.out.println("Add Candidate");
		try{
			System.out.println(user.getNcandidate_designation());
			String split=user.getNcandidate_designation();
			System.out.println(split);
			String[] arrSplit = split.split(",");
		    for (int i=0; i < arrSplit.length; i++)
		    {
		      System.out.println(arrSplit[i]);
		      user.setNcandidate_designation(arrSplit[i]);
		      ncandidateService.save(user);
		    }
			System.out.println("Candidate registered.");
		}catch(Exception e){
			errorString = "Error occured...";
			System.out.println(e);
		}
		if(errorString.equals("")){
			successMessage="success";
		}else{
			successMessage=errorString;
		}
	return successMessage;
	}

	@Override
	public String setaddDesignation(HttpServletRequest request, DesignationEntity user) {
		// TODO Auto-generated method stub
		System.out.println("Designation detail");
		try{
			System.out.println(user.getDesignation_name());
			designationService.save(user);
		    System.out.println("Designation registered.");
		}catch(Exception e){
			System.out.println(e);
		}
		
	return "Designation registered.";
	}

	@Override
	public List<DesignationEntity> getaddDesignation() {
		// TODO Auto-generated method stub
		List<DesignationEntity> list= null;
		// Check User has logged on
			System.out.println("View Designation");
			try{
				list= designationService.findAll();
				System.out.println(list.toString());
			}catch(Exception e){
				System.out.println(e);
			}
		return list;
	}

	@Override
	public String setaddInterviewrounds(HttpServletRequest request, InterviewrRoundEntity user) {
		// TODO Auto-generated method stub
		System.out.println("Designation detail");
		try{
			System.out.println(user.getRound_name());
			interviewroundService.save(user);
		    System.out.println("Designation registered.");
		}catch(Exception e){
			System.out.println(e);
		}
		
	return "Interview Round registered.";
	}

	@Override
	public List<InterviewrRoundEntity> getaddInterviewround() {
		// TODO Auto-generated method stub
		List<InterviewrRoundEntity> list= null;
		// Check User has logged on
			System.out.println("View Designation");
			try{
				list= interviewroundService.findAll();
				System.out.println(list.toString());
			}catch(Exception e){
				System.out.println(e);
			}
		return list;
	}

	
	
}
