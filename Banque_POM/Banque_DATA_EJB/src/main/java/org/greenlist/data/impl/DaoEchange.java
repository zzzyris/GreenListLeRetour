package org.greenlist.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoEchange;
import org.greenlist.entity.Conclusionechange;
import org.greenlist.entity.Echange;
import org.greenlist.entity.Message;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Rdv;
import org.greenlist.entity.Utilisateur;

public class DaoEchange implements IDaoEchange {

	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;
	
	
	private static final String REQUETE_GET_ECHANGE = " SELECT e FROM Echange e "
															+ "WHERE e.id = :pEid" ;
	private static final String REQUETE_GET_OBJETS = "SELECT e.objets fROM Echange e "
															+ "WHERE e.id = :pEId" ;
	private static final String REQUETE_GET_MESSAGES = "SELECT e.messages FROM Echange e"
															+ " WHERE e.id = :pEId" ;
	private static final String REQUETE_GET_RDVS ="SELECT e.rdvs FROM Echange e "
															+ "WHERE e.id = :pEId";
	
	@Override
	public Echange creerEchange(Echange echange) {
		em.persist(echange);
		return echange;
	}

	@Override
	public Echange GetEchange(int IdEchange) {
		Query query = em.createQuery(REQUETE_GET_ECHANGE).
				setParameter("pEid", IdEchange);
				
		return (Echange) query.getSingleResult();
	}

	@Override
	public Echange majEchange(Echange echange) {
	em.merge(echange);
		return echange;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Objet> getObjets(Echange echange) {
		Query query = em.createQuery(REQUETE_GET_OBJETS).
				setParameter("pEid", echange.getId());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessages(Echange echange) {
		Query query = em.createQuery(REQUETE_GET_MESSAGES).
				setParameter("pEid", echange.getId());
		
		return query.getResultList();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Rdv> getRdv(Echange echange) {
		Query query = em.createQuery(REQUETE_GET_RDVS).
				setParameter("pEid", echange.getId());
		return query.getResultList();
	}

	

	

}


