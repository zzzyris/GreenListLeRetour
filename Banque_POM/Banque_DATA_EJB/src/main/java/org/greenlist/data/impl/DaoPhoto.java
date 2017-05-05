package org.greenlist.data.impl;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.greenlist.data.api.IDaoPhoto;
import org.greenlist.entity.Objet;
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
	public Photo ajouterPhoto(Objet objet, String urlPhoto){
		Photo photo = new Photo();
		photo.setObjet(objet);
		photo.setUrl(urlPhoto);
		
		em.persist(photo);
		
		return photo;
	}
}
