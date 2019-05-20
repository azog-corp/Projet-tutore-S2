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

	/**
	 * ArrayList contenant tous les pions crapaud qui ne sont pas bloqu�s
	 */
	private static ArrayList<Pion> pionLibre;

	/**
	 * Fonction principale qui recherche en fonction du niveau de l'IA,
	 * le pion � d�placer
	 * @param plateau l'�tat du plateau de jeu actuel
	 * @param batracien tableau contenant tous les pions
	 * @param niveauIA niveau de l'IA
	 * @return le pion � d�placer
	 */
	public static Pion choixOrdi(Plateau plateau, Pion[][] batracien, int niveauIA) {
		initPionNonBloque(batracien);
		Pion choixPion = null;

		if (niveauIA == 2) {
			choixPionIA();
		}
		if (choixPion == null) {
			choixPion = pionLibre.get((int) (1 + (Math.random() * (pionLibre.size()))));
		}
		return choixPion;
	}

	/**
	 * Renpli pionLibre avec les pions crapaud non bloqu�
	 * @param crapaud le tableau contenant les pions
	 */
	public static void initPionNonBloque(Pion[][] crapaud) {
		for (int x = 0 ; x < crapaud[1].length ; x++) {
			if (!crapaud[1][x].isBloque()) {
				pionLibre.add(crapaud[1][x]);
			}
		}
	}
	
	public static void choixPionIA() {
		
	}
}
