/*
 * Ordinateur.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille;

import java.util.ArrayList;

/**
 * Class contenant des fonctions de recherche de pion
 * par l'ordianateur.
 * @author Arzcop
 */
public class Ordinateur {

	/**
	 * ArrayList contenant tous les pions crapaud qui ne sont pas bloqu�s.
	 */
	private static ArrayList<Pion> pionLibre = new ArrayList<Pion>();

	/**
	 * Fonction principale qui recherche en fonction du niveau de l'IA,
	 * le pion � d�placer.
	 * @param plateau l'�tat du plateau de jeu actuel
	 * @param batracien tableau contenant tous les pions
	 * @param niveauIA niveau de l'IA
	 * @return le pion � d�placer
	 */
	public static Pion choixOrdi(final Plateau plateau,
			final Pion[][] batracien, final int niveauIA) {
		initPionNonBloque(batracien);
		Pion choixPion = null;

		if (niveauIA == 2) {
			choixPion = choixPionIA();
		}
		if (choixPion == null) {
			/* choixPion devient un pion
			 * random parmis les pion d�pla�able */
			choixPion = pionLibre.get((int)
					(1 + (Math.random()
							* (pionLibre.size(
									) - 1)
							)));
		}
		Partie.currentPlateau.movePion(choixPion);
		return choixPion;
	}

	/**
	 * Renpli pionLibre avec les pions crapaud non bloqu�.
	 * @param crapaud le tableau contenant les pions
	 */
	public static void initPionNonBloque(final Pion[][] crapaud) {
		for (int x = 0; x < crapaud[1].length; x++) {
			if (!crapaud[1][x].isBloque()) {
				pionLibre.add(crapaud[1][x]);
			}
		}
	}

	/**
	 * Fonction qui recherche les d�placement qui
	 * assure la victoire � l'ordinateur.
	 * @return le pion � d�placer
	 */
	public static Pion choixPionIA() {
		return null;
	}
}
