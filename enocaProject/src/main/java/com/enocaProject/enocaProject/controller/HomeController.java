package com.enocaProject.enocaProject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.enocaProject.enocaProject.Entity.Kitap;
import com.enocaProject.enocaProject.Entity.Yazar;
import com.enocaProject.enocaProject.Service.KitapService;
import com.enocaProject.enocaProject.Service.YazarService;

@Controller
public class HomeController {

	@Autowired
	private KitapService kitapService;
	
	@Autowired
	private YazarService yazarService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/allAuthor")
	public ResponseEntity<List<Yazar>> getAllAuthors(){
		List<Yazar> allAuthors = yazarService.findAllAuthors();
		return new ResponseEntity<List<Yazar>>(allAuthors,HttpStatus.OK);
	}
	
	@PostMapping("/saveAuthor")
	public ResponseEntity<Yazar> addAuthor(@RequestBody Yazar yazar){
		Yazar addAuthor = yazarService.add(yazar);
		return new ResponseEntity<Yazar>(addAuthor,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteAuthor/{id}")
	public ResponseEntity<Void> deleteAuthorById(@PathVariable("id") Integer id){
		yazarService.deleteAuthor(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAuthor/{id}")
	public ResponseEntity<Yazar> getAuthorById(@PathVariable("id") Integer id){
		Yazar istenenYazar = yazarService.getAuthorById(id);
		return new ResponseEntity<Yazar>(istenenYazar,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateAuthor/{id}")
	public ResponseEntity<Yazar> updateAuthorById(@PathVariable("id") Integer id,@RequestBody Yazar y){
		Yazar existingAuthor = yazarService.getAuthorById(id);
		existingAuthor.setAd(y.getAd());
		existingAuthor.setSoyad(y.getSoyad());
		yazarService.update(existingAuthor);
		return new ResponseEntity<Yazar>(existingAuthor,HttpStatus.OK);
	}
	
	@GetMapping("/allBooks")
	public ResponseEntity<List<Kitap>> getAllBooks(){
		List<Kitap> allBooks = kitapService.findAllBooks();
		return new ResponseEntity<List<Kitap>>(allBooks,HttpStatus.OK);
	}
	
	@PostMapping("/saveBook")
	public ResponseEntity<Kitap> addBook(@RequestBody Kitap kitap, Yazar y){
		Kitap addBook = kitapService.add(kitap);
		return new ResponseEntity<Kitap>(addBook,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") Integer id){
		kitapService.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Kitap> getBookById(@PathVariable("id") Integer id){
		Kitap istenenKitap = kitapService.getKitapById(id);
		return new ResponseEntity<Kitap>(istenenKitap,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Kitap> updateBookById(@PathVariable("id") Integer id,@RequestBody Kitap k){
		Kitap existingKitap = kitapService.getKitapById(id);
		existingKitap.setAd(k.getAd());
		existingKitap.setTipi(k.getTipi());
		kitapService.update(existingKitap);
		return new ResponseEntity<Kitap>(existingKitap,HttpStatus.OK);
	}
	
	
}
