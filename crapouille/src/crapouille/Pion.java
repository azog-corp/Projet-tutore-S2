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
	 * V�rifie si l'ordonnee d'un pion est positif lors de l'initialisation
	 * @param ordonnee, valeur rentr� par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setOrdonnee(int ordonnee) {
		if ( ordonnee < 0) {
			System.out.println("Vous ne pouvez pas mettre d'abscisse n�gative");
		} else {
			this.abscisse = ordonnee;
		}
	}

	/**  
	 * V�rifie si l'abscisse d'un pion est positif lors de l'initialisation
	 * @param abscisse, valeur rentr� par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setAbscisse(int abscisse) {
		if ( abscisse < 0) {
			System.out.println("Vous ne pouvez pas mettre d'abscisse n�gative");
		} else {
			this.abscisse = abscisse;
		}
	}

	/**
	 * Renvoie la valeur de l'asbscisse de l'objet Pion demand�
	 * @return l'abscisse du pion demand�
	 */
	public int getAbscisse() {
		return abscisse;
	}

	/**
	 * Renvoie la valeur de l'ordonnee de l'objet Pion demand�
	 * @return l'ordonnee du pion demand�
	 */
	public int getOrdonnee() {
		return ordonnee;
	}

	/**
	 * Fonction permettant de bouger un pion sur un tableau en v�rifiant si le pion n'est pas bloqu�.<br/>
	 * Si le poin est un crapaud la fonction lui ajoute +1 a son abscisse si la 1er case devant lui est 
	 * libre ou ajoute +2 si la deuxieme case est libre.
	 * Si le poin est une grenouille la fonction lui ajoute -1 a son abscisse si la 1er case devant lui est 
	 * libre ou ajoute -2 si la deuxieme case est libre.
	 * @param abscisse, L'abscisse ou ce situe le pion
	 * @param plateau, tableau contenant des Pions
	 */
	public void setAbscisse(int abscisse, Pion[][] plateau) {
		// Si le pion est un crapaud est que la premi�re case de droite est vide
		if (crapaud && plateau[this.abscisse+1][this.ordonnee] == null) {
			this.abscisse = abscisse+1;
		// Si le pion est un crapaud est que la deuxi�me case de droite est vide
		} else if (crapaud && plateau[this.abscisse+2][this.ordonnee] == null) {
			this.abscisse = abscisse+2;
		// Si le pion est une grenouille est que la premi�re case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) {
			this.abscisse = abscisse-1;
		// Si le pion est une grenouille est que la deuxi�me case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-2][this.ordonnee] == null) {
			this.abscisse = abscisse-2;
		}
	}

	/**
	 * V�rifie si un pion est bloqu� :
	 * <ol><li>- Si un pion n'est pas bloqu�, il ajoute la valeur false � 
	 *         la propri�ter bloque de l'objet Pion.</li>
	 *     <li>- Si un pion est bloqu�, il ajoute la valeur true � 
	 *         la propri�ter bloque de l'objet Pion.</li></ol>
	 * @param bloque, boolean indiquant si un pion est bloqu� ou non
	 * @param plateau, tableau contenant des Pions
	 */
	public void setBloque(boolean bloque, Pion[][] plateau) {
		// Si le pion est un crapaud est que la premi�re case de gauche est vide
		if ((crapaud && plateau[this.abscisse+1][this.ordonnee] == null) || 
				// Si le pion est un crapaud est que la deuxi�me case de gauche est vide
				(crapaud && plateau[this.abscisse+2][this.ordonnee] == null) ||
				// Si le pion est une grenouille est que la premi�re case de droite est vide
				((!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) || 
						// Si le pion est une grenouille est que la premi�re case de droite est vide
						(!crapaud && plateau[this.abscisse-2][this.ordonnee] == null))) {
			this.bloque = false; // Le pion n'est pas bloqu�
		} else {
			this.bloque = true; // Le pion est bloqu�
		}
	}

	public boolean isCrapaud() {
		return crapaud;
	}

	public boolean isBloque() {
		return bloque;
	}

	/**
	 * Renvoie une repr�sentation sous forme de cha�ne de l'objet d'un Pion
	 * @return un string repr�sentant un Pion
	 */
	@Override
	public String toString() {
		return "Pion(" + abscisse + "," + ordonnee + ") crapaud=" + crapaud + ", bloque=" + bloque
				+ "]";
	}
	
	
}
