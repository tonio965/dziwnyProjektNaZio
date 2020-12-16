package com.zio.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.zio.models.KatProjektu;
import com.zio.models.Pracownik;
import com.zio.models.Projekt;
import com.zio.models.Szkolenie;
import com.zio.repositories.KatProjektuRepository;
import com.zio.repositories.PracownikRepository;
import com.zio.repositories.ProjektRepository;

@RestController
@RequestMapping(value = "/projekt")
public class ProjektController {
	
	@Autowired
	ProjektRepository projektRepository;
	
	@Autowired
	PracownikRepository pracownikRepository;
	
	@Autowired
	KatProjektuRepository katProjektuRepository;
	
	@PutMapping(value = "/addKategoria/{projektId}/{kategoriaId}")
	public Projekt addKategoriaToProjekt(@PathVariable int projektId, @PathVariable int kategoriaId) {
		Projekt p = projektRepository.findById(projektId).orElseThrow(() -> new ItemNotFoundException());
		KatProjektu kp = katProjektuRepository.findByIdKat(kategoriaId);
		p.setKategoriaProjektu(kp);
		projektRepository.save(p);
		return p;
	}
	
	@PutMapping(value = "/changeKategoria/{projektId}/{kategoriaId}")
	public Projekt changeKategoriaToProjekt(@PathVariable int projektId, @PathVariable int kategoriaId) {
		Projekt p = projektRepository.findById(projektId).orElseThrow(() -> new ItemNotFoundException());
		KatProjektu kp = katProjektuRepository.findByIdKat(kategoriaId);
		p.setKategoriaProjektu(kp);
		projektRepository.save(p);
		return p;
	}
	
	@PutMapping(value = "/removeKategoria/{projektId}/")
	public Projekt removeKategoriaToProjekt(@PathVariable int projektId) {
		Projekt p = projektRepository.findById(projektId).orElseThrow(() -> new ItemNotFoundException());
//		KatProjektu kp = katProjektuRepository.findByIdKat(kategoriaId);
		p.setKategoriaProjektu(null);
		projektRepository.save(p);
		return p;
	}
	
	@PutMapping(value="/addPracownik/{pracownik_id}/{projekt_id}")
	public void editProjekt(@PathVariable int projekt_id, @PathVariable int pracownik_id) {
		Projekt p = projektRepository.findById(projekt_id).orElseThrow(() -> new ItemNotFoundException());
		Pracownik prac = pracownikRepository.findById(pracownik_id).get();
		p.getPracownicy().add(prac);
		projektRepository.save(p);

	}
	
	@PutMapping(value="/removePracownik/{pracownik_id}/{projekt_id}")
	public void removeProjekt(@PathVariable int projekt_id, @PathVariable int pracownik_id) {
		Projekt p = projektRepository.findById(projekt_id).orElseThrow(() -> new ItemNotFoundException());
		int index = -1;
		List<Pracownik> pracownics = p.getPracownicy();
		for(int x = 0 ; x<pracownics.size(); x++) {
			if(pracownics.get(x).getId()==pracownik_id) {
				index=x;
			}
		}
		if(index!=-1) {
			p.getPracownicy().remove(index);
		}
		
		
		
		Pracownik prac = pracownikRepository.findById(pracownik_id).get();
		p.getPracownicy().add(prac);
		projektRepository.save(p);

	}
	
	@GetMapping
	public Iterable<Projekt> getProjekts(){
		return projektRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Projekt getProjekt(@PathVariable Integer id) {
		return projektRepository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	@PostMapping
	public Projekt addProjekt(@RequestBody Projekt projekt) {
		List<Pracownik> proj = projekt.getPracownicy();
		projekt.setPracownicy(new ArrayList<>());
		projektRepository.save(projekt);
		for(Pracownik p : proj)
			editProjekt(projekt.getIdProjekt(), p.getId());
		return projekt;
	}
	

	@Transactional
	@DeleteMapping(value = "/{id}")
	public void deleteProjekt(@PathVariable Integer id) {
		projektRepository.deleteByIdProjekt(id);
	}
	

}
