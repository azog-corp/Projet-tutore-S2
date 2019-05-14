/*
 * Partie.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille.game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import crapouille.Ordinateur;
import crapouille.Pion;
import crapouille.Plateau;
import crapouille.configuration.Configuration;

/**
 * class avec toute les fonctionalit� permettant de faire une partie
 * @author Azog-corp
 */
public class Partie {

	/**
	 * Plateau de jeu
	 */
	public static Plateau plateau;

	/**
	 * Tableau contenant toutes les grenouilles et tous les crapauds
	 */
	public static Pion[][] batracien = new Pion[2][];

	/**
	 * Valeure qui signifie quelle configuration pr�d�fini
	 * l'utilisateur souhaite charger
	 */
	public static int choixConfiguration = 0;
	
	/**
	 * Valeure qui signifie quelle mode de jeu
	 * l'utilisateur souhaite charger
	 */
	public static int choixModeDeJeu = 0;
	
	/**
	 * Valeur qui d�termine si la deuxi�me entit� est
	 * un humain ou une IA et son niveau de difficult�
	 */
	public static int choixDifficulte = 0;
	
	/**
	 * Valeure d'une ligne du plateau
	 */
	public static int ligne = 0;
	
	/**
	 * Valeure d'une colonne du plateau
	 */
	public static int colonne = 0;
	
	/**
	 * Nombre de pion pr�sent sur le plateau
	 */
	public static int nbPion = 0;

	/**
	 * Tableau contenant le nom des deux �quipes
	 */
	public static String[] equipe = new String[2];

	/**
	 * ArrayList contenant toutes les configurations existantes
	 */
	private static ArrayList<Configuration> listConfiguration;

	/**
	 * Configuration appartenant � listConfiguration
	 * et qui est celle sur laquelle l'utilisateur
	 * joue une partie
	 */
	private static Configuration configuration;

	/**
	 * @return choixModeDeJeu
	 */
	public static int getChoixModeDeJeu() {
		return choixModeDeJeu;
	}

	/**
	 * @param choixModeDeJeu la nouvelle valeure choixModeDeJeu
	 */
	public static void setChoixModeDeJeu(int choixModeDeJeu) {
		Partie.choixModeDeJeu = choixModeDeJeu;
	}

	/**
	 * @return ligne
	 */
	public static int getLigne() {
		return ligne;
	}

	/**
	 * @param ligne la nouvelle valeure de ligne
	 */
	public static void setLigne(int ligne) {
		Partie.ligne = ligne;
	}

	/**
	 * @return colonne
	 */
	public static int getColonne() {
		return colonne;
	}

	/**
	 * @param colonne la nouvelle valeure de colonne
	 */
	public static void setColonne(int colonne) {
		Partie.colonne = colonne;
	}

	/**
	 * @return getChoixConfiguration
	 */
	public static int getChoixConfiguration() {
		return choixConfiguration;
	}

	/**
	 * @param choix la nouvelle valeure de choix
	 */
	public static void setChoixConfiguration(int choix) {
		choixConfiguration = choix;
	}

	/**
	 * @return nbPion
	 */
	public static int getNbPion() {
		return nbPion;
	}

	/**
	 * @param nbPion la nouvelle valeur de nbPion
	 */
	public static void setNbPion(int nbPion) {
		Partie.nbPion = nbPion;
	}

	/**
	 * @return getChoixDifficulte
	 */
	public static int getChoixDifficulte() {
		return choixDifficulte;
	}

	/**
	 * @return equipe
	 */
	public static String[] getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe la nouvelle valeure d'une case
	 */
	public static void setEquipe(String[] equipe) {
		Partie.equipe = equipe;
	}

	/**
	 * @param choixDifficulte la nouvelle valeure de choixDifficulte
	 */
	public static void setChoixDifficulte(int choixDifficulte) {
		Partie.choixDifficulte = choixDifficulte;
	}


	/**
	 * Initialise le plateau de jeu
	 * @param ligne nombre de ligne du plateau
	 * @param colonne nombre de colonne du plateau
	 */
	public static void initPlateau(int ligne, int colonne) {
		plateau = new Plateau(ligne, colonne);
	}

	/**
	 * R�plique (� modifier bien sur si on veut pas avoir 0)
	 */
	private static String[] repliques =
		{"Bienvenue Crapouile !\nVeut tu faire une partie ou un casse-t�te ?"
				+ "\n - 1 : Jeux\n - 2 : Casse-t�te\n - 3 : Configuration\n - 4 : Quitter",

				"Veut tu jouer contre une homme ou mes fid�les laquais ?"
						+ "\n - 0 : Contre un d�veuloppeur aguerri (par d�fault)"
						+ "\n - 1 : contre crapus (facile)"
						+ "\n - 2 : Contre batrus (medium)"
						+ "\n - 3 : Contre craporitus (difficile)",

						"Tu pensais que \"casse-t�te\" c'�tait une m�thaphore ahaha",

						"Chosi 1, 2, 3"
		};

	public static void initConfig() {
		try(ObjectInputStream fichier = new ObjectInputStream(new FileInputStream("crapouille/configuration/default.bin"))) {           

			// lecture de l'objet contenu dans le fichier
			configuration = (Configuration) fichier.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listConfiguration.add(configuration);
	}

	public static void saveConfig() {
		// cr�ation et ouverture du fichier NOM_FICHIER_PAIRE
		try(ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream("crapouille/configuration/configuration.bin"))) {

			// on �crit l'objet argument dans le fichier
			fichier.writeObject(listConfiguration); 

		}  catch (IOException erreur) {
			// une erreur s'est produite lors de l'acc�s au fichier
		}
	}

