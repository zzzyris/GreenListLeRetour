package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Objet;
import org.greenlist.entity.Utilisateur;

public interface IBusinessUtilisateur {
	/*
	 * R�cup�ration de l'utilisateur souhaite se connecter � partir de son
	 * pseudo et son mdp.
	 * 
	 * @param pseudo le pseudo de l'utilisateur
	 * 
	 * @param mdp le mot de passe de l'utilisateur
	 * 
	 * @return l'utilisateur connect�. Renvoie l'utilisateur si les pseudo et
	 * mdp sont les bons, renvoie null sinon.
	 */
	public Utilisateur seConnecter(String pseudo, String mdp);

	/*
	 * R�cup�ration d'un utilisateur � partir de son ID.
	 * 
	 * @param idUtilisateur l'id de l'utilisateur cherch�
	 * 
	 * @return l'utilisateur cherch�. Renvoie l'utilisateur si l'ID existe, et
	 * null sinon.
	 */
	public Utilisateur getUtilisateurById(int idUtilisateur);
	
	public Utilisateur getUtilisateurCompletById(Utilisateur utilisateur);
	
	/**
	 * permet de recuperer le nombre d'echanges valdié par un utilisateur 
	 * @param utilisateur
	 * @return le nombre d'échanges validés par l'utilisateur 
	 */
	public int recupererNbEchangesValide(Utilisateur utilisateur);
	
	/**
	 * Permet de recuperer le nombre d'avis recu par un utilisateur
	 * @param utilisateur
	 * @return le nombre d'avis 
	 */
	public int recupererNbAvis(Utilisateur utilisateur);
	
	/**
	 * Permet de recuperer la moyenne des notes recus par l'utilisateur 
	 * @param utilisateur
	 * @return la note moyenne de l'utilisateur 
	 */
	public int recupererMoyenne( Utilisateur utilisateur);
	
	public int recupererNbSouhaits(Utilisateur utilisateur);
	
	public int recupererNbObjets(Utilisateur utilisateur);

	public List<Objet> recupererObjetsUtilisateur(Utilisateur utilisateur) ;
	
}
