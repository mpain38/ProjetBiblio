
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JSeparator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.SystemColor;
/**
 * Fenêtre de saisie d'un exemplaire d'un ouvrage avec la vue des exemplaires de l'ouvrage
 * Code du JFrame généré par Window Builder/Swing Designer.
 * @author IUT,  A.Culet 
 * @version 1.0
 */
public class VueSaisieParution extends Vue implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIssn;
	private JTextField textFieldTNom;
	private JTextField textFieldIDparution;
	private JTextField textFieldTitre;
	private JTextField textFieldPageDebut;
	
	// pour que les boutons soient des attributs, il faut faire "convert local to field"
	private JButton buttonRech;
	private JButton buttonEnreg;
	private JButton buttonAnnuler;
	private JButton buttonFermer;
	private JButton buttonEnregistrerArticle;
	private JButton buttonAjouterMot;
	private JButton buttonRetirerMot;
	
	private JComboBox<String> comboBoxAuteurs;
	private JComboBox<String> comboBoxMotsClesDispos;
	private JComboBox<String> comboBoxMotsClesChoisis;
	private JTextArea textAreaParution;
	
	// à ajouter car la vue est observatrice d'un periodique
	private Periodique _periodique ;	
	private Parution _parution;
	private JLabel lblAjoutDarticle;
	
	/**
	 * Create the frame.
	 */
	public VueSaisieParution(Controleur controleur) {
		super (controleur);
		setTitle("Enregistrement d'une nouvelle parution d'un periodique");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(0, 0, 626, 674);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
			getControleur().fermerVue(VueSaisieParution.this);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issn");
		lblNewLabel.setBounds(145, 31, 43, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID parution");
		lblNewLabel_1.setBounds(103, 115, 77, 15);
		contentPane.add(lblNewLabel_1);
		
		textFieldIssn = new JTextField();
		textFieldIssn.setBounds(189, 30, 159, 19);
		contentPane.add(textFieldIssn);
		textFieldIssn.setColumns(10);
		
		textFieldIDparution = new JTextField();
		textFieldIDparution.setEditable(false);
		textFieldIDparution.setText("");
		textFieldIDparution.setBounds(189, 114, 114, 19);
		contentPane.add(textFieldIDparution);
		textFieldIDparution.setColumns(10);
	
		
		JLabel lblNewLabel_2 = new JLabel("Nom periodique");
		lblNewLabel_2.setBounds(81, 85, 107, 15);
		contentPane.add(lblNewLabel_2);
		
		textFieldTNom = new JTextField();
		textFieldTNom.setEditable(false);
		textFieldTNom.setBounds(189, 83, 247, 19);
		contentPane.add(textFieldTNom);
		textFieldTNom.setColumns(10);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(110, 321, 70, 15);
		contentPane.add(lblAuteur);
		
		comboBoxAuteurs = new JComboBox<String>();
		comboBoxAuteurs.setToolTipText("");
		comboBoxAuteurs.setBounds(189, 290, 256, 76);
		contentPane.add(comboBoxAuteurs);
		
		JLabel lblMotsCls = new JLabel("Choisir les mots cles correspondant");
		lblMotsCls.setBounds(10, 406, 178, 15);
		contentPane.add(lblMotsCls);
		
		comboBoxMotsClesDispos = new JComboBox<String>();
		comboBoxMotsClesDispos.setBounds(189, 391, 114, 44);
		contentPane.add(comboBoxMotsClesDispos);
		
		comboBoxMotsClesChoisis = new JComboBox<String>();
		comboBoxMotsClesChoisis.setBounds(481, 391, 126, 44);
		contentPane.add(comboBoxMotsClesChoisis);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(161, 163, 300, 2);
		contentPane.add(separator);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(125, 215, 51, 15);
		contentPane.add(lblTitre);
		
		textFieldTitre = new JTextField();
		textFieldTitre.setEditable(false);
		textFieldTitre.setBounds(189, 212, 114, 19);
		contentPane.add(textFieldTitre);
		textFieldTitre.setColumns(10);
		
		JLabel lblPageDeDbut = new JLabel("Page de debut");
		lblPageDeDbut.setBounds(91, 256, 89, 15);
		contentPane.add(lblPageDeDbut);
		
		textFieldPageDebut = new JTextField();
		textFieldPageDebut.setEditable(false);
		textFieldPageDebut.setBounds(189, 253, 114, 19);
		contentPane.add(textFieldPageDebut);
		textFieldPageDebut.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(113, 482, 399, 96);
		contentPane.add(scrollPane);
		
		textAreaParution = new JTextArea();
		textAreaParution.setEditable(false);
		scrollPane.setColumnHeaderView(textAreaParution);
		
		//////////////////////Button/////////////////////////////////////
		
		
		buttonAjouterMot = new JButton("Ajouter mot");
		buttonAjouterMot.setEnabled(false);
		buttonAjouterMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonRetirerMot.setEnabled(true);
				String mot = (String)comboBoxMotsClesDispos.getSelectedItem();
				comboBoxMotsClesChoisis.addItem(mot);
				comboBoxMotsClesDispos.removeItem(mot);			
			}
		});
		buttonAjouterMot.setBounds(322, 388, 117, 18);
		contentPane.add(buttonAjouterMot);
		
		
		buttonRetirerMot = new JButton("Retirer mot");
		buttonRetirerMot.setEnabled(false);
		buttonRetirerMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot = (String)comboBoxMotsClesChoisis.getSelectedItem();
				comboBoxMotsClesChoisis.removeItem(mot);
				comboBoxMotsClesDispos.addItem(mot);
			}
		});	
		buttonRetirerMot.setBounds(322, 417, 117, 18);
		contentPane.add(buttonRetirerMot);
		
		
		buttonRech = new JButton("Rechercher");
		buttonRech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String issn = textFieldIssn.getText();
				// liaison de la vue avec l'objet observe
				setPeriodique (getControleur().rechPeriodique(issn));
		}});
		buttonRech.setBounds(358, 27, 107, 25);
		contentPane.add(buttonRech);
		
		
		
		buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControleur().fermerVue(VueSaisieParution.this);}
		});
		buttonAnnuler.setBounds(500, 589, 107, 25);
		contentPane.add(buttonAnnuler);
		
		
		
		buttonEnreg = new JButton("Enregistrer");
		buttonEnreg.setEnabled(false);
		buttonEnreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String issn = textFieldIssn.getText();
				Periodique p = getControleur().rechPeriodique(issn);
				String idParution = textFieldIDparution.getText();
				getControleur().nouvParution01(p, idParution);
				setParution (getControleur().rechParution02(idParution));
				}
		});
		buttonEnreg.setBounds(357, 115, 107, 25);
		contentPane.add(buttonEnreg);
		
		
		
		buttonEnregistrerArticle = new JButton("Enregistrer article");
		buttonEnregistrerArticle.setEnabled(false);
		buttonEnregistrerArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = textFieldTitre.getText();
				String auteur = (String) comboBoxAuteurs.getSelectedItem();
				String pageDeb = textFieldPageDebut.getText();
				HashSet<String> motCle = new HashSet<String>();
				for (int i = 0; i < (comboBoxMotsClesChoisis.getItemCount()); i++) {
					motCle.add((String)comboBoxMotsClesChoisis.getItemAt(i));
				}
				getControleur().nouvArticle(getParution(), titre, auteur, pageDeb, motCle);
				comboBoxMotsClesChoisis.removeAllItems();
				}
		});		
		buttonEnregistrerArticle.setBounds(227, 446, 173, 25);
		contentPane.add(buttonEnregistrerArticle);
		
		
		buttonFermer = new JButton("Fermer");
		buttonFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getControleur().fermerVue(VueSaisieParution.this);
			}
		});
		buttonFermer.setBounds(371, 589, 107, 25);
		contentPane.add(buttonFermer);
		
		lblAjoutDarticle = new JLabel("Ajout d'article :");
		lblAjoutDarticle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAjoutDarticle.setBounds(211, 172, 114, 14);
		contentPane.add(lblAjoutDarticle);
	}
	
	

		
		private Periodique getPeriodique() {
			return _periodique;
		}
		private void setPeriodique(Periodique period) {
			 _periodique = period;
		}
		
		private Parution getParution() {
			return _parution;
		}
		
		private void setParution(Parution paru) {
			 _parution = paru;
		}
		
		/**
		 * alimentation des composants d'affichage en consultant directement le periodique
		 */
		public void alimente(Periodique period) {
			textFieldTNom.setText(period.getNom());
		}		
		
		
		
		public void alimente01 (HashMap<String, Auteur> _auteurs,HashMap<String, MotCle> _motsCles) {
			for (String nom : _auteurs.keySet()) {
				comboBoxAuteurs.addItem(nom);	
				}
			for (String mot : _motsCles.keySet()) {
				comboBoxMotsClesDispos.addItem(mot);
				
				}
			}
		
		
		
		public void alimenteArticle(Periodique per) {
			String idParution = textFieldIDparution.getText();
			textAreaParution.setFont(new Font("Serif", Font.ITALIC, 16));
		textAreaParution.setText("Article(s) enregistr�(s) :"
				+ "\n");
		
		for (Article article : per.getParution(idParution).getArticles02()) {
			  textAreaParution.append(article.getTitre() + ", page n� " + article.getPage()  + "\n");
		}
	}
		
		public void update (Observable obs, Object arg) {
			
			this.alimenteArticle(this.getPeriodique());
			this.repaint();
		}
		
		/**
		 * definition des etats de la fenetre
		 */
		public void setEtat (int etat){
			switch (etat) {
			case initiale: {
				buttonRech.setEnabled(true);
				buttonEnreg.setEnabled(false);
				buttonAnnuler.setEnabled(true);
				buttonFermer.setEnabled(false);
				break;
				}
			case inter1: {
				buttonRech.setEnabled(false);
				buttonEnreg.setEnabled(true);
				textFieldIssn.setEditable(false);
				textFieldIDparution.setEditable(true);
				break;
				}
			case finale: {
				buttonEnreg.setEnabled(false);
				buttonEnregistrerArticle.setEnabled(true);				
				buttonAnnuler.setEnabled(false);
				buttonFermer.setEnabled(true);
				textFieldIDparution.setEditable(true);
				textFieldTitre.setEditable(true);
				textFieldPageDebut.setEditable(true);
				comboBoxAuteurs.setEditable(true);
				buttonAjouterMot.setEnabled(true);
				buttonRetirerMot.setEnabled(true);
				break;
				}
			}
		}
}
