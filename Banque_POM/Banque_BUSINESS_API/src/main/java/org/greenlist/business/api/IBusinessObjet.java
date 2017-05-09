package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Objet;
import org.greenlist.entity.Photo;
import org.greenlist.entity.Utilisateur;

public interface IBusinessObjet {

	/**
	 *  Methode qui permet d'enregistrer un OBjet dans le SI
	 * @param objet a enregistrer
	 * @return l'Objet actualis� ( id, date de depot)
	 */
	public Objet creerObjet(Objet objet );
	
	
	/**
	 * 
	 * @param utilisateur
	 * @return la liste d'objet de l'utilisateur 
	 */
	public List<Objet> getObjets(Utilisateur utilisateur);
	
	/**
	 * 
	 * @param objet que l'on rechercher
	 * @return l'Objet Complet 
	 */
	public Objet getObjet(Objet objet);
	
	
	public List<Photo> getPhotos(Objet objet);


	Objet getObjetComplet(Objet objet);
}
