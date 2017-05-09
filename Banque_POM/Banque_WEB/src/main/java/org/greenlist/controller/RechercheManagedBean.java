package org.greenlist.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.mail.Address;

import org.apache.commons.lang3.StringUtils;
import org.greenlist.business.api.IBusinessAdresse;
import org.greenlist.business.api.IBusinessObjet;
import org.greenlist.business.api.IBusinessProduit;
import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.business.comparator.ObjetComparator;
import org.greenlist.entity.Adresse;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;
import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbRecherche")
@SessionScoped
public class RechercheManagedBean {

	private String recherche;
	private Set<Objet> resultatRechercheSet = null;
	private List<Objet> resultatRechercheList = null;
	private Set<String> motsRecherche;
	private static final double SCORE_PRODUIT = 0.5;
	private final double score_groupe = 0.3;
	private final double score_domaine = 0.15;
	private Utilisateur utilisateur;

	// sera à définir à partir de l'utilisateur qui effectuera la recherche.
	// Valeur par défaut pour le moment.
	private double latitude;
	private double longitude;

	@EJB
	private IBusinessUtilisateur proxyUtilisateur;
	
	@EJB
	private IBusinessProduit proxyProduit;

	@EJB
	private IBusinessObjet proxyObjet;
	
	@EJB
	private IBusinessAdresse proxyAdresse;
	
	@PostConstruct
	private void init(){
		//TODO : modifier l'id par celle récupérée depuis la page précédente.
		utilisateur = proxyUtilisateur.getUtilisateurById(1);
		List<Adresse> adresses = proxyAdresse.getAdresseByUtilisateur(utilisateur);
		longitude = adresses.get(0).getLongitude();
		latitude = adresses.get(0).getLatitude();
	}

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
		resultatRechercheSet = new HashSet<>();

		// pour chaque mot dans la recherche
		for (String mot : motsRecherche) {
			// récupération des produits contenant ce mot dans leur libellé
			List<Produit> produits = proxyProduit.getProduits(mot);
			// pour chaque produit dans cette liste de produits
			for (Produit p : produits) {
				// récupération des objets appartenant à ce produit et n'appartenant pas à l'utilisateur
				Set<Objet> partialResults = proxyObjet.getObjets(p, utilisateur);

				// Enlever tous les résultats qui ne conviennent pas et calculer
				// la distance et la pertinence pour ceux qui conviennent.
				if (partialResults != null) {
					partialResults = filtrerResultats(mot, partialResults, SCORE_PRODUIT);
					resultatRechercheSet.addAll(partialResults);
				}
			}
		}
		
		resultatRechercheList = new ArrayList<>(resultatRechercheSet);
		Collections.sort(resultatRechercheList, new ObjetComparator());
		for (Objet o : resultatRechercheList) {
			System.out.println(o.getLibelle());
			System.out.println("Distance : " + o.getDistance() + "\nPertinence : " + o.getPertinence());
			System.out.println( "domaine : " + o.getProduit().getGroupe().getDomaine().getLibelle());
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
				/*
				 * Calcul de la pertinence : La catégorie compte pour 50% du
				 * score, le nombre de mots clefs trouvés pour 50%. Catégorie :
				 * 50% pour produit, 30% pour groupe, 15% pour domaine nb de
				 * mots clefs : nbMotsTrouvés / nbMotsClefs / 2
				 */
				o.setPertinence((scoreCategorie + (double)score / motsClefs.size() / 2)*100);
				o = calculDistance(o);
			} else if (motsClefs.size() == 0) {
				o.setPertinence(100);
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
		
		
		
		d = Math.round(d * 10);
		d = d / 10;
		
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
		return resultatRechercheSet;
	}

	public Set<String> getMotsRecherche() {
		return motsRecherche;
	}

	public Set<Objet> getResultatRechercheSet() {
		return resultatRechercheSet;
	}

	public void setResultatRechercheSet(Set<Objet> resultatRechercheSet) {
		this.resultatRechercheSet = resultatRechercheSet;
	}

	public List<Objet> getResultatRechercheList() {
		return resultatRechercheList;
	}

	public void setResultatRechercheList(List<Objet> resultatRechercheList) {
		this.resultatRechercheList = resultatRechercheList;
	}

	
	
}
