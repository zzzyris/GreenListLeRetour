package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;

public interface IBusinessMessagePublic {
	
	
	List<Messagepublic> getMessageByObjet(Objet objet);

	List<Messagepublic> getReponses(Messagepublic messagepublic);
}
