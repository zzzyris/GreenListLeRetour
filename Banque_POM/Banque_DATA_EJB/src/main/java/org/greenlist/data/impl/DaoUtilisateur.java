package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoUtilisateur;
import org.greenlist.entity.Echange;
import org.greenlist.entity.Note;
import org.greenlist.entity.Souhait;
import org.greenlist.entity.Utilisateur;

@Remote(IDaoUtilisateur.class)
@Singleton
public class DaoUtilisateur implements IDaoUtilisateur {

	private static final String REQUETE_CONNEXION = "SELECT u FROM Utilisateur u WHERE u.pseudo = :pPseudo AND u.password = :pMdp";

	private static final String REQUETE_GET_USER_BY_ID = "SELECT u FROM Utilisateur u WHERE u.id = :pId";
	
	private static final String REQUETE_GET_USER_COMPLET_BY_ID = "SELECT u FROM Utilisateur u inner join fetch u.experience WHERE u.id = :pId";

	private static final String REQUETTE_GET_ECHANGE_BY_USERA = "SELECT e FROM Echange e WHERE e.utilisateurByIdusera.id = :pUid AND  e.dateConclusion IS NOT null " ;
	private static final String REQUETTE_GET_ECHANGE_BY_USERB = "SELECT e FROM Echange e WHERE e.utilisateurByIduserb.id = :pUid AND  e.dateConclusion IS NOT null " ;

	private static final String REQUETE_GET_AVIS_UTILISATEUR = "u.notesForIdutilisateurestnote FROM Utilisateur u where u.id = :pUId";
	
	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;

	/*
	 * R�cup�ration de l'utilisateur souhaite se connecter � partir de son
	 * pseudo et son mdp.
	 * 
	 * @param pseudo le pseudo de l'utilisateur
	 * 
	 * @param mdp le mot de passe de l'utilisateur
	 * 
	 * @return l'utilisateur connect�. Renvoie l'utilisateur si les pseudo et
	 * mdp sont les bons, remonte une exception sinon.
	 */
	@Override
	public Utilisateur seConnecter(String pseudo, String mdp) throws Exception{
		Query query = em.createQuery(REQUETE_CONNEXION);
		query.setParameter("pPseudo", pseudo);
		query.setParameter("pMdp", mdp);
		return (Utilisateur) query.getSingleResult();
	}

	/*
	 * R�cup�ration d'un utilisateur � partir de son ID.
	 * 
	 * @param idUtilisateur l'id de l'utilisateur cherch�
	 * 
	 * @return l'utilisateur cherch�. Renvoie l'utilisateur si l'ID existe, et
	 * remonte une exception sinon.
	 */
	@Override
	public Utilisateur getUtilisateurById(int idUtilisateur) throws Exception {
		Query query = em.createQuery(REQUETE_GET_USER_BY_ID);
		query.setParameter("pId", idUtilisateur);
		return (Utilisateur) query.getSingleResult();
	}


	@Override
	public Utilisateur getUtilisateurCompletById(int idUtilisateur) throws Exception {
		
		
		Query query = em.createQuery(REQUETE_GET_USER_COMPLET_BY_ID);
		query.setParameter("pId", idUtilisateur);
		return (Utilisateur) query.getSingleResult();
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> GetEchangesValideserA(Utilisateur utilisateur) {
		Query query = em.createQuery(REQUETTE_GET_ECHANGE_BY_USERA);
		System.out.println(utilisateur.getId());
		query.setParameter("pUId", utilisateur.getId());
		return query.getResultList() ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> GetEchangesValideserB(Utilisateur utilisateur) {
		Query query = em.createQuery(REQUETTE_GET_ECHANGE_BY_USERB);
		query.setParameter("pUId", utilisateur.getId());
		return query.getResultList() ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getAvisUtilisateur(Utilisateur utilisateur) {
		Query query = em.createQuery(REQUETE_GET_AVIS_UTILISATEUR);
		query.setParameter("pUId", utilisateur.getId());
		return query.getResultList(); 
	}

	

	

}
