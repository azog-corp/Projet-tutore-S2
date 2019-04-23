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
	
	/**
	 * Plateau de jeu
	 */
	private static Plateau plateau;
	
	/**
	 * Tableau contenant toutes les grenouilles
	 */
	private static Pion[] grenouille;
	
	/**
	 * Tableau contenant tous les crapauds
	 */
	private static Pion[] crapaud;
	
	/**
	 * Servira peut �tre pour faire l'IA
	 */
	private static Action action;
	
	/**
	 * Ajout de l'entr�e courante
	 */
	Scanner entree = new Scanner(System.in);

	/**
	 * Initialise le tableau de crapauds
	 * @param nbCrapaud
	 */
	public static void setCrapaud(int nbCrapaud) {
		// Coordonn�es temporaires des crapauds
		int[][] coordonnees = {{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1}};
		// On cr�� un tableau de crapauds
		crapaud = new Pion[nbCrapaud];
		for (int i = 0; i < crapaud.length; i++) {
			// On cr�� les pions
			crapaud[i] = new Pion(coordonnees[0][i], coordonnees[1][i], true);
			// On initialise le boolean bloque
			crapaud[i].setBloque(plateau.getPlateau());
			// On met le pion cr�� sur le plateau
			plateau.setCase(crapaud[i]);
		}
	}
	
	/**
	 * Initialise le tableau de grenouilles
	 * @param nbGrenouille
	 */
	public static void setGrenouille(int nbGrenouille) {
		// Coordonn�es temporaires des grenouille
		int[][] coordonnees = {{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},{9, 8, 7, 6, 9, 8, 7, 6, 9, 8, 7, 6, 9, 8}};
		// On cr�� un tableau de grenouilles
		grenouille = new Pion[nbGrenouille];
		for (int i = 0; i < grenouille.length; i++) {
			// On cr�� les pions
			grenouille[i] = new Pion(coordonnees[0][i], coordonnees[1][i], false);
			// On initialise le boolean bloque
			grenouille[i].setBloque(plateau.getPlateau());
			// On met le pion cr�� sur le plateau
			plateau.setCase(grenouille[i]);
		}
	}
	
	/**
	 * Initialise le plateau de jeu
	 * @param ligne
	 * @param colonne
	 */
	public static void setPlateau(int ligne, int colonne) {
		plateau = new Plateau(ligne, colonne);
	}
	
	/**
	 * V�rifie si tous les pions d'une �quipe sont bloqu�s
	 * @param pion les pions � v�rifier
	 * @return true si les pions sont bloqu�
	 */
	public static boolean victoire(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si un pion n'est pas bloqu�
			if (!pion[x].isBloque()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Main principale qui lance le jeu
	 * @param args non utilis�
	 */
	public static void main(String[] args) {
		int abscisse = 7, // Nombre de ligne
		ordonnee = 10, // Nombre de colonne
		nbPion = 14, // Nombre de batraciens
		ordinateur = 0; // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
		setPlateau(abscisse, ordonnee);
		setGrenouille(nbPion);
		setCrapaud(nbPion);
		plateau.afficherPlateau();
		System.out.println("Tout c'est bien passer");
	}
}