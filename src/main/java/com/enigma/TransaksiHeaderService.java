package com.enigma;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.model.TransaksiHeaderModel;
import com.enigma.repository.TransaksiHeaderRepository;

@Service
public class TransaksiHeaderService {

	@Autowired
	TransaksiHeaderRepository transaksiHeaderRepository;
	
	public Page<TransaksiHeaderModel> getListTransaksiHeader(int page, int pagesize) {
		Pageable paging = PageRequest.of(page, pagesize);
		return transaksiHeaderRepository.findAll(paging);
		
	}
	
	public TransaksiHeaderModel createUpadateTransaksiHeader(TransaksiHeaderModel transaksiHeader) {
		return transaksiHeaderRepository.save(transaksiHeader);
	}
	
	public List<String> getListPenjualanTokoPerHari(){
		return transaksiHeaderRepository.getListTokoPenjualanTokoPerHari();
	}
	
	public List<String> getListAllProductSales(){
		return transaksiHeaderRepository.getListAllProductSales();
	}
	
	public List<String> getListPenjualanPerWilayah(){
		return transaksiHeaderRepository.getListPenjualanPerWilayah();
	}
	
	public List<String> getListSalesByRegion(){
		return transaksiHeaderRepository.getListSalesByRegion();
	}
	
	public List<String> getListBestSellerProduct(){
		return transaksiHeaderRepository.getListProductTerlaris();
	}
	
	public List<String> getAtLessProduct(){
		return transaksiHeaderRepository.getAtLessProduct();
	}
}
