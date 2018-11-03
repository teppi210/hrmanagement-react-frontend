package com.ktm.react.dao;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.ktm.react.bean.InterviewCandidateBean;
import com.ktm.react.entity.CallInfoEntity;
import com.ktm.react.entity.CandidateEntity;
import com.ktm.react.entity.InterviewProcessEntity;
import com.ktm.react.entity.NcandidateEntity;

public interface CallInfoDao {

	String getcallInfoStatusDetails(CallInfoEntity callinfoentity) throws Exception;
	List<InterviewCandidateBean> getinterviewDetails();
	String setInterviewDetails(InterviewProcessEntity interviewprocessentity);
	List<InterviewCandidateBean> searchDetails(String date, int round_id);
	CandidateEntity getreAllocateInterviewInfoStatus(int candidate_id);
	List<InterviewCandidateBean> getreAllocateInterviewInfoStatus(CallInfoEntity callinfoentity);
	ModelAndView getmodalcallInfoStatusDetails(CallInfoEntity callinfoentity);
	Iterable<InterviewCandidateBean> getRoundName(String date);
	
	
}
