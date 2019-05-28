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

	/**
	 * Fonction testant movePion de la classe partie
	 * La première baterie de test fait bouger sur un
	 * plateau tous les pions y étant présent ce qui
	 * permet de vérifier le setColonne ainsi que le
	 * setBloque de la classe pion puisque ce sont des
	 * fonctions appelées par cette methode.
	 * 
	 * La deuxième baterrie de test appelle movePion
	 * sur des pions bloqués pour vérifier que le
	 * pion ne bouge pas et que le programme ne plante
	 * pas
	 * 
	 * On considère que 
	 * 
	 */
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

	/**
	 * Test de la fonction pionValide qui vérifie
	 * si un pion existe et qui retourne le pion
	 * si c'est le cas et null si ça ne l'est pas
	 */
	private static void testPionValide() {
		Pion[][] plateauTest = {
				{pionGrenouille1, null, pionCrapaud1},
				{pionGrenouille2, null, pionCrapaud2}
		};
		Plateau testPlateau = new Plateau(plateauTest);
		System.out.println("Test de pionValide sur des pions supposés valides\n" 
				+ testPlateau.toString());
		if (testPlateau.pionValide(0, 0, 0).equals(pionGrenouille1) &&
				testPlateau.pionValide(0, 1, 0).equals(pionGrenouille2) &&
				testPlateau.pionValide(1, 0, 2).equals(pionCrapaud1) &&
				testPlateau.pionValide(1, 1, 2).equals(pionCrapaud2)) {
			System.out.println("Les 4 pions existe");
			continuer();
		}
		System.out.println("Test de pionValide sur des pions supposés non-valide\n" 
				+ testPlateau.toString());
		if (testPlateau.pionValide(0, 0, 1) == null &&
				testPlateau.pionValide(0, 1, 1) == null &&
				testPlateau.pionValide(1, 0, 1) == null &&
				testPlateau.pionValide(1, 1, 1) == null) {
			System.out.println("Les deux cases du millieu sont vides");
		}
	}

	/**
	 * Fonction qui test le boolean victoire sur un plateau
	 * non gagnant et plateau gagnant pour chaque équipe
	 */
	private static void testVictoire() {
		Pion[][] plateauTest1 = {
				{pionGrenouille1, null, pionCrapaud1},
				{pionGrenouille2, null, pionCrapaud2}
		};
		Plateau testPlateau1 = new Plateau(plateauTest1);
		System.out.println("Test du boolean victoire sur un plateau non gagnant\n" 
				+ testPlateau1.toString());
		if (!testPlateau1.victoire(0) && !testPlateau1.victoire(1)) {
			System.out.println("Le plateau n'est pas gagnant");
			continuer();
		}
		
		Pion[][] plateauTest2 = {
				{pionGrenouille1, pionCrapaud1, null},
				{pionGrenouille2, pionCrapaud2, null}
		};
		Plateau testPlateau2 = new Plateau(plateauTest2);
		System.out.println("Test du boolean victoire sur un plateau gagnant pour les grenouilles\n" 
				+ testPlateau2.toString());
		if (testPlateau2.victoire(1)) {
			System.out.println("L'équipe grenouille est bien gagnante");
			continuer();
		}
		
		Pion[][] plateauTest3 = {
				{null, pionCrapaud1, pionGrenouille1},
				{null, pionCrapaud2, pionGrenouille2}
		};
		Plateau testPlateau3 = new Plateau(plateauTest3);
		System.out.println("Test du boolean victoire sur un plateau gagnant pour les crapauds\n" 
				+ testPlateau3.toString());
		if (testPlateau3.victoire(0)) {
			System.out.println("L'équipe crapauds est bien gagnante");
		}
	}
	
	private static void testVictoireCasseTete() {
		Pion[][] plateauTest1 = {
				{pionGrenouille1, null, pionCrapaud1},
				{pionGrenouille2, null, pionCrapaud2}
		};
		Plateau testPlateau1 = new Plateau(plateauTest1);
		System.out.println("Test du boolean victoireCasseTete sur un plateau non gagnant\n" 
				+ testPlateau1.toString());
		if (!testPlateau1.victoireCasseTete()) {
			System.out.println("La configuration n'est pas gagnante");
			continuer();
		}
		
		Pion[][] plateauTest2 = {
				{pionGrenouille1, pionCrapaud1, null},
				{pionGrenouille2, pionCrapaud2, null}
		};
		Plateau testPlateau2 = new Plateau(plateauTest2);
		System.out.println("Test du boolean victoire sur un plateau gagnant pour les grenouilles\n" 
				+ testPlateau2.toString());
		if (testPlateau2.victoireCasseTete()) {
			System.out.println("Le casse tete n'est pas gagné");
			continuer();
		}
	}

	public static void main(String[] args) {
		System.out.println("----- Test visuel des différentes fonction -----");
		// testMovePion();
		// testPionValide();
		// testVictoire();
		testVictoireCasseTete();
	}
}
