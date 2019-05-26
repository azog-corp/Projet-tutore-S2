package crapouille.test;

import crapouille.*;
import crapouille.configuration.Configuration;

public class TestPartie {

	private static void testMovePion() {

		int ligne,
		colonne,
		pionCorrect;

		Partie.loadConfig(0);
		System.out.println("\n\nTentative de déplacement de tous les pions\n"
				+ Partie.getCurrentPlateau().toString());
		for (int x = 0 ; x < Partie.currentPlateau.getPlateau()[0].length ; x++) {
			for (int y = 0 ; y < Partie.currentPlateau.getPlateau().length ; y++) {
				if (Partie.getCurrentPlateau().getPlateau()[y][x] != null) {
					Partie.getCurrentPlateau().movePion(Partie.getCurrentPlateau().getPlateau()[x][y]);
					System.out.println("yes");
					x++;
				}
			}
		}
		System.out.println("\n" + Partie.currentPlateau.toString());
	}

	public static void main(String[] args) {
		Configuration.initConfig();
		System.out.println("----- Test visuel des différentes fonction -----");
		System.out.println(Partie.getCurrentPlateau().toString());
		testMovePion();

	}

}
