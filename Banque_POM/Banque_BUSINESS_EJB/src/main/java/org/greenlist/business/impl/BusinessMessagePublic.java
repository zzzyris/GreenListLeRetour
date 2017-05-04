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
	public List<Messagepublic> getMessagesByObjet(Objet objet) {
		List<Messagepublic> messagePub = null;
		try {
			messagePub = proxyDaoMessagePublic.getMessagesByObjet(objet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messagePub;
		
	}

}
