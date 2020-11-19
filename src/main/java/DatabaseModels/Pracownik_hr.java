package DatabaseModels;

import javax.persistence.*;

@Entity
@Table(name = "pracownik_hr")
public class Pracownik_hr {
	
	int id_pracownik;
	String login;
	String haslo;
	
	public Pracownik_hr(int id_pracownik, String login, String haslo) {
		super();
		this.id_pracownik = id_pracownik;
		this.login = login;
		this.haslo = haslo;
	}
	
	public Pracownik_hr() {
		super();
	}
	
	@Column(name = "id_pracownik")
	public int getId_pracownik() {
		return id_pracownik;
	}
	public void setId_pracownik(int id_pracownik) {
		this.id_pracownik = id_pracownik;
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
