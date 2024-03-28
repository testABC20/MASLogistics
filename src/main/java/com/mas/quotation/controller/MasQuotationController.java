package com.mas.quotation.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mas.quotation.entity.PackNPorts;
import com.mas.quotation.entity.Quotations;
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
  @PostMapping(value = "/saveQuote", produces=MediaType.APPLICATION_JSON_VALUE,
		     consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Response> saveQuotation(@RequestPart("jsonBodyData") QuotationRequest quote, @RequestParam MultiValueMap<String, MultipartFile> files) {
	  Response response = new Response();
	  Quotations quotation = service.saveQuotation(quote, files);
	  
	  if(quotation != null) {
		  logger.info("Save is Successful");
		  List<Quotations> quoteList = new ArrayList<>();
		  quoteList.add(quotation);
		  response.setResponseData(quoteList);
		  response.setStatus("SUCCESS");
	  }else {
		  response.setStatus("NO QUOTE FOUND");
	  }
	  return ResponseEntity.status(HttpStatus.ACCEPTED).header("Access-Control-Allow-Origin: *").body(response);
  }
  
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
  @GetMapping({"/getAllQuotes"})
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
 
}

