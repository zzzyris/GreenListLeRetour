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

	private static final String GET_TOUT_MESSAGES_BY_OBJET = "SELECT m FROM Messagepublic m WHERE m.objet.id = :pObjet";
	

	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;

	/**
	 * renvoi la liste de tous les messages liées à un objet
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Messagepublic> getMessagesByObjet(Objet objet) throws Exception {
		Query query = em.createQuery(GET_TOUT_MESSAGES_BY_OBJET).setParameter("pObjet", objet.getId());
		return query.getResultList();
	}
}
