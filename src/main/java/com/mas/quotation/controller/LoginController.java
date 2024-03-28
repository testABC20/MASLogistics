package com.mas.quotation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mas.quotation.model.LoginDto;
import com.mas.quotation.model.LoginResponse;
import com.mas.quotation.model.SignUpDto;
import com.mas.quotation.service.UserDetail;
import com.mas.quotation.util.Constant;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetail userService;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginDto loginDto) {
		logger.info("Login API called");
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		LoginResponse resp = new LoginResponse();
		resp.setStatus("User login successfully!");
		resp.setUsername(authentication.getName());
		resp.setRole(authentication.getAuthorities().toString());
		
		//return new ResponseEntity<>(resp, HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(resp);
	}
	
	@CrossOrigin
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
		logger.info("SignUp API called");
		String signUp = userService.signUpUser(signUpDto);
		if(signUp.equals(Constant.SIGN_UP_SUCCESS)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body("User is registered successfully!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body(signUp);
    }
	
	@CrossOrigin
	@GetMapping({"/health"})
	public String health() {
		return "Hello & Welcome to MAS Logistics !!!";
	}
}