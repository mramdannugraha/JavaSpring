//package com.enigma.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.enigma.model.TransaksiHeaderModel;
//
//public interface ReportRepository extends JpaRepository<TransaksiHeaderModel, Integer>{
//
//	@Query("select namaToko, tglTransaksi, totalPenjualan from Toko join TransaksiHeaderModel using (kodeToko) where tglTransaksi = CURDATE();")
//}
