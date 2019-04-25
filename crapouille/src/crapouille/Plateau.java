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
	 * 
	 * @param pion
	 */
	public void movePion(Pion pion) {
		this.plateau[pion.getAbscisse()][pion.getOrdonnee()] = null;
		pion.setOrdonnee(pion.getAbscisse(), this.plateau);
		pion.setBloque(this.plateau);
		this.plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
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
	
	/**
	 * 
	 * @param ligne
	 */
	public void updateBloque(int ligne) {
		for (int x = 0 ; x < this.abscisse ; x++) {
			if (this.plateau[ligne][x] != null) {
				plateau[ligne][x].setBloque(this.plateau);
			}
		}
	}

	public int getAbscisse() {
		return this.abscisse;
	}

}