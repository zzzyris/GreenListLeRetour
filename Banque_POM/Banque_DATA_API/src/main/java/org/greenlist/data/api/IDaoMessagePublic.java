package org.greenlist.data.api;

import java.util.List;
import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;

public interface IDaoMessagePublic {

	List<Messagepublic> getMessagesByObjet(Objet objet) throws Exception;
	
}
