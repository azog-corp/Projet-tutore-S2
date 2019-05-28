package crapouille.test;

import crapouille.*;
import java.util.Scanner;

public class TestPartie {


	private static Scanner entree = new Scanner(System.in);

	private static Pion pionGrenouille1 = new Pion(0, 0, false);
	private static Pion pionGrenouille2 = new Pion(1, 0, false);
	private static Pion pionCrapaud1 = new Pion(0, 2, true);
	private static Pion pionCrapaud2 = new Pion(1, 2, true);

	public static void continuer() {
		System.out.println("\nAppuyer sur entrée pour continuer");
		entree.nextLine();
	}

	private static void testMovePion() {
		Pion[][] plateauTest1 = {
				{pionGrenouille1, null, pionCrapaud1},
				{pionGrenouille2, null, pionCrapaud2}
		};
		int lastColonne = 0;
		Plateau testPlateau1 = new Plateau(plateauTest1);
		int nbTestOK = 0;
		for (int x = 0 ; x < 2 ; x++) {
			System.out.println("Déplacement du pion " 
		+ testPlateau1.getBatracien()[0][x].toString());
			lastColonne = testPlateau1.getBatracien()[0][x].getColonne();
			testPlateau1.movePion(testPlateau1.getBatracien()[0][x]);
			if (lastColonne != testPlateau1.getBatracien()[0][x].getColonne()) {
				nbTestOK++;
			}
			System.out.println(testPlateau1.toString() + "\n");
			lastColonne = testPlateau1.getBatracien()[1][x].getColonne();
			System.out.println("Déplacement du pion " 
			+ testPlateau1.getBatracien()[1][x].toString());
			testPlateau1.movePion(testPlateau1.getBatracien()[1][x]);
			if (lastColonne != testPlateau1.getBatracien()[1][x].getColonne()) {
				nbTestOK++;
			}
			System.out.println(testPlateau1.toString() + "\n");
		}
		if (nbTestOK == 4) {
			System.out.println("Les quatre pions ont été dépacé avec succès");
			continuer();
		}

		Pion[][] plateauTest2 = {
				{pionGrenouille1, pionCrapaud2},
				{pionCrapaud1, pionGrenouille2}
		};
		Plateau testPlateau2 = new Plateau(plateauTest2);
		nbTestOK = 0;
		for (int x = 0 ; x <= 1 ; x++) {
			System.out.println("Tentative de déplacement du pion bloqué " 
		+ testPlateau2.getBatracien()[0][x].toString());
			lastColonne = testPlateau2.getBatracien()[0][x].getColonne();
			testPlateau2.movePion(testPlateau2.getBatracien()[0][x]);
			if (lastColonne == testPlateau2.getBatracien()[0][x].getColonne()) {
				nbTestOK++;
			}
			System.out.println(testPlateau2.toString() + "\n");
			lastColonne = testPlateau2.getBatracien()[1][x].getColonne();
			System.out.println("Tentative de déplacement du pion bloqué " 
			+ testPlateau2.getBatracien()[1][x].toString());
			testPlateau2.movePion(testPlateau2.getBatracien()[1][x]);
			if (lastColonne == testPlateau2.getBatracien()[1][x].getColonne()) {
				nbTestOK++;
			}
			System.out.println(testPlateau2.toString() + "\n");
		}
		if (nbTestOK == 4) {
			System.out.println("Aucun pion n'a pu être déplacé");
			continuer();
		}

	}

	private static void testSetColonne() {

	}

	public static void main(String[] args) {
		System.out.println("----- Test visuel des différentes fonction -----");
		testMovePion();
		testSetColonne();
	}
}
