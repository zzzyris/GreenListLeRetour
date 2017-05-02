package org.greenlist.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoListe;
import org.greenlist.entity.Liste;
import org.greenlist.entity.Utilisateur;

@Remote(IDaoListe.class)
@Singleton
public class DaoListe implements IDaoListe {
	
	
	private static final String  REQUETE_GET_LISTE_BY_UTILISATEUR = "SELECT u.listes FROM Utilisateur as u"
			+ "WHERE u.id = :pIdUtilisateur";
	
	@PersistenceContext(unitName = "Data_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Liste> getListeByUtilisateur(Utilisateur utilisateur) throws Exception {
		
		Query query = em.createQuery(REQUETE_GET_LISTE_BY_UTILISATEUR).setParameter("pIdUtilisateur", utilisateur.getId());
		return query.getResultList();
	}

}
