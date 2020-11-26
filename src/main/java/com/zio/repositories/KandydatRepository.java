package com.zio.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zio.models.*;

public interface KandydatRepository extends JpaRepository<Kandydat, Integer>{
	
	List<Kandydat> findByNazwisko(String surname);
	
	List<Kandydat> findByStanowisko(Integer stanowisko);

}
