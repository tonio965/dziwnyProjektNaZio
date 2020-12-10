package com.zio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.Projekt;

public interface ProjektRepository extends JpaRepository<Projekt, Integer> {
	
	List<Projekt> findByIdProjekt(Integer id);
	
	public void deleteByIdProjekt(Integer id);
	
	

}
