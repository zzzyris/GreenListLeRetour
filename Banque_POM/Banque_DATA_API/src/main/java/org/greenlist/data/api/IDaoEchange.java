package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Echange;
import org.greenlist.entity.Message;
import org.greenlist.entity.Objet;
import org.greenlist.entity.Rdv;

public interface IDaoEchange {
	
	

	public Echange creerEchange (Echange echange);
	
	public Echange GetEchange ( int IdEchange);
	
	public Echange majEchange(Echange echange);
	
	public List<Objet> getObjets (Echange echange);
	
	public List<Message> getMessages (Echange echange);
	
	public List<Rdv> getRdv(Echange echange);
	
	
	
	
	
}
