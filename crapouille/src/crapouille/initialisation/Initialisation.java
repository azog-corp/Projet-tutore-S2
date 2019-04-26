/**
 * 
 */
package crapouille.initialisation;

/**
 * @author maell
 *
 */
public class Initialisation {

	private int abscisse,
	ordonnee,
	nbPion;
	private int[][] coGrenouille,
	coCrapaud;

	public Initialisation(int abscisse, int ordonnee, int nbPion, int[][] coGrenouille, int[][] coCrapaud) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.nbPion = nbPion;
		this.coGrenouille = coGrenouille;
		this.coCrapaud = coCrapaud;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
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
