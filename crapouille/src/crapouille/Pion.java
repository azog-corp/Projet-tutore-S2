package crapouille;

import crapouille.Pion;


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
		if (crapaud && plateau[this.abscisse+1][this.ordonnee] != null) {
			this.abscisse = abscisse+1;
		} else if (crapaud && plateau[this.abscisse+2][this.ordonnee] != null) {
			this.abscisse = abscisse+2;
		} else if (!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) {
			this.abscisse = abscisse-1;
		} else if (!crapaud && plateau[this.abscisse-2][this.ordonnee] == null) {
			this.abscisse = abscisse-2;
		}
	}

	public void setBloque(boolean bloque, Pion[][] plateau) {
		if ((crapaud && plateau[this.abscisse+1][this.ordonnee] == null) || 
				(crapaud && plateau[this.abscisse+2][this.ordonnee] == null) ||
				((!crapaud && plateau[this.abscisse-1][this.ordonnee] == null) || 
						(!crapaud && plateau[this.abscisse-2][this.ordonnee] == null))) {
			this.bloque = false;
		} else {
			this.bloque = true;
		}
	}
	
	public boolean isCrapaud() {
		return crapaud;
	}

	public boolean isBloque() {
		return bloque;
	}
}
