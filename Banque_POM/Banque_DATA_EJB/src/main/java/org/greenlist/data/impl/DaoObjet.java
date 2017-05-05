package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoObjet;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Photo;
import org.greenlist.entity.Produit;
import org.greenlist.entity.Utilisateur;

@Remote(IDaoObjet.class)
@Singleton
public class DaoObjet implements IDaoObjet {

	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;

	private static final String REQUETTE_GET_OBJET_BY_ID = "SELECT o FROM Objet o WHERE o.id = :pidObjet";
	private static final String REQUETTE_GET_OBJET_BY_ID_WITH_PDT_TA =
			"SELECT o FROM Objet o inner join fetch o.produit inner join fetch o.trancheAge WHERE o.id = :pidObjet";

	private static final String REQUETTE_GET_OBJETS_BY_UTILISATEUR = "SELECT u.objets FROM Utilisateur as u WHERE u.id = :pIdUtilisateur";

	private static final String REQUETTE_GET_OBJETS_BY_LIBELLE = "SELECT o FROM Objet as o WHERE o.libelle LIKE :pmotClef";

	private static final String REQUETE_GET_PHOTOS ="SELECT o.photos FROM Objet o WHERE o.id = :pIdObjet" ;
	

	
	  private static final String REQUETTE_GET_OBJETS_BY_DOMAINE =
	  " SELECT o FROM Objet  as o" +" JOIN o.produit as produit"
	  +" join produit.groupe as groupe" +"joint groupe.domaine as domaine"
	  +" WHERE domaine = :pDomaine";
	  
	  private static final String REQUETTE_GET_OBJETS_BY_GROUPE =
	  " SELECT o FROM Objet as  o" +" JOIN o.produit as produit "
	  +"join produit.groupe as groupe" +" WHERE groupe = :pGroupe";
	  
	  private static final String REQUETTE_GET_OBJETS_BY_PRODUIT =
	  "SELECT o from Objet o wehere o.produit + :pProduit" ;
	 
	/**
	 * Methode pour r�cup�rer un objet par son id
	 * 
	 * @param idObjet
	 *            id de l'objet recherch�
	 */
	@Override
	public Objet getObjetById(int idObjet) {
		Query query = em.createQuery(REQUETTE_GET_OBJET_BY_ID).setParameter("pidObjet", idObjet);
		return (Objet) query.getSingleResult();
	}
	/**
	 * Methode pour r�cup�rer un objet par son id
	 * 
	 * @param idObjet
	 *            id de l'objet recherch�
	 */
	@Override
	public Objet getObjetByIdWithProduitAndTA(int idObjet) {
		Query query = em.createQuery(REQUETTE_GET_OBJET_BY_ID_WITH_PDT_TA).setParameter("pidObjet", idObjet);
		return (Objet) query.getSingleResult();
	}
	/**
	 * Methode pour ajouter un objet
	 * 
	 * @param objet
	 *            Objet � cr�er
	 */
	@Override
	public Objet createObjet(Objet objet) {
		em.persist(objet);
		return objet;
	}

	/**
	 * Methode pour r�cup�rer l'ensemble des objets d'un utilisateur
	 * 
	 * @param utilisateur
	 *            le propri�taire des objets recherch�s
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Objet> getObjetsByUtilisateur(Utilisateur utilisateur) {
		String hql = "SELECT o FROM Objet o WHERE o.utilisateur.id = :pid";
		return em.createQuery(hql).setParameter("pid", utilisateur.getId()).getResultList();
	}

	/**
	 * Methode pour rechercher les objets aillant un libell� ressemblant � une
	 * chaine de caractere
	 * 
	 * @param motClef
	 *            Chaine que l'on cherche
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Objet> getObjetsByLibelle(String motClef) {

		StringBuilder sb = new StringBuilder();
		motClef = sb.append("%").append(motClef).append("%").toString();

		Query query = em.createQuery(REQUETTE_GET_OBJETS_BY_LIBELLE).setParameter("pmotClef", motClef);
		return query.getResultList();

	}

	/**
	 * Recherche des objets appartenant � un domaine
	 * 
	 * @param domaine
	 *            le domaine que l'on recherche
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Objet> getObjetsByDomaine(Domaine domaine) {
		Query query = em.createQuery(REQUETTE_GET_OBJETS_BY_DOMAINE).setParameter("pDomaine", domaine);
		return query.getResultList();
	}

	/**
	 * Recherche des objets appartenant � un groupe
	 * 
	 * @param domaine
	 *            le groupe que l'on recherche
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Objet> getObjetsByGroupe(Groupe groupe) {
		Query query = em.createQuery(REQUETTE_GET_OBJETS_BY_GROUPE).setParameter("pGroupe", groupe);
		return query.getResultList();
	}

	/**
	 * Recherche des objets appartenant � un produit
	 * 
	 * @param domaine
	 *            le produit que l'on recherche
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Objet> getObjetsByProduit(Produit produit) {
		Query query = em.createQuery(REQUETTE_GET_OBJETS_BY_PRODUIT).setParameter("pProduit", produit);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> getPhotos(Objet objet) {
		Query query = em.createQuery(REQUETE_GET_PHOTOS).setParameter("pIdObjet", objet.getId());
		return query.getResultList();
	}

}
