/**
 * 
 */
package crapouille.configuration;

/**
 * @author Azog
 *
 */
public class Configuration {

	private int ligne,
	colonne,
	nbPion;
	private int[][] coGrenouille,
	coCrapaud;
	
	
	public Configuration(int ligne, int colonne, int nbPion, int[][] coGrenouille, int[][] coCrapaud) {
		if (ligne <= 0 || colonne <= 0) {
			throw new RuntimeException("Erreur ! Les coordonnées du plateau doivent être positives");
		}
		if (nbPion > (ligne * colonne - colonne)) {
			throw new RuntimeException("Erreur ! Il y a trop de pion");
		}
		if (coGrenouille[0].length != coGrenouille[1].length ||
				coGrenouille[0].length != coCrapaud[0].length || 
				coGrenouille[0].length != coCrapaud[1].length ||
				coGrenouille.length != 2 || coCrapaud.length != 2) {
			throw new RuntimeException("Erreur ! Les tableaux de coordonnées sont invalides");
		}
		this.ligne = ligne;
		this.colonne = colonne;
		this.nbPion = nbPion;
		this.coGrenouille = coGrenouille;      
		this.coCrapaud = coCrapaud;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public int getNbPion() {
		return nbPion;
	}

	public int[][] getCoGrenouille() {
		return coGrenouille;
	}

	public int[][] getCoCrapaud() {
		return coCrapaud;
	}

}
