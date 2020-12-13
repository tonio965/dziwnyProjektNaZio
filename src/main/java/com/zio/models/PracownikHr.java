package com.zio.models;

import java.util.Set;

import javax.persistence.*;

import javassist.bytecode.Descriptor.Iterator;

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
	
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns =
    @JoinColumn(name = "id"), inverseJoinColumns =
    @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    private String role;
	
	public PracownikHr(int id, String login, String haslo, Pracownik pracownik) {
		super();
		this.id = id;
		this.pracownik = pracownik;
		this.login = login;
		this.haslo = haslo;
		this.role = "ADMIN";
	}
	

	
	public PracownikHr() {
	}
	
	public PracownikHr(PracownikHr pracownikHr) {
		this.id = pracownikHr.id;
		this.pracownik = pracownikHr.pracownik;
		this.login = pracownikHr.login;
		this.haslo = pracownikHr.haslo;
		this.roles=pracownikHr.roles;
		this.role = "ADMIN";
		
	}

	@Column(name = "pracownik")
	public Pracownik getPracownik() {
		return pracownik;
	}
	public void setPracownik(Pracownik p) {
		this.pracownik = p;
	}
	
	@Column(name = "login", unique=true)
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
	
	
	
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRole(String role) {
		this.role = role;
	}



	public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
	
	@Column(name = "role")
    public String getRole() {
    	return this.role;
    }
	
	

}
