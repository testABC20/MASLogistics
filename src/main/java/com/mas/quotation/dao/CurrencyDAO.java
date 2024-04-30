package com.mas.quotation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mas.quotation.entity.Currencies;

public interface CurrencyDAO extends JpaRepository<Currencies, Integer> {
	@Query(value = "SELECT * FROM currencies ORDER BY id ASC", nativeQuery = true)
	List<Currencies> findAllCurrencies();
}
