
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
/**
 * Fenetre de saisie d'un periodique
 * Code du JFrame genere par Window Builder/Swing Designer.
 * @author IUT,  A.Culet 
 * @version 1.0
 */
public class VueSaisiePeriodique extends Vue {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIssn ;
	private JTextField textFieldNom;
	
	// pour que les boutons soient des attributs, il faut faire "convert local to field"
	private JButton buttonEnreg;
	private JButton buttonAnnuler;
	
	
	/**
	 * Create the frame.
	 */
	public VueSaisiePeriodique(Controleur controleur) {
		super(controleur);
		setTitle("Enregistrement d'un nouveau periodique");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(0, 0, 561, 301);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		this.addWindowListener (new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
			getControleur().fermerVue(VueSaisiePeriodique.this);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(99, 32, 61, 15);
		contentPane.add(lblNewLabel);
		
		textFieldIssn = new JTextField();
		textFieldIssn.setBounds(177, 32, 141, 19);
		contentPane.add(textFieldIssn);
		textFieldIssn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(99, 66, 61, 15);
		contentPane.add(lblNewLabel_1);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(177, 65, 225, 19);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		
		
		//////////////////////Button/////////////////////////////////////	
		
		
		buttonEnreg = new JButton("Enregistrer");
		buttonEnreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String issn = textFieldIssn.getText();
				String nom = textFieldNom.getText();			
				getControleur().nouvPeriodique(issn, nom);
				}
			
	
		});
		buttonEnreg.setBounds(177, 159, 131, 25);
		contentPane.add(buttonEnreg);
		
		
	
		buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getControleur().fermerVue(VueSaisiePeriodique.this);}
		});
		buttonAnnuler.setBounds(355, 159, 127, 25);
		contentPane.add(buttonAnnuler);
		

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
