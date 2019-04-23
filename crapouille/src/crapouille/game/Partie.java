/*
 * 
 */
package crapouille.game;

import java.util.Scanner;

import crapouille.Action;
import crapouille.Pion;
import crapouille.Plateau;

/**
 * @author Azog-corp
 *
 */
public class Partie {
	
	private static Plateau plateau;
	private static Pion[] grenouille;
	private static Pion[] crapaud;
	private static Action action;
	Scanner entree = new Scanner(System.in);

	public static void setCrapaud(int nbCrapaud) {
		// Coordonnées temporaires des crapauds
		int[][] coordonnees = {{0, 1, 2, 3, 4, 0, 1, 2, 3, 4},{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}};
		// On créé un tableau de crapauds
		crapaud = new Pion[nbCrapaud];
		for (int i = 0; i < crapaud.length; i++) {
			// On créé les pions
			crapaud[i] = new Pion(coordonnees[0][i], coordonnees[1][i], true);
			// On met le pion créé sur le plateau
			plateau.setCase(crapaud[i]);
		}
	}
	
	public static void setGrenouille(int nbGrenouille) {
		// Coordonnées temporaires des grenouille
		int[][] coordonnees = {{0, 1, 2, 3, 4, 0, 1, 2, 3, 4},{4, 4, 4, 4, 4, 3, 3, 3, 3, 3}};
		// On créé un tableau de grenouilles
		grenouille = new Pion[nbGrenouille];
		for (int i = 0; i < grenouille.length; i++) {
			// On créé les pions
			grenouille[i] = new Pion(coordonnees[0][i], coordonnees[1][i], false);
			// On met le pion créé sur le plateau
			plateau.setCase(grenouille[i]);
		}
	}
	
	public static void setPlateau(int ligne, int colonne) {
		plateau = new Plateau(ligne, colonne);
	}

	public static void main(String[] args) {
		int abscisse = 5, // Nombre de colonne
		ordonnee = 5, // Nombre de ligne
		nbPion = 10, // Nombre de batraciens
		ordinateur = 0; // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
		setPlateau(abscisse, ordonnee);
		setGrenouille(nbPion);
		setCrapaud(nbPion);
		plateau.afficherPlateau();
		System.out.println("Tout c'est bien passer");
	}
}