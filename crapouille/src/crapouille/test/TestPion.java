package crapouille.test;

import crapouille.Pion;
import java.util.Scanner;

public class TestPion {
	
	/* Initialisation  de l'analyseur lexical */
    static Scanner entree = new Scanner(System.in);
    
    /* initialisation des pions pour les test */
    static Pion pionTest1 = new Pion(0,1,true);

	static Pion pionTest2 = new Pion(0,2,true);

	static Pion pionTest3 = new Pion(1,2,false);

	static Pion pionTest4 = new Pion(0,3,true);

	static Pion pionTest5 = new Pion(1,3,false);

	static Pion pionTest6 = new Pion(2,3,false);

	static Pion pionTest7 = new Pion(4,4,true);

	static Pion pionTest8 = new Pion(4,5,false);

	static Pion pionTest9 = new Pion(3,6,true);

	static Pion pionTest10 = new Pion(4,6,false);

	static Pion pionTest11 = new Pion(2,7,true);

	static Pion pionTest12 = new Pion(3,7,true);

	static Pion pionTest13 = new Pion(4,7,false);

	static Pion pionTest14 = new Pion(0,8,false);
         
    
    
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
				if ( entree.hasNextInt()) {
					ligne = entree.nextInt();
				} else {
					System.out.println("Erreur, veillez rentrer un entier");
					entree.nextLine();
				}
			} while(!entree.hasNextInt());
		
			/* boucle vérifiant si l'utilisateur rentre un entier en colonne */
			do {
				System.out.print("Veillez rentrer une valeur pour l'ordonnée du pion :");
				if ( entree.hasNextInt()) {
					colonne = entree.nextInt();
				} else {
					System.out.println("Erreur, veillez rentrer un entier");
				}
				entree.nextLine();
			} while(!entree.hasNextInt());
		
			/* boucle vérifiant si l'utilisateur rentre un boolean  */
			do {
				System.out.print("Votre pion est-il un crapaud :");
				if ( entree.hasNextBoolean()) {
					crapaud = entree.nextBoolean();
				} else {
					System.out.println("Erreur, veillez rentrer un boolean");
				}
				entree.nextLine();
			} while(!entree.hasNextBoolean());
			
			/* initialise un pion avec les valeur rentré au dessus */
			pionTest = new Pion( ligne, colonne, crapaud);
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
		ligneDebut = pionTest1.getligne();
		pionTest1.setligne(0, jeuTest);
		ligneFin = pionTest1.getligne();
		if ((ligneDebut + 1 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test si un crapaud avancé s'il y a u pion devant lui */
		ligneDebut = pionTest2.getligne();
		pionTest2.setligne(0, jeuTest);
		ligneFin = pionTest2.getligne();
		if ((ligneDebut + 2 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test quand un crapaud est bloqué par deux autre Pion */
		ligneDebut = pionTest4.getligne();
		pionTest4.setligne(0, jeuTest);
		ligneFin = pionTest4.getligne();
		if (ligneDebut != ligneFin ) {
			nbEchec++;
		}
		
		/*test si le pion est arriver à  la fin */
		ligneDebut = pionTest7.getligne();
		pionTest7.setligne(4, jeuTest);
		ligneFin = pionTest7.getligne();
		if (ligneDebut != ligneFin ) {
			nbEchec++;
		}
		
		/* Test d'avancement pour un crapaud sans être bloqué */
		ligneDebut = pionTest8.getligne();
		pionTest8.setligne(0, jeuTest);
		ligneFin = pionTest8.getligne();
		if ((ligneDebut - 1 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test si un crapaud avancé s'il y a u pion devant lui */
		ligneDebut = pionTest10.getligne();
		pionTest10.setligne(0, jeuTest);
		ligneFin = pionTest10.getligne();
		if ((ligneDebut - 2 ) != ligneFin ) {
			nbEchec++;
		}
		
		/* Test quand un crapaud est bloqué par deux autre Pion */
		ligneDebut = pionTest13.getligne();
		pionTest13.setligne(0, jeuTest);
		ligneFin = pionTest13.getligne();
		if (ligneDebut != ligneFin ) {
			nbEchec++;
		}
		
		/*test si le pion est arriver à  la fin */
		ligneDebut = pionTest14.getligne();
		pionTest14.setligne(0, jeuTest);
		ligneFin = pionTest14.getligne();
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
