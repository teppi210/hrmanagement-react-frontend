package com.ktm.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ktm.react.entity.UserEntity;

public interface HomeRepository extends JpaRepository<UserEntity, Integer>{

}
