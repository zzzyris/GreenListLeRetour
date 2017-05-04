package org.greenlist.data.impl;


import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.greenlist.data.api.IDaoMessagePublic;
import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;

@Remote(IDaoMessagePublic.class)
@Singleton
public class DaoMessagePublic implements IDaoMessagePublic {

	//private static final String GET_QUESTIONS ="SELECT m.messagepublics FROM Messagepublic m WHERE m.messagepublic is NULL AND m.objet.id = :pObjet";
	private static final String GET_REPONSES = "SELECT m.messagepublics FROM Messagepublic m "
			+ "WHERE m.id = :pIdChild AND m.messagepublic is not NULL";
	private static final String GET_TOUT_MESSAGES_BY_OBJET ="SELECT m FROM Messagepublic m WHERE m.objet.id = :pObjet";
	

	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;

	/**
	 * renvoi la liste des questions liées à un objet
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Messagepublic> getMessageByObjet(Objet objet) throws Exception {
		Query query = em.createQuery(GET_TOUT_MESSAGES_BY_OBJET).setParameter("pObjet", 21);
		return query.getResultList();
	}

	/**
	 * renvoi la liste de reponses liées à une question
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Messagepublic> getReponses(Messagepublic reponse) throws Exception {
		Query query = em.createQuery(GET_REPONSES).setParameter("pIdChild", reponse.getMessagepublics());
		return query.getResultList();
	}

}
