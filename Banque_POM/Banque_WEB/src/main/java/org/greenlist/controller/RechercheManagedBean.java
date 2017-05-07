package org.greenlist.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;
import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.business.api.IBusinessProduit;
import org.greenlist.entity.Adresse;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;

@ManagedBean(name = "mbRecherche")
@SessionScoped
public class RechercheManagedBean {

	private String recherche;
	private Set<Objet> resultatsRecherche = null;
	private Set<String> motsRecherche;
	private final double score_produit = 0.5;
	private final double score_groupe = 0.3;
	private final double score_domaine = 0.15;

	// sera à définir à partir de l'utilisateur qui effectuera la recherche.
	// Valeur par défaut pour le moment.
	private double latitude = 48.822288;
	private double longitude = 2.334929;

	@EJB
	private IBusinessProduit proxyProduit;

	@EJB
	private IBusinessObjet proxyObjet;

	public void decouperRecherche() {
		if (recherche.length() > 0) {
			motsRecherche = new HashSet<String>();
			String monString = StringUtils.stripAccents(recherche).toLowerCase();
			String[] mesMots = monString.split("[ -]");
			for (String s : mesMots) {
				if (s.length() > 2) {
					motsRecherche.add(s);
				}
			}
			construireResultats();
		}
	}

	/**
	 * Enregistre dans resultatsRecherche l'ensemble des objets correspondant à
	 * la recherche saisie par l'utilisateur : Cherche à partir des mots clefs
	 * saisis les produits correspondants, puis, parmis ces produits, les objets
	 * dont le libellé correspond au reste des mots-clefs.
	 */
	private void construireResultats() {
		resultatsRecherche = new HashSet<>();

		// pour chaque mot dans la recherche
		for (String mot : motsRecherche) {
			// récupération des produits contenant ce mot dans leur libellé
			List<Produit> produits = proxyProduit.getProduits(mot);
			// pour chaque produit dans cette liste de produits
			for (Produit p : produits) {
				// récupération des objets appartenant à ce produit
				Set<Objet> partialResults = proxyObjet.getObjets(p);

				// Enlever tous les résultats qui ne conviennent pas et calculer
				// la distance et la pertinence pour ceux qui conviennent.
				// méthode non-nécessaire si la recherche ne contient qu'un seul
				// mot.
				if (motsRecherche.size() > 1 && partialResults != null) {
					partialResults = filtrerResultats(mot, partialResults, score_produit);
				}
				if (partialResults != null) {
					resultatsRecherche.addAll(partialResults);
				}
			}
		}
		
		for (Objet o: resultatsRecherche){
			System.out.println(o.getLibelle());
		}

	}

	private Set<Objet> filtrerResultats(String mot, Set<Objet> partialResults, double scoreCategorie) {
		List<String> motsClefs = new ArrayList<>();
		motsClefs.addAll(motsRecherche);
		motsClefs.remove(mot);
		int score;
		Iterator<Objet> i = partialResults.iterator();
		while (i.hasNext()) {
			Objet o = i.next();
			score = 0;
			for (String m : motsClefs) {
				if (StringUtils.stripAccents(o.getLibelle()).toLowerCase().contains(m)) {
					score++;
				}
			}
			if (score > 0) {
				o.setPertinence(scoreCategorie + score / motsClefs.size()); // calcul
																			// de
																			// la
																			// pertinence
																			// du
																			// résultat.
				o = calculDistance(o);
			} else {
				i.remove();
			}
		}
		return partialResults;
	}

	// Formule d'Haversine, calcul de la distance entre deux points définis par
	// leurs longitude et latitude.
	// Cette distance est enregistrée dans l'objet o.
	private Objet calculDistance(Objet o) {
		Adresse adresse = proxyObjet.getAdresse(o);
		double R = 6371; // rayon de la terre en km
		double deltaLatitude = deg2rad(adresse.getLatitude() - latitude);
		double deltaLongitude = deg2rad(adresse.getLongitude() - longitude);

		double a = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2)
				+ Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(adresse.getLatitude())) * Math.sin(deltaLongitude / 2)
						* Math.sin(deltaLongitude / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c; // distance en km ( Magic...)
		o.setDistance(d);
		return o;

	}

	private double deg2rad(double deg) {
		return deg * Math.PI / 180;
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public Set<Objet> getResultatsRecherche() {
		return resultatsRecherche;
	}

	public Set<String> getMotsRecherche() {
		return motsRecherche;
	}

}
