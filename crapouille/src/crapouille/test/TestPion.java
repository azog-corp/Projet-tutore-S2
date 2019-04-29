package crapouille.test;

import crapouille.Pion;
import java.util.Scanner;

public class TestPion {
	
    static Scanner entree = new Scanner(System.in);
	
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

	public static void main(String[] args) {
		testCreationPion();

	}

}
