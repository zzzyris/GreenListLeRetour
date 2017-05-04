package org.greenlist.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbUserProfil")
@SessionScoped
public class UtilisateurProfilManagedBean {

	@EJB
	private IBusinessUtilisateur proxyUtilisateur;
	
	private Utilisateur utilisateur = null;
	private String pseudoUtilisateur;
	
	@PostConstruct
	public void init(){
	}

	public void getUtilisateur() {
	
	utilisateur = proxyUtilisateur.getUtilisateurById(utilisateur.getId());
	pseudoUtilisateur = utilisateur.getPseudo();		
	}

	public IBusinessUtilisateur getProxyUtilisateur() {
		return proxyUtilisateur;
	}

	public void setProxyUtilisateur(IBusinessUtilisateur proxyUtilisateur) {
		this.proxyUtilisateur = proxyUtilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getPseudoUtilisateur() {
		return pseudoUtilisateur;
	}

	public void setPseudoUtilisateur(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	}
	
	
	
	
}
