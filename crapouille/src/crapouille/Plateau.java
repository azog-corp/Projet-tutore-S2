package crapouille;

import crapouille.Pion;

public class Plateau {

	private int abscisse,
	ordonnee;
	private Pion[][] plateau;

	public Plateau(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.plateau = new Pion[abscisse][ordonnee];
	}


	public Pion[][] getPlateau() {
		return plateau;
	}


	public void setCase(Pion pion) {
		this.plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}


	public void movePion(Pion pion) {
		// La case ou se trouve le pion devient null
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = null;
		// On change l'abscisse du pion
		pion.setAbscisse(pion.getAbscisse(), plateau);
		// On met le pion dans sa case
		plateau[pion.getAbscisse()][pion.getOrdonnee()] = pion;
	}

	public void afficherPlateau() {
		for (int x = 0 ; x < this.abscisse ; x++) {
			System.out.print("[");
			for (int y = 0 ; y < this.ordonnee ; y++) {
				if (this.plateau[x][y] != null) {
					if (this.plateau[x][y].isCrapaud()) {
						System.out.print("C|");
					} else if (!this.plateau[x][y].isCrapaud()) {
						System.out.print("G|");
					}
				} else {
					System.out.print(" |");
				}
			}
			System.out.print("]\n");
		}
	}

}