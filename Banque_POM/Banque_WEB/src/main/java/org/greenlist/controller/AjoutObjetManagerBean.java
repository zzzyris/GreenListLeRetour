package org.greenlist.controller;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.greenlist.business.api.IBusinessObjet;

import org.greenlist.entity.Objet;
import org.greenlist.entity.Produit;

import org.greenlist.entity.TrancheAge;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "mbObjetAjout")
@ViewScoped
public class AjoutObjetManagerBean {

	@EJB
	private IBusinessObjet proxyObjet;

	private Objet objet = new Objet();

	private List<UploadedFile> uploadedFiles = new ArrayList<>();

	private UploadedFile photoUploade;

	@ManagedProperty(value = "#{mbUtilisateur}")
	private UtilisateurManagedBean mbConnect;

	@PostConstruct
	public void init() {
		objet.setTrancheAge(new TrancheAge());
		objet.setProduit(new Produit());

	}

	public Objet creerObjet() {
		objet.setUtilisateur(mbConnect.getUtilisateurConnecte());
		objet.setDateDepot(Calendar.getInstance().getTime());
		return proxyObjet.creerObjet(objet);
	}

//	<p:fileUpload
//	fileUploadListener="#{mbObjetAjout.handleFileUpload()}"
//	value="#{mbObjetAjout.photoUploade}"
//	mode="advanced"></p:fileUpload>
	public void handleFileUpload(FileUploadEvent event) {

		this.photoUploade = event.getFile();
		System.out.println("File name : " + photoUploade.getFileName() + "\nSize file : " + photoUploade.getSize());

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

	public List<UploadedFile> getUploadedFiles() {
		return uploadedFiles;
	}

	public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}

	public UploadedFile getPhotoUploade() {
		return photoUploade;
	}

	public void setPhotoUploade(UploadedFile photoUploade) {
		this.photoUploade = photoUploade;
	}

}
