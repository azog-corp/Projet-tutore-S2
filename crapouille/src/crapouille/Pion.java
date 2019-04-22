package crapouille;

import crapouille.Plateau;


public class Pion {


	private int abscisse,
	ordonnee;
	private boolean crapaud,
	bloque;

	public Pion(int abscisse, int ordonnee, boolean crapaud) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.crapaud = crapaud;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setAbscisse(int abscisse, Pion[][] plateau) {
		// Si le pion est un crapaud est que la première case de droite est vide
		if (crapaud && plateau[this.abscisse+1][this.ordonnee] == null) {
			this.abscisse = abscisse+1;
		// Si le pion est un crapaud est que la deuxième case de droite est vide
		} else if (crapaud && plateau[this.abscisse+2][this.ordonnee] == null) {
			this.abscisse = abscisse+2;
		// Si le pion est une grenouille est que la première case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) {
			this.abscisse = abscisse-1;
		// Si le pion est une grenouille est que la deuxième case de droite est vide
		} else if (!crapaud && plateau[this.abscisse-2][this.ordonnee] == null) {
			this.abscisse = abscisse-2;
		}
	}

	public void setBloque(boolean bloque, Pion[][] plateau) {
		// Si le pion est un crapaud est que la première case de gauche est vide
		if ((crapaud && plateau[this.abscisse+1][this.ordonnee] == null) || 
				// Si le pion est un crapaud est que la deuxième case de gauche est vide
				(crapaud && plateau[this.abscisse+2][this.ordonnee] == null) ||
				// Si le pion est une grenouille est que la première case de droite est vide
				((!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) || 
						// Si le pion est une grenouille est que la première case de droite est vide
						(!crapaud && plateau[this.abscisse-2][this.ordonnee] == null))) {
			this.bloque = false; // Le pion n'est pas bloqué
		} else {
			this.bloque = true; // Le pion est bloqué
		}
	}

	public boolean isCrapaud() {
		return crapaud;
	}

	public boolean isBloque() {
		return bloque;
	}
}
