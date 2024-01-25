package com.mas.quotation.service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mas.quotation.dao.RoleDAO;
import com.mas.quotation.dao.UserDAO;
import com.mas.quotation.entity.Role;
import com.mas.quotation.entity.User;
import com.mas.quotation.model.SignUpDto;
import com.mas.quotation.util.Constant;

@Service
public class UserDetail implements UserDetailsService {

	@Autowired
	UserDAO userRepo;
	
	@Autowired
	RoleDAO roleRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Check for username or email in database");
		User user = userRepo.findByUsernameOrEmail(username, username).get();
		if (user == null) {
			throw new UsernameNotFoundException("User not exists by Username");
		}
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		logger.info("Authorization success");
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}
	
	public String signUpUser(SignUpDto signUpDto) {
		logger.info("Validate if username or email present");
		 // checking for username exists in a database
        if(userRepo.findByUsername(signUpDto.getUsername()) != null){
            return "Username is already exist!";
        }
        // checking for email exists in a database
        if(userRepo.findByEmail(signUpDto.getEmail()) != null){
            return "Email is already exist!";
        }
        // creating user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepo.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(roles));
        userRepo.save(user);
        logger.info("User saved with ROLE_USER");
        return Constant.SIGN_UP_SUCCESS;
	}
}
