package com.ktm.react.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.react.entity.CandidateEntity;
import com.ktm.react.repository.CandidateRepository;

@Service
public class CandidateService{

	@Autowired
	private final CandidateRepository candidaterepository;
	
	public CandidateService(CandidateRepository candidaterepository){
		this.candidaterepository=candidaterepository;
	}
	
	
	public List<CandidateEntity> findAll() {
		// TODO Auto-generated method stub
		List<CandidateEntity> candidate= new ArrayList<>();
		for(CandidateEntity candidates: candidaterepository.findAllCandidates()){
			candidate.add(candidates);
		}
		return candidate;
	}
	
	public List<CandidateEntity> getSearch(String name) {
		// TODO Auto-generated method stub
		List<CandidateEntity> candidate= new ArrayList<>();
		for(CandidateEntity candidates: candidaterepository.getSearch(name)){
			candidate.add(candidates);
		}
		return candidate;
	}
	
	public CandidateEntity findUser(int candidateid){
		return candidaterepository.getOne(candidateid);
	}

	
	public void delete(int candidate_id) {
		// TODO Auto-generated method stub
		candidaterepository.deleteById(candidate_id);
		
	}

	
	public void save(CandidateEntity ce) {
		// TODO Auto-generated method stub
		candidaterepository.save(ce);
	}


	public CandidateEntity findUserByEmailid(String ncandidate_emailid) {
		// TODO Auto-generated method stub
		System.out.println(ncandidate_emailid);
		CandidateEntity ce=null;
		try{
			ce=candidaterepository.getUserByEmailid(ncandidate_emailid);
		}catch(NullPointerException e){
			ce=null;
		}			
		return ce;
	}
	

}
