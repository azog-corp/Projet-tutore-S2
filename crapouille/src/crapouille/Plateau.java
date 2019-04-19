package crapouille;

import crapouille.Pion;

public class Plateau {
	
	private Pion[][] plateau;

	public Plateau(int abscisse, int ordonnee) {
		this.plateau = new Pion[abscisse][ordonnee];
	}
	

	public Pion[][] getPlateau() {
		return plateau;
	}


	public void setPlateau(Plateau[][] plateaus, Pion[] pion) {
		for (int nbPion = 0 ; nbPion < 20 ; nbPion++) {
			this.plateau[pion[nbPion].getAbscisse()][pion[nbPion].getOrdonnee()] = pion[nbPion];
		}
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