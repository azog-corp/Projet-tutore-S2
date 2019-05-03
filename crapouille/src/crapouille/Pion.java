package crapouille;

import crapouille.Pion;


public class Pion {

	private int ligne,         // indique sur qu'elle ligne ce situe le pion
	            colonne;       // indique sur qu'elle colonne ce situe le pion
	private boolean crapaud,   // indique si le pîon est un crapaud ou non
	                bloque;    // indique si le pion est bloqué

	/**
	 * Constructeur d'un pion vérifiant si les lignes et colonne rentré sont valide
	 * @param ligne, représente la ligne où sera situé notre pion
	 * @param colonne, représente la colonne où sera situé notre pion
	 * @param crapaud, Indique si le pion est un crapoaud ou non
	 * @param plateau TODO remplir ce commentaire
	 */
	public Pion(int ligne, int colonne, boolean crapaud, Plateau plateau) {
		if (ligne < 0 || ligne > plateau.getLigne() ||
				colonne < 0 || colonne > plateau.getColonne()) {
			throw new RuntimeException("Les coordonnées sont invalides");
		}
		this.ligne = ligne;
		this.colonne = colonne;
		this.crapaud = crapaud;
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
	public void setColonne(int ligne, Pion[][] plateau) {
		// Si le pion est une grenouille est que la première case de droite est vide
		if (!crapaud && this.colonne < plateau[0].length-1 && plateau[this.ligne][this.colonne+1] == null) {
			this.colonne = colonne+1;
			// Si le pion est une grenouille est que la deuxième case de droite est vide
		} else if (!crapaud && this.colonne < plateau[0].length-2 && plateau[this.ligne][this.colonne+2] == null) {
			this.colonne = colonne+2;
			// Si le pion est un crapaud est que la première case de gauche est vide
		} else if (crapaud && this.colonne > 0 && plateau[this.ligne][this.colonne-1] == null) {
			this.colonne = colonne-1;
			// Si le pion est un crapaud est que la deuxième case de gauche est vide
		} else if (crapaud && this.colonne > 1 && plateau[this.ligne][this.colonne-2] == null) {
			this.colonne = colonne-2;
		} else {
			System.out.println("aucun changement");
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
		// Si le pion est une grenouille est que la première case de droite est vide
		if ((!crapaud && this.colonne < plateau[0].length-1 && plateau[this.ligne][this.colonne+1] == null) ||
				// Si le pion est une grenouille est que la deuxième case de droite est vide
				(!crapaud && this.colonne < plateau[0].length-2 && plateau[this.ligne][this.colonne+2] == null) ||
				// Si le pion est un crapaud est que la première case de gauche est vide
				(crapaud && this.colonne > 0 && plateau[this.ligne][this.colonne-1] == null) ||
				// Si le pion est un crapaud est que la deuxième case de gauche est vide
				(crapaud && this.colonne > 1 && plateau[this.ligne][this.colonne-2] == null)) {
			this.bloque = false; // Le pion n'est pas bloqué
		} else {
			this.bloque = true; // Le pion est bloqué
		}
	}

	/**
	 * Fonction qui permet d'indiquer si un pion est un crapaud ou non
	 * @return crapaud, un boolean indiquant si le pion est un crapaud ou non
	 */
	public boolean isCrapaud() {
		return crapaud;
	}

	/**
	 * Fonction qui permet d'indiquer si un pion est bloqué ou non
	 * @return bloque, un boolean indiquant si le pion est bloqué ou non
	 */
	public boolean isBloque() {
		return bloque;
	}

	/**
	 * Renvoie une représentation sous forme de chaîne de l'objet d'un Pion
	 * @return un string représentant un Pion avec c'est coordonée
	 */
	@Override
	public String toString() {
		return "Pion(" + ligne + "," + colonne + ")";
	}
	
	
}
