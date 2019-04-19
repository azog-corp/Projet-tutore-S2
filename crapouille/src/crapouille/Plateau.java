package crapouille;

import crapouille.Pion;

public class Plateau {
	
	private Pion[][] plateau;

	public Plateau(int abscisse, int ordonnee) {
		this.plateau = new Pion[abscisse][ordonnee];
	}

	public void movePion(Pion pion) {
		// La case ou se trouve le pion devient null
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = null;
		// On change l'abscisse du pion
		pion.setAbscisse(pion.getAbscisse(), plateau);
		// On met le pion dans sa case
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}
}