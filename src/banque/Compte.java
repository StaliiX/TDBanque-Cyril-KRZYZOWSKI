package banque;

public abstract class Compte {
	
	private double solde;
	private String idCompte;
	private String idClient;
	
	public Compte(String c) {
		this.idCompte = c;
	}
	
	public Compte(String idCompte, String idClient, double solde) {
		this.solde = solde;
		this.idCompte = idCompte;
		this.idClient = idClient;
	}
	
	public Compte() {}
	
	public void debiter(double montant) {
		
	}
	
	public void crediter(double montant) {
		
	}
	
	public double getSolde() {
		return solde;
	}
	public String getidCompte() {
		return idCompte;
	}
	public String getidClient() {
		return idClient;
	}
	
	
	public void setIDCompte(String id) {
		this.idCompte = id;
	}
	public void setIDClient(String id) {
		this.idClient = id;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public String ToString() {
		return "ID du compte : " + idCompte + " , ID du client associé au comtpe : " + idClient + " , Solde du compte : " + solde + " , Decouvert du compte : " + getDecouvert();
	}
	
	abstract double getDecouvert();

}
