package com.ktm.react.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ktm.react.entity.DesignationEntity;
import com.ktm.react.entity.InterviewrRoundEntity;
import com.ktm.react.entity.NcandidateEntity;

public interface CandidateDao {

	List<NcandidateEntity> viewCandidateDetails();
	List<NcandidateEntity> searchDetails(String search);
	NcandidateEntity getCandidateProfileDetails(int candidate_id);
	String setaddCandidates(HttpServletRequest request, NcandidateEntity user);
	String setaddDesignation(HttpServletRequest request, DesignationEntity user);
	List<DesignationEntity> getaddDesignation();
	String setaddInterviewrounds(HttpServletRequest request, InterviewrRoundEntity user);
	List<InterviewrRoundEntity> getaddInterviewround();

	
}
