package com.mas.quotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.quotation.dao.PackNPortsDAO;
import com.mas.quotation.entity.PackNPorts;

@Service
public class MasQuotationService {
  @Autowired
  PackNPortsDAO packNPortsDAO;
  
  public List<PackNPorts> findAllPackNPorts() {
    return packNPortsDAO.findAllPackNPorts();
  }
  
  public List<PackNPorts> getPackNPortsTransport(String transportMode){
	  return packNPortsDAO.getPackNPortsTransport(transportMode);
  }
}
