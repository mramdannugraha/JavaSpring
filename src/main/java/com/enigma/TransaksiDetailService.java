package com.enigma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.model.TransaksiDetailModel;
import com.enigma.repository.TransaksiDetailRepository;

@Service
public class TransaksiDetailService {

	@Autowired
	TransaksiDetailRepository transaksiRepository;
	
	public Page<TransaksiDetailModel> getListTransaksiDetail(int page, int pagesize){
		Pageable paging=PageRequest.of(page, pagesize);
		return transaksiRepository.findAll(paging);
	}
	
	public TransaksiDetailModel createUpdateTransaksiDetail(TransaksiDetailModel transaksiDetail) {
		return transaksiRepository.save(transaksiDetail);
	}
}
