package org.greenlist.data.api;

import org.greenlist.entity.Objet;
import org.greenlist.entity.Photo;

public interface IDaoPhoto {
	
	Photo ajouterPhoto(Objet objet , String urlPhoto);

}
