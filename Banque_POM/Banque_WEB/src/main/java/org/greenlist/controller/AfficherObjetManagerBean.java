package org.greenlist.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Photo;
import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbFicheObjet")
@ViewScoped
public class AfficherObjetManagerBean {
	
	
	
	@EJB
	private IBusinessObjet proxyObjet;
	
	@EJB
	private IBusinessUtilisateur proxyUtilisateur;
	
	
	private Objet objetAffiche = new Objet();
	private List<Photo> photos ;
	private Utilisateur proprietaire = new Utilisateur();
	
	
	public void init(){
		objetAffiche.setId(6);
		objetAffiche = proxyObjet.getObjetComplet(objetAffiche);
		
		photos = proxyObjet.getPhotos(objetAffiche);
		
		 proprietaire = objetAffiche.getUtilisateur();
		 proprietaire = proxyUtilisateur.getUtilisateurById(proprietaire.getId());
	}

	public Objet getObjetAffiche() {
		return objetAffiche;
	}

	public void setObjetAffiche(Objet objetAffiche) {
		this.objetAffiche = objetAffiche;
	}

	public IBusinessObjet getProxyObjet() {
		return proxyObjet;
	}

	public void setProxyObjet(IBusinessObjet proxyObjet) {
		this.proxyObjet = proxyObjet;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	

}
