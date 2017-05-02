package org.greenlist.business.api;

import org.greenlist.entity.Photo;

public interface IBusinessPhoto {
	
	Photo ajouterPhoto(int idObjet, String urlPhoto);
}
