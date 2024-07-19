package com.mas.quotation.util;

public class Constant {
	public static String MSDS_FILE = "msdsFile";
	public static String DRAWING_FILE = "drawingFile";
	public static String EMAIL_CONTENT =
		      "<!DOCTYPE html>\n"
			          + "<html>\n"
			          + "<head>\n"
			          + "    <meta charset=\"utf-8\">\n"
			          + "    <title>Example HTML Email</title>\n"
			          + "</head>\n"
			          + "<body style=\"background: whitesmoke; padding: 30px; height: 100%\">\n"
			          + "<h5 style=\"font-size: 18px; margin-bottom: 6px\">Hello,</h5>\n"
			          + "<p style=\"font-size: 16px; font-weight: 500\">Your Quote is Successfully saved.</p>\n"
			          + "<p><a target=\"_blank\" style=\"background-color: #FF0000; color: white;padding: 15px 25px; \" href=\"https://maslogistics.net/\">MAS Logistics</a></p>"
			          + "</body>\n"
			          + "</html>";
	
	public static String SENDER_EMAIL = "";
	public static String EMAIL_SUBJECT = "Quote Saved";
	public static String AWS_REGION = "";
	public static String AWS_ACCESS_KEY = "";
	public static String AWS_SECRET_KEY = "";
	public static String SIGN_UP_SUCCESS = "SIGNED";
	public static String DELETE_SUCCESS = "DELETED";
	public static String CHANGE_SUCCESS = "CHANGED";
	public static String ROLE_ADMIN = "ROLE_ADMIN";
}
