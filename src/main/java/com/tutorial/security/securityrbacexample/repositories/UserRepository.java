package com.tutorial.security.securityrbacexample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.security.securityrbacexample.domains.UserDomain;

public interface UserRepository extends JpaRepository<UserDomain, Integer>{

	Optional<UserDomain> findByName(String username);

}
