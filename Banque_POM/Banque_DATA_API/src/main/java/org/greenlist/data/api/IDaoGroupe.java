package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IDaoGroupe {
/**
 *  permet d'avoir l integralit� des produits pr�sent dans un groupe donn�
 * @param groupe le groupe dont on veut les produits
 * @return la liste des produits du groupe demand� 
 */
	 List<Produit> getProduits(Groupe groupe)throws Exception;
	 
	 /**
	  * permet de recuperer l'integralis� des groupes du SI
	 * @param domaine le domaine dont on veut les groupes
	  * @return la liste des groupes du domaine demandé
	  */
	 List<Groupe> getGroupes(Domaine domaine) throws Exception;
}
