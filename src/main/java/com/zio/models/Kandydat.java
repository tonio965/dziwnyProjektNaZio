package com.zio.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kandydat")
public class Kandydat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String imie;
	String nazwisko;
	String nazwa_pliku_CV;
	String email;
	
	@OneToOne
	private Stanowisko stanowisko;
	
	
	public Kandydat(int id, String imie, String nazwisko, String nazwa_pliku_CV) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nazwa_pliku_CV = nazwa_pliku_CV;
		this.email =new String();
	}
	
	public Kandydat(int id, String imie, String nazwisko, String nazwa_pliku_CV, String email) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nazwa_pliku_CV = nazwa_pliku_CV;
		this.email = email;
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
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	public Stanowisko getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(Stanowisko stanowisko) {
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
