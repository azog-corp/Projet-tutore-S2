package crapouille;

import java.io.Serializable;

public class Plateau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -106406785084186219L;

	/**
	 * Nombre Ligne max pour les configuraions
	 */
	private final static int LIGNE_MAX = 20;

	/**
	 * Nombre Colonne max pour les configurations
	 */
	private final static int COLONNE_MAX = 20;

	/**
	 * Nombre de ligne de la configuration actuelle
	 */
	private int ligneConf;

	/**
	 * Nombre de colonne de la configuration actuelle
	 */
	private int colonneConf;

	private int nbPion = 0;

	/**
	 * Tableau contenant toutes les instances de pions
	 * pr�sentent sur le plateau.
	 * La premi�re ligne contient tous les pion grenouilles
	 * et la seconde tous les crapaud
	 */
	private Pion[][] batracien = new Pion[2][];

	/**
	 * Plateau de taille maximale
	 */
	private Pion[][] plateau;

	/**
	 * Plateau sur lequel sont plac�s et d�plac�s
	 * chaque pion des deux �quipes.
	 * Les dimensions de celui-ci ne sont
	 * pas necessairement celles de la configuaration
	 */
	public Plateau(Pion[][] plateau) {
		this.ligneConf = plateau.length;
		this.colonneConf = plateau[0].length;
		this.plateau = new Pion[this.ligneConf][this.colonneConf];

		for (int x = 0 ; x < this.ligneConf ; x++) {
			for (int y = 0 ; y < this.colonneConf ; y++) {
				this.plateau[x][y] = plateau[x][y];
				if (this.plateau[x][y] != null) {
					this.nbPion++;
				}
			}
		}
		setBatracien();
	}

	/**
	 * 
	 * @return
	 */
	public Pion[][] getPlateau() {
		return plateau;
	}

	/**
	 * 
	 * @return
	 */
	public Pion[][] getBatracien() {
		return batracien;
	}

	/**
	 * Fonction appel� lors de la cr�ation d'une configuration
	 * et qui initialise l'attribut bloque de chaque pion
	 */
	public void initBloque() {
		for (int x = 0 ; x < this.ligneConf ; x++) {
			for (int y = 0 ; y < this.colonneConf ; y++) {
				if (this.plateau[x][y] != null) {
					this.plateau[x][y].setBloque(plateau, this.colonneConf);
				}
			}
		}
	}

	/**
	 * Fonction appel� lors du chargement d'une configuration
	 * et qui met dans le tableau batracien toutes les
	 * instances des pions grenouilles et crapaud
	 */
	public void setBatracien() {
		this.batracien = new Pion[2][this.nbPion/2];
		int crapaud = 0,
				grenouille = 0;
		for (int x = 0 ; x < this.ligneConf ; x++) {
			for (int y = 0 ; y < this.colonneConf ; y++) {
				if (this.plateau[x][y] != null && this.plateau[x][y].isCrapaud()) {
					this.batracien[1][crapaud] = new Pion (x, y, true);
					this.plateau[x][y] = this.batracien[1][crapaud];
					crapaud++;
				} else if (this.plateau[x][y] != null && !this.plateau[x][y].isCrapaud()) {
					this.batracien[0][grenouille] = new Pion (x, y, false);
					this.plateau[x][y] = this.batracien[0][grenouille];
					grenouille++;
				}
			}
		}
	}

	/**
	 * Associe un pion � une case du plateau
	 * @param pion, Le pion qui doit �tre associ�
	 */
	public void setCase(Pion pion) {
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
	}

	/**
	 * Cette fonction d�place un pion sur le plateau, puis change
	 * la colonne de celui-ci et enfin, r�initialise l'attribut
	 * bloque de chaque pion pr�sent sur la ligne du pion d�plac�
	 * @param pion le pion boug�
	 */
	public void movePion(Pion pion) {
		this.plateau[pion.getLigne()][pion.getColonne()] = null;
		pion.setColonne(this.plateau, this.colonneConf);
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
		for (int x = 0 ; x < this.ligneConf ; x++) {
			if (this.plateau[pion.getLigne()][x] != null) {
				this.plateau[pion.getLigne()][x].setBloque(this.plateau, this.colonneConf);
			}
		}
	}

	/**
	 * V�rifie si un pion dont les coordonn�es sont plac�es en argument
	 * existe et s'il appartient � l'�quipe dont c'est le tour
	 * @param equipe 0 sigifie l'�quipe grnouille, 1 l'�quipe crapaud
	 * @param ligne du potentiel pion
	 * @param colonne du potentiel pio
	 * @return true si le pion existe et appartient � la vonne �quipe
	 */
	public Pion pionValide(int equipe, int ligne, int colonne) {
		for (int x = 0 ; x < this.batracien[0].length ; x++) {
			if (this.batracien[equipe][x].getLigne() == ligne && 
					this.batracien[equipe][x].getColonne() == colonne &&
					!this.plateau[ligne][colonne].isBloque()) {
				return this.batracien[equipe][x];
			}
		}
		return null;
	}

	/**
	 * Vérifie si tous les pions d'une équipe sont bloqués
	 * @param equipe 0 pour les grenouille et 1 pour les crapauds
	 * @return true si les pions sont ploqué
	 */
	public boolean victoire(int equipe) {
		for (int x = 0 ; x < this.batracien[equipe].length ; x++) {
			// Si un pion n'est pas bloqué, alors c'est faux
			if (!this.batracien[equipe][x].isBloque()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vérifie si toutes les grenouilles sont �  droite
	 * et si tous les crapaud sont �  gauche
	 * @return true si c'est vrai
	 */
	public boolean victoireCasseTete() {
		int nbPion, // Nombre de pion bien placés
		colonne, // Colonne sur laquelle on fait une recherche des grenouille
		colonneC = this.colonneConf, // Colonne sur laquelle on fait une recherche des crapaud
		pionVictoire = this.batracien[0].length*2, // Nombre total de pion
		ligne;
		nbPion = ligne = colonne = 0; // On commence par la colonne la plus �  gauche
		// Pour chaque ligne du tableau
		while (ligne < ligneConf) {
			if (this.plateau[ligne][colonne] != null || this.plateau[ligne][colonne] != null) {
				if (this.plateau[ligne][colonne] != null && this.plateau[ligne][colonne].isCrapaud()) {
					nbPion++;
					colonne++;
				}
				if (this.plateau[ligne][colonne] != null && !this.plateau[ligne][colonneC].isCrapaud()) {
					nbPion++;
					colonneC--;
				}
			} else {
				ligne++;
			}
		}
		return nbPion == pionVictoire;
	}

	/**
	 * Fonction qui v�rifie la validit� d'un plateau de pion qui est d�termin� par :
	 * - Le nombre de ligne et de colonne doit �tre inf�rieur � 20
	 * - Il doit il y avoir au moins un pion de chaque type sur chaque ligne
	 * - Il doit y avoir autant de crapaud que de grenouille
	 * @param plateau � v�rifier
	 * @return true si toute les conditions sont valides
	 */
	public static boolean plateauEstValide(Pion[][] plateau) {
		boolean noCrapaud = false;
		boolean noGrenouille = false;
		int nbCrapaud = 0,
				nbGrenouille = 0;
		if (plateau.length > 20 || plateau[0].length > 20) {
			System.out.println("merde1");
			return false;
		}
		for (int ligne = 0 ; ligne < plateau.length ; ligne++) {
			if (noCrapaud || noGrenouille) {
				System.out.println("merde2");
				return false;
			}
			noCrapaud = noGrenouille = true;
			for (int colonne = 0 ; colonne < plateau[0].length ; colonne++) {
				if (plateau[ligne][colonne] != null && plateau[ligne][colonne].isCrapaud()) {
					nbCrapaud++;
					noCrapaud = false;
				}
				if (plateau[ligne][colonne] != null && !plateau[ligne][colonne].isCrapaud()) {
					nbGrenouille++;
					noGrenouille = false;
				}
			}
		}
		return nbCrapaud == nbGrenouille;
	}

	/**
	 * Cr�e un String qui repr�sente le plateau de jeu
	 * avec les pions et leur type
	 */
	public String toString() {
		StringBuilder plateauString = new StringBuilder();
		plateauString.append("  | ");
		for (int z = 0 ; z < this.colonneConf ; z++) {
			plateauString.append(z+1 + " | ");
		}
		for (int x = 0 ; x < this.ligneConf ; x++) {
			plateauString.append("\n" + (x+1) + " |");
			for (int y = 0 ; y < this.colonneConf ; y++) {
				if (this.plateau[x][y] != null) {
					if (this.plateau[x][y].isCrapaud()) {
						plateauString.append(" C |");
					} else if (!this.plateau[x][y].isCrapaud()) {
						plateauString.append(" G |");
					}
				} else {
					plateauString.append("   |");
				}
			}
		}
		return plateauString.toString();
	}
}