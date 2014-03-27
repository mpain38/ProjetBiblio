

import java.io.Serializable;
import java.util.HashSet;

/**
 * Classe de gestion d'un exemplaire d'un ouvrage
 * @author IUT, refactorÃ© par E. Ceret
 * @version 2.0
 *
 */
public class Article extends Document implements Serializable {

	// ************************************************************************************************************
	// Constantes
	// ************************************************************************************************************
	private static final long serialVersionUID = 1L;
	
	// ***********************************************************************************************************
	// Attributs
	// ************************************************************************************************************

    private String  _page;
    private Parution _par;   

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
	public Article( Parution parution,String titre, Auteur auteur, String page, HashSet<MotCle> mot) {
		super (titre, auteur, mot);
		this.setPage(page);
		this.setParution(parution);
		
	} // Fin Constructeur

	// ************************************************************************************************************
	// Methodes privees
	// ************************************************************************************************************

	// ------------------------------------------------------------------------------------------------------------


	private void setPage(String page) {
		_page = page;
	}

    private void setParution(Parution parution) {
        _par = parution;
    }
    
    
    public void setAuteur(Auteur aut) {
		super.setAuteur(aut);
		aut.ajouterArticle(this);
	}

	public void setMotCle(MotCle mot) {
		super.setMotCle(mot);
		mot.ajouterArticle(this);
	}
 
	
	////////////////////////////////////////////////GET/////////////////////////////////
	


	public String getPage() {
		return _page;
	}

    public Parution getParution() {
        return _par;
    }
	

	
}
