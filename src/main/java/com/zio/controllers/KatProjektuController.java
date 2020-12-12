package com.zio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zio.models.KatProjektu;
import com.zio.repositories.KatProjektuRepository;

@RestController
@RequestMapping(value ="/katProjektu")
public class KatProjektuController {

	@Autowired
	KatProjektuRepository repository;
	
	
	@GetMapping
	public Iterable<KatProjektu> getKatProjektus(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public KatProjektu getKatProjektu(@PathVariable Integer id) {
		return repository.findByIdKat(id);
	}
	
	
	@PostMapping
	public KatProjektu addKatProjektu(@RequestBody KatProjektu katProjektu) {
		return repository.save(katProjektu);
	}
}
