package com.ktm.react.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.react.entity.NcandidateEntity;
import com.ktm.react.repository.NcandidateRepository;

@Service
public class NcandidateService {

	@Autowired
	private final NcandidateRepository ncandidateRepository;
	
	public NcandidateService(NcandidateRepository ncandidateRepository){
		this.ncandidateRepository=ncandidateRepository;
	}
	
	public void save(NcandidateEntity ncandidateentity) {
		// TODO Auto-generated method stub
		System.out.println("save "+ncandidateentity.toString());
		
		ncandidateRepository.save(ncandidateentity.getNcandidate_name(), ncandidateentity.getNcandidate_age(), ncandidateentity.getNcandidate_emailid(), ncandidateentity.getNcandidate_phoneno(),
				ncandidateentity.getNcandidate_address(), ncandidateentity.getNcandidate_qualification(), ncandidateentity.getNcandidate_designation(),
				ncandidateentity. getNcandidate_resume(),ncandidateentity.getNcandidate_filepath(),ncandidateentity.getCreated_by(),ncandidateentity.getCreated_date(),ncandidateentity.getModified_by(),ncandidateentity.getModified_date());
	}
	
	public List<NcandidateEntity> findAll() {
		// TODO Auto-generated method stub
		List<NcandidateEntity> candidate= new ArrayList<>();
		for(NcandidateEntity candidates: ncandidateRepository.findAllCandidates()){
			candidate.add(candidates);
		}
		return candidate;

	}

	public NcandidateEntity findUser(int candidate_id) {
		// TODO Auto-generated method stub
		System.out.println(candidate_id);
		return ncandidateRepository.getOne(candidate_id);
	}
	
	public void delete(String emailid) {
		// TODO Auto-generated method stub
		ncandidateRepository.deleteByNcandidate_emailid(emailid);
	}
	
	public List<NcandidateEntity> getSearch(String name) {
		// TODO Auto-generated method stub
		List<NcandidateEntity> candidate= new ArrayList<>();
		for(NcandidateEntity candidates: ncandidateRepository.getSearch(name)){
			candidate.add(candidates);
		}
		return candidate;
	}

}
