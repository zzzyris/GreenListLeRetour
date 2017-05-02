package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.greenlist.business.api.IBusinessGroupe;
import org.greenlist.data.api.IDaoGroupe;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

@Remote(IBusinessGroupe.class)
@Stateless
public class BusinessGroupe implements IBusinessGroupe {

	@EJB
	private IDaoGroupe proxyObjet;

	@Override
	public List<Produit> getProduits(Groupe groupe) {
		List<Produit> produits = null;
		try {
			produits = proxyObjet.getProduits(groupe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public List<Groupe> getGroupes() {
		List<Groupe> groupes = null;
		try {
			groupes = proxyObjet.getGroupes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupes;
	}

}
