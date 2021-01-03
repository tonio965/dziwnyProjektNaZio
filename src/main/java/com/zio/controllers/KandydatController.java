package com.zio.controllers;

import java.util.List;

import javax.mail.MessagingException;

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
import com.zio.models.Kandydat;
import com.zio.models.Pracownik;
import com.zio.models.Stanowisko;
import com.zio.repositories.KandydatRepository;
import com.zio.repositories.PracownikRepository;
import com.zio.repositories.StanowiskoRepository;
import com.zio.services.MailService;

@RestController
@RequestMapping(value = "/kandydaci")
public class KandydatController {
	
	@Autowired
	KandydatRepository repository;
	
	@Autowired
	StanowiskoRepository stanowiskoRepository;
	
	@Autowired
	PracownikRepository pracownikRepository;
	
	@Autowired
	MailService mailService;
	
	@GetMapping
	public Iterable<Kandydat> getKandydaci(){
		return repository.findAll();
	}
	
	@PostMapping(value ="/employKandydat/{idCandidate}")
	public Pracownik employedKandydat(@PathVariable Integer idCandidate) {
		
		Kandydat k = repository.findById(idCandidate).get();
		
		Pracownik p = new Pracownik();
		
		p.setImie(k.getImie());
		p.setNazwisko(k.getNazwisko());
		p.setStanowisko(k.getStanowisko());
		p.setTyp_konta(1);
		p.setSzkolenia(null);
		repository.delete(k);
		if(k.getEmail().length()>1) {
			p.setEmail(k.getEmail());
    		try {
				mailService.sendMail(k.getEmail(),
			        "bajo jajo bajo jajo",
			        "bajo jajo bajo jajo", true);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
    		System.out.println("candidate employed, informed via email");
		}
		pracownikRepository.save(p);
		return p;
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
	
	@Transactional
	@PutMapping(value= "/addStanowisko/{id}/{pracownikId}")
	public void addStanowiskoToKandydat(@PathVariable Integer id,@PathVariable Integer pracownikId) {
		Stanowisko s = stanowiskoRepository.findById(id).get();
		Kandydat k = repository.findById(pracownikId).get();
		k.setStanowisko(s);
		repository.save(k);
	}
	
	@Transactional
	@PutMapping(value= "/changeStanowisko/{id}/{pracownikId}")
	public void changeStanowiskoToKandydat(@PathVariable Integer id,@PathVariable Integer pracownikId) {
		Stanowisko s = stanowiskoRepository.findById(id).get();
		Kandydat k = repository.findById(pracownikId).get();
		k.setStanowisko(s);
		repository.save(k);
	}
	
	@Transactional
	@PutMapping(value= "/removeStanowisko/{id}/{pracownikId}")
	public void removeStanowiskoToKandydat(@PathVariable Integer id,@PathVariable Integer pracownikId) {
//		Stanowisko s = stanowiskoRepository.findById(id).get();
		Kandydat k = repository.findById(pracownikId).get();
		k.setStanowisko(null);
		repository.save(k);
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

		if(kandydat.getImie()!=null)
			p.setImie(kandydat.getImie());
		if(p.getNazwisko()!=null)
			p.setNazwisko(kandydat.getNazwisko());
		
		p.setStanowisko(kandydat.getStanowisko());
		
		if(p.getNazwa_pliku_CV()!=null)
			p.setNazwa_pliku_CV(kandydat.getNazwa_pliku_CV());
		repository.save(p);
	}

}
