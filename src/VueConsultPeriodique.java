
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
/**
 * Fenetre de consultation d'un periodique
 * Code du JFrame genere par Window Builder/Swing Designer.
 * @author IUT,  A.Culet 
 * @version 1.0
 */
public class VueConsultPeriodique extends Vue {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIssn;
	private JTextField txtNom;
	private JTextField txtNbParu;
	
	// pour que les boutons soient des attributs, il faut faire "convert local to field"
	private JButton buttonConsult;
	private JButton buttonFermer;
	
	// A  ajouter car la vue est observatrice d'un ouvrage
	private Periodique _periodique;
	
	/**
	 * Create the frame.
	 */
	public VueConsultPeriodique(Controleur controleur) {
		super (controleur);
		setTitle("Consultation d'un ouvrage");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(0, 0, 505, 356);
		contentPane = new JPanel();
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
			getControleur().fermerVue(VueConsultPeriodique.this);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issn");
		lblNewLabel.setBounds(145, 31, 43, 17);
		contentPane.add(lblNewLabel);
		
		txtIssn = new JTextField();
		txtIssn.setBounds(190, 30, 159, 19);
		contentPane.add(txtIssn);
		txtIssn.setColumns(10);
		
		buttonConsult = new JButton("Consulter");
		buttonConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String issn = txtIssn.getText();
				// liaison de la vue avec l'objet observe
				setPeriodique (getControleur().rechPeriodiqueConsult(issn));
		}});
		
		buttonConsult.setBounds(217, 56, 107, 25);
		contentPane.add(buttonConsult);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(117, 93, 300, 2);
		contentPane.add(separator);
		
		buttonFermer = new JButton("Fermer");
		buttonFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getControleur().fermerVue(VueConsultPeriodique.this);
			}
		});
		buttonFermer.setBounds(190, 223, 107, 25);
		contentPane.add(buttonFermer);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(39, 123, 70, 15);
		contentPane.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(130, 121, 232, 19);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNbParu = new JLabel("Nombre de parution");
		lblNbParu.setBounds(15, 163, 107, 15);
		contentPane.add(lblNbParu);
		
		txtNbParu = new JTextField();
		txtNbParu.setEditable(false);
		txtNbParu.setBounds(130, 161, 232, 19);
		contentPane.add(txtNbParu);
		txtNbParu.setColumns(10);
	}
		
		
		private void setPeriodique(Periodique period) {
			_periodique = period;
		}
		
		@SuppressWarnings("unused")
		private Periodique getPeriodique(Periodique period) {
			return _periodique;
		}

		
	public void alimente(Periodique periodique) {
		txtNom.setText(periodique.getNom());
		txtNbParu.setText(String.valueOf(periodique.getNbParutions()));

	}

}
