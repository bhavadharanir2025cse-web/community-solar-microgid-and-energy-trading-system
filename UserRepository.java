package com.example.communitysolar.repository;

import com.example.communitysolar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}