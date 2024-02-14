package com.mas.quotation.model;

public class QuotationItemRequest {
	private int id;
	private int quoteId;
	private String containerType;
	private String containerQty;
	private String packType;
	private Double totalNoOfPkg;
	private Double netWeight;
	private Double grossWeight;
	private Double length; 
	private Double width; 
	private Double height; 
	private String measurementUnit;
	private Float cbm; 
	private String createdAt; 
	private String updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	public String getContainerQty() {
		return containerQty;
	}
	public void setContainerQty(String containerQty) {
		this.containerQty = containerQty;
	}
	public String getPackType() {
		return packType;
	}
	public void setPackType(String packType) {
		this.packType = packType;
	}
	public Double getTotalNoOfPkg() {
		return totalNoOfPkg;
	}
	public void setTotalNoOfPkg(Double totalNoOfPkg) {
		this.totalNoOfPkg = totalNoOfPkg;
	}
	public Double getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(Double netWeight) {
		this.netWeight = netWeight;
	}
	public Double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getMeasurementUnit() {
		return measurementUnit;
	}
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	public Float getCbm() {
		return cbm;
	}
	public void setCbm(Float cbm) {
		this.cbm = cbm;
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
