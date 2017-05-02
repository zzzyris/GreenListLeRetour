package org.greenlist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.greenlist.business.api.IBusinessGroupe;
import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.business.api.IBusinessProduit;
import org.greenlist.business.api.IBusinessTrancheAge;
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
	
	
	private List<TrancheAge> tranchesAges ;
	private List<Produit> produits;
	private List<Groupe> groupes ;
	
	

	public List<Groupe> getgroupes() {
		if (groupes == null ){
			groupes = new ArrayList<>();
			groupes =proxyGroupe.getGroupes();
			
		}
		
		return groupes;
	}
	
	
	public List<Produit> getproduits() {
		if (produits == null ){
			produits = new ArrayList<>();
			produits = proxyProduit.getProduits();
			
		}
		
		return produits;
	}
	

	public void setProduits(List<Produit> produits) {
		produits = produits;
	}

	public List<TrancheAge> getTranchesAges() {
		if (tranchesAges == null ){
			tranchesAges = new ArrayList<>();
			tranchesAges = proxyTrancheAge.getTranchesAges();
			
		}
		
		return tranchesAges;
	}

	public void setTranchesAges(List<TrancheAge> tranchesAges) {
		this.tranchesAges = tranchesAges;
	}
	
	
}
