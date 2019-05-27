package crapouille.test;

import crapouille.*;
import crapouille.configuration.Configuration;

public class TestPartie {

	private static void testMovePion() {
		Partie.loadConfig(0);
		System.out.println("\n\nTentative de d�placement de certains pion\n"
				+ Partie.getCurrentPlateau().toString());
		Partie.currentPlateau.movePion(Partie.currentPlateau.getBatracien()[0][0]);
		Partie.currentPlateau.movePion(Partie.currentPlateau.getBatracien()[1][0]);
		System.out.println("\n" + Partie.currentPlateau.toString());
	}
	
	private static void testSetColonne() {
		Partie.loadConfig(0);
		System.out.println("\n\nTentative de d�placement d'un pion pour v�rifi� le changement de colonne\n"
				+ Partie.getCurrentPlateau().toString());
	}

	public static void main(String[] args) {
		Configuration.initConfig();
		System.out.println("----- Test visuel des diff�rentes fonction -----");
		System.out.println(Partie.getCurrentPlateau().toString());
		testMovePion();
		testSetColonne();
	}
}
