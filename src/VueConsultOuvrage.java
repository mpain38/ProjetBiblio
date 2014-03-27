
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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
 * Fenetre de consultation d'un periodique
 * Code du JFrame genere par Window Builder/Swing Designer.
 * @author IUT,  A.Culet 
 * @version 1.0
 */
public class VueConsultOuvrage extends Vue{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textAreaExemplaire;
	private JTextField txtIsbn;
	private JTextField txtTitre;
	private JTextField txtAuteur;
	private JTextField txtEditeur;
	private JTextField txtEdition;
	
	// pour que les boutons soient des attributs, il faut faire "convert local to field"
	private JButton buttonConsult;
	private JButton buttonFermer;
	
	// à ajouter car la vue est observatrice d'un ouvrage
	private Ouvrage _ouvrage ;

	
	/**
	 * Create the frame.
	 */
	public VueConsultOuvrage(Controleur controleur) {
		super (controleur);
		setTitle("Consultation d'un ouvrage");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(0, 0, 559, 487);
		contentPane = new JPanel();
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
			getControleur().fermerVue(VueConsultOuvrage.this);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn");
		lblNewLabel.setBounds(145, 31, 43, 17);
		contentPane.add(lblNewLabel);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(190, 30, 159, 19);
		contentPane.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		buttonConsult = new JButton("Consulter");
		buttonConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = txtIsbn.getText();
				// liaison de la vue avec l'objet observé
				setOuvrage (getControleur().rechOuvrageConsult(isbn));
		}});
		buttonConsult.setBounds(217, 56, 107, 25);
		contentPane.add(buttonConsult);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(117, 93, 300, 2);
		contentPane.add(separator);
		
		buttonFermer = new JButton("Fermer");
		buttonFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getControleur().fermerVue(VueConsultOuvrage.this);
			}
		});
		buttonFermer.setBounds(196, 401, 107, 25);
		contentPane.add(buttonFermer);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(39, 123, 70, 15);
		contentPane.add(lblTitre);
		
		txtTitre = new JTextField();
		txtTitre.setEditable(false);
		txtTitre.setBounds(117, 121, 232, 19);
		contentPane.add(txtTitre);
		txtTitre.setColumns(10);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(39, 163, 70, 15);
		contentPane.add(lblAuteur);
		
		txtAuteur = new JTextField();
		txtAuteur.setEditable(false);
		txtAuteur.setBounds(117, 161, 232, 19);
		contentPane.add(txtAuteur);
		txtAuteur.setColumns(10);
		
		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setBounds(39, 206, 70, 15);
		contentPane.add(lblEditeur);
		
		txtEditeur = new JTextField();
		txtEditeur.setEditable(false);
		txtEditeur.setBounds(117, 204, 232, 19);
		contentPane.add(txtEditeur);
		txtEditeur.setColumns(10);
		
		JLabel lblDateDdition = new JLabel("Date d'edition");
		lblDateDdition.setBounds(12, 252, 131, 15);
		contentPane.add(lblDateDdition);
		
		txtEdition = new JTextField();
		txtEdition.setEditable(false);
		txtEdition.setBounds(117, 250, 232, 19);
		contentPane.add(txtEdition);
		txtEdition.setColumns(10);
		
		JLabel lblExemplaire = new JLabel("Exemplaire");
		lblExemplaire.setBounds(12, 304, 97, 15);
		contentPane.add(lblExemplaire);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 291, 399, 96);
		contentPane.add(scrollPane);
		
		textAreaExemplaire = new JTextArea();
		textAreaExemplaire.setEditable(false);
		scrollPane.setColumnHeaderView(textAreaExemplaire);
	}
	

		private void setOuvrage(Ouvrage ouvrage) {
			 _ouvrage = ouvrage;
		}
		
		@SuppressWarnings("unused")
		private Ouvrage getOuvrage(Ouvrage ouvrage) {
			return  _ouvrage;
		}

	public void alimente(Ouvrage ouv) {
		txtTitre.setText(ouv.getTitre());
		txtAuteur.setText(ouv.getAuteur().getNomAut() + " " + ouv.getAuteur().getPrenomAut());
		txtEditeur.setText(ouv.getEditeur());
		txtEdition.setText(ESDate.ecrireDate (ouv.getDateEdition()));
		textAreaExemplaire.setText("");
		for (Exemplaire exemplaire : ouv.getExemplaires()) {
			  textAreaExemplaire.append( "numero " + String.valueOf(exemplaire.getNumero()) 
			 + " : " + exemplaire.libStatut() + "\n");
		}
	}

}

