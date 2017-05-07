package org.greenlist.business.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.data.api.IDaoObjet;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;
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

	@Override
	public Set<Objet> getObjets(Produit produit) {
		List<Objet> resultList = proxyObjet.getObjetsByProduit(produit);
		Set<Objet> resultSet = null;
		if (!resultList.isEmpty()){
			resultSet = new HashSet<>(resultList);
		}
		return resultSet;
	}

}
