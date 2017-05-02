package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoAdresse;
import org.greenlist.data.api.IDaoObjet;
import org.greenlist.entity.Adresse;
import org.greenlist.entity.Utilisateur;

@Remote(IDaoAdresse.class)
@Singleton
public class DaoAdresse implements IDaoAdresse {

	@PersistenceContext(unitName = "Data_EJB")
	private EntityManager em;
	
	private static final String REQUETTE_GET_ADRESSES_BY_UTILISATEUR = "SELECT u.adresses FROM Utilisateur as u "
			+ "WHERE u.id = :pIdUtilisateur";

	@SuppressWarnings("unchecked")
	@Override
	public List<Adresse> getAdresseByUtilisateur(Utilisateur utilisateur) throws Exception{
		Query query = em.createQuery(REQUETTE_GET_ADRESSES_BY_UTILISATEUR).setParameter("pidUtilisateur",
				utilisateur.getId());
		return query.getResultList();
	}

}
