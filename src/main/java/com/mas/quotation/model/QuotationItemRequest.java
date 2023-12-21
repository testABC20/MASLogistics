package com.mas.quotation.model;

import org.springframework.web.multipart.MultipartFile;

public class QuotationItemRequest {
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
	private MultipartFile drawingFile;
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
	public MultipartFile getDrawingFile() {
		return drawingFile;
	}
	public void setDrawingFile(MultipartFile drawingFile) {
		this.drawingFile = drawingFile;
	} 
	
	
}
