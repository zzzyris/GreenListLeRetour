package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.greenlist.business.api.IBusinessListe;
import org.greenlist.data.api.IDaoListe;
import org.greenlist.entity.Liste;
import org.greenlist.entity.Utilisateur;

@Remote(IBusinessListe.class)
@Stateless
public class BusinessListe implements IBusinessListe {
	
	@EJB
	private IDaoListe proxyListe;
	
	@Override
	public List<Liste> getListeByUtilisateur(Utilisateur utilisateur) {
		List<Liste> listes = null;
		try {
			listes = proxyListe.getListeByUtilisateur(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listes;
	
	}

}
