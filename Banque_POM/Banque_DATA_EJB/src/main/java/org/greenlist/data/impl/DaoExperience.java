package org.greenlist.data.impl;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoExperience;
import org.greenlist.data.api.IDaoObjet;
import org.greenlist.entity.Experience;
import org.greenlist.entity.Utilisateur;

@Remote(IDaoExperience.class)
@Singleton
public class DaoExperience implements IDaoExperience {

	
	@PersistenceContext(unitName = "Data_EJB")
	private EntityManager em;
	
	private static final String GET_EXPERIENCE_BY_UTILISATEUR ="SELECT u.experience FROM Utilisateur as u "
			+ "WHERE u.id = :pIdUtilisateur";
	
	@Override
	public Experience getExperienceByUtilisateur(Utilisateur utilisateur) throws Exception{
	Query query = em.createQuery(GET_EXPERIENCE_BY_UTILISATEUR).setParameter("pIdUtilisateur", utilisateur.getId());
		return (Experience) query.getSingleResult();
	}

}
