

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;

/**
 * Classe de gestion d'un exemplaire d'un ouvrage
 * @author IUT, refactorÃ© par E. Ceret
 * @version 2.0
 *
 */
public class Document extends Observable implements Serializable {

	// ************************************************************************************************************
	// Constantes
	// ************************************************************************************************************
	private static final long serialVersionUID = 1L;
	
	// ***********************************************************************************************************
	// Attributs
	// ************************************************************************************************************

    private String _titre;
    private Auteur _aut;
    private MotCle _mot;
    
	// Attributs d'Association
    private HashMap<String, Auteur> _auteurs;
    private HashSet<MotCle> _motsCles;    

	// ************************************************************************************************************
	// Constructeur
	// ************************************************************************************************************
	/**
	 * Constructeur. Cree un article .
	 * 
	 * @param titre			titre de l'article.
	 * @param parution		parution auquel appartient l'article.
	 * @param page			page de début de l'article.
	 * @param auteur  		auteur de l'article.
	 * @param mot		mot(s) clé(s) de l'article.
	 */
	public Document(String titre, Auteur auteur, HashSet<MotCle> mot) {
		this.setTitre(titre);
		this.setAuteur(auteur);	
		this.setMotsCles(mot);
		for (MotCle motC : mot) {
			this.setMotCle(motC);
		}
		
	} // Fin Constructeur

	// ************************************************************************************************************
	// MÃ©thodes privÃ©es
	// ************************************************************************************************************

	// ------------------------------------------------------------------------------------------------------------
	private void setTitre(String titre) {
		_titre = titre;
	}
 
	
	public void setAuteur(Auteur aut){
		_aut = aut;
	}
	
	public void setMotCle(MotCle mot){
		_mot = mot;
	}
	
	public void setMotsCles(HashSet<MotCle> mot){
		_motsCles = mot;
	}
 
	
	////////////////////////////////////////////////GET/////////////////////////////////
	
	public String getTitre() {
		return _titre;
	}
    
    public Auteur getAuteur() {
		return _aut;
		
	}
    
    public MotCle getMotCle() {
		return _mot;
		
	}
	
	public HashMap<String, Auteur> getAuteurs(){
		return _auteurs;
	}
	
	public HashSet<MotCle> getMotsCles(){
		return _motsCles;
	}
	

	
}
