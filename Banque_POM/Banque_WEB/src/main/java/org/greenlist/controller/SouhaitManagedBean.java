package org.greenlist.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.greenlist.business.api.IBusinessSouhait;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Liste;
import org.greenlist.entity.Produit;
import org.greenlist.entity.Souhait;
import org.greenlist.entity.TrancheAge;

@ManagedBean(name = "mbSouhait")
@ViewScoped
public class SouhaitManagedBean {
	
	@EJB
	private IBusinessSouhait proxySouhait;

	@ManagedProperty(value = "#{mbAfficheRefObjetSOuhait}")
	private AffichageRefObjetSOuhait mbAffichage;

	@ManagedProperty(value = "#{mbUtilisateur}")
	private UtilisateurManagedBean mbConnect;
	
	private Souhait souhait = new Souhait();
	
	private List<Souhait> souhaits = null;

	@PostConstruct
	public void init() {
		souhait.setTrancheAge(new  TrancheAge());
		souhait.setProduit(new Produit());
		souhait.setGroupe(new Groupe());
		souhait.setDomaine(new Domaine());
		souhait.setListe(new Liste());
	}

	public void saveDomaine (int idDomaine) {
		//souhait.setDomaine(new Domaine(idDomaine, "toto"));
		souhait.getDomaine().setId(idDomaine);
		mbAffichage.rechercherGroupes(idDomaine);
		
	}
	
	public Souhait creerSouhait() {
		souhait.getListe().setUtilisateur(mbConnect.getUtilisateurConnecte());
		souhait.getListe().setId(1);
		souhait.setDateDepot(Calendar.getInstance().getTime());
		souhait.getGroupe().setId(mbAffichage.getSelectedGroupe().getId());
		souhait = proxySouhait.addSouhait(souhait);
		return souhait;
	}
	
	public List<Souhait> afficherSouhaitsParListe(int idListe){
		souhaits = proxySouhait.getSouhaits(idListe);
		return souhaits;
	}
	
	public UtilisateurManagedBean getMbConnect() {
		return mbConnect;
	}


	public AffichageRefObjetSOuhait getMbAffichage() {
		return mbAffichage;
	}

	public void setMbAffichage(AffichageRefObjetSOuhait mbAffichage) {
		this.mbAffichage = mbAffichage;
	}

	public void setMbConnect(UtilisateurManagedBean mbConnect) {
		this.mbConnect = mbConnect;
	}


	public Souhait getSouhait() {
		return souhait;
	}


	public void setSouhait(Souhait souhait) {
		this.souhait = souhait;
	}

	public IBusinessSouhait getProxySouhait() {
		return proxySouhait;
	}

	public void setProxySouhait(IBusinessSouhait proxySouhait) {
		this.proxySouhait = proxySouhait;
	}

	public List<Souhait> getSouhaits() {
		return souhaits;
	}

	public void setSouhaits(List<Souhait> souhaits) {
		this.souhaits = souhaits;
	}
	

}
