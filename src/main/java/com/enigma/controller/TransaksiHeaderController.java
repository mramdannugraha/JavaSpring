package com.enigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import com.enigma.TransaksiHeaderService;
import com.enigma.model.TransaksiHeaderModel;

@RestController
public class TransaksiHeaderController {

	@Autowired
	TransaksiHeaderService transaksiHeaderService;
	
	@GetMapping("/getListTransaksiHeader")
	public ResponseEntity<Page<TransaksiHeaderModel>> getListTransaksiHeader(@RequestParam("page") Integer page, @RequestParam("pagesize") Integer pageSize){
		Page<TransaksiHeaderModel> listTransaksiHeader = transaksiHeaderService.getListTransaksiHeader(page, pageSize);
		return new ResponseEntity(listTransaksiHeader, HttpStatus.OK);
	}
	@PostMapping("/createUpdateTransaksiHeader")
	public ResponseEntity<TransaksiHeaderModel> createUpdate(@RequestBody TransaksiHeaderModel transaksiHeader){
		transaksiHeaderService.createUpadateTransaksiHeader(transaksiHeader);
		return new ResponseEntity<TransaksiHeaderModel>(transaksiHeader, HttpStatus.OK);
	}
	
	@GetMapping("/getListPenjualanTokoPerHari")
	public ResponseEntity<List<String>> getListPenjualanTokoPerHari(){
		List<String> ListPenjualanToko = transaksiHeaderService.getListPenjualanTokoPerHari();
		return new ResponseEntity<>(ListPenjualanToko, HttpStatus.OK);
	}
	
	@GetMapping("/getListAllProductSales")
	public ResponseEntity<List<String>> getListAllProductSales(){
		List<String> listAllProductSales = transaksiHeaderService.getListAllProductSales();
		return new ResponseEntity<>(listAllProductSales, HttpStatus.OK);
	}
	
	
	@GetMapping("/getListPenjualanPerWilayah")
	public ResponseEntity<List<String>> getListPenjualanPerWilayah(){
		List<String> listPenjualanPerWilayah = transaksiHeaderService.getListPenjualanPerWilayah();
		return new ResponseEntity<>(listPenjualanPerWilayah, HttpStatus.OK);
	}
	@GetMapping("/getListBestSellerProduct")
	public ResponseEntity<List<String>> getListBestSellerProduct(){
		List<String> listBestSellerProduct = transaksiHeaderService.getListBestSellerProduct();
		return new ResponseEntity<>(listBestSellerProduct, HttpStatus.OK);
	}
	
	@GetMapping("/getListAtLessProduct")
	public ResponseEntity<List<String>> getAtLessProduct(){
		List<String> listAtLessProduct  = transaksiHeaderService.getAtLessProduct();
		return new ResponseEntity<>(listAtLessProduct, HttpStatus.OK);
	}
	
	@GetMapping("/getListSalesByRegion")
	public ResponseEntity<List<String>> getAllSalesByRegion(){
		List<String> listSalesByRegion  = transaksiHeaderService.getListSalesByRegion();
		return new ResponseEntity<>(listSalesByRegion, HttpStatus.OK);
	}
}
