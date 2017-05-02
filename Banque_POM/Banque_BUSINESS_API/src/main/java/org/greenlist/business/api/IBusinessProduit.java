package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IBusinessProduit {

	Groupe getGroupe(Produit produit);
	
	List<Produit> getProduits();
	
}
