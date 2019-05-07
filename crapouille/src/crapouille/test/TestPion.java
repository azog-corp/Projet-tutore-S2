package crapouille.test;

import java.util.Scanner;

import crapouille.Pion;
import crapouille.Plateau;

public class TestPion {
	
	/* Initialisation  de l'analyseur lexical */
    static Scanner entree = new Scanner(System.in);
    
    static Plateau plateau = new Plateau(4, 9);
    
    /* initialisation des pions pour les test */
    static Pion pionTest1 = new Pion(0, 1, true, plateau);

	static Pion pionTest2 = new Pion(0, 2, true, plateau);

	static Pion pionTest3 = new Pion(1, 2, false, plateau);

	static Pion pionTest4 = new Pion(0, 3, true, plateau);

	static Pion pionTest5 = new Pion(1, 3, false, plateau);

	static Pion pionTest6 = new Pion(2, 3, false, plateau);

	static Pion pionTest7 = new Pion(4, 4, true, plateau);

	static Pion pionTest8 = new Pion(4, 5, false, plateau);

	static Pion pionTest9 = new Pion(3, 6, true, plateau);

	static Pion pionTest10 = new Pion(4, 6, false, plateau);

	static Pion pionTest11 = new Pion(2, 7, true, plateau);

	static Pion pionTest12 = new Pion(3, 7, true, plateau);

	static Pion pionTest13 = new Pion(4, 7, false, plateau);

	static Pion pionTest14 = new Pion(0, 8, false, plateau);
         
    
    
    /*
     * Tableau de jeu contenant des pion pour la vérification de la fonction set 
     */
	static Pion[][] jeuTest = {
			{},
			{pionTest1},
			{pionTest2,pionTest3},
			{pionTest4,pionTest5,pionTest6},
			{pionTest7},
			{pionTest8},
			{pionTest9,pionTest10},
			{pionTest11,pionTest12,pionTest13},
			{pionTest14}
	};
    
    
    /**
     * Test usuel permettant de vérifier la création d'un pion
     * Un pion est initailiser avec les valeur suivante :
     * <ol><li>ligne = 0</li>
     *     <li>colonne = 0</li>
     *     <li>crapaud  = false</li></ol>
     */
	public static void testCreationPion() {
		int ligne = 0,
		    colonne = 0;
		boolean crapaud = true;
		Pion pionTest;
		
		System.out.println("----------- Test usuel de"
				        + "la création de pion ------------");
		
		/* répete plusieur fois la création d'un pion pour tester */
		for (int nbEssai = 0; nbEssai < 5; nbEssai++) {
			
			/* boucle vérifiant si l'utilisateur rentre un entier en ligne */
			do {
				System.out.println("Veillez rentrer une valeur pour l'ligne du pion :");
				if (entree.hasNextInt()) {
					ligne = entree.nextInt()-1;
				} else {
					System.out.println("Erreur, veillez rentrer un entier");
				}
				entree.nextLine();
			} while(!entree.hasNextInt());
		
			/* boucle vérifiant si l'utilisateur rentre un entier en colonne */
			do {
				System.out.print("Veillez rentrer une valeur pour l'ordonnée du pion :");
				if (entree.hasNextInt()) {
					colonne = entree.nextInt()-1;
				} else {
					System.out.println("Erreur, veillez rentrer un entier");
				}
				entree.nextLine();
			} while(!entree.hasNextInt());
		
			/* boucle vérifiant si l'utilisateur rentre un boolean  */
			do {
				System.out.print("Votre pion est-il un crapaud (true/false) : ");
				if (entree.hasNextBoolean()) {
					crapaud = entree.nextBoolean();
				} else {
					System.out.println("Erreur, veillez rentrer un boolean");
				}
				entree.nextLine();
			} while(!entree.hasNextBoolean());
			
			/* initialise un pion avec les valeur rentré au dessus */
			pionTest = new Pion(ligne, colonne, crapaud, plateau);
			/* affiche les coordonné des pion rentré par l'utilisateur ou un pion avec les valeurs initialisé */
			System.out.println(pionTest);
		}
	}

	public static void testSetligne() {
		int ligneDebut,
		    ligneFin,
		    nbEchec = 0;
		
		System.out.println("----------- Test pour la fonction setligne ----------\n\n");
		
		/* Test d'avancement pour un crapaud sans être bloqué */
		ligneDebut = pionTest1.getLigne();
		pionTest1.setColonne(0, jeuTest);
		ligneFin = pionTest1.getLigne();
		if ((ligneDebut + 1 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test si un crapaud avancé s'il y a u pion devant lui */
		ligneDebut = pionTest2.getLigne();
		pionTest2.setColonne(0, jeuTest);
		ligneFin = pionTest2.getLigne();
		if ((ligneDebut + 2 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test quand un crapaud est bloqué par deux autre Pion */
		ligneDebut = pionTest4.getLigne();
		pionTest4.setColonne(0, jeuTest);
		ligneFin = pionTest4.getLigne();
		if (ligneDebut != ligneFin ) {
			nbEchec++;
		}
		
		/*test si le pion est arriver à  la fin */
		ligneDebut = pionTest7.getLigne();
		pionTest7.setColonne(4, jeuTest);
		ligneFin = pionTest7.getLigne();
		if (ligneDebut != ligneFin ) {
			nbEchec++;
		}
		
		/* Test d'avancement pour un crapaud sans être bloqué */
		ligneDebut = pionTest8.getLigne();
		pionTest8.setColonne(0, jeuTest);
		ligneFin = pionTest8.getLigne();
		if ((ligneDebut - 1 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test si un crapaud avancé s'il y a u pion devant lui */
		ligneDebut = pionTest10.getLigne();
		pionTest10.setColonne(0, jeuTest);
		ligneFin = pionTest10.getLigne();
		if ((ligneDebut - 2 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test quand un crapaud est bloqué par deux autre Pion */
		ligneDebut = pionTest13.getLigne();
		pionTest13.setColonne(0, jeuTest);
		ligneFin = pionTest13.getLigne();
		if (ligneDebut != ligneFin ) {
			nbEchec++;
		}
		
		/*test si le pion est arriver à  la fin */
		ligneDebut = pionTest14.getLigne();
		pionTest14.setColonne(0, jeuTest);
		ligneFin = pionTest14.getLigne();
		if (ligneDebut != ligneFin ) {
			nbEchec++;
		}
		
		System.out.println("Il y a " + nbEchec + " echec.\n\n");
	}
	
	public static void main(String[] args) {
		testSetligne();
		testCreationPion();

	}

}
