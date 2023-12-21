package com.mas.quotation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mas.quotation.entity.Quotations;

@Repository
public interface QuotationsDAO extends JpaRepository<Quotations, Integer>{

}
