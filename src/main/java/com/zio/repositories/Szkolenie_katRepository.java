package com.zio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zio.models.Szkolenie;
import com.zio.models.SzkolenieKat;

public interface Szkolenie_katRepository extends JpaRepository<SzkolenieKat, Integer>{
	
	SzkolenieKat findByIdSzkKat(int id_szk_kat);
	void deleteByIdSzkKat(int id_szk_kat);
	

}
