package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.Echange;
import org.greenlist.entity.Note;
import org.greenlist.entity.Souhait;
import org.greenlist.entity.Utilisateur;

public interface IDaoUtilisateur {

	public Utilisateur seConnecter(String pseudo, String mdp) throws Exception;
	
	public Utilisateur getUtilisateurById(int idUtilisateur) throws Exception;
	
	public Utilisateur getUtilisateurCompletById(int idUtilisateur) throws Exception;
	
	public List<Echange> GetEchangesValideserA(Utilisateur utilisateur);
	
	public List<Echange> GetEchangesValideserB(Utilisateur utilisateur);
	
	public List<Note> getAvisUtilisateur(Utilisateur utilisateur );
	
	
	
	
	
	
	
}
