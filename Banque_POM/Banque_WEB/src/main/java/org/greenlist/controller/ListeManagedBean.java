package org.greenlist.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.greenlist.business.api.IBusinessListe;
import org.greenlist.business.api.IBusinessSouhait;
import org.greenlist.entity.Liste;
import org.greenlist.entity.Souhait;

@ManagedBean(name = "mbListes")
@ViewScoped
public class ListeManagedBean {
	
	@EJB
	private IBusinessListe proxyListe;
	@EJB
	private IBusinessSouhait proxySouhait;
	
	@ManagedProperty(value = "#{mbSouhait}")
	private SouhaitManagedBean mbSouhait;
	
	private List<Liste> listes = null;
	private Liste selectedListe = null;
	private List<Souhait> souhaits = null;
	

	@PostConstruct
	public void rechercherListes(){
		listes = proxyListe.getListeByIdUtilisateur(1);
		if (listes.size()>0) {
			selectedListe = listes.get(0);
			setSouhaits(proxySouhait.getSouhaits(selectedListe.getId()));
		}
	}
	
	public void afficherDetailListe(int id){
		
		setSouhaits(proxySouhait.getSouhaits(id));
		
	
	}
	

	//GETTERS AND SETTERS
	
	public IBusinessListe getProxyListe() {
		return proxyListe;
	}

	public void setProxyListe(IBusinessListe proxyListe) {
		this.proxyListe = proxyListe;
	}

	public List<Liste> getListes() {
		return listes;
	}

	public void setListes(List<Liste> listes) {
		this.listes = listes;
	}
	public List<Souhait> getSouhaits() {
		return souhaits;
	}
	public void setSouhaits(List<Souhait> souhaits) {
		this.souhaits = souhaits;
	}

	public IBusinessSouhait getProxySouhait() {
		return proxySouhait;
	}

	public void setProxySouhait(IBusinessSouhait proxySouhait) {
		this.proxySouhait = proxySouhait;
	}

	public Liste getSelectedListe() {
		return selectedListe;
	}

	public void setSelectedListe(Liste selectedListe) {
		this.selectedListe = selectedListe;
	}

	public SouhaitManagedBean getMbSouhait() {
		return mbSouhait;
	}

	public void setMbSouhait(SouhaitManagedBean mbSouhait) {
		this.mbSouhait = mbSouhait;
	}

	
}
