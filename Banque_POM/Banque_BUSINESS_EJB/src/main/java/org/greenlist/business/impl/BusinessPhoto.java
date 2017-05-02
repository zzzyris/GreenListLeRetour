package org.greenlist.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessPhoto;
import org.greenlist.data.api.IDaoPhoto;
import org.greenlist.entity.Photo;

@Remote(IBusinessPhoto.class)
@Stateless
public class BusinessPhoto implements IBusinessPhoto {

	@EJB
	private IDaoPhoto proxyPhoto;

	@Override
	public Photo ajouterPhoto(int idObjet, String urlPhoto) {
		Photo photo = null;
		try {
			photo = proxyPhoto.ajouterPhoto(idObjet, urlPhoto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photo;
	}

}
