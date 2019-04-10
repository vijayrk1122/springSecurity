package com.tutorial.security.securityrbacexample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutorial.security.securityrbacexample.domains.CustomUserDetailsDomain;
import com.tutorial.security.securityrbacexample.domains.UserDomain;
import com.tutorial.security.securityrbacexample.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserDomain> optionalUser = userRepository.findByName(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("username not found"));
		return optionalUser.map(CustomUserDetailsDomain :: new).get();
	}
}
