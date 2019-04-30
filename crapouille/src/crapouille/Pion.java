package crapouille;

import crapouille.Pion;


public class Pion {


	private int abscisse,
	ordonnee;
	private boolean crapaud,
	bloque;

	public Pion(int abscisse, int ordonnee, boolean crapaud) {
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.crapaud = crapaud;
	}

	/**  
	 * Vérifie si l'ordonnee d'un pion est positif lors de l'initialisation
	 * @param ordonnee, valeur rentré par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setOrdonnee(int ordonnee) {
		if ( ordonnee < 0) {
			System.out.println("Vous ne pouvez pas mettre d'abscisse négative");
		} else {
			this.abscisse = ordonnee;
		}
	}

	/**  
	 * Vérifie si l'abscisse d'un pion est positif lors de l'initialisation
	 * @param abscisse, valeur rentré par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setAbscisse(int abscisse) {
		if ( abscisse < 0) {
			System.out.println("Vous ne pouvez pas mettre d'abscisse négative");
		} else {
			this.abscisse = abscisse;
		}
	}

	/**
	 * Renvoie la valeur de l'asbscisse de l'objet Pion demandé
	 * @return l'abscisse du pion demandé
	 */
	public int getAbscisse() {
		return abscisse;
	}

	/**
	 * Renvoie la valeur de l'ordonnee de l'objet Pion demandé
	 * @return l'ordonnee du pion demandé
	 */
	public int getOrdonnee() {
		return ordonnee;
	}

	/**
	 * Fonction permettant de bouger un pion sur un tableau en vérifiant si le pion n'est pas bloqué.<br/>
	 * Si le poin est un crapaud la fonction lui ajoute +1 a son abscisse si la 1er case devant lui est 
	 * libre ou ajoute +2 si la deuxieme case est libre.
	 * Si le poin est une grenouille la fonction lui ajoute -1 a son abscisse si la 1er case devant lui est 
	 * libre ou ajoute -2 si la deuxieme case est libre.
	 * @param abscisse, L'abscisse ou ce situe le pion
	 * @param plateau, tableau contenant des Pions
	 */
	public void setAbscisse(int abscisse, Pion[][] plateau) {
		// Si le pion est un crapaud est que la première case de droite est vide
		if (crapaud && plateau[this.abscisse+1][this.ordonnee] == null) {
			this.abscisse = abscisse+1;
		// Si le pion est un crapaud est que la deuxième case de droite est vide
		} else if (crapaud && plateau[this.abscisse+2][this.ordonnee] == null) {
			this.abscisse = abscisse+2;
		// Si le pion est une grenouille est que la première case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) {
			this.abscisse = abscisse-1;
		// Si le pion est une grenouille est que la deuxième case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-2][this.ordonnee] == null) {
			this.abscisse = abscisse-2;
		}
	}

	/**
	 * Vérifie si un pion est bloqué :
	 * <ol><li>- Si un pion n'est pas bloqué, il ajoute la valeur false à 
	 *         la propriéter bloque de l'objet Pion.</li>
	 *     <li>- Si un pion est bloqué, il ajoute la valeur true à 
	 *         la propriéter bloque de l'objet Pion.</li></ol>
	 * @param bloque, boolean indiquant si un pion est bloqué ou non
	 * @param plateau, tableau contenant des Pions
	 */
	public void setBloque(boolean bloque, Pion[][] plateau) {
		// Si le pion est un crapaud est que la première case de gauche est vide
		if ((crapaud && plateau[this.abscisse+1][this.ordonnee] == null) || 
				// Si le pion est un crapaud est que la deuxième case de gauche est vide
				(crapaud && plateau[this.abscisse+2][this.ordonnee] == null) ||
				// Si le pion est une grenouille est que la première case de droite est vide
				((!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) || 
						// Si le pion est une grenouille est que la première case de droite est vide
						(!crapaud && plateau[this.abscisse-2][this.ordonnee] == null))) {
			this.bloque = false; // Le pion n'est pas bloqué
		} else {
			this.bloque = true; // Le pion est bloqué
		}
	}

	public boolean isCrapaud() {
		return crapaud;
	}

	public boolean isBloque() {
		return bloque;
	}

	/**
	 * Renvoie une représentation sous forme de chaîne de l'objet d'un Pion
	 * @return un string représentant un Pion
	 */
	@Override
	public String toString() {
		return "Pion(" + abscisse + "," + ordonnee + ") crapaud=" + crapaud + ", bloque=" + bloque
				+ "]";
	}
	
	
}
