package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Liste;
import org.greenlist.entity.Utilisateur;

public interface IBusinessListe {
	List<Liste> getListeByUtilisateur(Utilisateur utilisateur);
}
