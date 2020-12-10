package com.zio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.Szkolenie;
import com.zio.models.SzkolenieKat;

public interface Szkolenie_katRepository extends JpaRepository<SzkolenieKat, Integer>{
	
	SzkolenieKat findByIdSzkKat(int id_szk_kat);
	void deleteByIdSzkKat(int id_szk_kat);

}
