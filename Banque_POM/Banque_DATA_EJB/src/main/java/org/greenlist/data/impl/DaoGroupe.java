package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoGroupe;
import org.greenlist.data.api.IDaoObjet;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;


@Remote(IDaoObjet.class)
@Singleton
public class DaoGroupe implements IDaoGroupe {

	
	private static final String REQUETTE_GET_GROUPES ="SELECT g from Groupe as g";
	@PersistenceContext(unitName = "Data_EJB")
	private EntityManager em;
	
	
	
	@Override
	public List<Produit> getProduits(Groupe groupe) throws Exception{
		
		return groupe.getProduits();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> getGroupes() throws Exception{
		Query query = em.createQuery(REQUETTE_GET_GROUPES);
		return query.getResultList();
		
	}

}
