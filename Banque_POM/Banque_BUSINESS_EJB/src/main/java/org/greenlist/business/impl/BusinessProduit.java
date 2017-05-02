package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessProduit;
import org.greenlist.data.api.IDaoProduit;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

@Remote(IBusinessProduit.class)
@Stateless
public class BusinessProduit implements IBusinessProduit {

	@EJB
	private IDaoProduit proxyProduit;

	@Override
	public Groupe getGroupe(Produit produit) {
		Groupe groupe = null;
		try {
			groupe = proxyProduit.getGroupe(produit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupe;
	}

	@Override
	public List<Produit> getProduits() {
		List<Produit> produits = null;
		try {
			produits = proxyProduit.getProduits();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produits;
	}

}
