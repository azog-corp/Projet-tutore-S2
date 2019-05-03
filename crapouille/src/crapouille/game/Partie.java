/*
 * Partie.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille.game;

import java.util.Scanner;

import crapouille.Ordinateur;
import crapouille.Pion;
import crapouille.Plateau;
import crapouille.initialisation.Initialisation;

/**
 * class avec toute les fonctionalité permettant de faire une partie
 * @author Azog-corp
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
	 * Ajout de l'entrée courante
	 */
	private static Scanner entree = new Scanner(System.in);


	/**
	 * Initialise le plateau de jeu
	 * @param ligne nombre de ligne du plateau
	 * @param colonne nombre de colonne du plateau
	 */
	public static void setPlateau(int ligne, int colonne) {
		plateau = new Plateau(ligne, colonne);
	}

	/**
	 * Réplique (à modifier bien sur si on veut pas avoir 0)
	 */
	private static String[] repliques =
		{"Bienvenue Crapouile !\nVeut tu faire une partie ou un casse-tête ?"
				+ "\n - 1 : Jeux\n - 2 : Casse-tête\n - 3 : Quitter",
				
		"Veut tu jouer contre une homme ou mes fidèles laquais ?"
				+ "\n - 0 : Contre un déveuloppeur (par défault)"
				+ "\n - 1 : contre Franck Syslvestre, attention à ces... QCM mortels"
				+ "\n - 2 : Contre Bruno bélière sacré champion de citation que personne ne connais"
				+ "\n - 3 : Contre BARRIOS NOTRE MAITRE SUPREME",
				
				"Tu pensais que \"casse-tête\" c'était une méthaphore ahaha le con",
				
				"Tu es pourrais être un peu plus attentif... Comme au CM de Servère AHAHAHAH... pardon\n1, 2 ou 3"
		};

	/**
	 * Initialise le tableau de grenouilles
	 * @param nbGrenouille taille du tableau
	 * @param coordonnee des grenouilles sur le plateau
	 */
	public static void setGrenouille(int nbGrenouille, int[][] coordonnee) {
		// On créé un tableau de grenouilles
		batracien[0] = new Pion[nbGrenouille];
		for (int i = 0; i < nbGrenouille; i++) {
			// On créé les pions
			batracien[0][i] = new Pion(coordonnee[0][i], coordonnee[1][i], false, plateau);
			// On met le pion créé sur le plateau
			plateau.setCase(batracien[0][i]);
		}
	}


	/**
	 * Initialise le tableau de crapaud
	 * @param nbCrapaud taille du tableau
	 * @param coordonnee des crapauds sur le plateau
	 */
	public static void setCrapaud(int nbCrapaud, int[][] coordonnee) {
		// On créé un tableau de crapauds
		batracien[1] = new Pion[nbCrapaud];
		for (int i = 0; i < nbCrapaud; i++) {
			// On créé les pions
			batracien[1][i] = new Pion(coordonnee[0][i], coordonnee[1][i], true, plateau);
			// On initialise le boolean bloque
			batracien[1][i].setBloque(plateau.getPlateau());
			// On met le pion créé sur le plateau
			plateau.setCase(batracien[1][i]);
		}
	}

	/**
	 * Vérifie et bloque les pions sur le plateau
	 */
	public static void setBloque() {
		for (int x = 0 ; x < batracien[0].length ; x++) {
			batracien[0][x].setBloque(plateau.getPlateau());
			batracien[1][x].setBloque(plateau.getPlateau());
		}
	}

	/**
	 * Vérifie si tous les pions d'une équipe sont bloqués
	 * @param pion les pions à vérifier
	 * @return true si les pions sont bloqué
	 */
	public static boolean victoire(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si un pion n'est pas bloqué, alors c'est faux
			if (!pion[x].isBloque()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vérifie si toutes les grenouilles sont à droite
	 * et sir tous les crapaud sont à gauche
	 * @return true si c'est vrai
	 */
	public static boolean victoireCasseTete() {
		int nbPion, // Nombre de pion bien placés
		colonne, // Colonne sur laquelle on fait une recherche
		pionVictoire = batracien[0].length*2; // Nombre total de pion
		Pion[][] tab = plateau.getPlateau(); // Copie du plateau de jeu
		nbPion = colonne = 0; // On commence par la colonne la plus à gauche
		// Pour chaque ligne du tableau
		for (int ligne = 0 ; ligne < tab.length ; ligne++) {
			// Si le pion est un crapaud
			if (tab[ligne][colonne] != null && tab[ligne][colonne].isCrapaud()) {
				// Il y a un pion bien placé de plus
				nbPion++;
				// On regarde sur la colonne suivante
				colonne++;
				// On reste sur la même ligne
				ligne--;
			} else {
				// On arrete la boucle car il ne peut y avoir
				// de pion bien placé après
				break;
			}
		}
		colonne = tab[0].length; // On se met sur la colonne de droite
		// Pour chaque ligne du tableau
		for (int ligne = 0 ; ligne < tab.length ; ligne++) {
			// Si le pion est un crapaud
			if (tab[ligne][colonne] != null && !tab[ligne][colonne].isCrapaud()) {
				// Il y a un pion bien placé de plus
				nbPion++;
				// On regarde sur la colonne précédente
				colonne--;
				// On reste sur la même ligne
				ligne--;
			} else {
				// On arrete la boucle car il ne peut y avoir
				// de pion bien placé après
				break;
			}
		}
		// Si le nombre de pion bien placé est égal au nombre
		// total de pion, alors on retourne vrai
		return nbPion == pionVictoire;
	}

	/**
	 * Affiche tous les pions déplaçable
	 * @param pion crapaud ou grnouille
	 */
	public static void choixPion(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si le pion n'est pas bloqué
			if (!pion[x].isBloque()) {
				System.out.print("Pion (" + (pion[x].getLigne()+1) + ";" + (pion[x].getColonne()+1) + ") ");
			}
		}
		System.out.print("\n");
	}

	/**
	 * Vérifie si un pion existe
	 * @param equipe du pion
	 * @param absisse du pion
	 * @param colonne du pion
	 * @return le pion s'il est valide
	 */
	public static Pion pionValide(int equipe, int ligne, int colonne) {
		for (int x = 0 ; x < batracien[0].length ; x++) {
			if (batracien[equipe][x].getLigne() == ligne && batracien[equipe][x].getColonne() == colonne) {
				return batracien[equipe][x];
			}
		}
		return null;
	}

	/**
	 * Effectue un tour en mode joueur vs entité
	 * ou en mode casse t^te
	 * @param tourEquipe le numéro de l'équipe.
	 * Si égal à 2, alors c'est un casse tête
	 * @return
	 */
	public static int tourJoueur(int tourEquipe) {
		int ligne = -1, // ligne d'un pion
				colonne = -1; // Ordonnée d'un pion
		// On affiche le tableau
		plateau.afficherPlateau();
		System.out.println("\nChosi ton batracien parmi les suivants x y");
		// On affiche les pions déplaçable en fonction du mode de jeu
		if (tourEquipe == 2) {
			choixPion(batracien[0]);
			choixPion(batracien[1]);
		} else {
			choixPion(batracien[tourEquipe]);
		}
		System.out.print("\nLigne : ");
		ligne = entree.hasNextInt() ? entree.nextInt()-1 : ligne;
		System.out.print("\nColonne : ");
		colonne = entree.hasNextInt() ? entree.nextInt()-1 : colonne;
		// Si le mode de jeu est joueurVs
		if (tourEquipe < 2) {
			// Si le pion existe et qu'il n'est pas bloqué
			if (pionValide(tourEquipe, ligne, colonne) != null &&
					!pionValide(tourEquipe, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(tourEquipe, ligne, colonne));
				tourEquipe = tourEquipe == 0 ? 1 : 0;
				System.out.println("Le pion à été déplacé");
			}
			// Si le mode de jeu est casse tête
		} else if (tourEquipe == 2) {
			// Si la grenouille existe et qu'elle n'est pas bloquée
			if (pionValide(0, ligne, colonne) != null &&
					!pionValide(tourEquipe, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(0, ligne, colonne));
				System.out.println("Le pion à été déplacé");
				// Si le crapaud existe et qu'il n'est pas bloqué
			} else if (pionValide(1, ligne, colonne) != null &&
					!pionValide(1, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(1, ligne, colonne));
				System.out.println("Le pion à été déplacé");
			}
		} else {
			System.out.println("Le pion est bloqué ou invalide");
			entree.nextLine(); // Vidage du tampon
		}
		return tourEquipe;
	}

	/**
	 * Lance une partie entre un joueur et
	 * soit un humain soit une IA
	 * Leurs demande de nommé leur équipe puis
	 * à tour de role il vont selectionner
	 * un pion de leur équipe à déplacer jusqu'à ce que l'une des
	 * deux équipe soit bloqué
	 * @param ordinateur détermine si le joueur joue contre un humain
	 * et si non, le niveau de dificulté de l'IA
	 */
	public static void joueurVs(int ordinateur) {
		// Tableau contenant les nom des deux équipes
		String[] equipe = new String[2];
		int tourEquipe = 0; // Numéro de l'équipe dont c'est le tour
		System.out.println("Entrer le nom de l'equipe Crapaud : ");
		equipe[0] = entree.nextLine();
		// Si aucun nom n'est rentré, le nom par défault est Grenouille
		equipe[0] = equipe[0].length() == 0 ? "Grenouille" : equipe[0];
		System.out.println("Entrer le nom de l'equipe Grenouille : ");
		equipe[1] = ordinateur == 0 ? entree.nextLine() : "";
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
					if (ordinateur == 0) {
						tourEquipe = tourJoueur(tourEquipe);
					} else {
						plateau.movePion(Ordinateur.choixOrdi(plateau.getPlateau(), batracien[1], ordinateur));
						tourEquipe--;
					}
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
	 * Lance une partie de casse tête.
	 * Le joueur pourra déplacer tous les pions du plateau
	 * La partie ce termine quand tous les batraciens sont sur les coté du plateau
	 */
	private static void casseTete() {
		System.out.println("Bienvenu dans le mode casse tête !\n" +
				"Pour gagner, placer toutes les grenouilles à " +
				"droite et tous les crapaud à gauche !\n" +
				"Bonne chance !");
		do {
			tourJoueur(2);
		} while (!victoire(batracien[0]) && !victoire(batracien[1]));
		if (victoireCasseTete()) {
			System.out.println("Bravo ! Tu as gagné !");
		} else {
			System.out.println("Dommage ! Tu as perdu !");
		}
	}

	/**
	 * Main principale qui lance le jeu
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		// Coordonnées par défault des grenouille
		int[][] coGrenouille = {
				{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},
				{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1}};
		// Coordonnées par défault des crapauds
		int[][] coCrapaud = {
				{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},
				{9, 8, 7, 6, 9, 8, 7, 6, 9, 8, 7, 6, 9, 8}};
		// Initialisation par défault
		Initialisation parDefault = new Initialisation(7, 10, 14, coGrenouille, coCrapaud);
		int ordinateur = 0, // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
				choix = 3;
		setPlateau(parDefault.getLigne(), parDefault.getColonne());
		setGrenouille(parDefault.getNbPion(), parDefault.getCoGrenouille());
		setCrapaud(parDefault.getNbPion(), parDefault.getCoCrapaud());
		setBloque();
		System.out.println(repliques[0]);

		do {
			choix = entree.hasNextInt() ? entree.nextInt() : -1;
			if (choix == 1) {
				System.out.println(repliques[1]);
				ordinateur = entree.hasNextInt() ? entree.nextInt() : 0;
				entree.nextLine();
				joueurVs(ordinateur);
			} else if (choix == 2) {
				System.out.println(repliques[2]);
				casseTete();
			} else {
				System.out.println(repliques[3]);
				entree.nextLine();
			}
		} while (choix != 3);



		System.out.println("Tout c'est bien passer");
	}
}