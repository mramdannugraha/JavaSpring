package com.enigma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.model.TransaksiDetailModel;

public interface TransaksiDetailRepository extends JpaRepository<TransaksiDetailModel, Integer>{

	//Select All
	List<TransaksiDetailModel> findAll();
}
