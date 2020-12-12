package com.zio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.KatProjektu;

public interface KatProjektuRepository extends JpaRepository<KatProjektu, Integer>{
	

	public KatProjektu findByIdKat(int id);
	
	public List<KatProjektu>findByNazwaKatProjektu(String nazwa);

}
