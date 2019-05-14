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
 * class avec toute les fonctionalité permettant de faire une partie
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
	 * Valeur qui signifie quelle configuration prédéfini
	 * l'utilisateur souhaite charger
	 */
	public static int choixConfiguration = 0;

	/**
	 * Valeur qui signifie quelle est le mode de jeu
	 * que l'utilisateur souhaite charger
	 * 0 = casse tete
	 * 1 = versus
	 */
	public static int choixModeDeJeu = 0;

	/**
	 * Valeur qui détermine si la deuxième entité est
	 * un humain ou une IA et son niveau de difficulté
	 * 0 correspondra a un adversaire humain
	 * 1 correspondra a une ia de niveau 1
	 * 2 correspondra a une ia de niveau 2
	 * 3 correspondra a une ia de niveau 3
	 */
	public static int choixAdversaire = 0;

	/**
	 * Valeure d'une ligne du plateau
	 */
	public static int ligne = 0;

	/**
	 * Valeure d'une colonne du plateau
	 */
	public static int colonne = 0;

	/**
	 * Nombre de pion présent sur le plateau
	 */
	public static int nbPion = 0;

	/**
	 * Tableau contenant le nom des deux équipes
	 */
	public static String[] equipe = new String[2];

	/**
	 * ArrayList contenant toutes les configurations existantes
	 */
	private static ArrayList<Configuration> listConfiguration = new ArrayList<Configuration>();

	/**
	 * Configuration appartenant à listConfiguration
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
	 * @return getAdversaire
	 */
	public static int getAdversaire() {
		return choixAdversaire;
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
	 * @param choixAdversaire la nouvelle valeure de choixAdversaire
	 */
	public static void setAdversaire(int choixAdversaire) {
		Partie.choixAdversaire = choixAdversaire;
	}


	/**
	 * Initialise le plateau de jeu
	 * @param ligne nombre de ligne du plateau
	 * @param colonne nombre de colonne du plateau
	 */
	public static void initPlateau(int ligne, int colonne) {
		plateau = new Plateau(ligne, colonne);
	}

	public static void initConfig() {
		try(ObjectInputStream fichier = new ObjectInputStream(new FileInputStream("crapouille/configuration/default.bin"))) {           

			// lecture de l'objet contenu dans le fichier
			configuration = (Configuration) fichier.readObject();
			listConfiguration.add(configuration);
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
	}

	public static void saveConfig() {
		// création et ouverture du fichier NOM_FICHIER_PAIRE
		try(ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream("crapouille/configuration/listConfiguration.bin"))) {

			// on écrit l'objet argument dans le fichier
			fichier.writeObject(listConfiguration); 

		}  catch (IOException erreur) {
			// une erreur s'est produite lors de l'accès au fichier
			System.out.println("Erreur");
		}
	}

	/**
	 * Initialise le tableau de grenouilles
	 * @param nbGrenouille taille du tableau
	 * @param coordonnee des grenouilles sur le plateau
	 */
	public static void initGrenouille(int nbGrenouille, int[][] coordonnee) {
		// On créé un tableau de grenouilles
		batracien[0] = new Pion[nbGrenouille];
		for (int i = 0; i < nbGrenouille; i++) {
			// On créé les pions
			batracien[0][i] = new Pion(coordonnee[0][i], coordonnee[1][i], false);
			// On met le pion créé sur le plateau
			plateau.setCase(batracien[0][i]);
		}
	}


	/**
	 * Initialise le tableau de crapaud
	 * @param nbCrapaud taille du tableau
	 * @param coordonnee des crapauds sur le plateau
	 */
	public static void initCrapaud(int nbCrapaud, int[][] coordonnee) {
		// On créé un tableau de crapauds
		batracien[1] = new Pion[nbCrapaud];
		for (int i = 0; i < nbCrapaud; i++) {
			// On créé les pions
			batracien[1][i] = new Pion(coordonnee[0][i], coordonnee[1][i], true);
			// On initialise le boolean bloque
			batracien[1][i].setBloque(plateau.getPlateau());
			// On met le pion créé sur le plateau
			plateau.setCase(batracien[1][i]);
		}
	}

	/**
	 * Vérifie et bloque les pions sur le plateau
	 */
	public static void initBloque() {
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
	 * Vérifie si un pion existe
	 * @param equipe équipe du pion
	 * @param ligne ligne du pion
	 * @param colonne colonne du pion
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
	 * ou en mode casse tête
	 * @param tourEquipe le numéro de l'équipe.
	 * Si égal à 2, alors c'est un casse tête
	 * @return
	 */
	public static int tourJoueur(int tourEquipe) {
		// TODO : mettre une valeure à ligne
		// TODO : mettre une valeure à colonne
		// Si le mode de jeu est joueurVs
		if (tourEquipe < 2) {
			// Si le pion existe et qu'il n'est pas bloqué
			if (pionValide(tourEquipe, ligne, colonne) != null &&
					!pionValide(tourEquipe, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(tourEquipe, ligne, colonne));
				tourEquipe = tourEquipe == 0 ? 1 : 0;
			}
			// Si le mode de jeu est casse tête
		} else if (tourEquipe == 2) {
			// Si la grenouille existe et qu'elle n'est pas bloquée
			if (pionValide(0, ligne, colonne) != null &&
					!pionValide(tourEquipe, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(0, ligne, colonne));
				// Si le crapaud existe et qu'il n'est pas bloqué
			} else if (pionValide(1, ligne, colonne) != null &&
					!pionValide(1, ligne, colonne).isBloque()) {
				// On bouge le pion
				plateau.movePion(pionValide(1, ligne, colonne));
			}
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
	 * et si non, le niveau de difficulté de l'IA
	 */

	//TODO BOOLEAN PLUS ADAPTE POUR SAVOIR SI ordi ?
	//
	public static void joueurVs(int ordinateur) {
		// Tableau contenant les nom des deux équipes
		String[] equipe = new String[2];
		int tourEquipe = 0; // Numéro de l'équipe dont c'est le tour
		// TODO : mettre une valeure à equipe[0]
		// Si aucun nom n'est rentré, le nom par défault est Grenouille
		equipe[0] = equipe[0].length() == 0 ? "Grenouille" : equipe[0];
		// TODO : mettre une valeure à equipe[1]
		// Si aucun nom n'est rentré, le nom par défault est Crapaud
		equipe[1] = equipe[1].length() == 0 ? "Crapaud" : equipe[1];
		do {
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
	}

	/**
	 * 
	 */
	public static void createConfig(boolean isCrapaud) {
		Plateau newConfig = new Plateau(getLigne(), getColonne());
		Pion[] batracien = new Pion[getNbPion()];
		for (int x = 0; x < getNbPion(); x++) {
			Pion pion = new Pion(getLigne(), getColonne(), isCrapaud);
			newConfig.setCase(pion);
			batracien[x] = pion;
		}
		for (int x = 0; x < getNbPion(); x++) {
			batracien[x].setBloque(newConfig.getPlateau());
		}
	}
	
	public static void deleteConfig() {
		
	}

	/**
	 * Main principale qui lance le jeu
	 * @param args non utilisé
	 */
	public static void crapouille() {

		initConfig();
		saveConfig();

		do {
			// TODO : mettre une valeur à choixModeDeJeu
			if (choixModeDeJeu == 1) {
				System.out.println("1, 2, 3 ou 4");
				// TODO : mettre une valeur à choixAdversaire
				joueurVs(choixAdversaire);
			} else if (choixModeDeJeu == 2) {
				do {
					tourJoueur(2);
				} while (!victoire(batracien[0]) && !victoire(batracien[1]));
			}
		} while (choixModeDeJeu != 4);
	}
}
