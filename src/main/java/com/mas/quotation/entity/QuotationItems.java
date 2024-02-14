package com.mas.quotation.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quotation_items")
public class QuotationItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@ManyToOne
    @JoinColumn(name = "quote_id")
	private Quotations quoteId;  
	
	@Column(name = "container_type")
	private String containerType;
	@Column(name = "container_qty")
	private String containerQty;
	@Column(name = "pack_type")
	private String packType;
	@Column(name = "total_no_of_pkg")
	private double totalNoOfPkg;
	@Column(name = "net_weight")
	private double netWeight;
	@Column(name = "gross_weight")
	private double grossWeight;
	@Column(name = "length")
	private double length; 
	@Column(name = "width")
	private double width; 
	@Column(name = "height")
	private double height; 
	@Column(name = "measurement_unit")
	private String measurementUnit;
	@Column(name = "cbm")
	private Float cbm; 
	@JsonIgnore
	@Column(name = "drawing")
	@Lob
	private byte[] drawing; 
	@Column(name = "drawing_file_name")
	private String drawingFileName;
	@Column(name = "drawing_content_type")
	private String drawingContentType;
	@Column(name = "status")
	private Integer status;
	@Column(name = "created_at")
	private Timestamp createdAt; 
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Quotations getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(Quotations quoteId) {
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
	public double getTotalNoOfPkg() {
		return totalNoOfPkg;
	}
	public void setTotalNoOfPkg(double totalNoOfPkg) {
		this.totalNoOfPkg = totalNoOfPkg;
	}
	public double getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}
	public double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
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
	public byte[] getDrawing() {
		return drawing;
	}
	public void setDrawing(byte[] drawing) {
		this.drawing = drawing;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDrawingFileName() {
		return drawingFileName;
	}
	public void setDrawingFileName(String drawingFileName) {
		this.drawingFileName = drawingFileName;
	}
	public String getDrawingContentType() {
		return drawingContentType;
	}
	public void setDrawingContentType(String drawingContentType) {
		this.drawingContentType = drawingContentType;
	}
	
}
