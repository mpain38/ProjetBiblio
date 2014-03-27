
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JSeparator;

import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
/**
 * Fenetre de recherche d'ouvrage ou d'article a partir d'un auteur
 * Code du JFrame genere par Window Builder/Swing Designer.
 * @author IUT,  A.Culet 
 * @version 1.0
 */
public class VueRechercheMotCle extends Vue {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JTextArea textAreaArticles;
	private JTextArea textAreaOuvrages;
	
	// pour que les boutons soient des attributs, il faut faire "convert local to field"
	private JButton buttonOk;
	private JButton buttonNouv;
	private JButton buttonTerminer;
	
	private JComboBox<String> comboBoxMotCle;

	
	/**
	 * Create the frame.
	 */
	public VueRechercheMotCle(Controleur controleur) {
		super (controleur);
		setTitle("Recherche par mot cl�");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(0, 0, 592, 517);
		contentPane = new JPanel();
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
			getControleur().fermerVue(VueRechercheMotCle.this);
			}
		
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxMotCle = new JComboBox<String>();
		comboBoxMotCle.setBounds(177, 30, 183, 24);
		contentPane.add(comboBoxMotCle);
		
		JLabel lblChoisirUnMotCle = new JLabel("Choisir un mot cle :");
		lblChoisirUnMotCle.setBounds(18, 35, 141, 15);
		contentPane.add(lblChoisirUnMotCle);

		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 150, 300, 2);
		contentPane.add(separator);
		
		JLabel lblOuvrageCorrespondant = new JLabel("Ouvrage(s) correspondant(s)");
		lblOuvrageCorrespondant.setBounds(18, 227, 213, 15);
		contentPane.add(lblOuvrageCorrespondant);

		
		JLabel lblNewLabel = new JLabel("Article(s) correspondant(s)");
		lblNewLabel.setBounds(18, 351, 213, 15);
		contentPane.add(lblNewLabel);
		
		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot = (String)comboBoxMotCle.getSelectedItem();
				getControleur().rechParMotCle(mot);
				buttonOk.setEnabled(false);
				}
		});
		buttonOk.setBounds(200, 90, 117, 25);
		contentPane.add(buttonOk);
		
		buttonNouv = new JButton("Nouvelle recherche");
		buttonNouv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaOuvrages.getDocument().remove(0, textAreaOuvrages.getDocument().getLength());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				try {
					textAreaArticles.getDocument().remove(0, textAreaArticles.getDocument().getLength());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				buttonOk.setEnabled(true);	
				}
		});
		buttonNouv.setBounds(284, 444, 141, 23);
		contentPane.add(buttonNouv);
		
		buttonTerminer = new JButton("Terminer");
		buttonTerminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getControleur().fermerVue(VueRechercheMotCle.this);}
		});
		buttonTerminer.setBounds(449, 443, 117, 25);
		contentPane.add(buttonTerminer);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 178, 246, 101);
		contentPane.add(scrollPane);
		
		textAreaOuvrages = new JTextArea();
		textAreaOuvrages.setEditable(false);
		scrollPane.setViewportView(textAreaOuvrages);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(239, 312, 248, 88);
		contentPane.add(scrollPane_1);
		
		textAreaArticles = new JTextArea();
		textAreaArticles.setEditable(false);
		scrollPane_1.setViewportView(textAreaArticles);
		
	}	
		
	public void alimente(HashMap<String, MotCle> _motsCles) {
		for (String mot : _motsCles.keySet()) {
			comboBoxMotCle.addItem(mot);	
		}
	}

		
		public void alimente02(MotCle mot) {
			HashSet <Ouvrage> ouvrages = mot.getOuvrages();
			for (Ouvrage ouv : ouvrages) {
				textAreaOuvrages.append("ISBN : " + ouv.getIsbn() + "\n" + "Titre : " + ouv.getTitre() + "\n");
					for (Exemplaire exemplaire : ouv.getExemplaires()) {
						  textAreaOuvrages.append(String.valueOf("Exemplaires num�ro " +
						exemplaire.getNumero()) + " : " + exemplaire.libStatut() + "\n");
						  }
					textAreaOuvrages.append("\n" + "------------------------------------------" + "\n" + "\n");

			}
			HashSet <Article> articles = mot.getArticles();
			for (Article art : articles) {
				textAreaArticles.append("Nom p�riodique : " + art.getParution().getPeriodique().getNom() + "\n" 
						+ "ID parution : " + art.getParution().getidparution() + "\n"
						+ "Titre de l'article : '" + art.getTitre() + "' \n" + "\n");
			}			
		}

		

}
