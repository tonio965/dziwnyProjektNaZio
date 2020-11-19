package DatabaseModels;

import javax.persistence.*;

@Entity
@Table(name= "kat_projektu")
public class Kat_projektu {
	
	int id_kat;
	String nazwa_kat_projektu;
	public Kat_projektu(int id_kat, String nazwa_kat_projektu) {
		super();
		this.id_kat = id_kat;
		this.nazwa_kat_projektu = nazwa_kat_projektu;
	}
	public Kat_projektu() {
		super();
	}
	
	@Column(name = "id_kat")
	public int getId_kat() {
		return id_kat;
	}
	public void setId_kat(int id_kat) {
		this.id_kat = id_kat;
	}
	
	@Column(name = "nazwa_kat_projektu")
	public String getNazwa_kat_projektu() {
		return nazwa_kat_projektu;
	}
	public void setNazwa_kat_projektu(String nazwa_kat_projektu) {
		this.nazwa_kat_projektu = nazwa_kat_projektu;
	}
	
	
	

}
