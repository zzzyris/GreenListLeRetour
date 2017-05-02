package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Adresse;
import org.greenlist.entity.Utilisateur;

public interface IBusinessAdresse {
	List<Adresse> getAdresseByUtilisateur(Utilisateur utilisateur);
}
