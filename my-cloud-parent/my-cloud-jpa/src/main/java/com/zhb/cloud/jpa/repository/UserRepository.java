package com.zhb.cloud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhb.cloud.jpa.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
