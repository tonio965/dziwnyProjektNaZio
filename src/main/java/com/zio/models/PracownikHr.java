package com.zio.models;

import javax.persistence.*;

@Entity
@Table(name = "pracownik_hr")
public class PracownikHr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String login;
	String haslo;
	
	@OneToOne
	Pracownik pracownik;
	
	public PracownikHr(int id, String login, String haslo, Pracownik pracownik) {
		super();
		this.id = id;
		this.pracownik = pracownik;
		this.login = login;
		this.haslo = haslo;
	}
	
	public PracownikHr() {
	}
	
	@Column(name = "pracownik")
	public Pracownik getPracownik() {
		return pracownik;
	}
	public void setPracownik(Pracownik p) {
		this.pracownik = p;
	}
	
	@Column(name = "login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name = "haslo")
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	
	

}
