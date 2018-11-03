package com.ktm.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ktm.react.entity.InterviewrRoundEntity;

public interface InterviewRoundRepository extends JpaRepository<InterviewrRoundEntity, Integer>{

	@Query(value = "select count(round_id) from interview_round",nativeQuery = true)
	int getRoundCount();

}
