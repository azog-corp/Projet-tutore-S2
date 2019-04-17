package crapouille;

import crapouille.Crapaud;
import crapouille.Grenouille;
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

	public static void movePion(Pion pion, int oldAbscisse, int oldOrdonnee) {
		plateau[oldAbscisse][oldOrdonnee] = null;
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}
}