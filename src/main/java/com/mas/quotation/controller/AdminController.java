package com.mas.quotation.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mas.quotation.model.Response;
import com.mas.quotation.model.UserDto;
import com.mas.quotation.model.UserRole;
import com.mas.quotation.service.UserDetail;
import com.mas.quotation.util.Constant;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserDetail userService;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * This post API is used to change the user role by only Admin
	 * @param userRole
	 * @return ResponseEntity<String>
	 */
	@CrossOrigin
	@PostMapping("/changeRole")
    public ResponseEntity<?> changeRole(@RequestBody UserRole userRole){
		logger.info("changeRole API called");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Iterator<? extends GrantedAuthority> iter = authentication.getAuthorities().iterator();
		String role = iter.next().toString();
		if(!Constant.ROLE_ADMIN.equals(role))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body("Only Admin can change the role!");
		String signUp = userService.changeRole(userRole);
		if(signUp.equals(Constant.SIGN_UP_SUCCESS)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body("User Role changes successfully!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body(signUp);
    }
	
	/**
	 * This get API is used to return list of users with their roles
	 * @return ResponseEntity<List<UserRole>>
	 */
	@CrossOrigin
	@GetMapping({ "/getAllUsers" })
	public ResponseEntity<Response> getAllUsers() {
		List<UserRole> userList = userService.getAllUsers();
		Response response = new Response();
		if (null != userList) {
			logger.info("getAllUsers is Success");
			response.setResponseData(userList);
			response.setStatus("SUCCESS");
		} else {
			response.setStatus("NO DATA FOUND");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(response);
	}
	
	/**
	 * This post API is used to delete a user by only Admin 
	 * @param userRole
	 * @return ResponseEntity<String>
	 */
	@CrossOrigin
	@PostMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody UserDto user){
		logger.info("deleteUser API called");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Iterator<? extends GrantedAuthority> iter = authentication.getAuthorities().iterator();
		String role = iter.next().toString();
		if(!Constant.ROLE_ADMIN.equals(role))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body("Only Admin can delete a user!");
		
		String signUp = userService.deleteUser(user);
		if(signUp.equals(Constant.DELETE_SUCCESS)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body("User Deleted successfully!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body(signUp);
    }
}
