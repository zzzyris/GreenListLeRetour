package org.greenlist.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;

import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbUtilisateur")
@SessionScoped
public class UtilisateurManagedBean {

	@EJB
	private IBusinessUtilisateur proxyUtilisateur;
	
	private String pseudo ;
	private String mdp ; 
	private Utilisateur utilisateurConnecte = null;
	private String originalURL ;
	


	/**
	 * Recuperation de l'URL de la page demand�e avant la connection . 
	 * Si pas de demande, redirection vers index.
	 */
	@PostConstruct
	public void init(){
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		originalURL = (String) context.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
		
		if (originalURL == null ){
			originalURL = context.getRequestContextPath() + "/index.xhtml" ;
		}else {
			String originalQuery = (String) context.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);
			if ( originalQuery != null){
				originalURL += "?" + originalQuery ;
			}
		}
		
	}
	
	
	public void seConnecter() {
		
	FacesContext context = FacesContext.getCurrentInstance() ;
	ExternalContext externalContext = context.getExternalContext();
	
	utilisateurConnecte = proxyUtilisateur.seConnecter(pseudo, mdp);
	
		if (utilisateurConnecte != null){
			try {
				externalContext.redirect(originalURL);
			} catch (IOException e) {
				// Catch misère
				e.printStackTrace();
			}
		}else {
			//osef
		}
		
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	public String getMdp() {
		return mdp;
	}
	
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
