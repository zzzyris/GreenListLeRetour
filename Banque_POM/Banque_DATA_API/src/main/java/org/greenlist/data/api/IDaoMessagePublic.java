package org.greenlist.data.api;

import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;

public interface IDaoMessagePublic {
	
Messagepublic getMessageByObjet(Objet objet) throws Exception;
}
