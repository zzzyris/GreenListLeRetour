package org.greenlist.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessExperience;
import org.greenlist.data.api.IDaoExperience;
import org.greenlist.entity.Experience;
import org.greenlist.entity.Utilisateur;

@Remote(IBusinessExperience.class)
@Stateless
public class BusinessExperience implements IBusinessExperience {

	@EJB
	private IDaoExperience proxyExperience;

	@Override
	public Experience getExperienceByUtilisateur(Utilisateur utilisateur) {
		Experience experience = null;
		try {
			experience = proxyExperience.getExperienceByUtilisateur(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return experience;
	}

}
