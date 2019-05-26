package crapouille.test;

import crapouille.*;
import crapouille.configuration.Configuration;

public class TestPartie {

	private static void testTourEntite() {
		
		int ligne,
		colonne,
		pionCorrect;

		Partie.setChoixAdversaire(0);
		Partie.setChoixModeDeJeu(0);
		System.out.println("\n\nTentative de déplacement de tous les pions\n"
				+ Partie.getCurrentPlateau().toString());
		for (int x = 0 ; x < Partie.getCurrentPlateau().getBatracien()[0].length ; x++) {
			ligne = Partie.getCurrentPlateau().getBatracien()[0][x].getLigne();
			colonne = Partie.getCurrentPlateau().getBatracien()[0][x].getColonne();
			if (Partie.tourEntite(ligne, colonne) && Partie.tourEntite(ligne, colonne)) {
				System.out.println("Pion déplacé");
			}
		}
		System.out.println(Partie.currentPlateau.toString());
	}

	public static void main(String[] args) {
		Configuration.initConfig();
		Partie.loadConfig(0);
		System.out.println("----- Test visuel des différentes fonction -----");
		System.out.println(Partie.getCurrentPlateau().toString());
		testTourEntite();

	}

}
