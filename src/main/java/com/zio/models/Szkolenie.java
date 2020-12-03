package com.zio.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "szkolenie")
public class Szkolenie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nazwa;
	Timestamp data_szkolenia;
	int rodzaj_szkolenia;
	
	
	@ManyToMany (mappedBy = "szkolenia",
				 cascade = {
			             CascadeType.PERSIST,
			             CascadeType.MERGE})
	List<Pracownik> pracownicy;
	
	

	public Szkolenie() {

	}


	public Szkolenie(int id, String nazwa, Timestamp data_szkolenia, int rodzaj_szkolenia) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.data_szkolenia = data_szkolenia;
		this.rodzaj_szkolenia = rodzaj_szkolenia;
	}

	@Column(name = "id" )
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nazwa" )
	public String getNazwa() {
		return nazwa;
	}


	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Column(name = "data_szkolenia" )
	public Timestamp getData_szkolenia() {
		return data_szkolenia;
	}


	public void setData_szkolenia(Timestamp data_szkolenia) {
		this.data_szkolenia = data_szkolenia;
	}

	@Column(name = "rodzaj_szkolenia" )
	public int getRodzaj_szkolenia() {
		return rodzaj_szkolenia;
	}


	public void setRodzaj_szkolenia(int rodzaj_szkolenia) {
		this.rodzaj_szkolenia = rodzaj_szkolenia;
	}
	
	
	
	

}
