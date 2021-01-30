package com.zio.controllers;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.LoggerFactory;
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
import com.zio.main.UserDetailsServiceImpl;
import com.zio.models.Kandydat;
import com.zio.models.Pracownik;
import com.zio.models.Stanowisko;
import com.zio.repositories.KandydatRepository;
import com.zio.repositories.PracownikRepository;
import com.zio.repositories.StanowiskoRepository;
import com.zio.services.MailService;

import ch.qos.logback.classic.Logger;

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
	
	Logger logger = (Logger) LoggerFactory.getLogger(KandydatController.class);
	
	/*
	 * Zwraca liste wszystkich kandydatow
	 */
	@GetMapping
	public Iterable<Kandydat> getKandydaci(){
		logger.info("kandydatController: getAll()");
		return repository.findAll();
	}
	
	/**
	 * 
	 * @param idCandidate - id kandydata do zatrudneinia
	 * @return zwraca obiekt klasy PRacownik z danymi ktore byly w kandydacie
	 */
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
    		logger.info("candidate employed, informed via email");
		}
		pracownikRepository.save(p);
		return p;
	}
	
	
	/**
	 * 
	 * @param id - id kandydata do zwrocenia
	 * @return Obiekt klasy Kandydat wyjety z bazy na podstawie id
	 */
	@GetMapping(value = "/{id}")
	public Kandydat getKandydat(@PathVariable Integer id) {
		logger.info("kandydatController: getKandydat");
		return repository.findById(id).orElseThrow(ItemNotFoundException::new);
	}
	
	/**
	 * 
	 * @param kandydat - Obiekt klasy Kandydat do umieszczenia w bazie
	 * @return zwraca obiekt Kandydata
	 */
	@PostMapping
	public Kandydat addKandydat(@RequestBody Kandydat kandydat) {
		logger.info("kandydatController: saveKandydat");
	    return repository.save(kandydat);
	}
	
	/**
	 * 
	 * @param id - id kandydata do usuniecia
	 */
	@DeleteMapping(value = "/{id}")
	public void deleteKandydat(@PathVariable Integer id) {
		logger.info("kandydatController: deleteKandydat");
	    repository.deleteById(id);
	}
	
	/**
	 * 
	 * @param id -id stanowiska do dodania do pracownika
	 * @param pracownikId - id pracownika ktoremu chcemy ustawic stanowisko
	 */
	@Transactional
	@PutMapping(value= "/addStanowisko/{id}/{pracownikId}")
	public void addStanowiskoToKandydat(@PathVariable Integer id,@PathVariable Integer pracownikId) {
		Stanowisko s = stanowiskoRepository.findById(id).get();
		Kandydat k = repository.findById(pracownikId).get();
		k.setStanowisko(s);
		logger.info("kandydatController: addStanowisko");
		repository.save(k);
	}
	
	/**
	 * 
	 * @param id -id stanowiska do dodania do pracownika
	 * @param pracownikId - id pracownika ktoremu chcemy ustawic stanowisko
	 */
	@Transactional
	@PutMapping(value= "/changeStanowisko/{id}/{pracownikId}")
	public void changeStanowiskoToKandydat(@PathVariable Integer id,@PathVariable Integer pracownikId) {
		Stanowisko s = stanowiskoRepository.findById(id).get();
		Kandydat k = repository.findById(pracownikId).get();
		k.setStanowisko(s);
		logger.info("kandydatController: changeStanowisko");
		repository.save(k);
	}
	
	/**
	 * 
	 * @param id -id stanowisko do usuniecia z pracownika
	 * @param pracownikId - id pracownika ktoremu chcemy usunac stanowisko
	 */
	@Transactional
	@PutMapping(value= "/removeStanowisko/{id}/{pracownikId}")
	public void removeStanowiskoToKandydat(@PathVariable Integer id,@PathVariable Integer pracownikId) {
//		Stanowisko s = stanowiskoRepository.findById(id).get();
		Kandydat k = repository.findById(pracownikId).get();
		k.setStanowisko(null);
		logger.info("kandydatController: removeStanowisko");
		repository.save(k);
	}
	
	/**
	 * 
	 * @param nazwisko - nazwisko kandydata ktorego szukamy
	 * @return Lista osob spelniajacych to kryterium
	 */
	@GetMapping(value= "/nazwisko/{nazwisko}")
	public List<Kandydat> findByNazwisko(@PathVariable String nazwisko) {
		logger.info("kandydatController: findByNazwisko");
		return repository.findByNazwisko(nazwisko);
	}
	
	/**
	 * 
	 * @param id - id stanowiska na ktore aplikuje przez kandydat
	 * @return lista osob spelniajacych kryterium
	 */
	@GetMapping(value="/stanowisko/{id}")
	public List<Kandydat> findByStanowisko(@PathVariable Integer id){
		logger.info("kandydatController: findByStanowisko");
		return repository.findByStanowisko(id);
	}
	
	/**
	 * 
	 * @param id - id kandydata do edycji
	 * @param kandydat - Model kandydata do podmiany
	 */
	@PutMapping(value="/{id}")
	public void editKandydat(@PathVariable Integer id, @RequestBody Kandydat kandydat) {
		logger.info("kandydatController: editKandydat");
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
