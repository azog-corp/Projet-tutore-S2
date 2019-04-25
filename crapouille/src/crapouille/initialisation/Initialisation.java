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

	public Initialisation(int abscisse, int ordonnee, int nbPion) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.nbPion = nbPion;
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
}
