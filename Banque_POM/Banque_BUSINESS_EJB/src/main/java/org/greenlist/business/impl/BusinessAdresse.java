package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessAdresse;
import org.greenlist.data.api.IDaoAdresse;
import org.greenlist.entity.Adresse;
import org.greenlist.entity.Utilisateur;

@Remote(IBusinessAdresse.class)
@Stateless
public class BusinessAdresse implements IBusinessAdresse {

	@EJB
	private IDaoAdresse proxyAdresse;

	@Override
	public List<Adresse> getAdresseByUtilisateur(Utilisateur utilisateur) {
		List<Adresse> adresses = null;
		try {
			adresses = proxyAdresse.getAdresseByUtilisateur(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adresses;
	}

}
