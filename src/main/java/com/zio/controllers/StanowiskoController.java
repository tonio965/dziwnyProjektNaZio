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

import com.zio.exceptions.ItemNotFoundException;
import com.zio.models.Kandydat;
import com.zio.models.Pracownik;
import com.zio.models.Stanowisko;
import com.zio.repositories.KandydatRepository;
import com.zio.repositories.PracownikRepository;
import com.zio.repositories.StanowiskoRepository;

@RestController
@RequestMapping(value= "/stanowisko")
public class StanowiskoController {
	
	@Autowired
	StanowiskoRepository repository;
	
	@Autowired
	PracownikRepository pracownikRepository;
	
	@Autowired
	KandydatRepository kandydatRepository;
	
	@Autowired
	PracownikController pracownikController;
	
	@Autowired
	KandydatController kandydatController;
	
	
	
	
	@GetMapping
	public Iterable<Stanowisko> getStanowiskos(){
		return repository.findAll();
	}
	
	@GetMapping(value= "/dzial/{dzial}")
	public List<Stanowisko> findByDzial(@PathVariable String dzial) {
		return repository.findByDzial(dzial);
	}
	
	@GetMapping(value = "/{id}")
	public Stanowisko getStanowisko(@PathVariable Integer id) {
	    return repository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	@PostMapping
	public Stanowisko addStanowisko(@RequestBody Stanowisko stanowisko) {
	    return repository.save(stanowisko);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteStanowisko(@PathVariable Integer id) {
		List<Pracownik> pracowniks= pracownikRepository.findByStanowisko(id);
		List<Kandydat> kandydats= kandydatRepository.findByStanowisko(id);
		
//		for(Pracownik p : pracowniks) {
//			p.setStanowisko(1000);
//			pracownikController.editPracownik(p.getId(), p);
//			
//		}
//		
//		for(Kandydat k : kandydats) {
//			k.setStanowisko(null);
//			kandydatController.editKandydat(k.getId(), k);
//		}
		
	    repository.deleteById(id);
	}
	
	@PutMapping(value="/{id}")
	public void editStanowisko(@PathVariable Integer id, @RequestBody Stanowisko stanowisko) {
		Stanowisko p = repository.findById(id).orElseThrow(() -> new ItemNotFoundException());
		p.setNazwa(stanowisko.getNazwa());
		p.setDzial(stanowisko.getDzial());
		repository.save(p);
	}
	
	
	
	

}
