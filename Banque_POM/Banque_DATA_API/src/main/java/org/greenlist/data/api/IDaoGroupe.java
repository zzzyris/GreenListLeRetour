package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IDaoGroupe {
/**
 *  permet d'avoir l integralité des produits présent dans un groupe donné
 * @param groupe le groupe dont on veut les produits
 * @return la liste des produits du groupe demandé 
 */
	 List<Produit> getProduits(Groupe groupe)throws Exception;
	 
	 /**
	  * permet de recuperer l'integralisé des groupes du SI
	  * @return la liste des groupes dans le SI
	  */
	 List<Groupe> getGroupes() throws Exception;
}
