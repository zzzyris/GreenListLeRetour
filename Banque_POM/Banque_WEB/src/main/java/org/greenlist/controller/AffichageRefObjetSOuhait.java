package org.greenlist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.greenlist.business.api.IBusinessDomaine;
import org.greenlist.business.api.IBusinessGroupe;
import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.business.api.IBusinessProduit;
import org.greenlist.business.api.IBusinessTrancheAge;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;
import org.greenlist.entity.TrancheAge;

@ManagedBean(name = "mbAfficheRefObjetSOuhait")
@ViewScoped
public class AffichageRefObjetSOuhait {

	@EJB
	private IBusinessTrancheAge proxyTrancheAge;
	@EJB
	private IBusinessProduit proxyProduit;
	@EJB
	private IBusinessGroupe proxyGroupe;
	@EJB
	private IBusinessDomaine proxyDomaine;
	
	
	private List<TrancheAge> tranchesAges = null;
	private List<Produit> produits = null ;
	private List<Groupe> groupes = null  ;
	private Domaine domaine = null;
	
//
//	public List<Groupe> getgroupes(Domaine domaine) {
//		if (groupes == null ){
//			groupes = new ArrayList<>();
//			
//		}
//		groupes =proxyGroupe.getGroupes(domaine);
//		return groupes;
//	}
	
	
	public List<Produit> getproduits(Groupe groupe) {
		if (produits == null ){
			produits = new ArrayList<>();
			
		}
		produits = proxyProduit.getProduits(groupe);
		return produits;
	}
	

	public void setProduits(List<Produit> produits) {
		produits = produits;
	}

	public List<TrancheAge> getTranchesAges() {
	
		if (tranchesAges == null ){
			tranchesAges = new ArrayList<>();
			
		
		}
		tranchesAges = proxyTrancheAge.getTranchesAges();
		return tranchesAges;
	}

	public void setTranchesAges(List<TrancheAge> tranchesAges) {
		this.tranchesAges = tranchesAges;
	}
	
	public List<Groupe> getGroupes(int idDomaine){
		return proxyDomaine.getGroupes(proxyDomaine.getDomaine(idDomaine));
	}


	public List<Groupe> getGroupes() {
		return groupes;
	}


	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}


	public Domaine getDomaine() {
		return domaine;
	}


	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}


	public List<Produit> getProduits() {
		return produits;
	}
	
	
}
