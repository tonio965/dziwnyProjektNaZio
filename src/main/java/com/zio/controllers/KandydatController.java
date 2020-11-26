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
import com.zio.repositories.KandydatRepository;

@RestController
@RequestMapping(value = "/kandydaci")
public class KandydatController {
	
	@Autowired
	KandydatRepository repository;
	
	@GetMapping
	public Iterable<Kandydat> getKandydaci(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Kandydat getKandydat(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	@PostMapping
	public Kandydat addKandydat(@RequestBody Kandydat kandydat) {
	    return repository.save(kandydat);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteKandydat(@PathVariable Integer id) {
	    repository.deleteById(id);
	}
	
	@GetMapping(value= "/nazwisko/{nazwisko}")
	public List<Kandydat> findByNazwisko(@PathVariable String nazwisko) {
		return repository.findByNazwisko(nazwisko);
	}
	
	@GetMapping(value="/stanowisko/{id}")
	public List<Kandydat> findByStanowisko(@PathVariable Integer id){
		return repository.findByStanowisko(id);
	}
	
	@PutMapping(value="/{id}")
	public void editKandydat(@PathVariable Integer id, @RequestBody Kandydat kandydat) {
		
		Kandydat p = repository.findById(id).orElseThrow(() -> new ItemNotFoundException());

		p.setImie(kandydat.getImie());
		p.setNazwisko(kandydat.getNazwisko());
		p.setStanowisko(kandydat.getStanowisko());
		p.setNazwa_pliku_CV(kandydat.getNazwa_pliku_CV());
		repository.save(p);
	}

}
