package DatabaseModels;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "stanowisko")
public class Stanowisko {
	
	int id;
	String nazwa;
	String dzial;
	
	public Stanowisko() {
		super();
	}

	public Stanowisko(int id, String nazwa, String dzial) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.dzial = dzial;
	}

	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nazwa")
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Column(name = "dzial")
	public String getDzial() {
		return dzial;
	}

	public void setDzial(String dzial) {
		this.dzial = dzial;
	}
	
	
	
	

	
	
}
