package com.mas.quotation.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currencies {
	@Id
	@Column(name = "id")
	private Integer id; 
	@Column(name = "country")
	private String country;
	@Column(name = "code")
	private String code; 
	@Column(name = "exchange_rate")
	private double exchangeRate;
	@Column(name = "ex_rate_date")
	private Date exRateDate;
	@Column(name = "currency_symbol")
	private String currencySymbol;
	@Column(name = "is_default")
	private Integer isDefault;
	@Column(name = "status")
	private Integer status;
	@Column(name = "createdAt")
	private Timestamp created_at;
	@Column(name = "updatedAt")
	private Timestamp updated_at;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public Date getExRateDate() {
		return exRateDate;
	}
	public void setExRateDate(Date exRateDate) {
		this.exRateDate = exRateDate;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	
	
}
