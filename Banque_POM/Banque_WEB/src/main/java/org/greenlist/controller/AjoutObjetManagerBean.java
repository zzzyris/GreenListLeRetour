package org.greenlist.controller;

import java.util.Calendar;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
//import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.greenlist.business.api.IBusinessObjet;
//import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;
//import org.greenlist.entity.Utilisateur;
import org.greenlist.entity.TrancheAge;

@ManagedBean(name = "mbObjetAjout")
@ViewScoped
public class AjoutObjetManagerBean {

	@EJB
	private IBusinessObjet proxyObjet;
	
	private Objet objet = new Objet();
	
	@ManagedProperty(value = "#{mbUtilisateur}")
	private UtilisateurManagedBean mbConnect;
	
	
	@PostConstruct
	public void init() {
		objet.setTrancheAge(new TrancheAge());
		objet.setProduit(new Produit());
		
	}
	
	
	
	
	
	public Objet creerObjet (){
		

		
		objet.setUtilisateur(mbConnect.getUtilisateurConnecte());

		objet.setDateDepot(Calendar.getInstance().getTime());
		
		return proxyObjet.creerObjet(objet);
		
	
		
	}
	
	
	public UtilisateurManagedBean getMbConnect() {
		return mbConnect;
	}





	public void setMbConnect(UtilisateurManagedBean mbConnect) {
		this.mbConnect = mbConnect;
	}





	public IBusinessObjet getProxyObjet() {
		return proxyObjet;
	}
	public void setProxyObjet(IBusinessObjet proxyObjet) {
		this.proxyObjet = proxyObjet;
	}
	public Objet getObjet() {
		return objet;
	}
	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	
	
	
	
	
	
}
