package com.zio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kandydat")
public class Kandydat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String imie;
	String nazwisko;
	int stanowisko;
	String nazwa_pliku_CV;
	
	public Kandydat(int id, String imie, String nazwisko, int stanowisko, String nazwa_pliku_CV) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.stanowisko = stanowisko;
		this.nazwa_pliku_CV = nazwa_pliku_CV;
	}
	public Kandydat() {
	}
	
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "imie")
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	@Column(name = "nazwisko")
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	@Column(name = "stanowisko")
	public int getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(int stanowisko) {
		this.stanowisko = stanowisko;
	}
	
	@Column(name = "nazwa_pliku_CV")
	public String getNazwa_pliku_CV() {
		return nazwa_pliku_CV;
	}
	public void setNazwa_pliku_CV(String nazwa_pliku_CV) {
		this.nazwa_pliku_CV = nazwa_pliku_CV;
	}
	
	

}
