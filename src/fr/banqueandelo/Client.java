package fr.banqueandelo;

public class Client
{
	protected String name;
	protected String prename;
	protected String password;
	protected int solde;
	protected String countnumber;
	protected int numberfone;
	
	public Client(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	
	public Client(String name, String prename, String password, int solde, String countnumber, int numberfone)
	{
		this.name = name;
		this.prename = prename;
		this.password = password;
		this.solde = solde;
		this.countnumber = countnumber;
		this.numberfone = numberfone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrename() {
		return prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public String getCountnumber() {
		return countnumber;
	}

	public void setCountnumber(String countnumber) {
		this.countnumber = countnumber;
	}
	
	
	public int getNumberfone() {
		return numberfone;
	}

	public void setNumberfone(int numberfone) {
		this.numberfone = numberfone;
	}
	
	public void ajout()
	{
		solde +=solde;
	}
	
	public void retrait()
	{
		solde -=solde;
	}
}
