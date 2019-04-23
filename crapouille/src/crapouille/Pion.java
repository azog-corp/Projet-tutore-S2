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
	public void setOrdonnee(int abscisse, Pion[][] pion) {
		// Si le pion est un crapaud est que la première case de droite est vide
		if (!crapaud && this.ordonnee < pion.length-1 && pion[this.abscisse][this.ordonnee+1] == null) {
			this.ordonnee = ordonnee+1;
		// Si le pion est un crapaud est que la deuxième case de droite est vide
		} else if (!crapaud && this.abscisse < pion.length-2 && pion[this.abscisse][this.ordonnee+2] == null) {
			this.ordonnee = ordonnee+2;
		// Si le pion est une grenouille est que la première case de droite est vide
		} else if (crapaud && this.abscisse > 0 && pion[this.abscisse][this.ordonnee-1] == null) {
			this.ordonnee = ordonnee-1;
		// Si le pion est une grenouille est que la deuxième case de droite est vide
		} else if (crapaud && this.abscisse > 1 && pion[this.abscisse][this.ordonnee-2] == null) {
			this.ordonnee = ordonnee-2;
		}
	}

	/**
	 * Détermine si le pion est bloqué
	 * @param pion
	 */
	public void setBloque(Pion[][] pion) {
		// Si le pion est un crapaud est que la première case de gauche est vide
		if ((!crapaud && this.ordonnee < pion.length-1 && pion[this.abscisse][this.ordonnee+1] == null) || 
				// Si le pion est un crapaud est que la deuxième case de gauche est vide
				(!crapaud && this.ordonnee < pion.length-2 && pion[this.abscisse][this.ordonnee+2] == null) ||
				// Si le pion est une grenouille est que la première case de droite est vide
				((crapaud && this.ordonnee > 0 && pion[this.abscisse][this.ordonnee-1] == null) || 
						// Si le pion est une grenouille est que la première case de droite est vide
						(crapaud && this.ordonnee > 1 && pion[this.abscisse][this.ordonnee-2] == null))) {
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
