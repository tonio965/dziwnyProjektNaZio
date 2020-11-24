package com.zio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zio.exceptions.ItemNotFoundException;
import com.zio.models.Pracownik;
import com.zio.repositories.PracownikRepository;


@RestController
@RequestMapping(value = "/pracownicy")
public class PracownikController {
	
	@Autowired
	PracownikRepository repository;
	

	
	@GetMapping
	public Iterable<Pracownik> getPracowniks() {
	    return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Pracownik getPracownik(@PathVariable Integer id) {
	    return repository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	@PostMapping
	public Pracownik addPracownik(@RequestBody Pracownik pracownik) {
	    return repository.save(pracownik);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePracownik(@PathVariable Integer id) {
	    repository.deleteById(id);
	}
	
	@PutMapping(value="/{id}")
	public void editPracownik(@PathVariable Integer id, @RequestBody Pracownik pracownik) {
		
		Pracownik p = repository.findById(id).orElseThrow(() -> new ItemNotFoundException());

		p.setImie(pracownik.getImie());
		p.setNazwisko(pracownik.getNazwisko());
		p.setStanowisko(pracownik.getStanowisko());
		p.setTyp_konta(pracownik.getTyp_konta());
		repository.save(p);
	}

}
