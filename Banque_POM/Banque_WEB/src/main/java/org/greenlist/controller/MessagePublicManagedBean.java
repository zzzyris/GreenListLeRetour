package org.greenlist.controller;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import org.greenlist.business.api.IBusinessMessagePublic;
import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;
import java.io.Serializable;

@ManagedBean(name = "mbMessagePublic")
@SessionScoped
public class MessagePublicManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private IBusinessMessagePublic proxMP;
	private Messagepublic messagepublic;
	private Objet objet;

	/**
	 * permet de determiner le type de message
	 * 
	 * @return
	 */
	public void recupererQuestions() {
		proxMP.getMessageByObjet(objet);
	}

	/**
	 * premet de recuperer les reponses
	 * 
	 * @return
	 */
	public void recuperReponses() {
		proxMP.getReponses(messagepublic);
	}

	public IBusinessMessagePublic getProxMP() {
		return proxMP;
	}

	public void setProxMP(IBusinessMessagePublic proxMP) {
		this.proxMP = proxMP;
	}

	

}
