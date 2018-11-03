package com.ktm.react.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktm.react.entity.InterviewrRoundEntity;
import com.ktm.react.repository.InterviewRoundRepository;

@Service
public class InterviewRoundService {

	@Autowired
	private final InterviewRoundRepository interviewRoundRepository;
	
	public InterviewRoundService(InterviewRoundRepository interviewRoundRepository){
		this.interviewRoundRepository=interviewRoundRepository;
	}

	
	public void save(InterviewrRoundEntity user) {
		// TODO Auto-generated method stub
		interviewRoundRepository.save(user);
	}

	public List<InterviewrRoundEntity> findAll() {
		// TODO Auto-generated method stub
		List<InterviewrRoundEntity> candidate= new ArrayList<>();
		for(InterviewrRoundEntity candidates: interviewRoundRepository.findAll()){
			candidate.add(candidates);
		}
		return candidate;
	}


	public int getRoundCount() {
		// TODO Auto-generated method stub
		return interviewRoundRepository.getRoundCount();
	}
	
}
