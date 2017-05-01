package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.data.api.IDaoObjet;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Utilisateur;


@Remote(IBusinessObjet.class)
@Stateless
public class BusinessObjet implements IBusinessObjet {
	
	@EJB
	private IDaoObjet proxyObjet;

	@Override
	public Objet creerObjet(Objet objet) {
		
		return proxyObjet.createObjet(objet);
	}

	@Override
	public List<Objet> getObjets(Utilisateur utilisateur) {
	
		return proxyObjet.getObjetsByUtilisateur(utilisateur);
	}

	@Override
	public Objet getObjet(Objet objet) {
		
		return proxyObjet.getObjetById(objet.getId());
	}

}
