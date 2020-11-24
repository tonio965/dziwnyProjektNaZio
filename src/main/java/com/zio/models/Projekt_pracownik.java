package com.zio.models;

import javax.persistence.*;

@Embeddable
@Table(name = "projekt_pracownik")
public class Projekt_pracownik {
	
	int id_pracownik;
	int id_projekt;
	
	public Projekt_pracownik(int id_pracownik, int id_projekt) {
		super();
		this.id_pracownik = id_pracownik;
		this.id_projekt = id_projekt;
	}
	public Projekt_pracownik() {
	}
	
	@Column(name="id_pracownik")
	public int getId_pracownik() {
		return id_pracownik;
	}
	public void setId_pracownik(int id_pracownik) {
		this.id_pracownik = id_pracownik;
	}
	
	@Column(name="id_projekt")
	public int getId_projekt() {
		return id_projekt;
	}
	public void setId_projekt(int id_projekt) {
		this.id_projekt = id_projekt;
	}
	
	

}
