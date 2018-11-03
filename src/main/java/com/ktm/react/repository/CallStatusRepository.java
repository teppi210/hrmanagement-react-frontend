package com.ktm.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktm.react.entity.CallStatusEntity;

public interface CallStatusRepository extends JpaRepository<CallStatusEntity, Integer>{

}
