package com.enocaProject.enocaProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enocaProject.enocaProject.Entity.Yazar;
import com.enocaProject.enocaProject.repository.YazarRepository;

@Service
public class YazarService {

	@Autowired
	private YazarRepository yazarRepository;
	
	public Yazar add(Yazar yazar) {
		return yazarRepository.save(yazar);
	}
	
	public List<Yazar> findAllAuthors(){
		return yazarRepository.findAll();
	}
	
	public Yazar getAuthorById(Integer id) {
		return yazarRepository.findById(id).get();
	}
	
	public void update(Yazar existingYazar) {
		yazarRepository.saveAndFlush(existingYazar);
	}
	
	public void deleteAuthor(Integer yazarId) {
		yazarRepository.deleteById(yazarId);
	}
}
