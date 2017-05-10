package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoProduit;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;


@Remote(IDaoProduit.class)
@Singleton
public class DaoProduit implements IDaoProduit{
	
	
	private static final String REQUETTE_GET_PRODUITS = "SELECT p FROM Produit as p ";
	
	private static final String REQUETE_GET_PRODUIT_PAR_NOM = 
			"SELECT p FROM Produit p "
			+ "INNER JOIN fetch p.groupe g "
			+ "INNER JOIN fetch g.domaine d "
			+ "WHERE p.libelle LIKE :pnom";
	
	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;

	@Override
	public Groupe getGroupe(Produit produit) throws Exception{
	
		return produit.getGroupe();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getProduits() throws Exception{
		Query query = em.createQuery(REQUETTE_GET_PRODUITS);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getProduits(Groupe groupe) throws Exception {
		String hql = "SELECT p FROM Produit p WHERE p.groupe.id = :pid";
		return em.createQuery(hql).setParameter("pid", groupe.getId()).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getProduits(String nom) {
	String param = "%" + nom + "%";
	return em.createQuery(REQUETE_GET_PRODUIT_PAR_NOM).setParameter("pnom", param).getResultList();
	}

}
