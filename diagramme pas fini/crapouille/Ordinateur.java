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
	 * ArrayList contenant tous les pions crapaud qui ne sont pas bloqués.
	 */
	private static ArrayList<Pion> pionLibre = new ArrayList<Pion>();

	/**
	 * Fonction principale qui recherche en fonction du niveau de l'IA,
	 * le pion à déplacer.
	 * @param plateau l'état du plateau de jeu actuel
	 * @param batracien tableau contenant tous les pions
	 * @param niveauIA niveau de l'IA
	 * @return le pion à déplacer
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
			 * random parmis les pion déplaçable */
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
	 * Renpli pionLibre avec les pions crapaud non bloqué.
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
	 * Fonction qui recherche les déplacement qui
	 * assure la victoire à l'ordinateur.
	 * @return le pion à déplacer
	 */
	public static Pion choixPionIA() {
		return null;
	}
}
