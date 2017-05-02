package org.greenlist.data.api;
import java.util.List;

import org.greenlist.entity.Liste;
import org.greenlist.entity.Utilisateur;

public interface IDaoListe {
	
	List<Liste> getListeByUtilisateur(Utilisateur utilisateur) throws Exception;
}
