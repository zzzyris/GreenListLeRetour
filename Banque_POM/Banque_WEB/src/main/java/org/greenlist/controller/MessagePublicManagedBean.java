package org.greenlist.controller;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import org.greenlist.business.api.IBusinessMessagePublic;
import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "mbMessagePublic")
@SessionScoped
public class MessagePublicManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IBusinessMessagePublic proxMP;
	private Messagepublic messagepublic;
	private Objet objet;
	private List<Messagepublic> messages;

	/**
	 * permet de determiner le type de message
	 * 
	 * @return
	 */
	public List<Messagepublic> recupererQuestions() {
		objet = new Objet();
		objet.setId(21);
		return messages = proxMP.getMessageByObjet(objet);
	}
	/**
	 * premet de recuperer les reponses
	 */
	public List<Messagepublic> recuperReponses() {
		messagepublic = new Messagepublic();
		messagepublic.setId(21);
		messages = proxMP.getReponses(messagepublic);
		return messages;
		
		
	}
	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	public List<Messagepublic> getMessages() {
		return messages;
	}

	public void setMessages(List<Messagepublic> messages) {
		this.messages = messages;
	}

	public IBusinessMessagePublic getProxMP() {
		return proxMP;
	}

	public void setProxMP(IBusinessMessagePublic proxMP) {
		this.proxMP = proxMP;
	}
	public Messagepublic getMessagepublic() {
		return messagepublic;
	}
	public void setMessagepublic(Messagepublic messagepublic) {
		this.messagepublic = messagepublic;
	}

	

}
