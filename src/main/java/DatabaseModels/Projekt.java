package DatabaseModels;

import javax.persistence.*;

@Entity
public class Projekt {
	
	int id_projekt;
	String nazwa;
	int kategoria_projektu;
	public Projekt(int id_projekt, String nazwa, int kategoria_projektu) {
		super();
		this.id_projekt = id_projekt;
		this.nazwa = nazwa;
		this.kategoria_projektu = kategoria_projektu;
	}
	public Projekt() {
		super();
	}
	
	
	
	public void setId_projekt(int id_projekt) {
		this.id_projekt = id_projekt;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public void setKategoria_projektu(int kategoria_projektu) {
		this.kategoria_projektu = kategoria_projektu;
	}
	
	
	@Column(name = "id_projekt")
	public int getId_projekt() {
		return id_projekt;
	}
	
	@Column(name = "nazwa")
	public String getNazwa() {
		return nazwa;
	}
	
	@Column(name = "kategoria_projektu")
	public int getKategoria_projektu() {
		return kategoria_projektu;
	}
	
	

}
