package com.mas.quotation.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"responseData", "status"})
public class Response {
  @JsonProperty("responseData")
  private List<? extends Object> responseData;
  
  @JsonProperty("status")
  private String status;
  
  public List<? extends Object> getResponseData() {
    return this.responseData;
  }
  
  public void setResponseData(List<? extends Object> responseData) {
    this.responseData = responseData;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
}