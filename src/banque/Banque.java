package banque;

import java.sql.SQLException;
import java.util.ArrayList;

public class Banque {
	
	DAOCompte DaoCompte = new DAOCompte();
	DAOClient DaoClient = new DAOClient();
	
	public void retrait(String idCompte, String nomClient, double montant) throws SQLException {
		
		CompteAvecDecouvert compte = new CompteAvecDecouvert();
		compte.setIDCompte(idCompte);
		
		compte = (CompteAvecDecouvert) DaoCompte.read(compte); //On récupère un compte avec découvert pour récupérer la limite de découvert (0 si il n'en n'a pas)
		compte.setSolde(compte.getSolde()-montant); //On modifie le montant du solde du compte récupéré
		
		if (compte.getSolde()<compte.getDecouvert()) {
			System.out.println("Retrait impossible, vous êtes dans le rouge !");
		}
		else {
			DaoCompte.update(compte); //On update dans la BDD le montant du solde
			
			System.out.println("Nouveau solde du compte de "+nomClient+" : "+ compte.getSolde()+"€");
		}
	}// Que ce soit pour le retrait ou le dépot, je ne demande pas à l'utilisateur son nom et met un par défaut dans le main (même si il serait normalement inutile) mais il aurait juste fallu que lors de la demande on
	// Split pour récupérer d'un côté don nom et de l'autre le montant puis l'afficher ici. Manque de temps.
	
	public void depot(String idCompte, String nomClient, double montant) throws SQLException {
		CompteAvecDecouvert compte = new CompteAvecDecouvert();
		compte.setIDCompte(idCompte);
		
		compte = (CompteAvecDecouvert) DaoCompte.read(compte); //On récupère un compte avec découvert pour récupérer la limite de découvert (0 si il n'en n'a pas)
		compte.setSolde(compte.getSolde()+montant); //On modifie le montant du solde du compte récupéré
		
		DaoCompte.update(compte); //On update dans la BDD le montant du solde
		System.out.println("Nouveau solde du compte de "+ nomClient+ " : "+ compte.getSolde()+"€");
	}
	
	public void ouvertureCompte(String nomClient) throws SQLException{
		CompteAvecDecouvert compte = new CompteAvecDecouvert();
		compte = (CompteAvecDecouvert) DaoCompte.readLast();
		Client client = new Client(); //j'utilise le constructeur vide car on a pas l'adresse et j'ajoute le nom plus tard
		client = DaoClient.readLast(); //On récupère le dernier numéro de comtpe et le dernier numéro de client
		
		String[] idClientPasSplit = client.getId().split("o"); //On split la chaine de l'id au "o" pour pouvoir ne récupérer que le nombre après
		String idClient = idClientPasSplit[1]; //On ne récupère que le nombre
		int id = Integer.parseInt(idClient) + 1; //On le transforme en int et on y ajoute + 1 pour le nouveau client
		
		//String[] idComptePasSplit = compte.getidCompte().split("Numero"); //On split la chaine de l'id au "Numero" pour pouvoir ne récupérer que le nombre après. On ne peut pas juste "o" car il y en a plusieurs dans la chaine.
		//String idCompte = idComptePasSplit[1]; //On ne récupère que le nombre
		String idCompte = compte.getidCompte().substring(12); //On met douze car c'est le nombre de caractères avant les chiffres de l'id
		
		int idC = Integer.parseInt(idCompte) + 1; //On le transforme en int et on y ajoute + 1 pour le nouveau compte
		
		client.setNom(nomClient);
		client.setId("clientNumero"+id);
		compte.setIDCompte("compteNumero"+id);
		compte.setIDClient(client.getId());
		
		DaoCompte.create(compte);
		DaoClient.create(client); //Création du compte et du client avec un numéro supérieur de 1 dans leur id comparé au dernier réalisé
	}
	
	public String consultation(String idCompte) throws SQLException{
		CompteAvecDecouvert compte = new CompteAvecDecouvert();
		compte.setIDCompte(idCompte);
		
		if(DaoCompte.read(compte) == null)
		{
			return null;
		}
		else {
			compte = (CompteAvecDecouvert) DaoCompte.read(compte);
			return compte.toString();
		}
	}
	
	public double conversionFromEuro(double montant) {
		return montant*1.08;
	}
	
	public double conversionToEuro(double montant) {
		return montant*0.93;
	}
	
	public String allComptes() throws SQLException
	{
		ArrayList<Compte> c = DaoCompte.readAll();
		String DetailComptes = "";
		int i = 0;
		while (i<c.size())
		{
			DetailComptes = DetailComptes+c.get(i).ToString()+"\n";
			i++;
		}
		return DetailComptes;
	}

}