	/**
	 * Initialise le tableau de grenouilles
	 * @param nbGrenouille taille du tableau
	 * @param coordonnee des grenouilles sur le plateau
	 */
	public static void initGrenouille(int nbGrenouille, int[][] coordonnee) {
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
	public static void initCrapaud(int nbCrapaud, int[][] coordonnee) {
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
	public static void initBloque() {
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
		System.out.println(plateau.afficherJeu());
		System.out.println("\nChosi ton batracien parmi les suivants x y");
		// On affiche les pions d�pla�able en fonction du mode de jeu
		if (tourEquipe == 2) {
			choixPion(batracien[0]);
			choixPion(batracien[1]);
		} else {
			choixPion(batracien[tourEquipe]);
		}
		System.out.print("\nLigne : ");
		// TODO : mettre une valeure � ligne
		System.out.print("\nColonne : ");
		// TODO : mettre une valeure � colonne
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
		// TODO : mettre une valeure � equipe[0]
		// Si aucun nom n'est rentr�, le nom par d�fault est Grenouille
		equipe[0] = equipe[0].length() == 0 ? "Grenouille" : equipe[0];
		System.out.println("Entrer le nom de l'equipe Grenouille : ");
		// TODO : mettre une valeure � equipe[1]
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
	 * 
	 */
	public static Configuration chooseConfig() {

		System.out.print("Entrez le nombre de lignes du plateau (entre 1 et 20) : ");
		do {
			// TODO : mettre une valeure � ligne
			if (ligne <= 0 || ligne > 20) {
				System.out.println("Erreur !\nEntrer un nombre de colonnes positifs et non nul :\nEx : 6 ou 10"
						+ "\nAttention le plateau est limit� � 20 colonnes");
			}
		} while (ligne <= 0 || ligne > 20);

		System.out.print("Entrez le nombre de colonnes du plateau (entre 1 et 20) : ");
		do {
			// TODO : mettre une valeure � colonne
			if (colonne <= 0 || colonne > 20) {
				System.out.println("Erreur !\nEntrer un nombre de colonnes positifs et non nul :\nEx : 6 ou 10"
						+ "\nAttention le plateau est limit� � 20 colonnes");	
			}
		} while (colonne <= 0 || colonne > 20);

		System.out.print("Entrez le nombre de pions pr�sents sur le plateau : ");
		do {
			// TODO : mettre une valeure � nbPion
			if (nbPion <= 0 || nbPion >= ligne * colonne - colonne || nbPion % 2 == 1) {
				System.out.println("Erreur !\nEntrer un nombre de pions positifs pair et non nul :\nEx : 6 ou 10\n"
						+ "Compris entre 0 et " + (ligne * colonne - colonne));
				nbPion = 0;
			}
		} while (nbPion == 0);

		int abscisse = ligne,
				ordonnee = colonne;

		int[][] coGrenouille = new int[2][nbPion],
				coCrapaud = new int [2][nbPion];

		for (int x = 0; x < nbPion ; x++) {
			boolean pionJuste = true;
			System.out.println("Entrez les coordonn�es de la grenouille " + (x+1));
			do {
				System.out.println("ligne : ");
				// TODO : mettre une valeur � ligne
				System.out.println("colonne : ");
				// TODO : mettre une valeur � colonne
				if (ligne < 0 || colonne < 0) {
					System.out.println("Les coordonn�es doivent �tre positives");
					pionJuste = false;
				}
				if (pionJuste) {
					coGrenouille[0][x] = ligne;
					coGrenouille[1][x] = colonne;
				}
			} while (!pionJuste);
		}

		for (int x = 0; x < nbPion ; x++) {
			boolean pionJuste = true;
			System.out.println("Entrez les coordonn�es du crapaud " + (x+1));
			do {
				System.out.println("ligne : ");
				// TODO : mettre une valeur � ligne
				System.out.println("colonne : ");
				// TODO : mettre une valeur � colonne
				if (ligne < 0 || colonne < 0) {
					System.out.println("Les coordonn�es doivent �tre positives");
					pionJuste = false;
				} 
				if (pionJuste) {
					coCrapaud[0][x] = ligne;
					coCrapaud[1][x] = colonne;
				}
			} while (!pionJuste);	
		}

		System.out.printf("\nLe plateau sera compos� :\n" 
				+ "- %d" + " lignes\n"
				+ "- %d" + " colonnes\n"
				+ "- %d" + " pions\n", ligne, colonne, nbPion);	

		return new Configuration(ligne, colonne, nbPion, coGrenouille, coCrapaud);
	}

	/**
	 * Main principale qui lance le jeu
	 * @param args non utilis�
	 */
	public static void crapouille() {

		initConfig();
		saveConfig();
		System.out.println(repliques[0]);

		do {
			// TODO : mettre une valeur � choixModeDeJeu
			if (choixModeDeJeu == 1) {
				System.out.println(repliques[1]);
				// TODO : mettre une valeur � choixDifficulte
				joueurVs(choixDifficulte);
			} else if (choixModeDeJeu == 2) {
				System.out.println(repliques[2]);
				casseTete();
			} else if (choixModeDeJeu == 3) {
				Configuration confif = chooseConfig();
				initPlateau(confif.getLigne(), confif.getColonne());
				initGrenouille(confif.getNbPion(), confif.getCoGrenouille());
				initCrapaud(confif.getNbPion(), confif.getCoCrapaud());
				initBloque();
				System.out.println("Initialistion cr��");
			} else {
				System.out.println(repliques[3]);
			}
		} while (choixModeDeJeu != 4);



		System.out.println("Tout c'est bien passer");
	}
}