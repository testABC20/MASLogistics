package com.mas.quotation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mas.quotation.entity.PackNPorts;
import com.mas.quotation.entity.Quotations;
import com.mas.quotation.model.QuotationRequest;
import com.mas.quotation.model.Response;
import com.mas.quotation.service.MasQuotationService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/masquote/")
@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
public class MasQuotationController {
  @Autowired
  MasQuotationService service;
  
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
  
  @PostMapping(value = "/saveQuote", headers = "Accept=application/json")
  public Mono<Response> saveQuotation(@RequestBody QuotationRequest quote) {
	  Response response = new Response();
	  Quotations quotation = service.saveQuotation(quote);
	  
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
  
  @GetMapping({"/health"})
  public String health() {
    return "Hello & Welcome to MAS Logistics !!!";
  }
}

