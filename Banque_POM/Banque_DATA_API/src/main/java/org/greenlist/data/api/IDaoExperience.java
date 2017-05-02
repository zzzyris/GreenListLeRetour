package org.greenlist.data.api;

import org.greenlist.entity.Experience;
import org.greenlist.entity.Utilisateur;

public interface IDaoExperience {
	
	Experience getExperienceByUtilisateur(Utilisateur utilisateur)throws Exception;
}
