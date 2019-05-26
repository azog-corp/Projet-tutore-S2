package crapouille.test;

import crapouille.*;
import crapouille.configuration.Configuration;

public class TestPartie {

	public static Plateau plateauTest;

	public static Pion grenouilleTest1 = new Pion(0, 0, false);
	public static Pion grenouilleTest2 = new Pion(1, 0, false);
	public static Pion grenouilleTest3 = new Pion(2, 0, false);
	public static Pion crapaudTest1 = new Pion(0, 2, false);
	public static Pion crapaudTest2 = new Pion(1, 2, false);
	public static Pion crapaudTest3 = new Pion(2, 2, false);

	public static Pion[][] pionTest = {
			{grenouilleTest1, null, crapaudTest1}, 
			{grenouilleTest2, null, crapaudTest2},
			{grenouilleTest1, null, crapaudTest3}
	};

	private static void testTourEntite() {
		Partie.setChoixAdversaire(0);
		Partie.setChoixModeDeJeu(1);
		System.out.println("\n\nTentative de déplacement de tous les pions\n"
				+ Partie.getCurrentPlateau().toString());
		for (int x = 0 ; x < 7 ; x++) {
			for (int y = 0 ; y < 3 ; y++) {
				if (Partie.tourEntite(x, y)) {
					System.out.println("Pion déplacé");
				}
			}
		}
		System.out.println(Partie.currentPlateau.toString());
	}

	public static void main(String[] args) {
		Configuration.initConfig();
		Partie.loadConfig(0);
		System.out.println("----- Test visuel de la classe partie -----");
		System.out.println(Partie.getCurrentPlateau().toString());
		testTourEntite();

	}

}
