

import java.io.Serializable;
import java.util.HashMap;
import java.util.Observable;

/**
 * Classe de gestion de periodique.
 * @author IUT, refactore par E. Ceret
 * @version 2.0
 */
public class Periodique extends Observable implements Serializable {

	// ************************************************************************************************************
	// Constantes
	// ************************************************************************************************************

	private static final long serialVersionUID = 1L;
	
	// ************************************************************************************************************
	// Attributs
	// ************************************************************************************************************

	private String _issn;
	private String _nom;

	// Attributs d'Association
	private HashMap<String, Parution> _parutions;
	
	
	// ************************************************************************************************************
	// Constructeur
	// ************************************************************************************************************

	/**
	 * Constructeur. 
	 * @param issn			numero ISSN du periodique
	 * @param nom			nom du periodique
	 */
	public Periodique(String issn, String nom) {
		
		this.setIssn(issn);
		this.setNom(nom);
		this.setParutions(new HashMap<String, Parution>());
		
	} // Fin Constructeur

	// ************************************************************************************************************
	// Methodes privees
	// ************************************************************************************************************
	
	// ------------------------------------------------------------------------------------------------------------
	// Affecteurs



	
	/**
	 * setter de l'attribut num d'ISSN.
	 * @param issn valeur a affecter a l'ISSN du periodique
	 */
	public void setIssn(String issn) {
		this._issn = issn;
	}

	/**
	 * setter de l'attribut nom.
	 * @param nom valeur a affecter au nom du periodique
	 */
	public void setNom(String nom){
		_nom = nom;
	}



	// ************************************************************************************************************
	// Methodes publiques
	// ************************************************************************************************************

	// ------------------------------------------------------------------------------------------------------------
	// Accesseurs
	
	/**
	 * Getter de l'ISSN.
	 * @return ISSN du periodique
	 */
	public String getIsbn() {
		return _issn;
	}

	/**
	 * Getter du nom.
	 * @return nom du periodique
	 */
	public String getNom() {
		return _nom;
	}
	
	public Parution getParution(String id) {
		return _parutions.get(id);
	}
	
	private void setParutions(HashMap<String, Parution> parutions) {
        _parutions = parutions;
}
	
	private void setParution(String idParution, Parution parution) {
        _parutions.put(idParution, parution);
}	

	
	public HashMap<String, Parution> getParutions() {
		return _parutions;
	}
	
	
	/*public int getNbParution(){
		if (getParutions().size() != 0) {
		return getParutions().size();
		}
		
		else return 0;
	}*/
	
	public int getNbParutions() {
		return _parutions.size();
	}
	
	public Parution ajouterParution(String idParution){
		Parution paru = new Parution (this, idParution);
		this.setParution(idParution, paru);
		setChanged();
		notifyObservers();
		return paru;
	}
	
}

	