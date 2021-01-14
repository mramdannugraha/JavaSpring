package com.enigma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enigma.model.Toko;

public interface TokoRepository extends JpaRepository<Toko, Integer>{
	
	//Select All
	List<Toko> findAll();
	
	
	//Select Berdasarkan NamaToko
//	List<Toko> findAllByNamaToko(String namaToko);
	
//	@Query("select t from Toko t where t.namaToko like : namaToko")
	List<Toko> getListTokoByNamaTokoLike(String namaToko);
	
	//Select Berdasarkan Kode Toko
	Toko findAllBykodeToko(String kodeToko);
	
	//Delete By Id
	Toko findAllById(Integer id);

}
