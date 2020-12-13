package com.zio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zio.models.Pracownik;
import com.zio.models.PracownikHr;
import com.zio.repositories.PracownikHrRepository;
import com.zio.repositories.PracownikRepository;

@RestController
@RequestMapping(value = "/hr")
public class PracownikHrController {

	
	@Autowired
	PracownikHrRepository repository;
	
	@Autowired
	PracownikRepository pracownikRepository;
	
	@PostMapping(value = "/{pracownikId}")
	public PracownikHr addPracownik(@PathVariable int pracownikId, @RequestBody PracownikHr pracownik ) {
		
		Pracownik p = pracownikRepository.findById(pracownikId).get();
		PracownikHr phr = pracownik;
        String generatedSecuredPasswordHash = BCrypt.hashpw(pracownik.getHaslo(), BCrypt.gensalt(12));
        phr.setHaslo(generatedSecuredPasswordHash);
        System.out.println("pw hash: "+generatedSecuredPasswordHash);
		phr.setRole("role: ADMIN");
		phr.setPracownik(p);
		repository.save(phr);
		return phr;
	}
	
	@GetMapping
	public List<PracownikHr> pracownicy(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public PracownikHr pracwonikById(@PathVariable int id) {
		List<PracownikHr> pracowniks = repository.findAll();
		PracownikHr p = null;
		
		for(PracownikHr phr: pracowniks) {
			if(phr.getPracownik()!=null) {
				if(phr.getPracownik().getId()==id) {
					p=phr;
				}
				
				
			}
			
		}
		return p;
		
	}
	
	@GetMapping(value = "/getAccess")
	public boolean checkAccess(@RequestBody PracownikHr pracownikHr) {
		PracownikHr pracownik = repository.findByLoginAndHaslo(pracownikHr.getLogin(), pracownikHr.getHaslo());
		if(pracownik!=null)
			return true;
		else {
			return false;
		}
	}
	
	@DeleteMapping(value = "/{login}")
	public PracownikHr deletePracownikHr(@PathVariable String login) {
		PracownikHr pracownik = repository.findByLogin(login);
		if(pracownik!=null) {
			repository.delete(pracownik);
			return pracownik;
		}
		else {
			return null;
		}
			
	}
	
	
}
