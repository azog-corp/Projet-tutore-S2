/*
 * 
 */
package crapouille;

import crapouille.Plateau;

/**
 * 
 * @author Azog-corp
 *
 */
public class Pion {

	// Création des attributs de l'objet Pion
	// abscisse du pion
	// ordonnee du Pion
	// Le Pion est-il un crapaud ou une grenouille
	// Le pion est il bloqué
	private int abscisse,
	ordonnee;
	private boolean crapaud,
	bloque;

	/**
	 * Création d'un pion
	 * @param abscisse
	 * @param ordonnee
	 * @param crapaud
	 */
	public Pion(int abscisse, int ordonnee, boolean crapaud) {
		if (abscisse < 0 || ordonnee < 0) {
			throw new RuntimeException ("Les coordonnées doivent être positives");
		}
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.crapaud = crapaud;
	}

	/**
	 * 
	 * @return l'abscisse du pion
	 */
	public int getAbscisse() {
		return abscisse;
	}

	/**
	 * 
	 * @return l'ordonnee du pion
	 */
	public int getOrdonnee() {
		return ordonnee;
	}

	/**
	 * Change l'absisse d'un pion après déplacement
	 * @param abscisse
	 * @param plateau
	 */
	public void setAbscisse(int abscisse, Pion[][] plateau) {
		// Si le pion est un crapaud est que la première case de droite est vide
		if (crapaud && this.abscisse < 4 && plateau[this.abscisse+1][this.ordonnee] == null) {
			this.abscisse = abscisse+1;
		// Si le pion est un crapaud est que la deuxième case de droite est vide
		} else if (crapaud && this.abscisse < 3 && plateau[this.abscisse+2][this.ordonnee] == null) {
			this.abscisse = abscisse+2;
		// Si le pion est une grenouille est que la première case de droite est vide
		} else if (!crapaud && this.abscisse > 0 && plateau[this.abscisse-1][this.ordonnee] == null) {
			this.abscisse = abscisse-1;
		// Si le pion est une grenouille est que la deuxième case de droite est vide
		} else if (!crapaud && this.abscisse > 1 && plateau[this.abscisse-2][this.ordonnee] == null) {
			this.abscisse = abscisse-2;
		}
	}

	/**
	 * Détermine si le pion est bloqué
	 * @param pion
	 */
	public void setBloque(Pion[][] pion) {
		// Si le pion est un crapaud est que la première case de gauche est vide
		if ((crapaud && this.abscisse < 4 && pion[this.abscisse+1][this.ordonnee] == null) || 
				// Si le pion est un crapaud est que la deuxième case de gauche est vide
				(crapaud && this.abscisse < 3 && pion[this.abscisse+2][this.ordonnee] == null) ||
				// Si le pion est une grenouille est que la première case de droite est vide
				((!crapaud && this.abscisse > 0 && pion[this.abscisse-1][this.ordonnee] == null) || 
						// Si le pion est une grenouille est que la première case de droite est vide
						(!crapaud && this.abscisse > 1 && pion[this.abscisse-2][this.ordonnee] == null))) {
			this.bloque = false; // Le pion n'est pas bloqué
		} else {
			this.bloque = true; // Le pion est bloqué
		}
	}

	/**
	 * 
	 * @return le type du pion
	 */
	public boolean isCrapaud() {
		return crapaud;
	}

	/**
	 * 
	 * @return true si le pion est bloqué
	 */
	public boolean isBloque() {
		return bloque;
	}
}
