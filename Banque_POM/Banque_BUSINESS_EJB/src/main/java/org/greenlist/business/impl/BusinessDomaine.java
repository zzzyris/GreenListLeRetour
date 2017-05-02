package org.greenlist.business.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.greenlist.business.api.IBusinessDomaine;
import org.greenlist.data.api.IDaoDomaine;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;

@Remote(IBusinessDomaine.class)
@Stateless
public class BusinessDomaine implements IBusinessDomaine {

	@EJB
	private IDaoDomaine proxyObjet;

	@Override
	public List<Groupe> getGroupes(Domaine domaine) {
		List<Groupe> groupes = null;
		try {
			groupes = proxyObjet.getGroupes(domaine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupes;
	}

	@Override
	public List<Domaine> getDomaines() {
		List<Domaine> domaines = null;
		try {
			domaines = proxyObjet.getDomaines();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domaines;
	}

}
