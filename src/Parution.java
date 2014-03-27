

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;

/**
 * Classe de gestion d'une parution
 * @author IUT, refactoré par E. Ceret
 * @version 2.0
 *
 */
public class Parution extends Observable implements Serializable {

	// ************************************************************************************************************
	// Constantes
	// ************************************************************************************************************
	private static final long serialVersionUID = 1L;
	//final static int EMPRUNTABLE = 0, EN_CONSULTATION = 1;
	
	// ************************************************************************************************************
	// Attributs
	// ************************************************************************************************************

	private String _idParution;
    private Periodique _periodique;
    private HashMap<String, Article> _articles;


	// ************************************************************************************************************
	// Constructeur
	// ************************************************************************************************************
	/**
	 * Constructeur. Crée un exemplaire d'ouvrage .
	 * 
	 * @param numero		numéro de l'exemplaire dans l'ouvrage.
	 * @param dateReception	date de réception de cet exemplaire.
	 * @param statut  		statut de l'exemplaire (en consultation, empruntable)
	 * @param ouvrage		ouvrage dont cet exemplaire est un représentant.
	 */
	public Parution(Periodique periodique, String idPar) {
        this.setId(idPar);
        this.setPeriodique(periodique);
        this.setArticles(new HashMap<String, Article>());
		
	} // Fin Constructeur

	// ************************************************************************************************************
	// Méthodes privées
	// ************************************************************************************************************

	// ------------------------------------------------------------------------------------------------------------
	// Affecteurs
	

	/**
	 * @param numero le numéro à affecter
	 */
	private void setId(String idPar) {
		_idParution = idPar;
	}

	/**
	 * @param dateReception la date de réception àaffecter
	 */
	private void setPeriodique(Periodique periodique) {
		_periodique = periodique;
	}

    private void setArticles(HashMap<String, Article> articles) {
        _articles = articles;
    }

    
	private void setArticle(String titre, Article article) {
        _articles.put(titre, article);
}	
   

    
	public Periodique getPeriodique() {
		return _periodique;
	}
	
	public String getidparution() {
		return _idParution;
	}
    
    
	public HashMap<String, Article> getArticles() {
		return _articles;
		
	}
	
	public Article getArticle(String titre) {
		return (Article) _articles.get(titre);
	} // Fin unExemplaire
	
	public Collection<Article> getArticles02() {
		return _articles.values();
	}
	
	public int getNbArticles() {
		return _articles.size();
	}

	
	public Article ajouterArticle(String titre, Auteur auteur, String pageDeb,HashSet<MotCle> mot) {
		// Creation de l'article
			Article art = new Article(this, titre, auteur, pageDeb, mot);
		// liaison de la parution a l'article
			this.setArticle(titre, art);
			setChanged();
			notifyObservers();
			return art;
	} // Fin ajouterArticle
	
	
} // Fin Classe Parution
