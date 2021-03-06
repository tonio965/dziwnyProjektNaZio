package com.zio.models;

import java.util.ArrayList;
import java.util.List;

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
	String email;
	
	@OneToOne
	private Stanowisko stanowisko;
	
	@ManyToMany
	(cascade = { CascadeType.PERSIST,
			     CascadeType.MERGE})
	@JoinTable(
			name               = "szkolenie_pracownik",
			joinColumns        = @JoinColumn(name = "id_pracownik"),
			inverseJoinColumns = @JoinColumn(name = "id_szkolenie"))
	List<Szkolenie> szkolenia;
	
	@ManyToMany 
			(mappedBy = "pracownicy",
			 cascade = {
		             CascadeType.PERSIST,
		             CascadeType.MERGE})
	List<Projekt> projekty;
	
	
	
	
	
	
	
	
	public List<Szkolenie> getSzkolenia() {
		return szkolenia;
	}

	public void setSzkolenia(List<Szkolenie> szkolenia) {
		this.szkolenia = szkolenia;
	}
	
	public void addSzkolenie(Szkolenie szkolenie) {
		szkolenia.add(szkolenie);
	}
	
	public void removeSzkolenie(int id) {
		for(Szkolenie s : szkolenia) {
			if(s.getId()==id)
				szkolenia.remove(s);
		}
	}

	public Pracownik() {
		
	}
	
	public Pracownik(int id, String imie, String nazwisko, int typ_konta, Stanowisko stanowisko) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.typ_konta = typ_konta;
		this.stanowisko = stanowisko;
		this.szkolenia = new ArrayList<>();
		this.email = "";
	}
	
	public Pracownik(int id, String imie, String nazwisko, int typ_konta, Stanowisko stanowisko, String email) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.typ_konta = typ_konta;
		this.stanowisko = stanowisko;
		this.szkolenia = new ArrayList<>();
		this.email = email;
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
	
	@Column(name = "typ_konta")
	public int getTyp_konta() {
		return typ_konta;
	}
	public void setTyp_konta(int typ_konta) {
		this.typ_konta = typ_konta;
	}
	
	public Stanowisko getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(Stanowisko stanowisko) {
		this.stanowisko = stanowisko;
	}
	
	
	

}
