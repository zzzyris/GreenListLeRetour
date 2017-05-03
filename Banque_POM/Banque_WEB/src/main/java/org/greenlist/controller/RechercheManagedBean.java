package org.greenlist.controller;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;
import org.greenlist.entity.Objet;

@ManagedBean(name = "mbRecherche")
@SessionScoped
public class RechercheManagedBean {

	private String recherche;
	private Set<Objet> resultatsRecherche = null;
	private Set<String> motsRecherche;

	public void decouperRecherche() {
		motsRecherche = new HashSet<String>();
		String monString = StringUtils.stripAccents(recherche).toLowerCase();
		String[] mesMots = monString.split("[ -]");
		for (String s : mesMots) {
			if (s.length() > 2) {
				motsRecherche.add(s);
			}
		}
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

	public void setResultatsRecherche(Set<Objet> resultatsRecherche) {
		this.resultatsRecherche = resultatsRecherche;
	}

	public Set<String> getMotsRecherche() {
		return motsRecherche;
	}

	public void setMotsRecherche(Set<String> motsRecherche) {
		this.motsRecherche = motsRecherche;
	}

}
