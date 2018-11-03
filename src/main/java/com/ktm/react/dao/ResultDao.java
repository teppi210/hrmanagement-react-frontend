package com.ktm.react.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ktm.react.bean.InterviewCandidateBean;
import com.ktm.react.entity.CallLetterEntity;
import com.ktm.react.entity.CertificateVerificationEntity;
import com.ktm.react.entity.EmployeeEntity;

@Service
public interface ResultDao {

	InterviewCandidateBean getresultDetail(int candidate_id,int round_id,String date);
	Iterable<InterviewCandidateBean> getSelectedCandidatesDetail(int round_id, int round_statusid);
	InterviewCandidateBean getSelectedCandidateProfileDetails(int candidate_id);

	String getcallLetterAcceptanceInfoStatus(CallLetterEntity callletterentity);
	List<InterviewCandidateBean> getAcceptedCandidatesDetail();
	Iterable<InterviewCandidateBean> getCallLetterRelease();
	InterviewCandidateBean getReleaseCandidateProfileDetails(int candidate_id);
	Iterable<EmployeeEntity> getemployee();
	String setCertificateVerifyStatusDetails(CertificateVerificationEntity certificateVerifyentity);
	List<InterviewCandidateBean> searchSelectedCandidateResultDetails(String date);
	String setcallLetterReleaseDetail(int candidate_id, int hr_id);
	EmployeeEntity getemployeeDetail(int candidate_id);
}
