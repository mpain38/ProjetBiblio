import java.io.Serializable;
import java.util.HashSet;

public class MotCle implements Serializable {
	// ************************************************************************************************************
		// Constantes
		// ************************************************************************************************************

		private static final long serialVersionUID = 1L;
		
		// ************************************************************************************************************
		// Attributs
		// ************************************************************************************************************

		private String _mot;
		private HashSet<Ouvrage> _ouvrages;
		private HashSet<Article> _articles;
		private HashSet<Document> _documents;		
		// Attributs d'Association
		//private HashMap<Integer, Exemplaire> _exemplaires;
		
		// ************************************************************************************************************
		// Constructeur
		// ************************************************************************************************************

		public MotCle(String mot) {
			
			this.setMot(mot);
			this.setOuvrages(new HashSet<Ouvrage>());
			_articles = new HashSet<Article>();			
		}



public void setMot (String mot) {
		_mot = mot;
}

public void setOuvrages (HashSet<Ouvrage> ouv) {
	_ouvrages = ouv;
}

public String getMot() {
	return _mot;
}


public HashSet<Ouvrage> getOuvrages() {
	return _ouvrages;
}

public HashSet<Article> getArticles() {
	return _articles;
}

public void ajouterDocument(Document doc, String titre){
	_documents.add(doc);	
}


public void ajouterOuvrage(Ouvrage ouv){
	_ouvrages.add(ouv);	
}

public void ajouterArticle(Article art){
	_articles.add(art);	
}
}
