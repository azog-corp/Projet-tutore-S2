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

	/**
	 *  ligne et ordonnée correspondent à la taille du tableau
	 */ 
	private int ligne,
	colonne;
	/**
	 * Pion est est un tableau contenant soit :
	 * Une grenouille, un crapaud, ou la valeur null
	 */
	private Pion[][] plateau;

	/**
	 * Création de l'objet plateau
	 * @param ligne nombre de ligne
	 * @param colonne nombre de collone 
	 */
	public Plateau(int ligne, int colonne) {
		if (ligne < 0 || colonne < 0) {
			throw new RuntimeException ("Les coordonnées doivent être positives");
		}
		this.ligne = ligne;
		this.colonne = colonne;
		this.plateau = new Pion[ligne][colonne];
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
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
	}
	
	/**
	 * 
	 * @param pion
	 */
	public void movePion(Pion pion) {
		this.plateau[pion.getLigne()][pion.getColonne()] = null;
		pion.setColonne(pion.getLigne(), this.plateau);
		pion.setBloque(this.plateau);
		updateBloque(pion.getLigne());
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
	}
	
	/**
	 * Affiche le plateau
	 */
	public void afficherPlateau() {
		for (int x = 0 ; x < this.ligne ; x++) {
			System.out.print("\n|");
			for (int y = 0 ; y < this.colonne ; y++) {
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
	
	/**
	 * 
	 * @param ligne
	 */
	public void updateBloque(int ligne) {
		for (int x = 0 ; x < this.ligne ; x++) {
			if (this.plateau[ligne][x] != null) {
				plateau[ligne][x].setBloque(this.plateau);
			}
		}
	}

	public int getLigne() {
		return this.ligne;
	}
	
	public int getColonne() {
		return this.colonne;
	}

}