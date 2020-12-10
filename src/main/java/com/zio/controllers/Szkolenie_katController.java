package com.zio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import com.zio.exceptions.ItemNotFoundException;
import com.zio.models.Kandydat;
import com.zio.models.Szkolenie;
import com.zio.models.SzkolenieKat;
import com.zio.repositories.Szkolenie_katRepository;

@RestController
@RequestMapping(value = "/szkolenie_kat")
public class Szkolenie_katController {
	
	@Autowired
	Szkolenie_katRepository repository;
	
	@GetMapping
	public List<SzkolenieKat> getSzkolenia() {
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public SzkolenieKat getSzkolenie(@PathVariable Integer id) {
		return repository.findByIdSzkKat(id);
		//	    return repository.findById_szk_kat(id).orElseThrow(ItemNotFoundException::new);
	}
	
	@PostMapping
	public SzkolenieKat addSzkolenie(@RequestBody SzkolenieKat szkolenie) {
		return repository.save(szkolenie);
	}
	
	@Transactional
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
	    repository.deleteByIdSzkKat(id);
	}
	@Transactional
	@PutMapping(value="/{id}")
	public void editSzkolenieKat(@PathVariable Integer id, @RequestBody SzkolenieKat szkolenieKat) {
		SzkolenieKat p = repository.findByIdSzkKat(id);
		p.setnazwaSzkKat(szkolenieKat.getnazwaSzkKat());
		repository.save(p);
	}
	

}
