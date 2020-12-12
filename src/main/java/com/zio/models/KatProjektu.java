package com.zio.models;

import javax.persistence.*;

@Entity
@Table(name= "kat_projektu")
public class KatProjektu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idKat;
	String nazwaKatProjektu;
	
	
	public KatProjektu(int id_kat, String nazwa_kat_projektu) {
		super();
		this.idKat = id_kat;
		this.nazwaKatProjektu = nazwa_kat_projektu;
	}
	
	public KatProjektu() {
	}
	
	@Column(name = "id_kat")
	public int getidKat() {
		return idKat;
	}
	public void setidKat(int id_kat) {
		this.idKat = id_kat;
	}
	
	@Column(name = "nazwa_kat_projektu")
	public String getnazwaKatProjektu() {
		return nazwaKatProjektu;
	}
	public void setnazwaKatProjektu(String nazwa_kat_projektu) {
		this.nazwaKatProjektu = nazwa_kat_projektu;
	}
	
	
	

}
