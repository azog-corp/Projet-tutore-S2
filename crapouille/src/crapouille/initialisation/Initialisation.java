/**
 * Initialisation.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille.initialisation;

/**
 * Class de l'objet Initialisation
 * @author Azog-corp
 */
public class Initialisation {

	private int ligne,            // Nombre de ligne pour l'initialisation
	            colonne,          // Nombre de colonne pour l'initialisation
	            nbPion;           // Nombre de pion à initialiser
	private int[][] coGrenouille, // Coordonées de base des grenouilles
	                coCrapaud;    // Coordonées de base des crapauds

	/**
	 * COnstructeur de l'objet Initailisation
	 * @param ligne, Nombre de ligne pour l'initialisation
	 * @param colonne, Nombre de colonne pour l'initialisation
	 * @param nbPion, Nombre de pion à initialiser
	 * @param coGrenouille, Coordonées de base des grenouilles
	 * @param coCrapaud, Coordonées de base des crapauds
	 */
	public Initialisation(int ligne, int colonne, int nbPion, int[][] coGrenouille, int[][] coCrapaud) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.nbPion = nbPion;
		this.coGrenouille = coGrenouille;
		this.coCrapaud = coCrapaud;
	}

	/**
	 * Retourne la le nombre de ligne qui ont été initialisé
	 * @return ligne
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Fonction permettant de modifier le nombre de ligne de l'objet Initialisation
	 */
	public void setLigne(int ligne) {
		if (ligne < 0) {
			throw new RuntimeException("Une ligne ne peut pas être négatif");
		} 
		this.ligne = ligne;	
	}

	/**
	 * Retourne la le nombre de colonne qui ont été initialisé
	 * @return colonne
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * Fonction permettant de modifier le nombre de colonne de l'objet Initialisation
	 */
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	/**
	 * Retourne la le nombre de pion qui ont été initialisé
	 * @return nbPion, le nombre de pion initialisé
	 */
	public int getNbPion() {
		return nbPion;
	}

	/**
	 * Fonction permettant de modifier le nombre de Pion de l'objet Initialisation
	 */
	public void setNbPion(int nbPion) {
		this.nbPion = nbPion;
	}
	
	/**
	 * Retourne un tableau avec les coordonées des grenouilles qui ont été initialisé
	 * @return coGrenouille, tableau des coordonnée des grenouilles
	 */
	public int[][] getCoGrenouille() {
		return coGrenouille;
	}

	/**
	 * Fonction permettant de modifier le tableau des 
	 * coordonnées des grenouilles de l'objet Initialisation
	 */
	public void setCoGrenouille(int[][] coGrenouille) {
		this.coGrenouille = coGrenouille;
	}

	/**
	 * Retourne un tableau avec les coordonées des crapauds qui ont été initialisé
	 * @return coCrapaud, tableau des coordonnée des Crapauds
	 */
	public int[][] getCoCrapaud() {
		return coCrapaud;
	}

	/**
	 * Fonction permettant de modifier le tableau des 
	 * coordonnées des grenouilles de l'objet Initialisation
	 */
	public void setCoCrapaud(int[][] coCrapaud) {
		this.coCrapaud = coCrapaud;
	}
}
