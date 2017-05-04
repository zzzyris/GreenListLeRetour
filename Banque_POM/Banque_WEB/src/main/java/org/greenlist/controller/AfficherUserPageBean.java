package org.greenlist.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbAfficherUserProfil")
@SessionScoped
public class AfficherUserPageBean {

	@EJB
	private IBusinessUtilisateur proxyUtilisateur;
	
	private Utilisateur utilisateur;
	
	public void afficherPage(){
		
	}

	public IBusinessUtilisateur getProxyUtilisateur() {
		return proxyUtilisateur;
	}

	public void setProxyUtilisateur(IBusinessUtilisateur proxyUtilisateur) {
		this.proxyUtilisateur = proxyUtilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
