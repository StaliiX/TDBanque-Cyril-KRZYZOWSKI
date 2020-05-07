package modele;

import static factory.imprimante.ImprimanteSingletonFactory.getImprimanteInstance;

public class Client {

	private String id;
	private String nom;
	private String prenom;

	private Imprimante imprimante;

	public Imprimante getImprimante() {
		return imprimante;
	}

	public String getId() {
		return id;
	}

	public Client() {
		this.imprimante = getImprimanteInstance();
	}

	public String getNom() {
		return nom;

	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setId(String id) {
		this.id = id;
	}

}
