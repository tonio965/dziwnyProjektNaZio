package com.zio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.PracownikHr;

public interface PracownikHrRepository extends JpaRepository<PracownikHr, Integer> {
	
	public PracownikHr findByLogin(String login);
	
	public PracownikHr findByLoginAndHaslo(String login, String password);

}
