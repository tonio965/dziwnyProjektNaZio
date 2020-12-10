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
import com.zio.models.Pracownik;
import com.zio.models.Szkolenie;
import com.zio.repositories.PracownikRepository;
import com.zio.repositories.SzkolenieRepository;

@RestController
@RequestMapping(value = "/szkolenia")
public class SzkolenieController {
	
	@Autowired
	SzkolenieRepository repository;
	
	@Autowired
	PracownikRepository pracownikRepository;
	
	
	@GetMapping
	public Iterable<Szkolenie> getSzkolenies() {
	    return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Szkolenie getSzkolenie(@PathVariable Integer id) {
	    return repository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	@PostMapping
	public Szkolenie addSzkolenie(@RequestBody Szkolenie szkolenie) {
	    return repository.save(szkolenie);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteSzkolenie(@PathVariable Integer id) {
	    repository.deleteById(id);
	}
	
	@GetMapping(value = "/nazwa/{nazwa}")
	public List<Szkolenie> findByNazwa(@PathVariable String nazwa){
		return repository.findByNazwa(nazwa);
	}
	
	@PutMapping
	public Szkolenie editSzkolenie(@RequestBody Szkolenie szkolenie) {
		
		Szkolenie s = repository.findById(szkolenie.getId()).orElseThrow(() -> new ItemNotFoundException());
		if(szkolenie.getData_szkolenia()!=null)
			s.setData_szkolenia(szkolenie.getData_szkolenia());
		if(szkolenie.getNazwa()!=null)
			s.setNazwa(szkolenie.getNazwa());
		if(szkolenie.getRodzaj_szkolenia()!=null)
			s.setRodzaj_szkolenia(szkolenie.getRodzaj_szkolenia());
		s=szkolenie;
		repository.save(s);
		
		return s;
	}
	
//	@GetMapping(value = "/rodzaj/{rodzaj}")
//	public List<Szkolenie> findByRodzaj_szkolenia(@PathVariable Integer rodzaj){
//		return repository.findByRodzaj_szkolenia(rodzaj);
//	}
	

}
