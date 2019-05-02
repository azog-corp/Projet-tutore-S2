package crapouille;

import crapouille.Pion;


public class Pion {


	private int ligne,
	colonne;
	private boolean crapaud,
	bloque;

	public Pion(int ligne, int colonne, boolean crapaud) {
		this.setLigne(ligne);
		this.setColonne(colonne);
		this.crapaud = crapaud;
	}

	/**  
	 * Vérifie si l'colonne d'un pion est positif lors de l'initialisation
	 * @param colonne, valeur rentré par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setColonne(int colonne) {
		if (colonne < 0) {
			System.out.println("Vous ne pouvez pas mettre d'ligne négative");
		} else {
			this.ligne = colonne;
		}
	}

	/**  
	 * Vérifie si l'ligne d'un pion est positif lors de l'initialisation
	 * @param ligne, valeur rentré par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setLigne(int ligne) {
		if (ligne < 0) {
			System.out.println("Vous ne pouvez pas mettre d'ligne négative");
		} else {
			this.ligne = ligne;
		}
	}

	/**
	 * Renvoie la valeur de l'asbscisse de l'objet Pion demandé
	 * @return l'ligne du pion demandé
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Renvoie la valeur de l'colonne de l'objet Pion demandé
	 * @return l'colonne du pion demandé
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * Fonction permettant de bouger un pion sur un tableau en vérifiant si le pion n'est pas bloqué.<br/>
	 * Si le poin est un crapaud la fonction lui ajoute +1 a son ligne si la 1er case devant lui est 
	 * libre ou ajoute +2 si la deuxieme case est libre.
	 * Si le poin est une grenouille la fonction lui ajoute -1 a son ligne si la 1er case devant lui est 
	 * libre ou ajoute -2 si la deuxieme case est libre.
	 * @param ligne, L'ligne ou ce situe le pion
	 * @param plateau, tableau contenant des Pions
	 */
	public void setLigne(int ligne, Pion[][] plateau) {
		// Si le pion est un crapaud est que la première case de droite est vide
		if (crapaud && plateau[this.ligne+1][this.colonne] == null) {
			this.ligne = ligne+1;
		// Si le pion est un crapaud est que la deuxième case de droite est vide
		} else if (crapaud && plateau[this.ligne+2][this.colonne] == null) {
			this.ligne = ligne+2;
		// Si le pion est une grenouille est que la première case de droite est vide
		} else if (!crapaud && plateau[this.ligne-1][this.colonne] == null) {
			this.ligne = ligne-1;
		// Si le pion est une grenouille est que la deuxième case de droite est vide
		} else if (!crapaud && plateau[this.ligne-2][this.colonne] == null) {
			this.ligne = ligne-2;
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
	public void setBloque(Pion[][] plateau) {
		// Si le pion est un crapaud est que la première case de gauche est vide
		if ((crapaud && plateau[this.ligne+1][this.colonne] == null) || 
				// Si le pion est un crapaud est que la deuxième case de gauche est vide
				(crapaud && plateau[this.ligne+2][this.colonne] == null) ||
				// Si le pion est une grenouille est que la première case de droite est vide
				((!crapaud && plateau[this.ligne-1][this.colonne] == null) || 
						// Si le pion est une grenouille est que la première case de droite est vide
						(!crapaud && plateau[this.ligne-2][this.colonne] == null))) {
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
		return "Pion(" + ligne + "," + colonne + ") crapaud=" + crapaud + ", bloque=" + bloque
				+ "]";
	}
	
	
}
