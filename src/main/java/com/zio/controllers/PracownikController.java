package com.zio.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
import com.zio.models.Szkolenie;
import com.zio.repositories.PracownikRepository;
import com.zio.repositories.StanowiskoRepository;
import com.zio.repositories.SzkolenieRepository;


@RestController
@RequestMapping(value = "/pracownicy")
public class PracownikController {
	
	@Autowired
	PracownikRepository repository;
	
	@Autowired
	SzkolenieRepository szkolenieRepository;
	
	@Autowired
	StanowiskoRepository stanowiskoRepository;
	
	

	@GetMapping
	public Iterable<Pracownik> getPracowniks() {
	    return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Pracownik getPracownik(@PathVariable Integer id) {
	    return repository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	@PutMapping(value="/addSzkolenie/{pracownik_id}/{szkolenie_id}")
	public void editPracownik(@PathVariable int pracownik_id, @PathVariable int szkolenie_id) {
		Pracownik p = repository.findById(pracownik_id).orElseThrow(() -> new ItemNotFoundException());
		Szkolenie s = szkolenieRepository.findById(szkolenie_id).get();
		p.getSzkolenia().add(s);
		repository.save(p);
		
	}
	
	@PutMapping
	public void editAnything(@RequestBody Pracownik pracownik) {
		Pracownik p = repository.findById(pracownik.getId()).orElseThrow(() -> new ItemNotFoundException());
		if(pracownik.getImie()!=null)
			p.setImie(pracownik.getImie());
		if(pracownik.getNazwisko()!=null)
			p.setNazwisko(pracownik.getNazwisko());
		if(pracownik.getStanowisko()!=null)
			p.setStanowisko(pracownik.getStanowisko());
		if(pracownik.getTyp_konta()!=0) {
			p.setTyp_konta(pracownik.getTyp_konta());
		}
		
		repository.save(p);
	}
	
	@Transactional
	@PutMapping(value= "/addStanowisko/{id}/{pracownikId}")
	public void addStanowiskoToPracownik(@PathVariable Integer id,@PathVariable Integer pracownikId) {
		Stanowisko s = stanowiskoRepository.findById(id).get();
		Pracownik k = repository.findById(pracownikId).get();
		k.setStanowisko(s);
		repository.save(k);
	}
	
	@PutMapping(value="/removeSzkolenie/{pracownik_id}/{szkolenie_id}")
	public void removeSzkolenie(@PathVariable int pracownik_id, @PathVariable int szkolenie_id) {
		Pracownik p = repository.findById(pracownik_id).orElseThrow(() -> new ItemNotFoundException());
		int index=-1;
		List<Szkolenie> szkolenia = p.getSzkolenia();
		for(int x = 0 ; x<szkolenia.size(); x++) {
			if(szkolenia.get(x).getId()==szkolenie_id) {
				index=x;
			}
		}
		if(index!=-1) {
			p.getSzkolenia().remove(index);
		}
		repository.save(p);
		
	}
	
	@Transactional
	@PutMapping(value= "/changeStanowisko/{id}/{pracownikId}")
	public void changeStanowiskoToPracownik(@PathVariable Integer id,@PathVariable Integer pracownikId) {
		Stanowisko s = stanowiskoRepository.findById(id).get();
		Pracownik k = repository.findById(pracownikId).get();
		k.setStanowisko(s);
		repository.save(k);
	}
	
	@Transactional
	@PutMapping(value= "/removeStanowisko/{pracownikId}")
	public void removeStanowiskoToPracownik(@PathVariable Integer pracownikId) {
//		Stanowisko s = stanowiskoRepository.findById(id).get();
		Pracownik k = repository.findById(pracownikId).get();
		k.setStanowisko(null);
		repository.save(k);
	}
	
	@GetMapping(value="/getBySzkolenie/{szkolenie}")
	List<Pracownik> findBySzkolenia(@PathVariable int szkolenie){
		List<Pracownik> pracownics = new ArrayList<>();
		List<Pracownik> all = repository.findAll();
		
		for(Pracownik p : all) {
			for(Szkolenie s : p.getSzkolenia()) {
				if(s.getId()==szkolenie) {
					pracownics.add(p);
					break;
				}
			}
		}
		return pracownics;
	}
	
	@PostMapping
	public Pracownik addPracownik(@RequestBody Pracownik pracownik) {
//		Szkolenie s = szkolenieRepository.findById(1).get();
//		pracownik.getSzkolenia().add(s);
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
		p.setSzkolenia(pracownik.getSzkolenia());
		repository.save(p);
	}
	
	
	@GetMapping(value="/stanowisko/{id}")
	public List<Pracownik> findByStanowisko(@PathVariable Integer id){
		List<Pracownik> pracowniks = repository.findAll();
		List<Pracownik> filtered = new ArrayList<>();
		for(Pracownik p : pracowniks) {
			if(p.getStanowisko()!=null) {
				if(p.getStanowisko().getId()==id)
					filtered.add(p);
			}
		}
		return filtered;
	}

}
