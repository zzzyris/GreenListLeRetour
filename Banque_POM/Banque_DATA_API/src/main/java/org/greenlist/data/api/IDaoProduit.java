package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IDaoProduit {
/**
 * permet de recueprer le groupe d'un produit 
 * @param produit le produit dont on veut le groupe 
 * @return
 */
	Groupe getGroupe(Produit produit)throws Exception;
	/**
	 * Permet de recuperer l integralité des Produits de la base 
	 * @return
	 */
	List<Produit> getProduits()throws Exception;
}
