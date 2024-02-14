package com.mas.quotation.model;

import java.util.List;

public class QuotationRequest {
	private List<QuotationItemRequest> quoteItems;
	
	private int id;
	private String type; 
	private String name;
	private String company;
	private String country;
	private String email;
	private String mobile;
	private String address;
	private String cargoType;
	private String cargoSubType;
	private Integer pol; 
	private String polName;
	private Integer pod; 
	private String podName;
	private String shippingDate;
	private String commodity;
	private String dangerous;
	private String classification;
	private String unNo; 
	private String intoTerm;
	private String intoTermAddress;
	private Float totalCbm;
	private String createdAt; 
	private String updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<QuotationItemRequest> getQuoteItems() {
		return quoteItems;
	}
	public void setQuoteItems(List<QuotationItemRequest> quoteItems) {
		this.quoteItems = quoteItems;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCargoType() {
		return cargoType;
	}
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	public String getCargoSubType() {
		return cargoSubType;
	}
	public void setCargoSubType(String cargoSubType) {
		this.cargoSubType = cargoSubType;
	}
	public Integer getPol() {
		return pol;
	}
	public void setPol(Integer pol) {
		this.pol = pol;
	}
	public String getPolName() {
		return polName;
	}
	public void setPolName(String polName) {
		this.polName = polName;
	}
	public Integer getPod() {
		return pod;
	}
	public void setPod(Integer pod) {
		this.pod = pod;
	}
	public String getPodName() {
		return podName;
	}
	public void setPodName(String podName) {
		this.podName = podName;
	}
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getDangerous() {
		return dangerous;
	}
	public void setDangerous(String dangerous) {
		this.dangerous = dangerous;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getUnNo() {
		return unNo;
	}
	public void setUnNo(String unNo) {
		this.unNo = unNo;
	}
	public String getIntoTerm() {
		return intoTerm;
	}
	public void setIntoTerm(String intoTerm) {
		this.intoTerm = intoTerm;
	}
	public String getIntoTermAddress() {
		return intoTermAddress;
	}
	public void setIntoTermAddress(String intoTermAddress) {
		this.intoTermAddress = intoTermAddress;
	}
	public Float getTotalCbm() {
		return totalCbm;
	}
	public void setTotalCbm(Float totalCbm) {
		this.totalCbm = totalCbm;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
