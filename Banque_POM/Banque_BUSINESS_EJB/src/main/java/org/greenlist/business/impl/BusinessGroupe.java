package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.greenlist.business.api.IBusinessGroupe;
import org.greenlist.data.api.IDaoGroupe;
import org.greenlist.data.api.IDaoProduit;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

@Remote(IBusinessGroupe.class)
@Stateless
public class BusinessGroupe implements IBusinessGroupe {

	@EJB
	private IDaoGroupe proxyGroupe;
	@EJB
	private IDaoProduit proxyProduit;

	@Override
	public List<Produit> getProduits(Groupe groupe) {
		List<Produit> produits = null;
		try {
			produits = proxyProduit.getProduits(groupe);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produits;
	}
	
	@Override
	public List<Groupe> getGroupes(Domaine domaine) {
		List<Groupe> groupes = null;
		try {
			groupes = proxyGroupe.getGroupes(domaine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupes;
	}

}
