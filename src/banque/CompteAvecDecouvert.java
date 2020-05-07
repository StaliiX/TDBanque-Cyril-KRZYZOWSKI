package banque;

public class CompteAvecDecouvert extends Compte{
	
	private double decouvertAutorise;
	
	public CompteAvecDecouvert(double decouvert) {
		super();
		this.decouvertAutorise = decouvert;
	}
	
	public CompteAvecDecouvert(String idCompte, String idClient, double solde, double decouvert)
	{
		super(idCompte, idClient, solde);
		this.decouvertAutorise = decouvert;
	}
	
	public CompteAvecDecouvert() {
		super();
	}
	
	public void debiter(double montant) {
		
	}
	
	public double getDecouvert() {
		return decouvertAutorise;
	}
	
	public void setDecouvert(double decouvert) {
		this.decouvertAutorise = decouvert;
	}

}
