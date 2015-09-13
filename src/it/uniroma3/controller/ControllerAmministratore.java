package it.uniroma3.controller;

import java.util.GregorianCalendar;

import it.uniroma3.model.Amministratore;
import it.uniroma3.model.FacadeAmministratore;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean(name="controllerAmministratore", eager=true)
public class ControllerAmministratore {

	
	@EJB
	private FacadeAmministratore facadeAmministratore;
	
	private Amministratore amministratore;
	private String password;
	private String matricola;
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	
	private GregorianCalendar dataDiNascita;
	private Integer giorno;
	private Integer mese;
	private Integer anno;
	
	public String creaAmministratore(){
		this.dataDiNascita=  new GregorianCalendar(anno,mese-1,giorno);
		this.amministratore= this.facadeAmministratore.creaAmministratore(nome, cognome, dataDiNascita, email, password, matricola);
		if(this.amministratore==null)
			return "failure";
		return "success";
	}
	
	public String autenticaAmministratore(){
		if(this.facadeAmministratore.autenticaUtente(password, matricola)){
			this.amministratore = this.facadeAmministratore.cercaAmministratore(matricola);
			return "success";
		}
		return "failure";
	}
	
	public String logout(){
		this.facadeAmministratore.logout();
		return "/index.xhtml?faces-redirect=true";
	}
	


	

	/*getter e setter */
	

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getGiorno() {
		return giorno;
	}

	public void setGiorno(Integer giorno) {
		this.giorno = giorno;
	}

	public Integer getMese() {
		return mese;
	}

	public void setMese(Integer mese) {
		this.mese = mese;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	

	
	
	
}
