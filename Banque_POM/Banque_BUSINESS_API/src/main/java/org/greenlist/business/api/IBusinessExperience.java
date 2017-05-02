package org.greenlist.business.api;

import org.greenlist.entity.Experience;
import org.greenlist.entity.Utilisateur;

public interface IBusinessExperience {
	
	public Experience getExperienceByUtilisateur(Utilisateur utilisateur);

}
