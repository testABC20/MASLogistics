package com.mas.quotation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mas.quotation.model.Response;
import com.mas.quotation.model.UserRole;
import com.mas.quotation.service.UserDetail;
import com.mas.quotation.util.Constant;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserDetail userService;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@CrossOrigin
	@PostMapping("/changeRole")
    public ResponseEntity<?> changeRole(@RequestBody UserRole userRole){
		logger.info("changeRole API called");
		String signUp = userService.changeRole(userRole);
		if(signUp.equals(Constant.SIGN_UP_SUCCESS)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body("User Role changes successfully!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body(signUp);
    }
	
	@CrossOrigin
	@GetMapping({ "/getAllUsers" })
	public ResponseEntity<Response> findAllPackNPorts() {
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
}
