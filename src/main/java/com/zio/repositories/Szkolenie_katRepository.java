package com.zio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.Szkolenie;
import com.zio.models.Szkolenie_kat;

public interface Szkolenie_katRepository extends JpaRepository<Szkolenie_kat, Integer>{
	
	Szkolenie_kat findByIdSzkKat(int id_szk_kat);
	void deleteByIdSzkKat(int id_szk_kat);

}
