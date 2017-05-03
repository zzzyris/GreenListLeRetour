package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;

public interface IDaoDomaine {

	
	 /**
	  * permet d'avoir les Domaines de la base
	  * @return la liste de tous les domaines du SI
	  */
	 List<Domaine> getDomaines() throws Exception;
	 
	 /**
	  * permet de récupérer un domaine depuis son id
	  * @param idDomaine
	  * @return le domaine associé à l'id donné
	  * @throws Exception
	  */
	 Domaine getDomaine(int idDomaine) throws Exception;
}
