package com.mas.quotation.entity;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quotations")
public class Quotations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="quote_id")
    private List<QuotationItems> quoteItems;
	
	@Column(name = "code")
	private String code; 
	@Column(name = "type")
	private String type; 
	@Column(name = "name")
	private String name;
	@Column(name = "company")
	private String company;
	@Column(name = "country")
	private String country;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "address")
	private String address;
	@Column(name = "cargo_type")
	private String cargoType;
	@Column(name = "cargo_sub_type")
	private String cargoSubType;
	@Column(name = "pol")
	private Integer pol; 
	@Column(name = "pol_name")
	private String polName;
	@Column(name = "pod")
	private Integer pod; 
	@Column(name = "pod_name")
	private String podName;
	@Column(name = "shipping_date")
	private String shippingDate;
	@Column(name = "commodity")
	private String commodity;
	@Column(name = "dangerous")
	private String dangerous;
	@Column(name = "classification")
	private String classification;
	@Column(name = "un_no")
	private String unNo; 
	@JsonIgnore
	@Column(name = "msds")
	@Lob
	private byte[] msds; 
	@Column(name = "into_term")
	private String intoTerm;
	@Column(name = "into_term_address")
	private String intoTermAddress;
	@Column(name = "total_cbm")
	private Float totalCbm;
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
	
	public List<QuotationItems> getQuoteItems() {
		return quoteItems;
	}
	public void setQuoteItems(List<QuotationItems> quoteItems) {
		this.quoteItems = quoteItems;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public byte[] getMsds() {
		return msds;
	}
	public void setMsds(byte[] msds) {
		this.msds = msds;
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
	
	
}
