package com.enigma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.TokoService;
import com.enigma.model.Toko;

@RestController
public class TokoController {

	@Autowired
	TokoService tokoService;
	
	@GetMapping("/getListToko")
	public ResponseEntity<Page<Toko>> getListToko(@RequestParam("page") Integer page, @RequestParam("pagesize") Integer pageSize){
		Page<Toko> listToko = tokoService.getListToko(page, pageSize);
		return new ResponseEntity(listToko, HttpStatus.OK);
		
	}
	
	@PostMapping("/createUpdateToko")
	public ResponseEntity<Toko> createUpdate(@RequestBody Toko toko){
		tokoService.createUpdateToko(toko);
		return new ResponseEntity<Toko>(toko, HttpStatus.OK);
	}
	
	@GetMapping("/getListTokoByName")
	public ResponseEntity<List<Toko>> getTokoByNama(@RequestParam("namaToko") String namaToko){
		List<Toko> listToko = tokoService.getListTokoByNama(namaToko);
		return new ResponseEntity<List<Toko>>(listToko, HttpStatus.OK);
	}
	
	@GetMapping("/getListTokoByKodeToko")
	public ResponseEntity<List<Toko>> getTokoByKodeToko(@RequestParam("kodeToko") String kodeToko){
		Toko toko = tokoService.getKodeToko(kodeToko);
		return new ResponseEntity(toko, HttpStatus.OK);
	}
	
	@GetMapping("/doDeleteToko")
	public ResponseEntity<Integer> deleteToko(@RequestParam Toko toko){
		Integer result = tokoService.deleteToko(toko.getId());
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
