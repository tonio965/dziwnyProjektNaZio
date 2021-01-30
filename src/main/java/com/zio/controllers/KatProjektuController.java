package com.zio.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zio.models.KatProjektu;
import com.zio.repositories.KatProjektuRepository;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value ="/katProjektu")
public class KatProjektuController {

	@Autowired
	KatProjektuRepository repository;
	
	Logger logger = (Logger) LoggerFactory.getLogger(KatProjektuController.class);
	
	
	@GetMapping
	public Iterable<KatProjektu> getKatProjektus(){
		logger.info("katProjektuController: getall");
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public KatProjektu getKatProjektu(@PathVariable Integer id) {
		logger.info("katProjektuController: getById");
		return repository.findByIdKat(id);
	}
	
	
	@PostMapping
	public KatProjektu addKatProjektu(@RequestBody KatProjektu katProjektu) {
		logger.info("katProjektuController: addKatProjektu");
		return repository.save(katProjektu);
	}
}
