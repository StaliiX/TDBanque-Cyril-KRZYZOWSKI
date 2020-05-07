package factory.imprimante;

import modele.Imprimante;

public class ImprimanteSingletonFactory {

	private static Imprimante instance;

	private ImprimanteSingletonFactory() {
		// empêcher instanciation :
	}

	public static Imprimante getImprimanteInstance() {
		if (instance == null) {
			// int i = getIdAvailable();
			instance = new Imprimante(1, "new1");
		}
		return instance;
	}

}
