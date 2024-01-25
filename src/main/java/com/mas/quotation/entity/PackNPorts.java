package com.mas.quotation.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "packandports")
public class PackNPorts {
	@Id
	@Column(name = "id")
	private Integer id; 
	@Column(name = "packing_code")
	private String packingCode;
	@Column(name = "packing_name")
	private String packingName;
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "country_name")
	private String countryName;
	@Column(name = "region_code")
	private String regionCode;
	@Column(name = "region_name")
	private String regionName;
	@Column(name = "edi_port_code")
	private String ediPortCode;
	@Column(name = "transport_mode")
	private String transportMode;
	@Column(name = "lov_status")
	private String lovStatus;
	@Column(name = "is_other_countries")
	private Integer isOtherCountries;
	@Column(name = "crearted_at")
	private Timestamp createdAt;
	@Column(name = "created_by")
	private Integer createdBy; 
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPackingCode() {
		return packingCode;
	}
	public void setPackingCode(String packingCode) {
		this.packingCode = packingCode;
	}
	public String getPackingName() {
		return packingName;
	}
	public void setPackingName(String packingName) {
		this.packingName = packingName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getEdiPortCode() {
		return ediPortCode;
	}
	public void setEdiPortCode(String ediPortCode) {
		this.ediPortCode = ediPortCode;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getLovStatus() {
		return lovStatus;
	}
	public void setLovStatus(String lovStatus) {
		this.lovStatus = lovStatus;
	}
	public Integer getIsOtherCountries() {
		return isOtherCountries;
	}
	public void setIsOtherCountries(Integer isOtherCountries) {
		this.isOtherCountries = isOtherCountries;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
