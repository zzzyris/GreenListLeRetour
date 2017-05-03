package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoGroupe;
import org.greenlist.data.api.IDaoObjet;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;


@Remote(IDaoGroupe.class)
@Singleton
public class DaoGroupe implements IDaoGroupe {

	
//	private static final String REQUETTE_GET_GROUPES ="SELECT g from Groupe as g";
	
	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;
	
	
	
	

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Groupe> getGroupes() throws Exception{
//		Query query = em.createQuery(REQUETTE_GET_GROUPES);
//		return query.getResultList();
//		
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> getGroupes(Domaine domaine) throws Exception {
		String hql = "SELECT g FROM Groupe g WHERE g.domaine.id = :pid";
		return em.createQuery(hql).setParameter("pid", domaine.getId()).getResultList();
		
	}

}
