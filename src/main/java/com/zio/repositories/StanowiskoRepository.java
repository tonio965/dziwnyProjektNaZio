package com.zio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.Stanowisko;

public interface StanowiskoRepository  extends JpaRepository<Stanowisko, Integer>{
	
	List<Stanowisko> findByNazwa(String nazwa);
	
	List<Stanowisko> findByDzial(String dzial);


}
