package com.mas.quotation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mas.quotation.entity.Currencies;
import com.mas.quotation.model.QuotationRequest;
import com.mas.quotation.model.Response;
import com.mas.quotation.service.MasQuotationService;

@RestController
@RequestMapping(value = "/masquote")
public class MasQuotationController {
  @Autowired
  MasQuotationService service;
  
  final Logger logger = LoggerFactory.getLogger(this.getClass());
  
  @CrossOrigin
  @GetMapping(value="/getQuotes", produces=MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<MultiValueMap<String, Object>> findAllQuotes() {
	  logger.info("Inside getallQuotes");
	  
	  MultiValueMap<String, Object> fileMap = service.findAllQuotes();
	  
	  if(null != fileMap && !fileMap.isEmpty()) {
		  logger.info("Retrieving Files are success");
		  return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(fileMap);
	  } else {
		  logger.info("No Data found");
		  return new ResponseEntity<MultiValueMap<String, Object>>(HttpStatus.NO_CONTENT);
	  }
	 
  }
  
	@CrossOrigin
	@GetMapping({ "/getAllQuotes" })
	public ResponseEntity<Response> findAllQuotesWithoutFiles() {
		logger.info("Inside findAllQuotesWithoutFiles");
		Response response = new Response();
		List<QuotationRequest> quotes = service.findAllQuotesWithoutFiles();

		if (null != quotes) {
			logger.info("findAllQuotesWithoutFiles is Success");
			response.setResponseData(quotes);
			response.setStatus("SUCCESS");
		} else {
			response.setStatus("NO DATA FOUND");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(response);
	}

	@CrossOrigin
	@GetMapping({ "/getCurrencies" })
	public ResponseEntity<Response> findAllCurrencies() {
		logger.info("Inside findAllCurrencies");
		Response response = new Response();
		List<Currencies> currencies = service.findAllCurrencies();

		if (null != currencies) {
			logger.info("findAllCurrencies is Success");
			response.setResponseData(currencies);
			response.setStatus("SUCCESS");
		} else {
			response.setStatus("NO DATA FOUND");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(response);
	}

}

