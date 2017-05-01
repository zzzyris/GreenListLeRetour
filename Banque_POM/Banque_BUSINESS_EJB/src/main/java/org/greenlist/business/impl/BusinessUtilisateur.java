package org.greenlist.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.data.api.IDaoUtilisateur;
import org.greenlist.entity.Utilisateur;

@Remote(IBusinessUtilisateur.class)
@Stateless
public class BusinessUtilisateur implements IBusinessUtilisateur {

	@EJB
	private IDaoUtilisateur proxyDaoUtilisateur;

	@Override
	public Utilisateur seConnecter(String pseudo, String mdp) {
		Utilisateur utilisateur = null;
		try {
			utilisateur = proxyDaoUtilisateur.seConnecter(pseudo, mdp);
		} catch (Exception e) {
			// catch misere
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public Utilisateur getUtilisateurById(int idUtilisateur) {
		Utilisateur utilisateur = null;
		try {
			utilisateur = proxyDaoUtilisateur.getUtilisateurById(idUtilisateur);
		} catch (Exception e) {
			// Catch misere
			e.printStackTrace();
		}
		return utilisateur;
	}

}
