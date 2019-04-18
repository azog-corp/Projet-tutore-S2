package crapouille;

import crapouille.Pion;

public class Plateau {
	
	private Pion[][] plateau;

	public Plateau(int abscisse, int ordonnee) {
		this.plateau = new Pion[abscisse][ordonnee];
	}

	public void movePion(Pion pion) {
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = null;
		pion.setAbscisse(pion.getAbscisse(), plateau);
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}
}