package org.greenlist.controller;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import org.greenlist.business.api.IBusinessMessagePublic;
import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mbMessagePublic")
@SessionScoped
public class MessagePublicManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IBusinessMessagePublic proxMP;
	private Messagepublic messagepublic;

	private Objet objet;
	private List<Messagepublic> messages = new ArrayList<>();
	
	private Messagepublic node0;
	
	@PostConstruct
	public void init(){
		System.out.println("yahoooooooo");
		objet = new Objet();
		objet.setId(21);
		System.out.println(objet.getId());
		recupererMessages();
		System.out.println("nb messages : " + messages.size());
	}

	/**
	 * permet de determiner le type de message
	 * 
	 * @return
	 */
	public List<Messagepublic> recupererMessages() {
		return messages = proxMP.getMessagesByObjet(objet);
	}

	public boolean isNode0(){	
		System.out.println("Plop");
		System.out.println(node0);
		if (hasNoParent(node0)){
			return true;
		}
		return false;
	}

	public boolean hasNoParent(Messagepublic message) {
		return message.getMessageParent().equals(null);
	}
	
	public boolean hasChildren(Messagepublic message){
		if (message.getMessageEnfants() != null){
			return true;
		}
		return false;
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

	public Messagepublic getNode0() {
		return node0;
	}

	public void setNode0(Messagepublic node0) {
		this.node0 = node0;
	}
	
	

}
