package org.greenlist.business.api;

import java.util.List;

import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;

public interface IBusinessDomaine {
	
	List<Groupe> getGroupes(Domaine domaine);
	
	 List<Domaine> getDomaines();
}
