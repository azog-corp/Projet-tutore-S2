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
 * class avec toute les fonctionalit� permettant de faire une partie
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
	 * Ajout de l'entr�e courante
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
	 * R�plique (� modifier bien sur si on veut pas avoir 0)
	 */
	private static String[] repliques =
		{"Bienvenue Crapouile !\nVeut tu faire une partie ou un casse-t�te ?"
				+ "\n - 1 : Jeux\n - 2 : Casse-t�te\n - 3 : Quitter",
				
		"Veut tu jouer contre une homme ou mes fid�les laquais ?"
				+ "\n - 0 : Contre un d�veuloppeur (par d�fault)"
				+ "\n - 1 : contre Franck Syslvestre, attention � ces... QCM mortels"
				+ "\n - 2 : Contre Bruno b�li�re sacr� champion de citation que personne ne connais"
				+ "\n - 3 : Contre BARRIOS NOTRE MAITRE SUPREME",
				
				"Tu pensais que \"casse-t�te\" c'�tait une m�thaphore ahaha le con",
				
				"Tu es pourrais �tre un peu plus attentif... Comme au CM de Serv�re AHAHAHAH... pardon\n1, 2 ou 3"
		};

	/**
	 * Initialise le tableau de grenouilles
	 * @param nbGrenouille taille du tableau
	 * @param coordonnee des grenouilles sur le plateau
	 */
	public static void setGrenouille(int nbGrenouille, int[][] coordonnee) {
		// On cr�� un tableau de grenouilles
		batracien[0] = new Pion[nbGrenouille];
		for (int i = 0; i < nbGrenouille; i++) {
			// On cr�� les pions
			batracien[0][i] = new Pion(coordonnee[0][i], coordonnee[1][i], false, plateau);
			// On met le pion cr�� sur le plateau
			plateau.setCase(batracien[0][i]);
		}
	}


	/**
	 * Initialise le tableau de crapaud
	 * @param nbCrapaud taille du tableau
	 * @param coordonnee des crapauds sur le plateau
	 */
	public static void setCrapaud(int nbCrapaud, int[][] coordonnee) {
		// On cr�� un tableau de crapauds
		batracien[1] = new Pion[nbCrapaud];
		for (int i = 0; i < nbCrapaud; i++) {
			// On cr�� les pions
			batracien[1][i] = new Pion(coordonnee[0][i], coordonnee[1][i], true, plateau);
			// On initialise le boolean bloque
			batracien[1][i].setBloque(plateau.getPlateau());
			// On met le pion cr�� sur le plateau
			plateau.setCase(batracien[1][i]);
		}
	}

	/**
	 * V�rifie et bloque les pions sur le plateau
	 */
	public static void setBloque() {
		for (int x = 0 ; x < batracien[0].length ; x++) {
			batracien[0][x].setBloque(plateau.getPlateau());
			batracien[1][x].setBloque(plateau.getPlateau());
		}
	}

	/**
	 * V�rifie si tous les pions d'une �quipe sont bloqu�s
	 * @param pion les pions � v�rifier
	 * @return true si les pions sont bloqu�
	 */
	public static boolean victoire(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si un pion n'est pas bloqu�, alors c'est faux
			if (!pion[x].isBloque()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * V�rifie si toutes les grenouilles sont � droite
	 * et sir tous les crapaud sont � gauche
	 * @return true si c'est vrai
	 */
	public static boolean victoireCasseTete() {
		int nbPion, // Nombre de pion bien plac�s
		colonne, // Colonne sur laquelle on fait une recherche
		pionVictoire = batracien[0].length*2; // Nombre total de pion
		Pion[][] tab = plateau.getPlateau(); // Copie du plateau de jeu
		nbPion = colonne = 0; // On commence par la colonne la plus � gauche
		// Pour chaque ligne du tableau
		for (int ligne = 0 ; ligne < tab.length ; ligne++) {
			// Si le pion est un crapaud
			if (tab[ligne][colonne] != null && tab[ligne][colonne].isCrapaud()) {
				// Il y a un pion bien plac� de plus
				nbPion++;
				// On regarde sur la colonne suivante
				colonne++;
				// On reste sur la m�me ligne
				ligne--;
			} else {
				// On arrete la boucle car il ne peut y avoir
				// de pion bien plac� apr�s
				break;
			}
		}
		colonne = tab[0].length; // On se met sur la colonne de droite
		// Pour chaque ligne du tableau
		for (int ligne = 0 ; ligne < tab.length ; ligne++) {
			// Si le pion est un crapaud
			if (tab[ligne][colonne] != null && !tab[ligne][colonne].isCrapaud()) {
				// Il y a un pion bien plac� de plus
				nbPion++;
				// On regarde sur la colonne pr�c�dente
				colonne--;
				// On reste sur la m�me ligne
				ligne--;
			} else {
				// On arrete la boucle car il ne peut y avoir
				// de pion bien plac� apr�s
				break;
			}
		}
		// Si le nombre de pion bien plac� est �gal au nombre
		// total de pion, alors on retourne vrai
		return nbPion == pionVictoire;
	}

	/**
	 * Affiche tous les pions d�pla�able
	 * @param pion crapaud ou grnouille
	 */
	public static void choixPion(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si le pion n'est pas bloqu�
			if (!pion[x].isBloque()) {
				System.out.print("Pion (" + (pion[x].getLigne()+1) + ";" + (pion[x].getColonne()+1) + ") ");
			}
		}
		System.out.print("\n");
	}

	/**
	 * V�rifie si un pion existe
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
	 * Effectue un tour en mode joueur vs entit�
	 * ou en mode casse t^te
	 * @param tourEquipe le num�ro de l'�quipe.
	 * Si �gal � 2, alors c'est un casse t�te
	 * @return
	 */
	public static int tourJoueur(int tourEquipe) {
		int ligne = -1, // ligne d'un pion
				colonne = -1; // Ordonn�e d'un pion
		// On affiche le tableau
		plateau.afficherPlateau();
		System.out.println("\nChosi ton batracien parmi les suivants x y");
		// On affiche les pions d�pla�able en fonction du mode de jeu
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
			// Si le pion existe et qu'il n'est pas bloqu�
			if (pionValide(tourEquipe, ligne, colonne) != null &&
					!pionValide(tourEquipe, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(tourEquipe, ligne, colonne));
				tourEquipe = tourEquipe == 0 ? 1 : 0;
				System.out.println("Le pion � �t� d�plac�");
			}
			// Si le mode de jeu est casse t�te
		} else if (tourEquipe == 2) {
			// Si la grenouille existe et qu'elle n'est pas bloqu�e
			if (pionValide(0, ligne, colonne) != null &&
					!pionValide(tourEquipe, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(0, ligne, colonne));
				System.out.println("Le pion � �t� d�plac�");
				// Si le crapaud existe et qu'il n'est pas bloqu�
			} else if (pionValide(1, ligne, colonne) != null &&
					!pionValide(1, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(1, ligne, colonne));
				System.out.println("Le pion � �t� d�plac�");
			}
		} else {
			System.out.println("Le pion est bloqu� ou invalide");
			entree.nextLine(); // Vidage du tampon
		}
		return tourEquipe;
	}

	/**
	 * Lance une partie entre un joueur et
	 * soit un humain soit une IA
	 * Leurs demande de nomm� leur �quipe puis
	 * � tour de role il vont selectionner
	 * un pion de leur �quipe � d�placer jusqu'� ce que l'une des
	 * deux �quipe soit bloqu�
	 * @param ordinateur d�termine si le joueur joue contre un humain
	 * et si non, le niveau de dificult� de l'IA
	 */
	public static void joueurVs(int ordinateur) {
		// Tableau contenant les nom des deux �quipes
		String[] equipe = new String[2];
		int tourEquipe = 0; // Num�ro de l'�quipe dont c'est le tour
		System.out.println("Entrer le nom de l'equipe Crapaud : ");
		equipe[0] = entree.nextLine();
		// Si aucun nom n'est rentr�, le nom par d�fault est Grenouille
		equipe[0] = equipe[0].length() == 0 ? "Grenouille" : equipe[0];
		System.out.println("Entrer le nom de l'equipe Grenouille : ");
		equipe[1] = ordinateur == 0 ? entree.nextLine() : "";
		// Si aucun nom n'est rentr�, le nom par d�fault est Crapaud
		equipe[1] = equipe[1].length() == 0 ? "Crapaud" : equipe[1];
		do {
			System.out.println("\nC'est au tour de l'�quipe " + equipe[tourEquipe]);
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
			System.out.println("Victoire de l'�quipe " + equipe[0] + "avec les grenouilles");
		} else {
			System.out.println("Victoire de l'�quipe " + equipe[1] + "avec les crapauds");
		}
	}

	/**
	 * Lance une partie de casse t�te.
	 * Le joueur pourra d�placer tous les pions du plateau
	 * La partie ce termine quand tous les batraciens sont sur les cot� du plateau
	 */
	private static void casseTete() {
		System.out.println("Bienvenu dans le mode casse t�te !\n" +
				"Pour gagner, placer toutes les grenouilles � " +
				"droite et tous les crapaud � gauche !\n" +
				"Bonne chance !");
		do {
			tourJoueur(2);
		} while (!victoire(batracien[0]) && !victoire(batracien[1]));
		if (victoireCasseTete()) {
			System.out.println("Bravo ! Tu as gagn� !");
		} else {
			System.out.println("Dommage ! Tu as perdu !");
		}
	}

	/**
	 * Main principale qui lance le jeu
	 * @param args non utilis�
	 */
	public static void main(String[] args) {
		// Coordonn�es par d�fault des grenouille
		int[][] coGrenouille = {
				{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},
				{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1}};
		// Coordonn�es par d�fault des crapauds
		int[][] coCrapaud = {
				{0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6},
				{9, 8, 7, 6, 9, 8, 7, 6, 9, 8, 7, 6, 9, 8}};
		// Initialisation par d�fault
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