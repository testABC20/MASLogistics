package com.mas.quotation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mas.quotation.entity.PackNPorts;

@Repository
public interface PackNPortsDAO extends JpaRepository<PackNPorts, Integer>{
	@Query(value="SELECT * FROM packandports ORDER BY id ASC", nativeQuery = true)
	List<PackNPorts> findAllPackNPorts();
	
	@Query(value="SELECT * FROM packandports where transport_mode= ?1 ORDER BY id ASC", nativeQuery = true)
	List<PackNPorts> getPackNPortsTransport(String transportMode);
}

