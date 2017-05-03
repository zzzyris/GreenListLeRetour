package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IDaoGroupe {

	 
	 /**
	  * permet de recuperer l'integralis� des groupes du SI
	 * @param domaine le domaine dont on veut les groupes
	  * @return la liste des groupes du domaine demandé
	  */
	 List<Groupe> getGroupes(Domaine domaine) throws Exception;
}
