package fr.banqueandelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MenuClient extends JFrame implements ActionListener 
{
	protected JMenuBar menu1 = new JMenuBar();	
	protected JMenu fc1 = new JMenu("Fichier");
	//
	protected JTextField nom = new JTextField();
	protected JTextField prenom = new JTextField();
	protected JTextField numero = new JTextField();
	protected JPasswordField pass = new JPasswordField();
	
	protected Client A = new Client("andelo","horly","pass",20000, "987654321",697287566);
	protected Client B = new Client("ali","bolo","past",10000, "123456789",111111111);
	protected Client C = new Client("taha","amin","post",5000, "1234567",2222222);
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{	
		int choix = JOptionPane.showOptionDialog(null, 
				new Object[] {"Nom : ", nom, "Prénom :",prenom,"Numéro de Compte : ", numero, "Mot de passe : ", pass}, 
				"Accéder", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(choix == JOptionPane.OK_OPTION)
			{
				if((nom.getText().equals(A.getName()) && prenom.getText().equals(A.getPrename()) && numero.getText().equals(A.getCountnumber()) && pass.getText().equals(A.getPassword())) 
						|| (nom.getText().equals(B.getName()) && prenom.getText().equals(B.getPrename()) && numero.getText().equals(B.getCountnumber()) && pass.getText().equals(B.getPassword())) 
						||(nom.getText().equals(C.getName()) && prenom.getText().equals(C.getPrename()) && numero.getText().equals(C.getCountnumber()) && pass.getText().equals(C.getPassword())))
			
				{
					this.setTitle("Menu Client");
					this.setSize(600,700);
					this.setLocationRelativeTo(null);					
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.setResizable(false);
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

}
