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
	 * Tableau contenant toutes les grenouilles et tous les crapauds
	 */
	private static Pion[][] batracien = new Pion[2][];

	/**
	 * Servira peut être pour faire l'IA
	 */
	private static Action action;

	/**
	 * Ajout de l'entrée courante
	 */
	private static Scanner entree = new Scanner(System.in);

	/**
	 * Initialise le tableau de grenouilles
	 * @param nbGrenouille
	 */
	public static void setGrenouille(int nbGrenouille) {
		// Coordonnées temporaires des grenouille
		int[][] coordonnees = {
				{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},
				{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1}};
		// On créé un tableau de grenouilles
		batracien[0] = new Pion[nbGrenouille];
		for (int i = 0; i < nbGrenouille; i++) {
			// On créé les pions
			batracien[0][i] = new Pion(coordonnees[0][i], coordonnees[1][i], false);
			// On initialise le boolean bloque
			batracien[0][i].setBloque(plateau.getPlateau());
			// On met le pion créé sur le plateau
			plateau.setCase(batracien[0][i]);
		}
	}

	/**
	 * Initialise le tableau de crapauds
	 * @param nbCrapaud
	 */
	public static void setCrapaud(int nbCrapaud) {
		// Coordonnées temporaires des crapauds
		int[][] coordonnees = {
				{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},
				{9, 8, 7, 6, 9, 8, 7, 6, 9, 8, 7, 6, 9, 8}};
		// On créé un tableau de crapauds
		batracien[1] = new Pion[nbCrapaud];
		for (int i = 0; i < nbCrapaud; i++) {
			// On créé les pions
			batracien[1][i] = new Pion(coordonnees[0][i], coordonnees[1][i], true);
			// On initialise le boolean bloque
			batracien[1][i].setBloque(plateau.getPlateau());
			// On met le pion créé sur le plateau
			plateau.setCase(batracien[1][i]);
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
	 * Vérifie si tous les pions d'une équipe sont bloqués
	 * @param pion les pions à vérifier
	 * @return true si les pions sont bloqué
	 */
	public static boolean victoire(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si un pion n'est pas bloqué
			if (!pion[x].isBloque()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Affiche tous les pions déplaçable
	 * @param pion
	 */
	public static void choixPion(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si un pion n'est pas bloqué
			if (!pion[x].isBloque()) {
				System.out.print("Pion (" + (pion[x].getAbscisse()+1) + ";" + (pion[x].getOrdonnee()+1) + ") ");
			}
		}
		System.out.print("\n");
	}

	/**
	 * Vérifie si un pion existe
	 * @param equipe du pion
	 * @param absisse du pion
	 * @param ordonnee du pion
	 * @return le pion s'il est valide
	 */
	public static Pion pionValide(int equipe, int absisse, int ordonnee) {
		for (int x = 0 ; x < batracien[0].length ; x++) {
			if (batracien[equipe][x].getAbscisse() == absisse && batracien[equipe][x].getOrdonnee() == ordonnee) {
				return batracien[equipe][x];
			}
		}
		return null;
	}

	/**
	 * 
	 * @param tourEquipe
	 * @return
	 */
	public static int tourJoueur(int tourEquipe) {
		int abscisse = -1, // Abscisse d'un pion
				ordonnee = -1; // Ordonnée d'un pion
		// On affiche le tableau
		plateau.afficherPlateau();
		System.out.println("\nChosi ton batracien parmi les suivants x y");
		// On affiche les pions déplaçable
		choixPion(batracien[tourEquipe]);
		System.out.print("\nAbscisse : ");
		abscisse = entree.hasNextInt() ? entree.nextInt()-1 : abscisse;
		System.out.print("\nOrdonnee : ");
		ordonnee = entree.hasNextInt() ? entree.nextInt()-1 : ordonnee;
		// Si le pion est existe et est non bloqué
		System.out.println(abscisse + " " + ordonnee);
		if (pionValide(tourEquipe, abscisse, ordonnee) != null) {
			plateau.movePion(pionValide(tourEquipe, abscisse, ordonnee));
			plateau.updateBloque(abscisse);
			tourEquipe = tourEquipe == 0 ? 1 : 0;
			System.out.println("Le pion à été déplacé");
		} else {
			System.out.println("Le pion est bloqué ou invalide");
			entree.nextLine(); // Vidage du tampon
		}
		return tourEquipe;
	}

	/**
	 * Lance une partie entre deux joueurs humains
	 * Leurs demande de nommé leur équipe puis
	 * à tour de role il vont selectionner
	 * un pion de leur équipe à déplacer jusqu'à ce que l'une des
	 * deux équipe soit bloqué
	 */
	public static void joueurVsJoueur() {
		// Tableau contenant les nom des deux équipes
		String[] equipe = new String[2];
		int tourEquipe = 0; // Numéro de l'équipe dont c'est le tour
		System.out.println("Entrer le nom de l'equipe Crapaud : ");
		equipe[0] = entree.nextLine();
		// Si aucun nom n'est rentré, le nom par défault est Grenouille
		equipe[0] = equipe[0].length() == 0 ? "Grenouille" : equipe[0];
		System.out.println("Entrer le nom de l'equipe Grenouille : ");
		equipe[1] = entree.nextLine();
		// Si aucun nom n'est rentré, le nom par défault est Crapaud
		equipe[1] = equipe[1].length() == 0 ? "Crapaud" : equipe[1];
		do {
			System.out.println("\nC'est au tour de l'équipe " + equipe[tourEquipe]);
			if (tourEquipe == 0) {
				do {
					tourEquipe = tourJoueur(tourEquipe);
				} while(tourEquipe == 0);
			} else {
				do {
					tourEquipe = tourJoueur(tourEquipe);
				} while(tourEquipe == 1);
			}
		} while(!victoire(batracien[0]) || !victoire(batracien[1]));
		if (victoire(batracien[0])) {
			System.out.println("Victoire de l'équipe " + equipe[0] + "avec les grenouilles");
		} else {
			System.out.println("Victoire de l'équipe " + equipe[1] + "avec les crapauds");
		}
	}

	/**
	 * Main principale qui lance le jeu
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		int abscisse = 7, // Nombre de ligne
				ordonnee = 10, // Nombre de colonne
				nbPion = 14, // Nombre de batraciens
				ordinateur = 0; // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
		setPlateau(abscisse, ordonnee);
		setGrenouille(nbPion);
		setCrapaud(nbPion);
		joueurVsJoueur();
		System.out.println("Tout c'est bien passer");
	}
}