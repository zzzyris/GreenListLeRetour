package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.data.api.IDaoObjet;
import org.greenlist.data.api.IDaoSouhait;
import org.greenlist.data.api.IDaoUtilisateur;
import org.greenlist.entity.Echange;
import org.greenlist.entity.Note;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Utilisateur;

@Remote(IBusinessUtilisateur.class)
@Stateless
public class BusinessUtilisateur implements IBusinessUtilisateur {

	@EJB
	private IDaoUtilisateur proxyDaoUtilisateur;
	@EJB
	private IDaoObjet proxyObjet;
	@EJB
	private IDaoSouhait proxySouhait;
	

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

	@Override
	public int recupererNbEchangesValide(Utilisateur utilisateur) {
		List<Echange> userAEchange = proxyDaoUtilisateur.GetEchangesValideserA(utilisateur);
		List<Echange> userBEchange = proxyDaoUtilisateur.GetEchangesValideserB(utilisateur);
		
		userAEchange.addAll(userBEchange);
		return userAEchange.size();
	}

	@Override
	public int recupererNbAvis(Utilisateur utilisateur) {
		
		return proxyDaoUtilisateur.getAvisUtilisateur(utilisateur).size();
	}

	@Override
	public int recupererMoyenne(Utilisateur utilisateur) {
		List<Note> notes = proxyDaoUtilisateur.getAvisUtilisateur(utilisateur);
		int somme = 0 ;
		if(notes.size() != 0){
		for ( Note note : notes){
			somme += note.getNote();
		}
		return (somme / notes.size()) ;
		} else return 0 ;
	}

	@Override
	public Utilisateur getUtilisateurCompletById(Utilisateur utilisateur)  {
		
		try {
			return proxyDaoUtilisateur.getUtilisateurCompletById(utilisateur.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int recupererNbSouhaits(Utilisateur utilisateur) {
		int nbSOuhaits = 0 ;
		try {
			nbSOuhaits =proxySouhait.getSouhaits(utilisateur).size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbSOuhaits;
	}

	@Override
	public int recupererNbObjets(Utilisateur utilisateur) {
		int nbObjets =0 ;
				
				proxyObjet.getObjetsByUtilisateur(utilisateur);
				
		return nbObjets;
	}

	@Override
	public List<Objet> recupererObjetsUtilisateur(Utilisateur utilisateur) {
	
		return proxyObjet.getObjetsByUtilisateur(utilisateur);
	}

}
