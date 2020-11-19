package DatabaseModels;

import javax.persistence.*;

@Entity
@Table(name = "szkolenie_pracownik")
public class Szkolenie_pracownik {
	
	int id_pracownik;
	int id_szkolenie;
	
	
	public Szkolenie_pracownik() {
		super();
	}
	
	public Szkolenie_pracownik(int id_pracownik, int id_szkolenie) {
		super();
		this.id_pracownik = id_pracownik;
		this.id_szkolenie = id_szkolenie;
	}
	
	@Column(name = "id_pracownik")
	public int getId_pracownik() {
		return id_pracownik;
	}
	public void setId_pracownik(int id_pracownik) {
		this.id_pracownik = id_pracownik;
	}
	
	@Column(name = "id_szkolenie")
	public int getId_szkolenie() {
		return id_szkolenie;
	}
	public void setId_szkolenie(int id_szkolenie) {
		this.id_szkolenie = id_szkolenie;
	}
	
	

}
