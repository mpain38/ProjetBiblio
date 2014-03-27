
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Classe controleur et application (système)
 * @author IUT,   A. Culet
 * @version 1.0 
 */


public class Controleur implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//private static final String  = null;

	/**
	 * La classe Controleur est unique pour tous les cas d'utilisation
	 * Elle est egalement la classe "application" qui gere l'ensemble des objets de l'appli
	 */	
	// ************************************************************************************************************
		// Attributs
		// ************************************************************************************************************
	
		// Attributs d'Association
		// Ensemble des ouvrages de la bibliothèque
		private HashMap<String, Ouvrage> _ouvrages;
		private HashMap<String, Auteur> _auteurs;
		private HashMap<String, MotCle> _motsCles;
		private HashMap<String, Parution> _parutions;
		private HashMap<String, Periodique> _periodiques;	
		private HashMap<String, Article> _articles;	
		
		
		// la liste des vues. La 1ere est toujours la vue Menu Principal. La dernière est la vue active.
		private LinkedList<Vue> _vues;
		
		
		// ************************************************************************************************************
		// Constructeur
		// ************************************************************************************************************

		public Controleur() {
			this.setOuvrages(new HashMap<String, Ouvrage>());
			this.setAuteurs(new HashMap<String, Auteur>());
			this.setMotsCles(new HashMap<String, MotCle>());
			this.setPeriodiques(new HashMap<String, Periodique>());	
			this.setParutions(new HashMap<String, Parution>());
			this.setArticles(new HashMap<String, Article>());
			_vues = new LinkedList<Vue>();
		} // Fin Controleur

		// ************************************************************************************************************
		// Méthodes privées
		// ************************************************************************************************************

		// ------------------------------------------------------------------------------------------------------------
		// Affecteurs
		
		/**
		 * Ajoute un ouvrage à l'ensemble des ouvrages de la bibliothèque.
		 * @param ouvrage 	Ouvrage à ajouter
		 * @param isbn 	code ISBN de cet ouvrage
		 */
		private void setOuvrage(Ouvrage ouvrage, String isbn) {
			this.getOuvrages().put(isbn, ouvrage);
		} // Fin setOuvrage

		/**
		 * @param ouvrages hashtable d'ouvrages à affecter
		 */
		private void setOuvrages(HashMap<String, Ouvrage> ouvrages) {
			_ouvrages = ouvrages;
		}// Fin setOuvrages
		
		private void setArticle(Article article, String titre) {
			this.getArticles().put(titre, article);
		} // Fin setOuvrage
 
		private void setArticles(HashMap<String, Article> articles) {
			_articles = articles;
		}// Fin setOuvrages
		
		private void setPeriodique(Periodique periodique, String issn) {
			this.getPeriodiques().put(issn, periodique);
		} // Fin setOuvrageouvrages
		
		private void setPeriodiques(HashMap<String, Periodique> periodiques) {
			_periodiques = periodiques;
		}// Fin setOuvrages
		
		private void setAuteurs(HashMap<String,Auteur> auteurs) {
			_auteurs=auteurs;
		}// Fin setOuvrages
		
		private void setParutions(HashMap<String, Parution> parutions) {
			_parutions= parutions;
		}// Fin setOuvrages
		
		private void setParution ( Parution paru, String idParu) {
			this.getParutions().put(idParu, paru);
		}
		
		private void setAuteur(Auteur auteur, String nom) {
			this.getAuteurs().put(nom, auteur);
		} // Fin setOuvrage
		
		
		private void setMotsCles(HashMap<String, MotCle> motsCles) {
			_motsCles = motsCles;
		}// Fin setOuvrages
		
		/**
		 * ajoute ou enlève la vue active courante de la liste des vues
		 * @param vue  la vue à affecter
		 */
		 private void setVue(Vue vue) {
				_vues.addLast(vue);
		 }
		 private void removeVue() {
				_vues.removeLast();
		 }
		
		/*
		// ------------------------------------------------------------------------------------------------------------
		// Accesseurs
		
		/**
		 * @return ensemble des ouvrages de la bibliothèque
		 */
		private HashMap<String, Ouvrage> getOuvrages() {
			return _ouvrages;
		}// Fin getOuvrages
		
		private HashMap<String, Parution> getParutions() {
			return _parutions;
		}// Fin getOuvrages
		
		private HashMap<String, Periodique> getPeriodiques() {
			return _periodiques;
		}// Fin getOuvrages
		
		private HashMap<String, Article> getArticles() {
			return _articles;
		}// Fin getOuvrages
		


		/**
		 * Accès à un ouvrage par son numéro ISBN
		 * @param isbn 	le code ISBN de l'ouvrage cherché
		 * @return l'ouvrage qui a l'ISBN indiqué
		 */
		private Ouvrage getOuvrage(String isbn) {
			return this.getOuvrages().get(isbn);
		} // Fin getOuvrage
		
		private Periodique getPeriodique(String issn) {
			return this.getPeriodiques().get(issn);
		} // Fin getPeriodique
		
		private Parution getParution(String idParution) {
			return this.getParutions().get(idParution);
		} // Fin getPeriodique
		

		/**
		 * @return la vue active courante 
		 */
		private Vue getVue() {
			return (Vue)_vues.getLast() ;
		}
		/**
		 * @return la vue Menu Principal 
		 */
		private VueMenuBiblio getVueMenu() {
			return (VueMenuBiblio)_vues.getFirst() ;
		}
		
		public Auteur getAuteur(String nom) {
			return _auteurs.get(nom);
		}
		
		public HashMap<String, Auteur> getAuteurs(){
			return _auteurs;
		}
		
		public MotCle getMotCle(String mot) {
			return _motsCles.get(mot);
		}
		
		public HashMap<String, MotCle> getMotscles(){
			return _motsCles;
		}		
		/*
		// ************************************************************************************************************
		// Methodes publiques de creation et affichage des fenetres de l'application et fermeture
		// ************************************************************************************************************
		/**
		 * Creation et affichage de la fenetre principale de l'application. 
		 * Elle propose le menu de l'appli
		 */
		
		public void menuBiblio() {
			try {this.setVue(new VueMenuBiblio(this));
				this.getVueMenu().setVisible(true); 	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		/**
		 * Cas d'utilisation : saisie d'un exemplaire d'ouvrage
		 * Création et affichage de la fenêtre de saisie d'un exemplaire d'ouvrage
		 */
		public void saisirExemplaire() {
			try {this.setVue(new VueSaisieExemplaire(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
			// la vue courante est VueSaisieExemplaire
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * Cas d'utilisation : saisie d'un exemplaire d'ouvrage
		 * Création et affichage de la fenêtre de saisie d'un exemplaire d'ouvrage
		 */
		public void rechercheAuteur() {
			try {this.setVue(new VueRechercheAuteur(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
				((VueRechercheAuteur) this.getVue()).alimente(this.getAuteurs());
			// la vue courante est VueSaisieExemplaire
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		public void rechercheMotCle() {
			try {this.setVue(new VueRechercheMotCle(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
				((VueRechercheMotCle) this.getVue()).alimente(this.getMotscles());
			// la vue courante est VueSaisieExemplaire
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}			
		/**
		 * cas d'utilisation : consultation d'un ouvrage
		 * Création et affichage de la fenêtre de consultation d'un ouvrage
		 */
		public void ConsultOuvrage() {
			try {this.setVue(new VueConsultOuvrage(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
			// la vue courante est VueSaisieExemplaire
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void consultPeriod() {
			try {this.setVue(new VueConsultPeriodique(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
			// la vue courante est VueSaisieExemplaire
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * cas d'utilisation : saisie d'un ouvrage
		 * Création et affichage de la fenêtre de saisie d'un ouvrage
		 */
		public void saisirOuvrage() {
			try {this.setVue(new VueSaisieOuvrage(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
				((VueSaisieOuvrage) this.getVue()).alimente(this.getAuteurs(),this.getMotscles());
			// la vue courante est VueSaisieOuvrage
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		

		
		/**
		 * cas d'utilisation : saisie d'un périodique
		 * Création et affichage de la fenêtre de saisie d'un périodique
		 */
		public void saisirPeriodique() {
			try {this.setVue(new VueSaisiePeriodique(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
			// la vue courante est VueSaisieOuvrage
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		public void saisirParution() {
			try {this.setVue(new VueSaisieParution(this));
			// le Menu est caché
				this.getVueMenu().setVisible(false); 
				((VueSaisieParution) this.getVue()).alimente01(this.getAuteurs(),this.getMotscles());
			// la vue courante est VueSaisieOuvrage
				this.getVue().setEtat(Vue.initiale);
				this.getVue().setVisible(true);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		
		/**
		 * fermeture de la fenêtre vue
		 * lors de la fermeture de la fenêtre principale de l'application sauvegarde des objets sérialisés 
		 */
		public void fermerVue (Vue vue) {
			//la vue est détruite et n'est plus la vue active courante	
			
			if (vue instanceof VueMenuBiblio ) {
			// Quitte l'aplication. Sauvegarde les objets du modèle
				vue.dispose();
				this.removeVue();this.sauve();
				System.exit(0);
				}
			else {
			// le Menu est rendu de nouveau visible
				vue.dispose();
				this.removeVue();
				this.getVueMenu().setVisible(true); 
			}
		}
		
		/*
		// ************************************************************************************************************
		// Opérations liées à la sérialisation des objets de l'application
		// ************************************************************************************************************
		/**
		 *  restauration des objets de l'application
		 */
		public Controleur restaure() {
			try {
				this.lectureLignesFichier();
				FileInputStream fichier = new FileInputStream("Fsauv.ser");
				@SuppressWarnings("resource")
				ObjectInputStream in = new ObjectInputStream(fichier);
				return((Controleur) in.readObject());
			} catch (Exception e) {
				new Message("Pbs de Restauration ou fichier non encore cree");
				return this;
			} 
		}
		/**
		 *  sauvegarde des objets de l'application
		 */
		private void sauve() {
			try {
				FileOutputStream f = new FileOutputStream("Fsauv.ser");
				@SuppressWarnings("resource")
				ObjectOutputStream out = new ObjectOutputStream(f);
				out.writeObject(this);
				this.lectureLignesFichier();
			} catch (Exception e) {
				new Message("Pb de Sauvegarde dans le fichier");
			}
		}
		// ************************************************************************************************************
		// Opérations liées à l'application en réponse à une action de l'utilisateur dans une vue
		// ************************************************************************************************************

		/**
		 * Accès à un ouvrage par son numéro ISBN
		 * Invoqué VueSaisieExemplaire
		 * @param isbn 	le code ISBN de l'ouvrage cherché
		 * @return l'ouvrage qui a l'ISBN indiqué ou null
		 * affiche un message d'erreur si l'ouvrage n'est pas trouvé
		 */
		public void rechParAuteur(String auteur) {
			Auteur aut = this.getAuteur(auteur);
			// le controleur modifie l'etat de la vue
			this.getVue().setEtat(Vue.inter1);	
		// le controleur demande à la vue d'afficher les infos de l'ouvrage
			((VueRechercheAuteur)this.getVue()).alimente02(aut);
			//return aut;
		}
		
		public void rechParMotCle(String motcle) {
			MotCle mot = this.getMotCle(motcle);
			// le controleur modifie l'etat de la vue
			this.getVue().setEtat(Vue.inter1);	
		// le controleur demande à la vue d'afficher les infos de l'ouvrage
			if (mot.getArticles() != null) {
			((VueRechercheMotCle)this.getVue()).alimente02(mot);
			}
			//return aut;
		}
		
		
		public Ouvrage rechOuvrage(String isbn) {
			Ouvrage ouv = this.getOuvrage(isbn);			
			if (ouv == null) {
				new Message("Ouvrage inconnu");
			}
			else {
				// le contrôleur modifie l'état de la vue
					this.getVue().setEtat(Vue.inter1);	
				// le controleur demande à la vue d'afficher les infos de l'ouvrage
					((VueSaisieExemplaire)this.getVue()).alimente(ouv);					
					ouv.addObserver((VueSaisieExemplaire)(this.getVue()));				
					}	
			return ouv;
		} // Fin rechOuvrage
		
		public Ouvrage rechOuvrageConsult(String isbn) {
			Ouvrage ouv = this.getOuvrage(isbn);			
			if (ouv == null) {
				new Message("Ouvrage inconnu");
			}
			else {
				// le contrôleur modifie l'état de la vue
					this.getVue().setEtat(Vue.inter1);	
				// le controleur demande à la vue d'afficher les infos de l'ouvrage
					((VueConsultOuvrage)this.getVue()).alimente(ouv);			
					}	
			return ouv;
		} // Fin rechOuvrageConsult
		
		public Periodique rechPeriodique(String issn) {
			Periodique period = this.getPeriodique(issn);			
			if (period == null) {
				new Message("Periodique inconnu");
			}
			else {
				// le contrôleur modifie l'état de la vue
					this.getVue().setEtat(Vue.inter1);	
				// le controleur demande à la vue d'afficher les infos de l'ouvrage
					((VueSaisieParution)this.getVue()).alimente(period);					
					period.addObserver((VueSaisieParution)(this.getVue()));				
					}	
			return period;
		} // Fin rechOuvrage
		
		
		


		
		public Parution rechParution02(String id) {
			Parution paru = this.getParution(id);			
			if (paru == null) {
				new Message("Parution inconnu");
			}
			else {
				this.getVue().setEtat(Vue.inter1);

			}
			return paru;
		} 
		
		
		public Periodique rechPeriodiqueConsult(String issn) {
			Periodique period = this.getPeriodique(issn);			
			if (period == null) {
				new Message("Periodique inconnu");
			}
			else {
				// le contrôleur modifie l'état de la vue
					this.getVue().setEtat(Vue.inter1);	
				// le controleur demande à la vue d'afficher les infos de l'ouvrage
					((VueConsultPeriodique)this.getVue()).alimente(period);					
					//period.addObserver((VueConsultPeriodique)(this.getVue()));				
					}	
			return period;
		} // Fin rechOuvrage
		

		
		/**
		 * Création d'un exemplaire d'ouvrage 
		 * Invoqué dans VueSaisieExemplaire
		 * @param ouv l'ouvrage  dateRecep la date de réception de l'exemplaire	
		 * affiche un message de confirmation après l'enregistrement ou un message d'erreur 
		 */
		public void nouvExemplaire(Ouvrage ouv, String dateReception, String statut) {
			// vérification de la présence de la date et de son format
			if (dateReception.length() == 0 ){
					new Message("La date de reception est obligatoire");
					}
			else {
				GregorianCalendar date = ESDate.lireDate (dateReception);
				if (date == null) {
					new Message("Le format de la date est incorrect");
					}
				else {
					int statutEx;
					if (statut == "empruntable") {
						statutEx = Exemplaire.EMPRUNTABLE ; }
					else {
						statutEx = Exemplaire.EN_CONSULTATION ; }
			// demande d'ajout de l'exemplaire
					Exemplaire exemplaire = ouv.ajouterExemplaire(date, statutEx);
			// l'opération s'est bien passée
					if (exemplaire != null) {
			// le contrôleur modifie l'état de la vue
						this.getVue().setEtat(Vue.inter1);
			new Message("Exemplaire enregistre");
					}
					else {
						new Message("Date de Reception incorrecte / A� la date d'Edition.");
					}
				}
			}
		} // Fin nouvExemplaire
		
		/**
		 * Création d'un  d'ouvrage 
		 * Invoqué dans VueSaisieOuvrage
		 * @param  dateEdition la date d'édition de l'ouvrage
		 * affiche un message de confirmation après l'enregistrement ou un message d'erreur 
		 */
		public void nouvOuvrage(String isbn, String titre, String auteur, String editeur, String dateEdition, HashSet<String> motCle) {
			// vérification de la présence des infos obligatoires et du format de la date
			if ((isbn.length() == 0) || (titre.length() == 0)
					|| (editeur.length() == 0 )|| (dateEdition.length() == 0 )){
					new Message("Tous les champs sont obligatoires");
					}
			else if (isbn.length() != 13) {
				new Message("L'ISBN doit comporter 13 chiffres");
			}
			else {
				GregorianCalendar date = ESDate.lireDate (dateEdition);
				if (date == null) {
					new Message("Le format de la date est incorrect");
					}
				else if (this.getOuvrage(isbn )== null) {
					if (getAuteur(auteur) == null) {
						Auteur aut = new Auteur(auteur.split(" ")[0],auteur.split(" ")[1]);
						this.setAuteur(aut,auteur);					
					}
					
					Auteur aut = getAuteur(auteur);
					HashSet<MotCle> mot = new HashSet <MotCle>();
					for (String motC : motCle) {
						mot.add(getMotCle(motC));
					}
				// Instanciation de l'ouvrage
					Ouvrage ouvrage = new Ouvrage(isbn, titre, aut, editeur, date, mot);
				// Ajout de l'ouvrage dans l'ensemble des ouvrages de la bibliothèque
					this.setOuvrage(ouvrage, isbn);
					
					new Message("Ouvrage enregistre");
					this.fermerVue (this.getVue());
					} 
					else {
						new Message("Ouvrage deja� present");
					}
				}
			}
		
		
		public void nouvParution01(Periodique p, String idParution) {
			// vérification de la présence de la date et de son format
			if (idParution.length() == 0){
					new Message("L'identite de la parution est obligatoire");
					}
			else {
				if (p.getParution(idParution) == null) {

					Parution paru = p.ajouterParution(idParution);
			// l'opération s'est bien passée
					if (paru != null) {
			// le contrôleur modifie l'état de la vue
						this.getVue().setEtat(Vue.finale);
						this.setParution(paru, idParution);
						((VueSaisieParution)this.getVue()).alimenteArticle(p);					
						paru.addObserver((VueSaisieParution)(this.getVue()));
			new Message("Parution enregistr�");
					}
					else {
						new Message("erreur dans l'enregistrement");
					}
				}
				else {
				new Message ("Parution deja existante");
				}
			}
			
			
		} // Fin nouvExemplaire
		
		
		
		
		

		public void nouvPeriodique(String issn, String nom) {
			// vérification de la présence des infos obligatoires et du format de la date
			if ((issn.length() == 0) || (nom.length() == 0)){
					new Message("Tous les champs sont obligatoires");
					}
			else {
				if (this.getPeriodique(issn)== null) {
				// Instanciation de l'ouvrage
					Periodique periodique = new Periodique(issn, nom);
				// Ajout de l'ouvrage dans l'ensemble des ouvrages de la bibliothèque
					this.setPeriodique(periodique, issn);
					
					new Message("Periodique enregistre");
					this.fermerVue (this.getVue());
					} 
					else {
						new Message("Periodique deja� present");
					}
				}
			}
		
		
		
		
		/**
		 * Création d'une parution d'un périodique 
		 * Invoqué dans VueSaisieParution 
		 */
		public void nouvArticle(Parution paru, String titre, String auteur, String pageDeb, HashSet<String> motCle) {
			// vérification de la présence de la date et de son format
			if ((titre.length() == 0)){
						new Message("Tous les champs sont obligatoires");
						}
				else {
						if (getAuteur(auteur) == null) {
							Auteur aut = new Auteur(auteur.split(" ")[0],auteur.split(" ")[1]);
							this.setAuteur(aut,auteur);					
						}
						
						Auteur aut = getAuteur(auteur);					
						HashSet<MotCle> mot = new HashSet <MotCle>();
						for (String motC : motCle) {
							mot.add(getMotCle(motC));
						}
						Article art = paru.ajouterArticle(titre, aut, pageDeb, mot);
						
						
					// Ajout de l'ouvrage dans l'ensemble des ouvrages de la bibliothèque
						if (art != null) {
						this.setArticle(art, titre);
						
						new Message("Article enregistr�");
						} 
						else {
							new Message("Article d�j� pr�sent");
						}
				}

		} // Fin nouvExemplaire	
		
		

public void lectureLignesFichier(){

	try  {
		BufferedReader in = new BufferedReader(new FileReader("ListeAutorite.txt"));
		String ligne;
		while ((ligne= in.readLine()) != null)  {
			MotCle mot = new MotCle(ligne);
			_motsCles.put(ligne, mot);
			
		}
		in.close();
	}

	catch (IOException e) {
		System.out.println("$$$$$ PB de Lecture dans le fichier XXXXX ");
		System.out.println();
	}

}
}

