package com.zio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "szkolenie_kat")
public class Szkolenie_kat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idSzkKat;
	String nazwaSzkKat;
	
	public Szkolenie_kat() {
	
	}

	public Szkolenie_kat(int id_szk_kat, String nazwa_kat_szk) {
		this.idSzkKat = id_szk_kat;
		this.nazwaSzkKat = nazwa_kat_szk;
	}

	@Column(name = "id_szk_kat")
	public int getIdSzkKat() {
		return idSzkKat;
	}

	public void setIdSzkKat(int id_szk_kat) {
		this.idSzkKat = id_szk_kat;
	}
	
	
	@Column(name = "nazwa_kat_szk")
	public String getnazwaSzkKat() {
		return nazwaSzkKat;
	}

	public void setnazwaSzkKat(String nazwa_kat_szk) {
		this.nazwaSzkKat = nazwa_kat_szk;
	}
	
	
	
	
	
	

}
