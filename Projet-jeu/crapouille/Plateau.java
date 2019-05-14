/*
 * Plateau.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille;

import crapouille.Pion;

/**
 * Class de l'objet plateau
 * @author Azog-corp
 */
public class Plateau {

	/**
	 *  ligne et colonne correspondent à la taille du tableau
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
		/* Vérification taille du tableau est valide */
		if (ligne < 0 || colonne < 0) {
			throw new RuntimeException ("Les coordonnées doivent être positives");
		}
		this.ligne = ligne;
		this.colonne = colonne;
		this.plateau = new Pion[ligne][colonne];
	}

	/**
	 * Fonction renvoyant un tableau de pion 
	 * @return plateau, un tableau contenant les pions du plateau
	 */
	public Pion[][] getPlateau() {
		return plateau;
	}

	/**
	 * Associe une case à un pion
	 * @param pion, Le pion qui doit être associé
	 */
	public void setCase(Pion pion) {
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
	}
	
	/**
	 * Fonction permettant d'avancer un pion et aussi vérifiant si le pion n'est 
	 * pas bloqué 
	 * @param pion, Le pion qu'on veut bouger
	 */
	public void movePion(Pion pion) {
		this.plateau[pion.getLigne()][pion.getColonne()] = null;
		pion.setColonne(this.plateau);
		pion.setBloque(this.plateau);
		updateBloque(pion.getLigne());
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
	}
	
	/**
	 * Affiche le plateau
	 */
	public String afficherJeu() {
		StringBuilder plateauString = new StringBuilder();
		for (int x = 0 ; x < this.ligne ; x++) {
			plateauString.append("\n|");
			for (int y = 0 ; y < this.colonne ; y++) {
				if (plateau[x][y] != null) {
					if (plateau[x][y].isCrapaud()) {
						plateauString.append("C|");
					} else if (!plateau[x][y].isCrapaud()) {
						plateauString.append("G|");
					}
				} else {
					plateauString.append(" |");
				}
			}
		}
		return plateauString.toString();
	}
	
	/**
	 * Vérifie sur une ligne si des cases ne sont pas bloqué
	 * @param ligne, la ligne que l'on veut vérifier
	 */
	public void updateBloque(int ligne) {
		for (int x = 0 ; x < this.ligne ; x++) {
			if (this.plateau[ligne][x] != null) {
				plateau[ligne][x].setBloque(this.plateau);
			}
		}
	}

	/**
	 * Renvoie le nombre de ligne que contient le tableau
	 * @return Le nombre de ligne du tableau
	 */
	public int getLigne() {
		return this.ligne;
	}
	
	/**
	 * Renvoie le nombre de colonne que contient le tableau
	 * @return Le nombre de colonne du tableau
	 */
	public int getColonne() {
		return this.colonne;
	}

}