package org.greenlist.business.api;

import java.util.List;
import org.greenlist.entity.Groupe;
import org.greenlist.entity.Produit;

public interface IBusinessGroupe {
	List<Produit> getProduits(Groupe groupe);
	 
	List<Groupe> getGroupes();
}
