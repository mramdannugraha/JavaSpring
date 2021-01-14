package com.enigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.TransaksiDetailService;
import com.enigma.model.TransaksiDetailModel;

@RestController
public class TransaksiDetailController {

	@Autowired
	TransaksiDetailService transaksiDetailService;
	
	@GetMapping("/getListTransaksiDetail")
	public ResponseEntity<Page<TransaksiDetailModel>> getListTransaksiDetail(@RequestParam("page") Integer page, @RequestParam("pagesize") Integer pageSize){
		Page<TransaksiDetailModel> listTransaksiDetail = transaksiDetailService.getListTransaksiDetail(page, pageSize);
		return new ResponseEntity(listTransaksiDetail, HttpStatus.OK);
	}
	
	@PostMapping("/createUpdateTransaksiDetail")
	public ResponseEntity<TransaksiDetailModel> createUpdate(@RequestBody TransaksiDetailModel transaksiDetail){
		transaksiDetailService.createUpdateTransaksiDetail(transaksiDetail);
		return new ResponseEntity<TransaksiDetailModel>(transaksiDetail, HttpStatus.OK);
	}
}
