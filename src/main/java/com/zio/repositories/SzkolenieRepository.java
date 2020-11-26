package com.zio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.Szkolenie;

public interface SzkolenieRepository extends JpaRepository<Szkolenie, Integer>{
	
	List<Szkolenie> findByNazwa(String name);
	
//	List<Szkolenie> findByRodzaj_szkolenia(Integer type);

}
