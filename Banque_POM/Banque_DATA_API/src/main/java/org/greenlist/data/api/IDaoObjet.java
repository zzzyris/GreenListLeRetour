package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;
import org.greenlist.entity.Utilisateur;

public interface IDaoObjet {
	
	Objet getObjetById(int idObjet);
	Objet createObjet(Objet objet);
	List<Objet> getObjetsByUtilisateur(Utilisateur utilisateur);
	List<Objet> getObjetsByLibelle(String libelle);

	List<Objet> getObjetsByDomaine(Domaine domaine);
	List<Objet> getObjetsByGroupe(Groupe groupe);
	List<Objet> getObjetsByProduit(Produit produit);
	

}
