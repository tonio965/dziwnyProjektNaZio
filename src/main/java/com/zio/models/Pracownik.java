package com.zio.models;

import javax.persistence.*;

@Entity
@Table(name = "pracownik")
public class Pracownik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String imie;
	String nazwisko;
	int typ_konta;
	int stanowisko;
	
	
	public Pracownik() {
		
	}
	
	public Pracownik(int id, String imie, String nazwisko, int typ_konta, int stanowisko) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.typ_konta = typ_konta;
		this.stanowisko = stanowisko;
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
	
	@Column(name = "typ_konta")
	public int getTyp_konta() {
		return typ_konta;
	}
	public void setTyp_konta(int typ_konta) {
		this.typ_konta = typ_konta;
	}
	
	@Column(name = "stanowisko")
	public int getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(int stanowisko) {
		this.stanowisko = stanowisko;
	}
	
	
	

}
