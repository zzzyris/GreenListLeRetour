package org.greenlist.controller;

import java.io.IOException;
import java.util.Calendar;
//import java.util.List;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
//import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.jms.Session;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.greenlist.business.api.IBusinessObjet;
//import org.greenlist.business.api.IBusinessUtilisateur;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;
//import org.greenlist.entity.Utilisateur;
import org.greenlist.entity.TrancheAge;

@ManagedBean(name = "mbObjetAjout")
@ViewScoped
public class AjoutObjetManagerBean {

	@EJB
	private IBusinessObjet proxyObjet;
	
	private Objet objet = new Objet();
	
	private List<String> listeUrl;
	private Part urlPhoto;
	
	
	@ManagedProperty(value = "#{mbUtilisateur}")
	private UtilisateurManagedBean mbConnect;
	
	
	@PostConstruct
	public void init() {
		objet.setTrancheAge(new TrancheAge());
		objet.setProduit(new Produit());
		
	}
	
	
	public Objet creerObjet (){
		objet.setUtilisateur(mbConnect.getUtilisateurConnecte());
		objet.setDateDepot(Calendar.getInstance().getTime());
		return proxyObjet.creerObjet(objet);
	}	
	
	public String upload() {
		String path = Thread.currentThread().getContextClassLoader().getResource("bidon.txt").getPath();
		System.out.println(path);
		path = path.split("WEB-INF")[0] + "img/";
		System.out.println(path.substring(1));
		try {
			urlPhoto.write(path.substring(1) + getFilename(urlPhoto));
		} catch (IOException e) {
			System.out.println("souci d'écriture de fichier");
			e.printStackTrace();
		}
		return "";
	}
	
	private static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}
	
	
	public UtilisateurManagedBean getMbConnect() {
		return mbConnect;
	}

	public void setMbConnect(UtilisateurManagedBean mbConnect) {
		this.mbConnect = mbConnect;
	}

	public IBusinessObjet getProxyObjet() {
		return proxyObjet;
	}
	public void setProxyObjet(IBusinessObjet proxyObjet) {
		this.proxyObjet = proxyObjet;
	}
	public Objet getObjet() {
		return objet;
	}
	public void setObjet(Objet objet) {
		this.objet = objet;
	}
	public List<String> getListeUrl() {
		return listeUrl;
	}
	public void setListeUrl(List<String> listeUrl) {
		this.listeUrl = listeUrl;
	}
	
	
	
	
	
	
}
