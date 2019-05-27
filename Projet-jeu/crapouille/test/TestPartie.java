package crapouille.test;

import crapouille.*;
import crapouille.configuration.Configuration;

public class TestPartie {

	private static void testMovePion() {
		Partie.loadConfig(0);
		System.out.println("\n\nTentative de déplacement de certains pion\n"
				+ Partie.getCurrentPlateau().toString());
		Partie.currentPlateau.movePion(Partie.currentPlateau.getBatracien()[0][0]);
		Partie.currentPlateau.movePion(Partie.currentPlateau.getBatracien()[1][0]);
		System.out.println("\n" + Partie.currentPlateau.toString());
	}
	
	private static void testSetColonne() {
		Partie.loadConfig(0);
		System.out.println("\n\nTentative de déplacement d'un pion pour vérifié le changement de colonne\n"
				+ Partie.getCurrentPlateau().toString());
	}

	public static void main(String[] args) {
		Configuration.initConfig();
		System.out.println("----- Test visuel des différentes fonction -----");
		System.out.println(Partie.getCurrentPlateau().toString());
		testMovePion();
		testSetColonne();
	}
}
