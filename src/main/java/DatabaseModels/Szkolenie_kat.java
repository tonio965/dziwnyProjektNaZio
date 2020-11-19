package DatabaseModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "szkolenie_kat")
public class Szkolenie_kat {
	
	int id_szk_kat;
	String nazwa_kat_szk;
	
	public Szkolenie_kat() {
		super();
	}

	public Szkolenie_kat(int id_szk_kat, String nazwa_kat_szk) {
		super();
		this.id_szk_kat = id_szk_kat;
		this.nazwa_kat_szk = nazwa_kat_szk;
	}

	@Column(name = "id_szk_kat")
	public int getId_szk_kat() {
		return id_szk_kat;
	}

	public void setId_szk_kat(int id_szk_kat) {
		this.id_szk_kat = id_szk_kat;
	}
	
	
	@Column(name = "nazwa_kat_szk")
	public String getNazwa_kat_szk() {
		return nazwa_kat_szk;
	}

	public void setNazwa_kat_szk(String nazwa_kat_szk) {
		this.nazwa_kat_szk = nazwa_kat_szk;
	}
	
	
	
	
	
	

}
