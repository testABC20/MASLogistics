package com.mas.quotation.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
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
import com.mas.quotation.model.ChangePasswordDto;
import com.mas.quotation.model.SignUpDto;
import com.mas.quotation.model.UserRole;
import com.mas.quotation.util.Constant;
import com.mas.quotation.util.InvalidInputException;
import com.mas.quotation.util.ValidationUtil;

@Service
public class UserDetail implements UserDetailsService {

	@Autowired
	UserDAO userRepo;
	
	@Autowired
	RoleDAO roleRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * This method is used to authenticate the user
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Check for username or email in database");
		User user = userRepo.findByUsernameOrEmail(username, username).get();
		if (user == null) {
			throw new UsernameNotFoundException("User not exists by Username");
		}
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		authorities.add(new SimpleGrantedAuthority(user.getEmail()));
		
		logger.info("Authorization success");
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}
	
	/**
	 * This method is used to register new user
	 * @param signUpDto
	 * @return String
	 */
	public String signUpUser(SignUpDto signUpDto) {
		try {
			logger.info("Validate SignUp details");
			ValidationUtil.validateSignUp(signUpDto);
			
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
	        
		}catch(InvalidInputException ex) {
			logger.error("Invalid Entries in Signup:{}",ex);
			return ex.getMessage();
		}catch(Exception e) {
			logger.error("Error Occurred: {}", e);
			return "Error registering the user";
		}
		
        return Constant.SIGN_UP_SUCCESS;
	}
	
	/**
	 * This method is used to change the password
	 * @param changePasswordDto
	 * @return String
	 */
	public String changePassword(ChangePasswordDto changePasswordDto) {
		
		// checking for username exists in a database
		User user = null;
		try {
			logger.info("Validate Input");
			ValidationUtil.validateChangePassword(changePasswordDto);
			
			logger.info("Validate if username present");
			user = userRepo.findByUsername(changePasswordDto.getUsername());
			if (user != null) {
				if(passwordEncoder.matches(changePasswordDto.getPassword(),user.getPassword())) {
					user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
					userRepo.save(user);
				}else {
					return "Invalid Credentials!";
				}
			}else {
				logger.info("Username not present in DB: {}", changePasswordDto.getUsername());
				return "Username not Found!";
			}
		}catch(InvalidInputException ex) {
			logger.error("Invalid Input: {}", ex);
			return ex.getMessage();
		}catch(NoSuchElementException e) {
			logger.error("Username not present in DB: {}", e);
			return "Username not Found!";
		}catch(Exception e) {
			logger.error("Error Occurred: {}", e);
			return "Error changing password for: "+changePasswordDto.getUsername();
		}
		return Constant.CHANGE_SUCCESS;
	}
	
	/**
	 * This method is used to change user roles
	 * @param userRole
	 * @return String
	 */
	public String changeRole(UserRole userRole) {
		User user = null;
		try {
			logger.info("Validate Input");
			ValidationUtil.validateUserRole(userRole);
			
			logger.info("Validate if username present");
			// checking for username exists in a database
			
			user = userRepo.findByUsername(userRole.getUsername());
			if (user != null) {
				Role role = roleRepo.findByName(userRole.getRole()).get();
				if(role != null) {
					Set<Role> roles = new HashSet<>();
					roles.add(role);
					user.setRoles(roles);
				}else {
					logger.info("Role not present in DB for: {}", userRole.getUsername());
					return "Username/Role not Found! Valid roles are ROLE_USER and ROLE_ADMIN";
				}
				userRepo.save(user);
		        logger.info("User saved with role= {}",userRole.getRole());
			}else {
				logger.info("Username not present in DB: {}", userRole.getUsername());
				return "Username not Found!";
			}
		}catch(InvalidInputException ex) {
			logger.error("Invalid Input: {}", ex);
			return ex.getMessage();
		}catch(NoSuchElementException e) {
			logger.error("Username/Role not present in DB: {}", e);
			return "Username/Role not Found! Valid roles are ROLE_USER and ROLE_ADMIN";
		}catch(Exception e) {
			logger.error("Error Occurred: {}", e);
			return "Error changing Username/Role";
		}
		return Constant.SIGN_UP_SUCCESS;
	}
	
	/**
	 * This method is used fetch all users
	 * @return List<UserRole>
	 */
	public List<UserRole> getAllUsers(){
		logger.info("Fetch All Users");
		List<User> userList = userRepo.findAll();
		List<UserRole> userRoles = null;
		if (null != userList) {
			userRoles = userList
					.stream().map(p -> new UserRole(p.getUsername(), p.getRoles().stream()
							.map((role) -> (role.getName())).collect(Collectors.toSet()).toString()))
					.collect(Collectors.toList());

		}
		return userRoles;
	}
	
	/**
	 * This method is used to delete an user
	 * @param userRole
	 * @return String
	 */
	public String deleteUser(UserRole userRole) {
		User user = null;
		try {
			logger.info("Validate Input");
			ValidationUtil.validateUser(userRole);
			
			logger.info("Validate if username present");
			// checking for username exists in a database
			
			user = userRepo.findByUsername(userRole.getUsername());
			if (user != null) {
				userRepo.delete(user);
		        logger.info("User Deleted ");
			}else {
				logger.error("Username not present in DB: {}", userRole.getUsername());
				return "Username not Found!";
			}
		}catch(InvalidInputException ex) {
			logger.error("Invalid Input: {}", ex);
			return ex.getMessage();
		}catch(NoSuchElementException e) {
			logger.error("Username not present in DB: {}", e);
			return "Username not Found!";
		}catch(Exception e) {
			logger.error("Error Occurred: {}", e);
			return "Error deleting Username";
		}
		return Constant.DELETE_SUCCESS;
	}
}
