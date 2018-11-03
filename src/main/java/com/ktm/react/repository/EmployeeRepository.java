package com.ktm.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktm.react.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

}
