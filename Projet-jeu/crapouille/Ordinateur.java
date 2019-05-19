/**
 * Ordinateur.java
 * Azcop 2019, droit d'auteur
 */
package crapouille;

import java.util.ArrayList;

import crapouille.Pion;


/**
 * Class onjet de l'ordinateur permettant de gérer toute ces manipulations
 * @author Arzcop
 */
public class Ordinateur {

	private static ArrayList<Pion> pionLibre;

	public static Pion choixOrdi(Pion[][] plateau, Pion[] crapaud, int niveauIA) {
		initPionNonBloque(crapaud);
		Pion choixPion = null;

		if (niveauIA == 2) {
			choixPionIA();
		}
		if (choixPion == null) {
			choixPion = pionLibre.get((int) (1 + (Math.random() * (pionLibre.size()))));
		}
		return choixPion;
	}

	public static void initPionNonBloque(Pion[] crapaud) {
		for (int x = 0 ; x < crapaud.length ; x++) {
			if (!crapaud[x].isBloque()) {
				pionLibre.add(crapaud[x]);
			}
		}
	}
	
	public static void choixPionIA() {
		
	}
}
