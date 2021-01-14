package com.enigma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enigma.model.Toko;
import com.enigma.repository.TokoRepository;

@Service
public class TokoService {

	@Autowired
	TokoRepository tokoRepository;
	
	public Page<Toko> getListToko(int page, int pagesize){
		Pageable paging = PageRequest.of(page, pagesize);
		return tokoRepository.findAll(paging);
	}

	public Toko createUpdateToko(Toko toko) {
		return tokoRepository.save(toko);
	}

	public List<Toko> getListTokoByNama(String namaToko) {
		return tokoRepository.getListTokoByNamaTokoLike("%"+namaToko+"%");
	}
	
	public Toko getKodeToko(String kodeToko) {
		return tokoRepository.findAllBykodeToko(kodeToko);
	}
	
	public Integer deleteToko(int id) {
		try {
			Toko toko = tokoRepository.findAllById(id);
			tokoRepository.delete(toko);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
