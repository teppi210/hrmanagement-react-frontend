package com.ktm.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ktm.react.entity.CertificateVerificationEntity;

public interface CertificateVerificationRepository  extends JpaRepository<CertificateVerificationEntity, Integer>{

	
	@Query(value = "INSERT INTO certificate_verification(verification_status,candidate_id,verification_date) values (?,?,?); ",nativeQuery = true)
	void insertcall(String callstatus,int candidate_id, String date);

}
