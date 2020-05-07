package banque;

public class Client {

	private String numeroClient;
	private String adresse;
	private String nom;
	
	public Client(String numeroClient, String adresse, String nom) {
		this.numeroClient = numeroClient;
		this.adresse = adresse;
		this.nom = nom;
	}
	
	public Client() {};
	
	public void setId(String c) {
		numeroClient = c;
	}
	
	public String getId() {
		return numeroClient;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public String getNom() {
		return nom;
	}

}
