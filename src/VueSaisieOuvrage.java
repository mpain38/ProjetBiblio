
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
/**
 * Fenetre de saisie d'un ouvrage 
 * Code du JFrame généré par Window Builder/Swing Designer.
 * @author IUT,  A.Culet 
 * @version 1.0
 */
public class VueSaisieOuvrage extends Vue {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIsbn ;
	private JTextField textFieldTitre;
	private JTextField textFieldDate;
	private JTextField textFieldEditeur;
	
	// pour que les boutons soient des attributs, il faut faire "convert local to field"
	private JButton buttonEnreg;
	private JButton buttonAnnuler;
	private JButton buttonAjouterMot;
	private JButton buttonRetirerMot;
	
	private JComboBox<String> comboBoxAuteur;
	private JComboBox<String> comboBoxMotCle;
	private JComboBox<String> comboBoxMotCleChoisis;	
	
	
	/**
	 * Create the frame.
	 */
	public VueSaisieOuvrage(Controleur controleur) {
		super(controleur);
		setTitle("Enregistrement d'un nouvel ouvrage");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(0, 0, 600, 500);
		contentPane = new JPanel();
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
			getControleur().fermerVue(VueSaisieOuvrage.this);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero ISBN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(71, 32, 89, 15);
		contentPane.add(lblNewLabel);
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setBounds(177, 32, 141, 19);
		contentPane.add(textFieldIsbn);
		textFieldIsbn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(99, 66, 61, 15);
		contentPane.add(lblNewLabel_1);
		
		textFieldTitre = new JTextField();
		textFieldTitre.setBounds(177, 65, 225, 19);
		contentPane.add(textFieldTitre);
		textFieldTitre.setColumns(10);		
		
		
		JLabel lblNewLabel_2 = new JLabel("Date edition (MM/AAAA)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(6, 217, 154, 33);
		contentPane.add(lblNewLabel_2);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(177, 224, 114, 19);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEditeur.setBounds(99, 150, 61, 71);
		contentPane.add(lblEditeur);
		
		textFieldEditeur = new JTextField();
		textFieldEditeur.setColumns(10);
		textFieldEditeur.setBounds(177, 176, 218, 19);
		contentPane.add(textFieldEditeur);
		
		comboBoxAuteur = new JComboBox<String>();
		comboBoxAuteur.setEditable(true);
		comboBoxAuteur.setBounds(177, 114, 244, 33);
		contentPane.add(comboBoxAuteur);
		
		comboBoxMotCle = new JComboBox<String>();
		comboBoxMotCle.setBounds(177, 271, 244, 19);
		contentPane.add(comboBoxMotCle);
		
		JLabel lblMotsClsDisponible = new JLabel("Mots cles disponibles");
		lblMotsClsDisponible.setBounds(64, 273, 114, 15);
		contentPane.add(lblMotsClsDisponible);
		
		JLabel lblAuteursPrsents = new JLabel("Auteur");
		lblAuteursPrsents.setBounds(99, 123, 61, 15);
		contentPane.add(lblAuteursPrsents);
		
		comboBoxMotCleChoisis = new JComboBox<String>();
		comboBoxMotCleChoisis.setBounds(177, 313, 244, 24);
		contentPane.add(comboBoxMotCleChoisis);
		
		JLabel lblMotsClsChoisis = new JLabel("Mots cles choisis");
		lblMotsClsChoisis.setBounds(80, 318, 98, 15);
		contentPane.add(lblMotsClsChoisis);
		

		//////////////////////Button/////////////////////////////////////
		
		
		buttonAjouterMot = new JButton("Ajouter mot");
		buttonAjouterMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonRetirerMot.setEnabled(true);
				String mot = (String)comboBoxMotCle.getSelectedItem();
				comboBoxMotCleChoisis.addItem(mot);
				comboBoxMotCle.removeItem(mot);
				if (comboBoxMotCleChoisis.getItemCount()!=0) buttonRetirerMot.setEnabled(true);				
			}
		});
		buttonAjouterMot.setBounds(440, 268, 117, 25);
		contentPane.add(buttonAjouterMot);
		
	
		
		
		buttonRetirerMot = new JButton("Retirer mot");
		buttonRetirerMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot = (String)comboBoxMotCleChoisis.getSelectedItem();
				comboBoxMotCleChoisis.removeItem(mot);
				comboBoxMotCle.addItem(mot);
			}
		});	
		buttonRetirerMot.setBounds(440, 313, 117, 25);
		contentPane.add(buttonRetirerMot);
		
		
		
		buttonEnreg = new JButton("Enregistrer");
		buttonEnreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = textFieldIsbn.getText();
				String titre = textFieldTitre.getText();
				String auteur = (String) comboBoxAuteur.getSelectedItem();
				String editeur = textFieldEditeur.getText();
				String dateEdition = textFieldDate.getText();
				HashSet<String> motCle = new HashSet<String>();
				for (int i=0; i < (comboBoxMotCleChoisis.getItemCount()); i++) {
					motCle.add((String)comboBoxMotCleChoisis.getItemAt(i));
				}
 				getControleur().nouvOuvrage(isbn, titre, auteur, editeur, dateEdition, motCle);
				}
		});
		buttonEnreg.setBounds(242, 394, 131, 25);
		contentPane.add(buttonEnreg);
		
		
		
		
		buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getControleur().fermerVue(VueSaisieOuvrage.this);}
		});
		buttonAnnuler.setBounds(412, 394, 127, 25);
		contentPane.add(buttonAnnuler);}
	
	
	
	public void alimente (HashMap<String, Auteur> _auteurs,HashMap<String, MotCle> _motsCles) {
	for (String nom : _auteurs.keySet()) {
		comboBoxAuteur.addItem(nom);	
		}
	for (String mot : _motsCles.keySet()) {
		comboBoxMotCle.addItem(mot);
		
		}
	}
	

	
	public void setEtat (int etat){
		switch (etat) {
		case initiale: {
			buttonEnreg.setEnabled(true);
			buttonAnnuler.setEnabled(true);
			break;
			}
		}
	}
}
