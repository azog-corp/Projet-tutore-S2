package crapouille;

import crapouille.OutilAction;
import crapouille.Crapaud;
import crapouille.Grenouille;
import crapouille.Plateau;
import crapouille.Pion;


public class Pion {


	private int abscisse,
	ordonnee;
	private boolean bloque;

	public Pion(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
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

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}
}
