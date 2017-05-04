package org.greenlist.controller;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import org.greenlist.business.api.IBusinessMessagePublic;
import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mbMessagePublic")
@SessionScoped
public class MessagePublicManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private IBusinessMessagePublic proxyMessagePublic;

	private Messagepublic messagepublic;
	private Objet objet;
	private List<Messagepublic> messages = new ArrayList<>();
	private List<TreeNode> nodes = new ArrayList<>();

	/**
	 * permet de determiner le type de message
	 * 
	 * @return
	 */
	public List<Messagepublic> recupererMessages() {
		objet = new Objet();
		objet.setId(21);
		return messages = proxyMessagePublic.getMessagesByObjet(objet);
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

	public Messagepublic getMessagepublic() {
		return messagepublic;
	}

	public void setMessagepublic(Messagepublic messagepublic) {
		this.messagepublic = messagepublic;
	}

	public IBusinessMessagePublic getProxyMessagePublic() {
		return proxyMessagePublic;
	}

	public void setProxyMessagePublic(IBusinessMessagePublic proxyMessagePublic) {
		this.proxyMessagePublic = proxyMessagePublic;
	}

}
