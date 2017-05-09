package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IBusinessProduit {

	Groupe getGroupe(Produit produit);
	
	List<Produit> getProduits(Groupe groupe);

	List<Produit> getProduits();

	/**
	 * Récupération de tous les produits dont le libellé contient nom
	 * 
	 * @param nom
	 *            le nom recherché dans les produits
	 * @return les produits
	 */
	List<Produit> getProduits(String nom);

}
