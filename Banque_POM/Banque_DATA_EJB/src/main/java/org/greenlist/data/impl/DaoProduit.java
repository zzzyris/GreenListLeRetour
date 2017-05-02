package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoObjet;
import org.greenlist.data.api.IDaoProduit;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;


@Remote(IDaoProduit.class)
@Singleton
public class DaoProduit implements IDaoProduit{
	
	
	private static final String REQUETTE_GET_PRODUITS = "SELECT p FROM Produit as p ";
	
	@PersistenceContext(unitName = "Data_EJB")
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

}
