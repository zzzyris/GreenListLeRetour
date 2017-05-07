package org.greenlist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.greenlist.business.api.IBusinessListe;
import org.greenlist.entity.Liste;
import org.greenlist.entity.Utilisateur;

@ManagedBean(name = "mbListe")
public class ListeManagedBean {
	@EJB
	private IBusinessListe proxyListe;
	private List<Liste> listes = new ArrayList<>();
	private Utilisateur utilisateur = null;

	
}
