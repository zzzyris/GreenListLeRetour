package org.greenlist.business.api;

import org.greenlist.entity.Objet;
import org.greenlist.entity.Photo;

public interface IBusinessPhoto {
	
	Photo ajouterPhoto(Objet objet, String urlPhoto);
}
