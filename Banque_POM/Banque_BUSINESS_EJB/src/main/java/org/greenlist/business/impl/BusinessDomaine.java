package org.greenlist.business.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.greenlist.business.api.IBusinessDomaine;
import org.greenlist.data.api.IDaoDomaine;
import org.greenlist.data.api.IDaoGroupe;
import org.greenlist.entity.Domaine;
import org.greenlist.entity.Groupe;

@Remote(IBusinessDomaine.class)
@Stateless
public class BusinessDomaine implements IBusinessDomaine {

	@EJB
	private IDaoDomaine proxyDomaine;
	@EJB
	private IDaoGroupe proxyGroupe;

	@Override
	public List<Groupe> getGroupes(Domaine domaine) {
		List<Groupe> groupes = null;
		try {
			groupes = proxyGroupe.getGroupes(domaine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupes;
	}

	@Override
	public List<Domaine> getDomaines() {
		List<Domaine> domaines = null;
		try {
			domaines = proxyDomaine.getDomaines();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domaines;
	}

	@Override
	public Domaine getDomaine(int idDomaine) {
		Domaine domaine = new Domaine();
		try {
		 domaine =  proxyDomaine.getDomaine(idDomaine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return domaine;
	} 

}
