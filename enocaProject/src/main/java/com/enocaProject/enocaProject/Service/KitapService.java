package com.enocaProject.enocaProject.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enocaProject.enocaProject.Entity.Kitap;
import com.enocaProject.enocaProject.repository.KitapRepository;

@Service
public class KitapService {

	@Autowired
	private KitapRepository kitapRepository;
	
	public Kitap add(Kitap kitap) {
		return kitapRepository.save(kitap);
	}
	
	public List<Kitap> findAllBooks(){
		return kitapRepository.findAll();
	}
	
	public Kitap getKitapById(Integer id) {
		return kitapRepository.findById(id).get();
	}
	
	public void update(Kitap existingKitap) {
		kitapRepository.saveAndFlush(existingKitap);
	}
	
	public void deleteBook(Integer kitapId) {
		kitapRepository.deleteById(kitapId);
	}
}
