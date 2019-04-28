package crapouille;

import crapouille.Pion;


public class Pion {


	private int abscisse,
	ordonnee;
	private boolean crapaud,
	bloque;

	public Pion(int abscisse, int ordonnee, boolean crapaud) {
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
		this.crapaud = crapaud;
	}

	/**  
	 * V�rifie si l'ordonnee d'un pion est positif lors de l'initialisation
	 * @param ordonnee, valeur rentr� par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setOrdonnee(int ordonnee) {
		if ( ordonnee < 0) {
			System.out.println("Vous ne pouvez pas mettre d'abscisse n�gative");
		} else {
			this.abscisse = ordonnee;
		}
	}

	/**  
	 * V�rifie si l'abscisse d'un pion est positif lors de l'initialisation
	 * @param abscisse, valeur rentr� par l'utilisateur pour l'ordonee du pion
	 * sur le plateau
	 */
	private void setAbscisse(int abscisse) {
		if ( abscisse < 0) {
			System.out.println("Vous ne pouvez pas mettre d'abscisse n�gative");
		} else {
			this.abscisse = abscisse;
		}
	}

	public int getAbscisse() {
		return abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setAbscisse(int abscisse, Pion[][] plateau) {
		// Si le pion est un crapaud est que la premi�re case de droite est vide
		if (crapaud && plateau[this.abscisse+1][this.ordonnee] == null) {
			this.abscisse = abscisse+1;
		// Si le pion est un crapaud est que la deuxi�me case de droite est vide
		} else if (crapaud && plateau[this.abscisse+2][this.ordonnee] == null) {
			this.abscisse = abscisse+2;
		// Si le pion est une grenouille est que la premi�re case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) {
			this.abscisse = abscisse-1;
		// Si le pion est une grenouille est que la deuxi�me case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-2][this.ordonnee] == null) {
			this.abscisse = abscisse-2;
		}
	}

	public void setBloque(boolean bloque, Pion[][] plateau) {
		// Si le pion est un crapaud est que la premi�re case de gauche est vide
		if ((crapaud && plateau[this.abscisse+1][this.ordonnee] == null) || 
				// Si le pion est un crapaud est que la deuxi�me case de gauche est vide
				(crapaud && plateau[this.abscisse+2][this.ordonnee] == null) ||
				// Si le pion est une grenouille est que la premi�re case de droite est vide
				((!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) || 
						// Si le pion est une grenouille est que la premi�re case de droite est vide
						(!crapaud && plateau[this.abscisse-2][this.ordonnee] == null))) {
			this.bloque = false; // Le pion n'est pas bloqu�
		} else {
			this.bloque = true; // Le pion est bloqu�
		}
	}

	public boolean isCrapaud() {
		return crapaud;
	}

	public boolean isBloque() {
		return bloque;
	}

	@Override
	public String toString() {
		return "Pion(" + abscisse + "," + ordonnee + ") crapaud=" + crapaud + ", bloque=" + bloque
				+ "]";
	}
	
	
}
