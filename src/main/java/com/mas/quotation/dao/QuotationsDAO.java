package com.mas.quotation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mas.quotation.entity.Quotations;

@Repository
public interface QuotationsDAO extends JpaRepository<Quotations, Integer>{
	@Query(value="SELECT * FROM quotations ORDER BY id ASC", nativeQuery = true)
	List<Quotations> findAllQuotes();
}
