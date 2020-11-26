package com.zio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zio.models.Pracownik;


public interface PracownikRepository extends JpaRepository<Pracownik, Integer>{
	
	List<Pracownik> findByNazwisko(String surname);
	
	List<Pracownik> findByStanowisko(Integer stanowisko);
	



}
