package org.greenlist.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbFicheUtilisateur")
@ViewScoped
public class FicheUtilisateurManagerBean {
	@EJB
	private IBusinessUtilisateur proxyUtilisateur ;
	
	private Utilisateur utilisateurAffiche = new Utilisateur();
	private int moyenne =0;
	private int nbAVis =0 ;
	private int nbObjets =0;
	private int nbSouhaits =0;
	private int nbEchanges = 0 ;
	
	
	@PostConstruct
	public void init(){
		utilisateurAffiche.setId(2);
	
			utilisateurAffiche = proxyUtilisateur.getUtilisateurCompletById(utilisateurAffiche);
		
		nbEchanges = proxyUtilisateur.recupererNbEchangesValide(utilisateurAffiche);	
		nbSouhaits = proxyUtilisateur.recupererNbSouhaits(utilisateurAffiche);
		nbObjets = proxyUtilisateur.recupererNbObjets(utilisateurAffiche);
		moyenne = proxyUtilisateur.recupererMoyenne(utilisateurAffiche);
		nbAVis = proxyUtilisateur.recupererNbAvis(utilisateurAffiche);
		
	}
}
