package crapouille;

import crapouille.Pion;

public class Plateau {

	private int abscisse,
	ordonnee;
	private static Pion[][] plateau;

	public Plateau(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.plateau = new Pion[abscisse][ordonnee];
	}

	public static void movePion(Pion pion) {
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = null;
		pion.setAbscisse(pion.getAbscisse(), plateau);
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}
}