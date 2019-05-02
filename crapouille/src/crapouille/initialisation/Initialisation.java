/**
 * 
 */
package crapouille.initialisation;

/**
 * @author maell
 *
 */
public class Initialisation {

	private int ligne,
	colonne,
	nbPion;
	private int[][] coGrenouille,
	coCrapaud;

	public Initialisation(int ligne, int colonne, int nbPion, int[][] coGrenouille, int[][] coCrapaud) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.nbPion = nbPion;
		this.coGrenouille = coGrenouille;
		this.coCrapaud = coCrapaud;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getNbPion() {
		return nbPion;
	}

	public void setNbPion(int nbPion) {
		this.nbPion = nbPion;
	}
	public int[][] getCoGrenouille() {
		return coGrenouille;
	}

	public void setCoGrenouille(int[][] coGrenouille) {
		this.coGrenouille = coGrenouille;
	}

	public int[][] getCoCrapaud() {
		return coCrapaud;
	}

	public void setCoCrapaud(int[][] coCrapaud) {
		this.coCrapaud = coCrapaud;
	}
}
