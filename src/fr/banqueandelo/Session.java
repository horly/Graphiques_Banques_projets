package fr.banqueandelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.banqueandelo.MenuAdmin.Fermer;

public class Session extends JFrame implements ActionListener
{
	protected JPanel pan = new JPanel();		//Modelisation de la fenetre
	protected JLabel lb = new JLabel("Bienvenue à BANQUE SOFT");
	protected JLabel lb1 = new JLabel("Selectionner votre Session");
	protected JButton adm = new JButton("ADMINISTRATEUR");	//Insetion de mon bouton
	protected JButton cl = new JButton("CLIENT");
	
	Session()
	{
		this.setTitle("Banque Soft");  //Titre de la fenêtre
		this.setSize(400,400);			//La taille de la fenêtre
		this.setLocationRelativeTo(null);					//Centré par défaut 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//pour quitter 
		this.setResizable(false);
		//
		adm.addActionListener(new MenuAdmin()); //Action Session administrateur
		cl.addActionListener(new MenuClient());	//action Session client

		//
		Font police1 = new Font("Calibri",Font.BOLD,30);	//Police et definition pour label 
		Font police2 = new Font("Calibri",Font.BOLD,16);	//Police et definition pour boutton 
		Font police3 = new Font("Calibri",Font.BOLD,16);
		String img = "Images\\banque.jpg";
		ImageIcon icon = new ImageIcon(img);
		JLabel logo = new JLabel(icon, JLabel.CENTER);
		//
		String img1 = "Images\\Image4.png";
		ImageIcon icon1 = new ImageIcon(img1);
		JLabel lign1 = new JLabel(icon1, JLabel.CENTER);
		//
		String img2 = "Images\\Image5.png";
		ImageIcon icon2 = new ImageIcon(img2);
		JLabel lign2 = new JLabel(icon2, JLabel.CENTER);
		//
		pan.setLayout(new BorderLayout());
		JPanel nord = new JPanel();			//ce Panel contient les objet nord
		nord.add(lb);
		lb.setFont(police1);
		lb.setPreferredSize(new Dimension(380,80) );
		lb.setForeground(Color.WHITE);
		lb.setBackground(Color.BLUE);
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setBorder(BorderFactory.createLineBorder(Color.white));
		pan.add(nord,BorderLayout.NORTH);
		nord.setBackground(Color.BLACK);  //Couleur arrière plan
		//
		JPanel centre = new JPanel();		//les objets centre
		centre.add(lign1);
		centre.add(lb1);
		lb1.setFont(police3);
		lb1.setPreferredSize(new Dimension(500,20) );
		lb1.setForeground(Color.BLACK);
		lb1.setHorizontalAlignment(JLabel.CENTER);
		centre.add(adm);
		adm.setPreferredSize(new Dimension(180,100));		//définir la taille du bouton
		adm.setForeground(Color.black);
		adm.setBackground(Color.YELLOW);
		adm.setFont(police2);
		centre.add(cl);
		cl.setPreferredSize(new Dimension(180,100));
		cl.setForeground(Color.black);
		cl.setBackground(Color.GREEN);
		cl.setFont(police2);
		centre.add(lign2);
		pan.add(centre,BorderLayout.CENTER);
		centre.setBackground(Color.lightGray);
		//
		JPanel sud = new JPanel();
		sud.add(logo);
		logo.setBorder(BorderFactory.createLineBorder(Color.black));
		sud.setBackground(Color.lightGray);
		pan.add(sud,BorderLayout.SOUTH);
		//
		this.setVisible(true);	// rendre visible
		this.setContentPane(pan);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Session();
		
	}

}
