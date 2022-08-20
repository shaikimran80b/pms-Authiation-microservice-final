package com.pms.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.authorization.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
}