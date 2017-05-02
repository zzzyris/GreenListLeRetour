package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoDomaine;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;



@Remote(IDaoDomaine.class)
@Singleton
public class DaoDomaine implements IDaoDomaine{

	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;
	
	private static final String REQUETTE_GET_DOMAINES = "SELECT d FROM Domaine as d ";
	
	private static final String REQUETTE_GET_DOMAINE_BY_ID = "SELECT d FROM Domaine d WHERE d.id = :pIdDomaine";
	
	
	@Override
	public List<Groupe> getGroupes(Domaine domaine) throws Exception{
		
		return domaine.getGroupes();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domaine> getDomaines() throws Exception{
		Query query = em.createQuery(REQUETTE_GET_DOMAINES);
		return query.getResultList();
	}

	@Override
	public Domaine getDomaine(int idDomaine) throws Exception {
		Query query = em.createQuery(REQUETTE_GET_DOMAINE_BY_ID);
		query.setParameter("pIdDomaine", idDomaine);
		return (Domaine) query.getSingleResult();
	}

}
