package com.mas.quotation.util;

import com.mas.quotation.model.ChangePasswordDto;
import com.mas.quotation.model.LoginDto;
import com.mas.quotation.model.SignUpDto;
import com.mas.quotation.model.UserRole;

public class ValidationUtil {
	public static void validateUserRole(UserRole userRole) throws InvalidInputException{
		if(null != userRole) {
			if(null == userRole.getUsername() || userRole.getUsername().trim().equals("")) 
				throw new InvalidInputException("Enter Username!");
			if(null == userRole.getRole() || userRole.getRole().trim().equals("")) 
				throw new InvalidInputException("Enter Role!");
		}else {
			throw new InvalidInputException("User/Role not entered!");
		}
	}
	
	public static void validateUser(UserRole userRole) throws InvalidInputException{
		if(null != userRole) {
			if(null == userRole.getUsername() || userRole.getUsername().trim().equals("")) 
				throw new InvalidInputException("Enter Username!");
		}else {
			throw new InvalidInputException("User not entered!");
		}
	}
	
	public static void validateLogin(LoginDto loginDto) throws InvalidInputException{
		if(null != loginDto) {
			if(null == loginDto.getUsername() || loginDto.getUsername().trim().equals("")) 
				throw new InvalidInputException("Enter Username!");
			if(null == loginDto.getPassword() || loginDto.getPassword().trim().equals("")) 
				throw new InvalidInputException("Enter Password!");
		}else {
			throw new InvalidInputException("Invalid User/Password entered!");
		}
	}
	
	public static void validateSignUp(SignUpDto signUpDto) throws InvalidInputException{
		if(null != signUpDto) {
			if(null == signUpDto.getUsername() || signUpDto.getUsername().trim().equals("")) 
				throw new InvalidInputException("Enter Username!");
			if(null == signUpDto.getPassword() || signUpDto.getPassword().trim().equals("")) 
				throw new InvalidInputException("Enter Password!");
		}else {
			throw new InvalidInputException("Invalid User/Password entered!");
		}
	}
	
	public static void validateChangePassword(ChangePasswordDto changePasswordDto) throws InvalidInputException{
		if(null != changePasswordDto) {
			if(null == changePasswordDto.getUsername() || changePasswordDto.getUsername().trim().equals("")) 
				throw new InvalidInputException("Enter Username!");
			if(null == changePasswordDto.getPassword() || changePasswordDto.getPassword().trim().equals("")) 
				throw new InvalidInputException("Enter Password!");
			if(null == changePasswordDto.getNewPassword() || changePasswordDto.getNewPassword().trim().equals("")) 
				throw new InvalidInputException("Enter New Password!");
		}else {
			throw new InvalidInputException("Invalid User/Password entered!");
		}
	}
	
}
