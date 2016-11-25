package fr.banqueandelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class MenuAdmin extends JFrame implements ActionListener
{
	protected JMenuBar menu = new JMenuBar();	//Creation de la barre de menu
	protected JMenu fc = new JMenu("Fichier");	//les composants de ma barre de menu
	protected JMenu ot = new JMenu("Outils");
	protected JMenu ap = new JMenu("A propos ");
	//
	protected JMenuItem en = new JMenuItem("Enregistrer"); //sous finchiers des composants de ma barre de menu
	protected JMenuItem fer = new JMenuItem("Fermer");
	protected JMenuItem imp = new JMenuItem("Impression");
	protected JMenuItem af = new JMenuItem("Affichage");
	protected JMenuItem pi = new JMenuItem("?");
	//
	protected JToolBar toolsbar = new JToolBar();		//Barre d'outils
	//les icones des boutons de la barre d'outils 
	protected JButton home = new JButton(new ImageIcon("Images\\home.png"));
	protected JButton open = new JButton(new ImageIcon("Images\\open.gif"));
	protected JButton save = new JButton(new ImageIcon("Images\\save_all.gif"));
	protected JButton deconnect = new JButton(new ImageIcon("Images\\turn_off.gif"));
	protected JButton option = new JButton(new ImageIcon("Images\\options.gif"));
	protected JButton note = new JButton(new ImageIcon("Images\\notes.gif"));
	protected JButton calc = new JButton(new ImageIcon("Images\\calculator.gif"));
	protected JButton close = new JButton(new ImageIcon("Images\\close.gif"));
	//
	private Color fondButton = Color.white;			// le fond de la couleur des boutons icons
	//
	protected JTextField adm = new JTextField();
	protected JPasswordField passea = new JPasswordField();
	
	//création d'un administrateur par défaut
	Administrateur AD = new Administrateur("admin", "password");
	//la méthodes qui définit les comportements de nos icones boutons
	public void iniToolsbar()
	{
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		int choix = JOptionPane.showOptionDialog(null, 
				new Object[] {"Administrateur : ", adm, "Mot de passe :",passea}, 
				"Connexion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if(choix == JOptionPane.OK_OPTION)
		{
			if(adm.getText().equals(AD.getName()) && passea.getText().equals(AD.getPassword()))
			{
				this.setTitle("Administration Banque");
				this.setSize(1200,725);
				this.setLocationRelativeTo(null);					
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setResizable(true);
				this.setExtendedState(this.MAXIMIZED_BOTH);		//Affichage de la fénêtre en entière
				//
				fer.addActionListener(new Fermer()); //quand nous cliquons sur fermer il quitte
				//
				
				this.fc.add(en);		//le menu fichier contient enregistrement
				this.fc.add(imp);		//le menu fichier contient impression
				this.fc.add(fer);		//le menu fichier contient fermer 
				fc.setMnemonic('F');	//Ajouter un Mnemonique
				//
				this.ot.add(af);		//dans outils nous mettons juste affichage
				ot.setMnemonic('O');
				//
				this.ap.add(pi);
				ap.setMnemonic('P');
				//
				this.menu.add(fc);
				this.menu.add(ot);
				this.menu.add(ap);
				this.setJMenuBar(menu);
				
				//définir la couleur de fond des bouttons icons de la barre d'outils
				this.home.setBackground(fondButton);
				this.open.setBackground(fondButton);
				this.save.setBackground(fondButton);
				this.deconnect.setBackground(fondButton);
				this.option.setBackground(fondButton);
				this.note.setBackground(fondButton);
				this.calc.setBackground(fondButton);
				this.close.setBackground(fondButton);
				
				//insertion des nos icones boutons dans la barre d'outils 
				this.toolsbar.add(home);
				this.toolsbar.add(open);
				this.toolsbar.add(save);
				this.toolsbar.add(deconnect);
				this.toolsbar.addSeparator();     //Espacer après 4 icones 
				this.toolsbar.add(option);
				this.toolsbar.add(note);
				this.toolsbar.add(calc);
				this.toolsbar.add(close);
				this.add(toolsbar,BorderLayout.NORTH);
				//les actions de nos boutons icones 
				home.addActionListener(null);  				//à comppéter
				open.addActionListener(null);				//à comppéter
				save.addActionListener(null);				//à comppéter
				deconnect.addActionListener(new Session());
				option.addActionListener(null);				//à comppéter
				note.addActionListener(new Files());		//ouvrir un fichier note pad 
				calc.addActionListener(null);			//à comppéter
				close.addActionListener(new Fermer());
				
				//Traitement des onglets 
				JTabbedPane onglet = new JTabbedPane();	//définition d'un onglet
				
				JPanel pn1 = new JPanel();		//le panneau qui sera dans l'onglet
				onglet.addTab("Accueil", pn1);			//ajouter un onglet
				//... à compléter 
				
				JPanel pn2 = new JPanel();		//Chaque onnlet contient son panneau
				onglet.addTab("Ajouter un client", pn2);
				//... à compléter 
				
				JPanel pn3 = new JPanel();
				onglet.addTab("Liste de tous les Clients", pn3);
				String title[]= {"Nom","Prénom","Mot de passe","Solde","Numéro de Compte","Téléphone"}; //Titres des champs
				
				Object [][] data ={{"andelo","horly","pass",20000, "987654321",697287566},
						{"ali","bolo","past",10000, "123456789",111111111},
						{"taha","amin","post",5000, "1234567",2222222}};
				
				JTable tableau = new JTable(data,title);
				
				pn3.add(new JScrollPane(tableau));

				add(onglet, BorderLayout.CENTER);		//spécifié l'endroit 
				
				this.getContentPane().add(onglet);
				this.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Veuillez entre des informations valides S.V.P",
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			System.exit(0);
		}	
	
	}
	
public class Fermer extends JFrame implements ActionListener
{
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		int pa = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment quitter ?");
		if(pa==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	
}

public class Files implements ActionListener
	{

	@Override
	public void actionPerformed(ActionEvent e) 
	{	// exécuter un fichier notepad 
		String cmd= "c:\\windows\\notepad.exe";
	       try {
				Runtime r = Runtime.getRuntime();
				Process p = r.exec(cmd);
				p.waitFor();//si l'application doit attendre a ce que ce process fini
	       		}catch(Exception et) {
		System.out.println("erreur d'execution " + cmd + e.toString());
		}      
	}
	
	}

}