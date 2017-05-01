package org.greenlist.business.api;

import org.greenlist.entity.Utilisateur;

public interface IBusinessUtilisateur {
	/*
	 * Récupération de l'utilisateur souhaite se connecter à partir de son
	 * pseudo et son mdp.
	 * 
	 * @param pseudo le pseudo de l'utilisateur
	 * 
	 * @param mdp le mot de passe de l'utilisateur
	 * 
	 * @return l'utilisateur connecté. Renvoie l'utilisateur si les pseudo et
	 * mdp sont les bons, renvoie null sinon.
	 */
	public Utilisateur seConnecter(String pseudo, String mdp);

	/*
	 * Récupération d'un utilisateur à partir de son ID.
	 * 
	 * @param idUtilisateur l'id de l'utilisateur cherché
	 * 
	 * @return l'utilisateur cherché. Renvoie l'utilisateur si l'ID existe, et
	 * null sinon.
	 */
	public Utilisateur getUtilisateurById(int idUtilisateur);

}
