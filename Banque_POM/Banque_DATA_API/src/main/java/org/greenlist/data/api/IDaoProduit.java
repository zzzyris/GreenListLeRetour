package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IDaoProduit {
	/**
	 * permet de recupérer le groupe d'un produit
	 * 
	 * @param produit
	 *            le produit dont on veut le groupe
	 * @return
	 */
	Groupe getGroupe(Produit produit) throws Exception;

	/**
	 * Permet de recuperer l integralit� des Produits de la base
	 * 
	 * @return
	 */
	List<Produit> getProduits() throws Exception;

	List<Produit> getProduits(Groupe groupe) throws Exception;

	/**
	 * Permet de récupérer tous les produits dont le libellé contient nom
	 * 
	 * @param nom
	 *            le nom de produit cherché
	 * @return les produits contenant nom dans leur libellé.
	 */
	List<Produit> getProduits(String nom);
}
