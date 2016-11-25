package fr.banqueandelo;

import java.util.ArrayList;

public class Administrateur extends Client
{
	public Administrateur(String name, String password)
	{
		super(name, password);
	}
	
	public Administrateur(String name, String prename, String password,
			int solde, String countnumber, int numberfone) {
		super(name, prename, password, solde, countnumber, numberfone);
	}

	protected ArrayList<Client> client = new ArrayList<>();
	
	public void Ajouclient(Client client)
	{
		this.client.add(client);
	}
	
	public void Supclient(Client client)
	{
		this.client.remove(client);
	}
	
	public void afficheClient()
	{
		System.out.println("La liste de tous les Clients :");
		
		for(int i = 0; i < client.size(); i++)
		{
			System.out.println("Nom : " + client.get(i).getName() + "\nPr�nom : " + client.get(i).getPrename() 
					+ "\nNum�ro de compte : " + client.get(i).getCountnumber() +"\nSolde : " + client.get(i).getSolde() + "euros"
					+ "\nT�l�phone : " + client.get(i).getNumberfone());
		}
	}
}
