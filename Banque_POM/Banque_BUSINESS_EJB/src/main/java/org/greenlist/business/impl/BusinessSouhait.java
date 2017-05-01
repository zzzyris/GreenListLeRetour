package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessSouhait;
import org.greenlist.data.api.IDaoSouhait;
import org.greenlist.entity.Liste;
import org.greenlist.entity.Souhait;
import org.greenlist.entity.Utilisateur;

@Remote(IBusinessSouhait.class)
@Stateless
public class BusinessSouhait implements IBusinessSouhait {

	@EJB
	private IDaoSouhait proxyDaoSouhait;

	@Override
	public List<Souhait> getSouhaits(Utilisateur utilisateur) {
		List<Souhait> user = null;
		try {
			user = proxyDaoSouhait.getSouhaits(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Souhait> getSouhaits(Liste liste) {
		List<Souhait> user = null;
		try {
			user = proxyDaoSouhait.getSouhaits(liste);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Liste> getListes(Utilisateur utilisateur) {
		List<Liste> list = null;
		try {
			list = proxyDaoSouhait.getListes(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Souhait getSouhait(Souhait souhait) {
		Souhait psouhait = null;
		try {
			psouhait = proxyDaoSouhait.getSouhait(souhait);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return psouhait;
	}

	@Override
	public Souhait addSouhait(Souhait souhait) {
		return proxyDaoSouhait.addSouhait(souhait);
	}

	@Override
	public Liste addListe(Liste liste) {
		return proxyDaoSouhait.addListe(liste);
	}

}
