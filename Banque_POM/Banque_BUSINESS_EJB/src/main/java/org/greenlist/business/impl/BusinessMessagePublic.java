package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.greenlist.business.api.IBusinessMessagePublic;
import org.greenlist.data.api.IDaoMessagePublic;
import org.greenlist.entity.Messagepublic;
import org.greenlist.entity.Objet;

@Remote(IBusinessMessagePublic.class)
@Stateless
public class BusinessMessagePublic implements IBusinessMessagePublic {
	
	@EJB
	private IDaoMessagePublic proxyDaoMessagePublic;
	
	@Override
	public List<Messagepublic> getMessageByObjet(Objet objet) {
		List<Messagepublic> messagePub = null;
		try {
			messagePub = proxyDaoMessagePublic.getMessageByObjet(objet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messagePub;
		
	}

	@Override
	public List<Messagepublic> getReponses(Messagepublic messagepublic) {
		List<Messagepublic> messagePubIdParent = null;
		try {
			messagePubIdParent = proxyDaoMessagePublic.getReponses(messagepublic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messagePubIdParent;
	}

}
