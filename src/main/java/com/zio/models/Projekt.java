package com.zio.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Projekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idProjekt;
	String nazwa;
	@OneToOne
	KatProjektu kategoriaProjektu;
	
	@ManyToMany
	(cascade = { CascadeType.PERSIST,
			     CascadeType.MERGE})
	@JoinTable(
			name               = "projekt_pracownik",
			joinColumns        = @JoinColumn(name = "id_projekt"),
			inverseJoinColumns = @JoinColumn(name = "id_pracownik"))
	List<Pracownik> pracownicy;
	
		
	public List<Pracownik> getPracownicy() {
		return pracownicy;
	}
	public void setPracownicy(List<Pracownik> pracownicy) {
		this.pracownicy = pracownicy;
	}
	
	public void addPracownik(Pracownik pracownik) {
		pracownicy.add(pracownik);
	}
	
	public void removePracownik(int id) {
		for(Pracownik p : pracownicy) {
			if(p.getId()==id) {
				pracownicy.remove(p);
			}
		}
	}
	
	
	
	
	
	public Projekt(int id_projekt, String nazwa, KatProjektu kategoria_projektu) {
		super();
		this.idProjekt = id_projekt;
		this.nazwa = nazwa;
		this.kategoriaProjektu = kategoria_projektu;
		this.pracownicy = new ArrayList<>();
	}
	public Projekt() {
	}
	
	
	
	public void setId_projekt(int id_projekt) {
		this.idProjekt = id_projekt;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	
	
	@Column(name = "id_projekt")
	public int getIdProjekt() {
		return idProjekt;
	}
	
	@Column(name = "nazwa")
	public String getNazwa() {
		return nazwa;
	}
	
	@Column(name = "kategoria_projektu")
	public KatProjektu getKategoriaProjektu() {
		return kategoriaProjektu;
	}
	public void setKategoriaProjektu(KatProjektu kategoriaProjektu) {
		this.kategoriaProjektu = kategoriaProjektu;
	}
	
	
	
	

}
