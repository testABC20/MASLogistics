package com.mas.quotation.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mas.quotation.entity.PackNPorts;
import com.mas.quotation.entity.Quotations;
import com.mas.quotation.model.ChangePasswordDto;
import com.mas.quotation.model.LoginDto;
import com.mas.quotation.model.LoginResponse;
import com.mas.quotation.model.QuotationRequest;
import com.mas.quotation.model.Response;
import com.mas.quotation.model.SignUpDto;
import com.mas.quotation.service.MasQuotationService;
import com.mas.quotation.service.UserDetail;
import com.mas.quotation.util.Constant;
import com.mas.quotation.util.InvalidInputException;
import com.mas.quotation.util.ValidationUtil;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UserDetail userService;

	@Autowired
	MasQuotationService service;

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * This post API is used to authenticate User
	 * 
	 * @param loginDto
	 * @return ResponseEntity<LoginResponse>
	 */
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginDto loginDto) {
		logger.info("Login API called");

		try {
			logger.info("Validate login details");
			ValidationUtil.validateLogin(loginDto);
		} catch (InvalidInputException ex) {
			logger.error("Invalid Login details:{}", ex);
			LoginResponse resp = new LoginResponse();
			resp.setStatus(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body(resp);
		}

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Iterator<? extends GrantedAuthority> iter = authentication.getAuthorities().iterator();
		LoginResponse resp = new LoginResponse();
		resp.setStatus("User login successfully!");
		resp.setUsername(authentication.getName());
		resp.setRole(iter.next().toString());
		resp.setEmailId(iter.next().toString());
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(resp);
	}

	/**
	 * This post API is used to register new user
	 * 
	 * @param signUpDto
	 * @return ResponseEntity<String>
	 */
	@CrossOrigin
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
		logger.info("SignUp API called");
		String signUp = userService.signUpUser(signUpDto);
		if (signUp.equals(Constant.SIGN_UP_SUCCESS)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *")
					.body("User is registered successfully!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body(signUp);
	}

	/**
	 * This Post API is used to change password
	 * 
	 * @param changePasswordDto
	 * @return ResponseEntity<String>
	 */
	@CrossOrigin
	@PostMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
		logger.info("changePassword API called");
		String signUp = userService.changePassword(changePasswordDto);
		if (signUp.equals(Constant.CHANGE_SUCCESS)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *")
					.body("Password changed successfully!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("Access-Control-Allow-Origin: *").body(signUp);
	}

	/**
	 * This Get API is used for health check by load balancer
	 * 
	 * @return String
	 */
	@CrossOrigin
	@GetMapping({ "/health" })
	public String health() {
		return "Hello & Welcome to MAS Logistics !!!";
	}

	/**
	 * This Get API is used to fetch all pack and ports
	 * @return
	 */
	@CrossOrigin
	@GetMapping({ "/getPacknPorts" })
	public ResponseEntity<Response> findAllPackNPorts() {
		List<PackNPorts> masQuoteList = service.findAllPackNPorts();
		Response response = new Response();
		if (null != masQuoteList && !masQuoteList.isEmpty()) {
			logger.info("FindAllPackNPorts is Success");
			response.setResponseData(masQuoteList);
			response.setStatus("SUCCESS");
		} else {
			response.setStatus("NO DATA FOUND");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(response);
	}

	/**
	 * This Get API is used to fetch pack and ports based on transport mode
	 * @param transportMode
	 * @return
	 */
	@CrossOrigin
	@GetMapping({ "/getPacknPortsByMode/{transportMode}" })
	public ResponseEntity<Response> getPackNPortsTransport(@PathVariable String transportMode) {
		List<PackNPorts> masQuoteList = null;
		Response response = new Response();
		logger.info("TransportMode used is:{}", transportMode);

		if (transportMode != null && !transportMode.trim().isEmpty()) {
			masQuoteList = service.getPackNPortsTransport(transportMode);
			if (null != masQuoteList && !masQuoteList.isEmpty()) {
				logger.info("getPackNPortsTransport is Success");
				response.setResponseData(masQuoteList);
				response.setStatus("SUCCESS");
			} else {
				response.setStatus("NO DATA FOUND");
			}
		} else {
			response.setStatus("INVALID TRANSPORT MODE");
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(response);
	}

	/**
	 * This Post API is used to save a Quote
	 * @param quote
	 * @param files
	 * @return ResponseEntity<Response>
	 */
	@CrossOrigin
	@PostMapping(value = "/saveQuote", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> saveQuotation(@RequestPart("jsonBodyData") QuotationRequest quote,
			@RequestParam MultiValueMap<String, MultipartFile> files) {
		Response response = new Response();
		Quotations quotation = service.saveQuotation(quote, files);

		if (quotation != null) {
			logger.info("Save is Successful");
			List<Quotations> quoteList = new ArrayList<>();
			quoteList.add(quotation);
			response.setResponseData(quoteList);
			response.setStatus("SUCCESS");
		} else {
			response.setStatus("NO QUOTE FOUND");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(response);
	}
}