package org.greenlist.controller;

import java.util.Calendar;
//import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.print.attribute.standard.DateTimeAtCompleted;

import org.greenlist.business.api.IBusinessObjet;
//import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Objet;
//import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbObjetAjout")
@ViewScoped
public class AjoutObjetManagerBean {

	@EJB
	private IBusinessObjet proxyObjet;
	
	private Objet objet ;

	
	
	
	
	
	
	public Objet creerObjet (){
		
		
		

		objet.setDateDepot(Calendar.getInstance().getTime());
		
		return proxyObjet.creerObjet(objet);
		
	
		
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
