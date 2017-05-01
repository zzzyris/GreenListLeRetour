package org.greenlist.data.impl;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoPhoto;
import org.greenlist.entity.Photo;

@Remote(IDaoPhoto.class)
@Singleton
public class DaoPhoto implements IDaoPhoto{
	
	@PersistenceContext(unitName = "Banque_DATA_EJB")
	private EntityManager em;
	
	private static final String CREATE_OBJET = "INSERT INTO Photo f (f.IDOBJET, f.url) VALUES (:pidObjet, :pUrl)";
	
	/**
	 * M�thode pour ajouter une photo � un Objet
	 * @param idObjet id de l'objet auquel la photo sera associ�
	 * @param urlPhoto url de la photo � ajouter
	 */
	public Photo ajouterPhoto(int idObjet, String urlPhoto){
		Query query = em.createQuery(CREATE_OBJET).setParameter("pidObjet", idObjet)
												.setParameter("pUrl", urlPhoto);
		return (Photo) query.getSingleResult();
	}
}
