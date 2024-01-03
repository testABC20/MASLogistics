package com.mas.quotation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/masquote/")
public class MasQuotationController {
  @Autowired
  MasQuotationService service;
  
  @CrossOrigin
  @GetMapping({"/getPacknPorts"})
  public Mono<Response> findAllPackNPorts() {
    List<PackNPorts> masQuoteList = service.findAllPackNPorts();
    Response response = new Response();
    if(null != masQuoteList) {
    	response.setResponseData(masQuoteList);
	    response.setStatus("SUCCESS");
    }else {
    	response.setStatus("NO DATA FOUND");
    }
   
    return Mono.just(response);
  }
  
  @CrossOrigin
  @GetMapping({"/getPacknPortsByMode/{transportMode}"})
  public Mono<Response> getPackNPortsTransport(@PathVariable String transportMode) {
    List<PackNPorts> masQuoteList = null;
    Response response = new Response();
    if(transportMode != null && !transportMode.trim().isEmpty()) {
    	masQuoteList = service.getPackNPortsTransport(transportMode);
    	 if(null != masQuoteList) {
	    	response.setResponseData(masQuoteList);
		    response.setStatus("SUCCESS");
	    }else {
	    	response.setStatus("NO DATA FOUND");
	    }
    }else{
    	response.setStatus("INVALID TRANSPORT MODE");
    }
   
    return Mono.just(response);
  }
  
  @CrossOrigin
  @PostMapping(value = "/saveQuote", produces=MediaType.APPLICATION_JSON_VALUE,
		     consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
  public Mono<Response> saveQuotation(@RequestPart("jsonBodyData") QuotationRequest quote, @RequestParam MultiValueMap<String, MultipartFile> files) {
	  Response response = new Response();
	  Quotations quotation = service.saveQuotation(quote, files);
	  
	  if(quotation != null) {
		  List<Quotations> quoteList = new ArrayList<>();
		  quoteList.add(quotation);
		  response.setResponseData(quoteList);
		  response.setStatus("SUCCESS");
	  }else {
		  response.setStatus("NO QUOTE FOUND");
	  }
	  return Mono.just(response);
  }
  
  @CrossOrigin
  @GetMapping({"/health"})
  public String health() {
    return "Hello & Welcome to MAS Logistics !!!";
  }
}

