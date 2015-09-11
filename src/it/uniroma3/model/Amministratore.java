package it.uniroma3.model;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name = "findAllAmministratori", query = "SELECT a FROM Amministratore a")
public class Amministratore {
	
	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String cognome;

	@Column(nullable=false)
	private String email;

	@Temporal(TemporalType.DATE)
	private GregorianCalendar dataDiNascita;

	@Id
	@Column(nullable = false)
	private String matricola;
	
	@Column(nullable=false)
	private String password;
	
	public Amministratore(String nome, String cognome, String email, GregorianCalendar dataDiNascita, String password, String matricola){
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.password = password;
		this.matricola = matricola;
	}
	
	public boolean verificaCredenziali(String matricola, String password){
		return this.matricola.equals(matricola) && this.password.equals(password);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(GregorianCalendar dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
