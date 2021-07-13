package com.vishal.gamePortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.gamePortal.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
