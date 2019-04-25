/*
 * 
 */
package crapouille;

import crapouille.Pion;

/**
 * 
 * @author Azog-corp
 *
 */
public class Plateau {

	// Création des attributs de l'objet Plateau
	// Abscisse et ordonnée correspondent à la taille du tableau
	// Pion est est un tableau contenant soit :
	// Une grenouille, un crapaud, ou la valeur null
	private int abscisse,
	ordonnee;
	private Pion[][] plateau;

	/**
	 * Création de l'objet plateau
	 * @param abscisse nombre de ligne
	 * @param ordonnee nombre de collone 
	 */
	public Plateau(int abscisse, int ordonnee) {
		if (abscisse < 0 || ordonnee < 0) {
			throw new RuntimeException ("Les coordonnées doivent être positives");
		}
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.plateau = new Pion[abscisse][ordonnee];
	}

	/**
	 * 
	 * @return le plateau
	 */
	public Pion[][] getPlateau() {
		return plateau;
	}

	/**
	 * Associe une case à un pion
	 * @param pion
	 */
	public void setCase(Pion pion) {
		this.plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}

	/**
	 * Déplace un pion sur le plateau
	 * @param pion
	 */
	public void movePion(Pion pion) {
		// La case ou se trouve le pion devient null
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = null;
		// On change l'abscisse du pion
		pion.setOrdonnee(pion.getAbscisse(), plateau);
		// On met le pion dans sa case
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}
	
	/**
	 * Affiche le plateau
	 */
	public void afficherPlateau() {
		for (int x = 0 ; x < this.abscisse ; x++) {
			System.out.print("\n|");
			for (int y = 0 ; y < this.ordonnee ; y++) {
				if (this.plateau[x][y] != null) {
					if (this.plateau[x][y].isCrapaud()) {
						System.out.print("C|");
					} else if (!this.plateau[x][y].isCrapaud()) {
						System.out.print("G|");
					}
				} else {
					System.out.print(" |");
				}
			}
		}
	}

}