package it.uniroma3.model;

import java.util.GregorianCalendar;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name="facadeAmministratore")
public class FacadeAmministratore {
	
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	public FacadeAmministratore(){}
	
	public Amministratore creaAmministratore(String nome, String cognome, GregorianCalendar dataDiNascita, String email, String password, String matricola){
		Amministratore amministratore = new Amministratore(nome, cognome, email, dataDiNascita, password, matricola);
		this.em.persist(amministratore);
		return amministratore;
	}
	
	public boolean autenticaUtente(String password, String matricola){
		Amministratore admin =  this.em.find(Amministratore.class, matricola);
		return admin.verificaCredenziali(matricola , password);
	}
	
	public Amministratore cercaAmministratore(String matricola){
		return this.em.find(Amministratore.class, matricola);
	}
	
	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
