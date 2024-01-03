package com.mas.quotation.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.mas.quotation.dao.PackNPortsDAO;
import com.mas.quotation.dao.QuotationsDAO;
import com.mas.quotation.entity.PackNPorts;
import com.mas.quotation.entity.QuotationItems;
import com.mas.quotation.entity.Quotations;
import com.mas.quotation.model.QuotationItemRequest;
import com.mas.quotation.model.QuotationRequest;

@Service
public class MasQuotationService {
  @Autowired
  PackNPortsDAO packNPortsDAO;
  
  @Autowired 
  QuotationsDAO quoteDAO;
  
  public List<PackNPorts> findAllPackNPorts() {
    return packNPortsDAO.findAllPackNPorts();
  }
  
  public List<PackNPorts> getPackNPortsTransport(String transportMode){
	  return packNPortsDAO.getPackNPortsTransport(transportMode);
  }
  
  public Quotations saveQuotation(QuotationRequest quote, MultiValueMap<String, MultipartFile> files) {
	  Quotations quotation = null;
	  if(null != quote && null != quote.getType() && !"".equals(quote.getType().trim())) {
		  quotation = new Quotations();
		  Timestamp currTime = new Timestamp(System.currentTimeMillis());
		  try {
			  if(files != null) {
				  for(String keys: files.keySet()) {
					  if(keys.equals("msdsFile") ) {
						  MultipartFile msdsFile = files.getFirst(keys);
						  if(null != msdsFile && !msdsFile.getOriginalFilename().equals("")) {
							  byte[] byteData = msdsFile.getBytes();
							  quotation.setMsds(byteData);
						  }
						  break;
					  }
				  }
			  }
			  quotation.setType(quote.getType());
			  
			  if(null != quote.getName() && !"".equals(quote.getName().trim()))
				  quotation.setName(quote.getName());
			  if(null != quote.getCompany() && !"".equals(quote.getCompany().trim()))
				  quotation.setCompany(quote.getCompany());
			  if(null != quote.getCountry() && !"".equals(quote.getCountry().trim()))
				  quotation.setCountry(quote.getCountry());
			  if(null != quote.getEmail() && !"".equals(quote.getEmail().trim()))
				  quotation.setEmail(quote.getEmail());
			  if(null != quote.getMobile() && !"".equals(quote.getMobile().trim()))
				  quotation.setMobile(quote.getMobile());
			  if(null != quote.getAddress() && !"".equals(quote.getAddress().trim()))
				  quotation.setAddress(quote.getAddress());
			  if(null != quote.getCargoType() && !"".equals(quote.getCargoType().trim()))
				  quotation.setCargoType(quote.getCargoType());
			  if(null != quote.getCargoSubType() && !"".equals(quote.getCargoSubType().trim()))
				  quotation.setCargoSubType(quote.getCargoSubType());
			  if(null != quote.getPol())
				  quotation.setPol(quote.getPol());
			  if(null != quote.getPolName() && !"".equals(quote.getPolName().trim()))
				  quotation.setPolName(quote.getPolName());
			  if(null != quote.getPod())
				  quotation.setPod(quote.getPod());
			  if(null != quote.getPodName() && !"".equals(quote.getPodName().trim()))
				  quotation.setPodName(quote.getPodName());
			  if(null != quote.getShippingDate() && !"".equals(quote.getShippingDate().trim()))
				  quotation.setShippingDate(quote.getShippingDate());
			  if(null != quote.getCommodity() && !"".equals(quote.getCommodity().trim()))
				  quotation.setCommodity(quote.getCommodity());
			  if(null != quote.getDangerous() && !"".equals(quote.getDangerous().trim()))
				  quotation.setDangerous(quote.getDangerous());
			  if(null != quote.getClassification() && !"".equals(quote.getClassification().trim()))
				  quotation.setClassification(quote.getClassification());
			  if(null != quote.getUnNo() && !"".equals(quote.getUnNo().trim()))
				  quotation.setUnNo(quote.getUnNo());
			  if(null != quote.getIntoTerm() && !"".equals(quote.getIntoTerm().trim()))
				  quotation.setIntoTerm(quote.getIntoTerm());
			  if(null != quote.getIntoTermAddress() && !"".equals(quote.getIntoTermAddress().trim()))
				  quotation.setIntoTermAddress(quote.getIntoTermAddress());
			  if(null != quote.getTotalCbm())
				  quotation.setTotalCbm(quote.getTotalCbm());
	
			  int count=0;
			  if(null != quote.getQuoteItems() && quote.getQuoteItems().size() > 0) {
				  List<QuotationItems> quoteItemList = new ArrayList<>();
				  QuotationItems items = null;
				  MultipartFile drawingFile = null;
				  byte[] drawingFileData = null;
				  for(QuotationItemRequest itemReq: quote.getQuoteItems()) {
					  if(null != itemReq) {
						  items = new QuotationItems();
						  
						  if(files != null) {
							  drawingFile = files.getFirst("drawingFile"+count);
							  if(null != drawingFile && !drawingFile.getOriginalFilename().equals("")) {
								  drawingFileData = drawingFile.getBytes();
								  items.setDrawing(drawingFileData);
							  }
						  }
						  
						  count++;
						  
						  if(null != itemReq.getContainerType() && !"".equals(itemReq.getContainerType().trim()))
							  items.setContainerType(itemReq.getContainerType());
						  if(null != itemReq.getContainerQty() && !"".equals(itemReq.getContainerQty().trim()))
							  items.setContainerQty(itemReq.getContainerQty());
						  if(null != itemReq.getPackType() && !"".equals(itemReq.getPackType().trim()))
							  items.setPackType(itemReq.getPackType());
						  if(null != itemReq.getTotalNoOfPkg())
							  items.setTotalNoOfPkg(itemReq.getTotalNoOfPkg());
						  if(null != itemReq.getNetWeight())
							  items.setNetWeight(itemReq.getNetWeight());
						  if(null != itemReq.getGrossWeight())
							  items.setGrossWeight(itemReq.getGrossWeight());
						  if(null != itemReq.getLength())
							  items.setLength(itemReq.getLength());
						  if(null != itemReq.getWidth())
							  items.setWidth(itemReq.getWidth());
						  if(null != itemReq.getHeight())
							  items.setHeight(itemReq.getHeight());
						  if(null != itemReq.getMeasurementUnit() && !"".equals(itemReq.getMeasurementUnit().trim()))
							  items.setMeasurementUnit(itemReq.getMeasurementUnit());
						  if(null != itemReq.getCbm())
							  items.setCbm(itemReq.getCbm());
						  
						  items.setCreatedAt(currTime);
						  items.setUpdatedAt(currTime);
						  quoteItemList.add(items);
					  }
				  }
				  
				  quotation.setQuoteItems(quoteItemList);
				  quotation.setCreatedAt(currTime);
				  quotation.setUpdatedAt(currTime);
			  }
			  
			  quoteDAO.saveAndFlush(quotation);
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
	  }
	  return quotation;
  }
}
