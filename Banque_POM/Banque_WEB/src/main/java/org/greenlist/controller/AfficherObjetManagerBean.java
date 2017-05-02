package org.greenlist.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.entity.Objet;

@ManagedBean(name = "mbAfficheObjet")
@ViewScoped
public class AfficherObjetManagerBean {
	
	private Objet objetAffiche;
	
	@EJB
	private IBusinessObjet proxyObjet;
	
	
	public Objet recupererObjet ( Objet objet ){
		
		objetAffiche = proxyObjet.getObjet(objet);
		
		return objetAffiche;
	}
	
	

}
