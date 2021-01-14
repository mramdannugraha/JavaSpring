package com.enigma.repository;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import com.enigma.model.TransaksiHeaderModel;

public interface TransaksiHeaderRepository extends JpaRepository<TransaksiHeaderModel, Integer> {

	// Select All
	List<TransaksiHeaderModel> findAll();

	//Select All
	@Query("select th from TransaksiHeaderModel th")
	List<TransaksiHeaderModel> getAllTransaksiHeader();
	
	// total penjualan toko per toko per hari
	@Query(" select sum(th.totalPenjualan), th.toko.namaToko, th.tglTransaksi from TransaksiHeaderModel  th " + 
			"group by th.toko.namaToko ")
	List<String> getListTokoPenjualanTokoPerHari();
	
	// total penjualan seluruh toko per hari
	@Query(nativeQuery = true, value = "select tgl_transaksi, nama_toko, sum(total_penjualan) from transaksi_header\r\n" + 
			" join ms_toko using(kode_toko) group by tgl_transaksi, nama_toko")
	List<String> getListAllProductSales();

	//total penjualan per wilayah per hari
	@Query(nativeQuery = true, value = " select tgl_transaksi, total_penjualan, wilayah from transaksi_header \r\n" + 
			" join ms_toko using(kode_toko) group by wilayah")
	List<String> getListPenjualanPerWilayah();
	
	//total penjualan total semua wilayah per hari
	@Query(nativeQuery = true, value = " select tgl_transaksi, total_penjualan, wilayah from transaksi_header  \r\n" + 
			" join ms_toko using(kode_toko) group by wilayah, tgl_transaksi")
	List<String> getListSalesByRegion();
	
	//Product yang paling laku
	@Query(nativeQuery = true, value = "  select product_name, tgl_transaksi, total_qty from product p\r\n" + 
			" join transaksi_detail td on td.product_id = p.product_id\r\n" + 
			" order by total_qty desc\r\n" + 
			" limit 1")
	List<String> getListProductTerlaris();
	
	//Product yang kurang laku
	@Query(nativeQuery = true, value = " select product_name, tgl_transaksi, total_qty from product p\r\n" + 
			" join transaksi_detail td on td.product_id = p.product_id\r\n" + 
			" order by total_qty asc\r\n" + 
			" limit 1")
	List<String> getAtLessProduct();
}
