/*
 * Pion.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille;

import java.io.Serializable;

/**
 * Class de l'objet Pion contenant deux fonctions principales
 * La première modifie la colonne d'un pion
 * La deuxième vérifie si le pion est bloqué
 * @author Azog-corp
 */
public class Pion implements Serializable {

	/** ID de la serialisation */
	private static final long serialVersionUID = -2711928380072215024L;
	private int ligne, // indique sur qu'elle ligne ce situe le pion
	colonne;           // indique sur qu'elle colonne ce situe le pion
	private boolean crapaud,   // indique si le pîon est un crapaud ou non
	bloque;                    // indique si le pion est bloqué

	/**
	 * Constructeur d'un pion qui lui associe trois caractèrisques
	 * @param ligne, représente la ligne où sera situé notre pion
	 * @param colonne, représente la colonne où sera situé notre pion
	 * @param crapaud, Indique si le pion est un crapoaud ou non
	 * @param plateau, permet de vérifier que les coordonnées du pion
	 * sont incluses dans le plateau
	 */
	public Pion(int ligne, int colonne, boolean crapaud) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.crapaud = crapaud;
	}

	/**
	 * Renvoie la valeur de la ligne de l'objet Pion demandé
	 * @return ligne du pion demandé
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Renvoie la valeur de la colonne de l'objet Pion demandé
	 * @return colonne du pion demandé
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * Vérifie premièrement que le pion n'est pas bloqué.
	 * Ajoute/enlève un à colonne si la case adjacente au pion est libre
	 * Ajoute/enlève deux à colonne si la case adjacente au pion est du
	 * même type que le pion à déplacé et que la case suivante est libre
	 * @param plateau, plateau contenant des pions
	 * @param ligneConf
	 */
	public void setColonne(Pion[][] plateau, int colonneConf) {
		if (this.bloque) {
			System.out.println("Le pion est bloqué");
			return;
		}
		/* Si le pion est une grenouille est que la première case de droite est vide */
		if (!crapaud && this.colonne < colonneConf-1 && plateau[this.ligne][this.colonne+1] == null) {
			this.colonne = colonne+1;
			/* Si le pion est une grenouille est que la deuxième case de droite est vide */
		} else if (!crapaud && this.colonne < colonneConf-2 && plateau[this.ligne][this.colonne+1].crapaud &&
				plateau[this.ligne][this.colonne+2] == null) {
			this.colonne = colonne+2;
			/* Si le pion est un crapaud est que la première case de gauche est vide */
		} else if (crapaud && this.colonne > 0 && plateau[this.ligne][this.colonne-1] == null) {
			this.colonne = colonne-1;
			/* Si le pion est un crapaud est que la deuxième case de gauche est vide */
		} else if (crapaud && this.colonne > 1 && !plateau[this.ligne][this.colonne-1].crapaud &&
				plateau[this.ligne][this.colonne-2] == null) {
			this.colonne = colonne-2;
		}
	}

	/**
	 * Vérifie si un pion est bloqué :
	 * <ol><li>- Si un pion n'est pas bloqué, il ajoute la valeur false à 
	 *         la propriéte bloque de l'objet Pion.</li>
	 *     <li>- Si un pion est bloqué, il ajoute la valeur true à 
	 *         la propriéter bloque de l'objet Pion.</li></ol>
	 * @param bloque, boolean indiquant si un pion est bloqué ou non
	 * @param plateau, tableau contenant des Pions
	 */
	public void setBloque(Pion[][] plateau, int colonneConf) {
		/* Si le pion est une grenouille, qu'il à une case du bord et que sa case adjacente est vide */
		if ((!crapaud && this.colonne < colonneConf-1 && plateau[this.ligne][this.colonne+1] == null) 
				/* Si le pion est une grenouille, qu'il à deux cases du bord,
				 * que sa case adjacente est un crapaud et que la case suivante est vide */
			||(!crapaud && this.colonne < colonneConf-2 && plateau[this.ligne][this.colonne+1].crapaud && 
						plateau[this.ligne][this.colonne+2] == null) 
			/* Si le pion est un crapaud, qu'il à une case du bord et que sa case adjacente est vide */
			||((crapaud && this.colonne > 0 && plateau[this.ligne][this.colonne-1] == null) 
					/* Si le pion est un crapaud, qu'il à deux cases du bord,
					 * que sa case adjacente est une grenouille et que la case suivante est vide */
			||(crapaud && this.colonne > 1 && !plateau[this.ligne][this.colonne-1].crapaud && 
						plateau[this.ligne][this.colonne-2] == null))) {
			this.bloque = false;
		} else {
			this.bloque = true;
		}
	}

	/**
	 * Fonction qui permet d'indiquer si un pion est un crapaud ou non
	 * @return true, si le pion est un crapaud
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
	 * Fonction qui vérifie si deux pions sont égaux
	 * @param pion le pion a vérifier
	 * @return true s'ils sont égaux
	 */
	public boolean equals(Pion pion) {
		return this.ligne == pion.getLigne() &&
				this.colonne == pion.getColonne() &&
				this.crapaud == pion.isCrapaud() &&
				this.bloque == pion.isBloque();
	}

	/**
	 * Renvoie une représentation sous forme de chaîne de l'objet d'un Pion
	 * @return un string représentant un Pion avec c'est coordonée
	 */
	public String toString() {
		return "Pion(" + ligne + "," + colonne + ")";
	}


}
