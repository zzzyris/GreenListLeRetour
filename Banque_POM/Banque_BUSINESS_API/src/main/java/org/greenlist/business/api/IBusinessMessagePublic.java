package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;

public interface IBusinessMessagePublic {
	
	List<Messagepublic> getMessagesByObjet(Objet objet);
	
}
