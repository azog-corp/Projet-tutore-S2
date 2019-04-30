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
     * Tableau de jeu contenant des pion pour la v�rification de la fonction set 
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
     * Test usuel permettant de v�rifier la cr�ation d'un pion
     * Un pion est initailiser avec les valeur suivante :
     * <ol><li>abscisse = 0</li>
     *     <li>ordonnee = 0</li>
     *     <li>crapaud  = false</li></ol>
     */
	public static void testCreationPion() {
		int abscisse = 0,
		    ordonnee = 0;
		boolean crapaud = true;
		Pion pionTest;
		
		System.out.println("----------- Test usuel de"
				        + "la cr�ation de pion ------------");
		
		/* r�pete plusieur fois la cr�ation d'un pion pour tester */
		for (int nbEssai = 0; nbEssai < 5; nbEssai++) {
			
			/* boucle v�rifiant si l'utilisateur rentre un entier en abscisse */
			do {
				System.out.println("Veillez rentrer une valeur pour l'abscisse du pion :");
				if ( entree.hasNextInt()) {
					abscisse = entree.nextInt();
				} else {
					System.out.println("Erreur, veillez rentrer un entier");
					entree.nextLine();
				}
			} while(!entree.hasNextInt());
		
			/* boucle v�rifiant si l'utilisateur rentre un entier en ordonnee */
			do {
				System.out.print("Veillez rentrer une valeur pour l'ordonn�e du pion :");
				if ( entree.hasNextInt()) {
					ordonnee = entree.nextInt();
				} else {
					System.out.println("Erreur, veillez rentrer un entier");
				}
				entree.nextLine();
			} while(!entree.hasNextInt());
		
			/* boucle v�rifiant si l'utilisateur rentre un boolean  */
			do {
				System.out.print("Votre pion est-il un crapaud :");
				if ( entree.hasNextBoolean()) {
					crapaud = entree.nextBoolean();
				} else {
					System.out.println("Erreur, veillez rentrer un boolean");
				}
				entree.nextLine();
			} while(!entree.hasNextBoolean());
			
			/* initialise un pion avec les valeur rentr� au dessus */
			pionTest = new Pion( abscisse, ordonnee, crapaud);
			/* affiche les coordonn� des pion rentr� par l'utilisateur ou un pion avec les valeurs initialis� */
			System.out.println(pionTest);
		}
	}

	public static void testSetAbscisse() {
		int abscisseDebut,
		    abscisseFin,
		    nbEchec = 0;
		
		System.out.println("----------- Test pour la fonction setAbscisse ----------\n\n");
		
		/* Test d'avancement pour un crapaud sans �tre bloqu� */
		abscisseDebut = pionTest1.getAbscisse();
		pionTest1.setAbscisse(0, jeuTest);
		abscisseFin = pionTest1.getAbscisse();
		if ((abscisseDebut + 1 ) != abscisseFin ) {
			nbEchec++;
		}
		
		/* Test si un crapaud avanc� s'il y a u pion devant lui */
		abscisseDebut = pionTest2.getAbscisse();
		pionTest2.setAbscisse(0, jeuTest);
		abscisseFin = pionTest2.getAbscisse();
		if ((abscisseDebut + 2 ) != abscisseFin ) {
			nbEchec++;
		}
		
		/* Test quand un crapaud est bloqu� par deux autre Pion */
		abscisseDebut = pionTest4.getAbscisse();
		pionTest4.setAbscisse(0, jeuTest);
		abscisseFin = pionTest4.getAbscisse();
		if (abscisseDebut != abscisseFin ) {
			nbEchec++;
		}
		
		/*test si le pion est arriver �  la fin */
		abscisseDebut = pionTest7.getAbscisse();
		pionTest7.setAbscisse(4, jeuTest);
		abscisseFin = pionTest7.getAbscisse();
		if (abscisseDebut != abscisseFin ) {
			nbEchec++;
		}
		
		/* Test d'avancement pour un crapaud sans �tre bloqu� */
		abscisseDebut = pionTest8.getAbscisse();
		pionTest8.setAbscisse(0, jeuTest);
		abscisseFin = pionTest8.getAbscisse();
		if ((abscisseDebut - 1 ) != abscisseFin ) {
			nbEchec++;
		}
		
		/* Test si un crapaud avanc� s'il y a u pion devant lui */
		abscisseDebut = pionTest10.getAbscisse();
		pionTest10.setAbscisse(0, jeuTest);
		abscisseFin = pionTest10.getAbscisse();
		if ((abscisseDebut - 2 ) != abscisseFin ) {
			nbEchec++;
		}
		
		/* Test quand un crapaud est bloqu� par deux autre Pion */
		abscisseDebut = pionTest13.getAbscisse();
		pionTest13.setAbscisse(0, jeuTest);
		abscisseFin = pionTest13.getAbscisse();
		if (abscisseDebut != abscisseFin ) {
			nbEchec++;
		}
		
		/*test si le pion est arriver �  la fin */
		abscisseDebut = pionTest14.getAbscisse();
		pionTest14.setAbscisse(0, jeuTest);
		abscisseFin = pionTest14.getAbscisse();
		if (abscisseDebut != abscisseFin ) {
			nbEchec++;
		}
		
		System.out.println("Il y a " + nbEchec + " echec.\n\n");
	}
	
	public static void main(String[] args) {
		testSetAbscisse();
		testCreationPion();

	}

}
