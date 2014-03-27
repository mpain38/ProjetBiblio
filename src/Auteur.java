
import java.io.Serializable;
import java.util.HashSet;

public class Auteur implements Serializable {
	// ************************************************************************************************************
		// Constantes
		// ************************************************************************************************************

		private static final long serialVersionUID = 1L;
		
		// ************************************************************************************************************
		// Attributs
		// ************************************************************************************************************

		private String _nomAut;
		private String _prenomAut;
		private HashSet<Ouvrage> _ouvrages;
		private HashSet<Article> _articles;
		
		// Attributs d'Association
		//private HashMap<Integer, Exemplaire> _exemplaires;
		
		// ************************************************************************************************************
		// Constructeur
		// ************************************************************************************************************

		public Auteur(String nomAut, String prenomAut) {
			
			this.setNomAut(nomAut);
			this.setPrenomAut(prenomAut);
			_ouvrages = new HashSet<Ouvrage>();
			_articles = new HashSet<Article>();			
		}



public void setNomAut (String nomAut) {
	_nomAut = nomAut;
}

public void setPrenomAut (String prenomAut) {
	_prenomAut = prenomAut;
}

public String getPrenomAut (){
	return _prenomAut;
}

public String getNomAut (){
	return _nomAut;
}

public HashSet<Ouvrage> getOuvrages() {
	return _ouvrages;
}

public void ajouterOuvrage(Ouvrage ouv){
	_ouvrages.add(ouv);
	
}

public HashSet<Article> getArticles() {
	return _articles;
}

public void ajouterArticle(Article art){
	_articles.add(art);
	
}

}