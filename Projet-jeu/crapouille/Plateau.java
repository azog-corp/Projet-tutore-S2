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
	 * présentent sur le plateau.
	 * La première ligne contient tous les pion grenouilles
	 * et la seconde tous les crapaud
	 */
	private Pion[][] batracien = new Pion[2][];
	
	/**
	 * Plateau de taille maximale
	 */
	private Pion[][] plateau;

	/**
	 * Plateau sur lequel sont placés et déplacés
	 * chaque pion des deux équipes.
	 * Les dimensions de celui-ci ne sont
	 * pas necessairement celles de la configuaration
	 */
	public Plateau(Pion[][] plateau) {
		this.plateau = new Pion[LIGNE_MAX][COLONNE_MAX];
		this.ligneConf = plateau.length;
		this.colonneConf = plateau[0].length;
		for (int x = 0 ; x < this.ligneConf ; x++) {
			for (int y = 0 ; y < this.colonneConf ; y++) {
				this.plateau[x][y] = plateau[x][y];
				if (this.plateau[x][y] != null) {
					this.nbPion++;
				}
			}
		}
		System.out.println(this.nbPion);
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
	 * Fonction appelé lors de la création d'une configuration
	 * et qui initialise l'attribut bloque de chaque pion
	 */
	public void initBloque() {
		for (int x = 0 ; x < this.ligneConf ; x++) {
			for (int y = 0 ; y < this.colonneConf ; y++) {
				if (this.plateau[x][y] != null) {
					this.plateau[x][y].setBloque(plateau);
				}
			}
		}
	}
	
	/**
	 * Fonction appelé lors du chargement d'une configuration
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
					this.batracien[1][crapaud] = this.plateau[x][y];					System.out.println(this.batracien[1][crapaud].getLigne()+ " " + this.batracien[1][crapaud].getColonne());
					crapaud++;
				} else if (this.plateau[x][y] != null && !this.plateau[x][y].isCrapaud()) {
					this.batracien[0][grenouille] = this.plateau[x][y];					System.out.println(this.batracien[0][crapaud].getLigne()+ " " + this.batracien[0][crapaud].getColonne());
					grenouille++;
				}
			}
		}
	}
	
	/**
	 * Associe un pion à une case du plateau
	 * @param pion, Le pion qui doit être associé
	 */
	public void setCase(Pion pion) {
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
	}
	
	/**
	 * Cette fonction déplace un pion sur le plateau, puis change
	 * la colonne de celui-ci et enfin, réinitialise l'attribut
	 * bloque de chaque pion présent sur la ligne du pion déplacé
	 * @param pion le pion bougé
	 */
	public void movePion(Pion pion) {
		this.plateau[pion.getLigne()][pion.getColonne()] = null;
		pion.setColonne(this.plateau);
		this.plateau[pion.getLigne()][pion.getColonne()] = pion;
		for (int x = 0 ; x < this.ligneConf ; x++) {
			if (this.plateau[pion.getLigne()][x] != null) {
				this.plateau[pion.getLigne()][x].setBloque(this.plateau);
			}
		}
	}
	
	/**
	 * Vérifie si un pion dont les coordonnées sont placées en argument
	 * existe et s'il appartient à l'équipe dont c'est le tour
	 * @param equipe 0 sigifie l'équipe grnouille, 1 l'équipe crapaud
	 * @param ligne du potentiel pion
	 * @param colonne du potentiel pio
	 * @return true si le pion existe et appartient à la vonne équipe
	 */
	public boolean pionValide(int equipe, int ligne, int colonne) {
		for (int x = 0 ; x < this.batracien[0].length ; x++) {
			if (this.batracien[equipe][x].getLigne() == ligne && 
					this.batracien[equipe][x].getColonne() == colonne &&
					!this.plateau[ligne][colonne].isBloque()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * VÃ©rifie si tous les pions d'une Ã©quipe sont bloquÃ©s
	 * @param equipe 0 pour les grenouille et 1 pour les crapauds
	 * @return true si les pions sont ploquÃ©
	 */
	public boolean victoire(int equipe) {
		for (int x = 0 ; x < this.batracien[equipe].length ; x++) {
			// Si un pion n'est pas bloquÃ©, alors c'est faux
			if (!this.batracien[equipe][x].isBloque()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * VÃ©rifie si toutes les grenouilles sont Ã  droite
	 * et si tous les crapaud sont Ã  gauche
	 * @return true si c'est vrai
	 */
	public boolean victoireCasseTete() {
		int nbPion, // Nombre de pion bien placÃ©s
		colonne, // Colonne sur laquelle on fait une recherche des grenouille
		colonneC = this.colonneConf, // Colonne sur laquelle on fait une recherche des crapaud
		pionVictoire = this.batracien[0].length*2, // Nombre total de pion
		ligne;
		nbPion = ligne = colonne = 0; // On commence par la colonne la plus Ã  gauche
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
	 * Crée un String qui représente le plateau de jeu
	 * avec les pions et leur type
	 */
	public String toString() {
		StringBuilder plateauString = new StringBuilder();
		plateauString.append(" |");
		for (int z = 0 ; z < this.colonneConf ; z++) {
			plateauString.append(z+1 + " | ");
		}
		for (int x = 0 ; x < this.ligneConf ; x++) {
			plateauString.append("\n" + (x+1) + " |");
			for (int y = 0 ; y < this.colonneConf ; y++) {
				if (this.plateau[x][y] != null) {
					if (this.plateau[x][y].isCrapaud()) {
						plateauString.append("C|");
					} else if (!this.plateau[x][y].isCrapaud()) {
						plateauString.append("G|");
					}
				} else {
					plateauString.append("    |");
				}
			}
		}
		return plateauString.toString();
	}
}
