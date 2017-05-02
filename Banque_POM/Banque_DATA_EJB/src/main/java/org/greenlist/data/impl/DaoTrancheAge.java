package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoTrancheAge;
import org.greenlist.entity.TrancheAge;


@Remote(IDaoTrancheAge.class)
@Singleton
public class DaoTrancheAge implements IDaoTrancheAge {

	
	@PersistenceContext(unitName = "Data_EJB")
	private EntityManager em;
	
	private static final String REQUETTE_GET_TRANCHES_AGE = "SELECT ta FROM TrancheAge as ta ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TrancheAge> getTranchesAges() throws Exception{
		Query query = em.createQuery(REQUETTE_GET_TRANCHES_AGE);
		return query.getResultList();
	}

}
