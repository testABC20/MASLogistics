package com.mas.quotation.util;

public class InvalidInputException extends Exception{

	private static final long serialVersionUID = -5404269362798726891L;
	
	public InvalidInputException() {}
	public InvalidInputException(String message) {
		super(message);
	}
}
