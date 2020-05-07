package banque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		Banque banque = new Banque();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean bonCompte = false;
		boolean bonneEntree = false;
		String entreeUtilisateur;
		String compteActuel = "";
		
		
		System.out.println("Bienvenue à la banque de France, voici la liste de tous les comptes enregistrés à la banque : ");
		try {
			System.out.println(banque.allComptes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Une erreur est survenue : " + e.getMessage());
		}
		
		while(true)
		{
			while (bonCompte == false)
			{
				System.out.println("Consultez un compte en entrant son identifiant : ");
				entreeUtilisateur = reader.readLine();
				if(banque.consultation(entreeUtilisateur) == null) {
					System.out.println("Veuillez entrez un identifiant de compte valide");
				}
				else {
					bonCompte = true;
					compteActuel = entreeUtilisateur;
				}
			}
			bonCompte = false;
			System.out.println("Que voulez-vous faire :\n1 - Créer un nouveau compte\n2 - Effectuer un retrait\n3 - Effectuer un dépôt\n4 - Convertir des euros en dollars\n5 - Convertir des dollars en euros\n6 - Consulter tous les comptes de la banque\n7 - Quitter l'application");
			while (bonneEntree == false)
			{
				entreeUtilisateur = reader.readLine();
				switch(entreeUtilisateur) {
				case "1" :
					bonneEntree=true;
					System.out.println("Veuillez entrer votre nom :");
					entreeUtilisateur = reader.readLine();
					banque.ouvertureCompte(entreeUtilisateur);
					break;
				case "2" :
					bonneEntree=true;
					System.out.println("Veuillez préciser la somme du retrait :");
					entreeUtilisateur = reader.readLine();
					banque.retrait(compteActuel, "toto", Double.parseDouble(entreeUtilisateur)); //Il aurait fallu faire une vérification pour que l'entrée utilisateur soit bien un double !!
					break;
				case "3" :
					bonneEntree=true;
					System.out.println("Veuillez préciser la somme du dépôt :");
					entreeUtilisateur = reader.readLine();
					banque.depot(compteActuel, "toto", Double.parseDouble(entreeUtilisateur)); //Il aurait fallu faire une vérification pour que l'entrée utilisateur soit bien un double !!
					break;
				case "4" :
					bonneEntree=true;
					System.out.println("Veuillez entrer la valeur à convertir : ");
					entreeUtilisateur = reader.readLine();
					System.out.println(banque.conversionFromEuro(Double.parseDouble(entreeUtilisateur))+"$");
					break;
				case "5" :
					bonneEntree=true;
					System.out.println("Veuillez entrer la valeur à convertir : "); //Idem qu'au-dessus, vérification à faire normalement !
					entreeUtilisateur = reader.readLine();
					System.out.println(banque.conversionToEuro(Double.parseDouble(entreeUtilisateur))+"€");
					break;
				case "6" :
					bonneEntree=true;
					try {
						System.out.println(banque.allComptes());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Une erreur est survenue : " + e.getMessage());
					}
					break;
				case "7" :
					bonneEntree=true;
					System.out.println("Au revoir !");
					System.exit(0);
					break;
				default :
					System.out.println("Entree non valide, veuillez réessayer.");
				}
			}
			bonneEntree=false;
		}
	}

}
