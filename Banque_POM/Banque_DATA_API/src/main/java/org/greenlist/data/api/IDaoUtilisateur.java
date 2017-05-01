package org.greenlist.data.api;

import org.greenlist.entity.Utilisateur;

public interface IDaoUtilisateur {

	public Utilisateur seConnecter(String pseudo, String mdp) throws Exception;
	
	public Utilisateur getUtilisateurById(int idUtilisateur) throws Exception;
}
