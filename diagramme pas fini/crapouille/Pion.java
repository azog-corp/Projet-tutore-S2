/*
 * Pion.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille;

import java.io.Serializable;

/**
 * Class de l'objet Pion contenant deux fonctions principales
 * La premi�re modifie la colonne d'un pion
 * La deuxi�me v�rifie si le pion est bloqu�
 * @author Azog-corp
 */
public class Pion implements Serializable {

	/** ID de la serialisation */
	private static final long serialVersionUID = -2711928380072215024L;
	private int ligne, // indique sur qu'elle ligne ce situe le pion
	colonne;           // indique sur qu'elle colonne ce situe le pion
	private boolean crapaud,   // indique si le p�on est un crapaud ou non
	bloque;                    // indique si le pion est bloqu�

	/**
	 * Constructeur d'un pion qui lui associe trois caract�risques
	 * @param ligne, repr�sente la ligne o� sera situ� notre pion
	 * @param colonne, repr�sente la colonne o� sera situ� notre pion
	 * @param crapaud, Indique si le pion est un crapoaud ou non
	 * @param plateau, permet de v�rifier que les coordonn�es du pion
	 * sont incluses dans le plateau
	 */
	public Pion(int ligne, int colonne, boolean crapaud) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.crapaud = crapaud;
	}

	/**
	 * Renvoie la valeur de la ligne de l'objet Pion demand�
	 * @return ligne du pion demand�
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Renvoie la valeur de la colonne de l'objet Pion demand�
	 * @return colonne du pion demand�
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * V�rifie premi�rement que le pion n'est pas bloqu�.
	 * Ajoute/enl�ve un � colonne si la case adjacente au pion est libre
	 * Ajoute/enl�ve deux � colonne si la case adjacente au pion est du
	 * m�me type que le pion � d�plac� et que la case suivante est libre
	 * @param plateau, plateau contenant des pions
	 * @param ligneConf
	 */
	public void setColonne(Pion[][] plateau, int colonneConf) {
		if (this.bloque) {
			System.out.println("Le pion est bloqu�");
			return;
		}
		/* Si le pion est une grenouille est que la premi�re case de droite est vide */
		if (!crapaud && this.colonne < colonneConf-1 && plateau[this.ligne][this.colonne+1] == null) {
			this.colonne = colonne+1;
			/* Si le pion est une grenouille est que la deuxi�me case de droite est vide */
		} else if (!crapaud && this.colonne < colonneConf-2 && plateau[this.ligne][this.colonne+1].crapaud &&
				plateau[this.ligne][this.colonne+2] == null) {
			this.colonne = colonne+2;
			/* Si le pion est un crapaud est que la premi�re case de gauche est vide */
		} else if (crapaud && this.colonne > 0 && plateau[this.ligne][this.colonne-1] == null) {
			this.colonne = colonne-1;
			/* Si le pion est un crapaud est que la deuxi�me case de gauche est vide */
		} else if (crapaud && this.colonne > 1 && !plateau[this.ligne][this.colonne-1].crapaud &&
				plateau[this.ligne][this.colonne-2] == null) {
			this.colonne = colonne-2;
		}
	}

	/**
	 * V�rifie si un pion est bloqu� :
	 * <ol><li>- Si un pion n'est pas bloqu�, il ajoute la valeur false � 
	 *         la propri�te bloque de l'objet Pion.</li>
	 *     <li>- Si un pion est bloqu�, il ajoute la valeur true � 
	 *         la propri�ter bloque de l'objet Pion.</li></ol>
	 * @param bloque, boolean indiquant si un pion est bloqu� ou non
	 * @param plateau, tableau contenant des Pions
	 */
	public void setBloque(Pion[][] plateau, int colonneConf) {
		/* Si le pion est une grenouille, qu'il � une case du bord et que sa case adjacente est vide */
		if ((!crapaud && this.colonne < colonneConf-1 && plateau[this.ligne][this.colonne+1] == null) 
				/* Si le pion est une grenouille, qu'il � deux cases du bord,
				 * que sa case adjacente est un crapaud et que la case suivante est vide */
			||(!crapaud && this.colonne < colonneConf-2 && plateau[this.ligne][this.colonne+1].crapaud && 
						plateau[this.ligne][this.colonne+2] == null) 
			/* Si le pion est un crapaud, qu'il � une case du bord et que sa case adjacente est vide */
			||((crapaud && this.colonne > 0 && plateau[this.ligne][this.colonne-1] == null) 
					/* Si le pion est un crapaud, qu'il � deux cases du bord,
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
	 * Fonction qui permet d'indiquer si un pion est bloqu� ou non
	 * @return bloque, un boolean indiquant si le pion est bloqu� ou non
	 */
	public boolean isBloque() {
		return bloque;
	}
	
	/**
	 * Fonction qui v�rifie si deux pions sont �gaux
	 * @param pion le pion a v�rifier
	 * @return true s'ils sont �gaux
	 */
	public boolean equals(Pion pion) {
		return this.ligne == pion.getLigne() &&
				this.colonne == pion.getColonne() &&
				this.crapaud == pion.isCrapaud() &&
				this.bloque == pion.isBloque();
	}

	/**
	 * Renvoie une repr�sentation sous forme de cha�ne de l'objet d'un Pion
	 * @return un string repr�sentant un Pion avec c'est coordon�e
	 */
	public String toString() {
		return "Pion(" + ligne + "," + colonne + ")";
	}


}
