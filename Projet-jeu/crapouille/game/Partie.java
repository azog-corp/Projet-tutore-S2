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
import crapouille.configuration.Configuration;

public class Partie {

	/**
	 * Nombre Ligne max pour les configuraions
	 */
	private final static int LIGNE_MAX = 20;

	/**
	 * Nombre Colonne max pour les configurations
	 */
	private final static int COLONNE_MAX = 20;

	/**
	 * Nombre de ligne de la configuration actuelle
	 */
	private static int ligneConf;

	/**
	 * Nombre de colonne de la configuration actuelle
	 */
	private static int colonneConf;

	/** Adversaire choisi par l'utilisateur
	 * 0 = humain
	 * 1 = ia niveau 1
	 * 2 = ia niveau 2
	 * 3 = ia niveau 3
	 */
	private static int choixAdversaire;

	/**
	 * Mode de jeu choisi par l'adversaire
	 * 0 = casse tete
	 * 1 = versus
	 */
	private static int choixModeDeJeu;

	/**
	 * Configuration choisie par l'utilisateur
	 */
	private static int choixConfig;

	/**
	 * Nombre de pion present dans la configuration 
	 */
	private static int nbPion;

	/**
	 * Nom par défaut de l'équipe Crapaud
	 */
	private static String nomEquipe1Defaut = "Crapaud";

	/**
	 * Nom par défaut de l'équipe Grenouille
	 */
	private static String nomEquipe2Defaut = "Grenouille";

	/**
	 * Tableau contenant le nom des deux équipes
	 * saisies par le ou les joueurs
	 */
	public static String[] equipe = new String[2];

	/**
	 * Plateau sur lequel sont placés et déplacés
	 * chaque pion des deux équipes.
	 * Les dimensions de celui-ci ne sont
	 * pas necessairement celles de la configuaration
	 */
	public static Pion[][] plateau = new Pion[LIGNE_MAX][COLONNE_MAX];

	/**
	 * ArrayList contenant toutes les configurations créé
	 * ainsi que la configuration par défaut.
	 * Cette variable est enregistré lorsque le joueur
	 * quitte l'application
	 */
	public static ArrayList<Configuration> listConfiguration;

	/**
	 * Configuration sur laquelle la partie en cours
	 * est joué
	 */
	public static Configuration currentConfig;

	/**
	 * Tableau contenant toutes les instances de pions
	 * présentent sur le plateau.
	 * La première ligne contient tous les pion grenouilles
	 * et la seconde tous les crapaud
	 */
	public static Pion[][] batracien = new Pion[2][];

	/**
	 * Chemin du fichier bin dans lequel est enregistré
	 * la ArryList listConfiguration
	 */
	private final static String CHEMIN_FICHIER = "/crapouille/configuration/listeConfiguration.bin";

	/**
	 * @return le nom de l'équipe grenouille
	 */
	public static String getNomEquipe1Defaut() {
		return nomEquipe1Defaut;
	}

	/**
	 * @return le nom de l'équipe crapaud
	 */
	public static String getNomEquipe2Defaut() {
		return nomEquipe2Defaut;
	}

	/**
	 * @param ligneConf le nombre de lignes de la configuration
	 */
	public static void setLigneConf(int ligneConf) {
		Partie.ligneConf = ligneConf;
	}

	/**
	 * @param colonneConf le nombre de colonnes de la configuration
	 */
	public static void setColonneConf(int colonneConf) {
		Partie.colonneConf = colonneConf;
	}

	/**
	 * @param choixAdversaire l'entité contre laquelle
	 * le joueur veut faire une partie :
	 * - 0 pour un humain
	 * - 1 ou plus pour une IA
	 */
	public static void setChoixAdversaire(int choixAdversaire) {
		Partie.choixAdversaire = choixAdversaire;
	}

	/**
	 * @return l'entité contre laquelle le joueur veut faire une partie
	 */
	public static int getChoixAdversaire() {
		return choixAdversaire;
	}

	/**
	 * @param choixModeDeJeu 0 pour joueur versus et 1 pour casse tête
	 */
	public static void setChoixModeDeJeu(int choixModeDeJeu) {
		Partie.choixModeDeJeu = choixModeDeJeu;
	}

	/**
	 * @return le mode de jeu en cours
	 */
	public static int getChoixModeDeJeu() {
		return choixModeDeJeu;
	}

	/**
	 * @param choixConfig l'index de listConfiguration déésignant une
	 * configuration spécifique
	 */
	public static void setChoixConfig(int choixConfig) {
		Partie.choixConfig = choixConfig;
	}

	/**
	 * @param nbPion le nombre de pion présent sur le plateau
	 */
	public static void setNbPion(int nbPion) {
		Partie.nbPion = nbPion;
	}

	/**
	 * @param equipe le nom de l'équipe grenouille
	 */
	public static void setEquipe1(String equipe) {
		Partie.equipe[0] = equipe;
	}

	/**
	 * @param equipe le nom de l'équipe crapaud
	 */
	public static void setEquipe2(String equipe) {
		Partie.equipe[1] = equipe;
	}

	/**
	 * Récupère la ArrayList contenant toutes les configurations
	 * qui ont été crées et celle par défaut
	 */
	@SuppressWarnings("unchecked")
	public static void initConfig() {
		try(ObjectInputStream fichier = new ObjectInputStream(new FileInputStream(CHEMIN_FICHIER))) {           
			// lecture de l'objet contenu dans le fichier
			listConfiguration = (ArrayList<Configuration>) fichier.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sauvegarde en mémoire la ArrayList contenant toutes les configurations
	 */
	public static void saveConfig() {
		try(ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream(CHEMIN_FICHIER))) {
			fichier.writeObject(listConfiguration); 
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fonction appelé lors de la création d'une configuration
	 * et qui initialise l'attribut bloque de chaque pion
	 */
	public static void initBloque() {
		for (int x = 0 ; x < ligneConf ; x++) {
			for (int y = 0 ; y < colonneConf ; y++) {
				if (plateau[x][y] != null) {
					plateau[x][y].setBloque(plateau);
				}
			}
		}
	}

	/**
	 * Fonction appelé lors du chargement d'une configuration
	 * et qui met dans le tableau batracien toutes les
	 * instances des pions grenouilles et crapaud
	 */
	public static void initBatracien() {
		batracien = new Pion[2][nbPion];
		int crapaud = 0,
				grenouille = 0;
		for (int x = 0 ; x < ligneConf ; x++) {
			for (int y = 0 ; y < colonneConf ; y++) {
				if (plateau[x][y] != null && plateau[x][y].isCrapaud()) {
					batracien[1][crapaud] = plateau[x][y];
					crapaud++;
				} else if (plateau[x][y] != null && !plateau[x][y].isCrapaud()) {
					batracien[0][grenouille] = plateau[x][y];
					grenouille++;
				}
			}
		}
	}

	/**
	 * Associe un pion à une case du plateau
	 * @param pion, Le pion qui doit être associé
	 */
	public static void setCase(Pion pion) {
		plateau[pion.getLigne()][pion.getColonne()] = pion;
	}

	/**
	 * VÃ©rifie si tous les pions d'une Ã©quipe sont bloquÃ©s
	 * @param pion les pions Ã  vÃ©rifier
	 * @return true si les pions sont bloquÃ©
	 */
	public static boolean victoire(Pion[] pion) {
		for (int x = 0 ; x < pion.length ; x++) {
			// Si un pion n'est pas bloquÃ©, alors c'est faux
			if (!pion[x].isBloque()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Cette fonction déplace un pion sur le plateau, puis change
	 * la colonne de celui-ci et enfin, réinitialise l'attribut
	 * bloque de chaque pion présent sur la ligne du pion déplacé
	 * @param pion le pion bougé
	 */
	public static void movePion(Pion pion) {
		plateau[pion.getLigne()][pion.getColonne()] = null;
		pion.setColonne(plateau);
		plateau[pion.getLigne()][pion.getColonne()] = pion;
		for (int x = 0 ; x < ligneConf ; x++) {
			if (plateau[pion.getLigne()][x] != null) {
				plateau[pion.getLigne()][x].setBloque(plateau);
			}
		}
	}

	/**
	 * VÃ©rifie si toutes les grenouilles sont Ã  droite
	 * et si tous les crapaud sont Ã  gauche
	 * @return true si c'est vrai
	 */
	public static boolean victoireCasseTete() {
		int nbPion, // Nombre de pion bien placÃ©s
		colonne, // Colonne sur laquelle on fait une recherche
		pionVictoire = batracien[0].length*2, // Nombre total de pion
		ligne;
		nbPion = ligne = colonne = 0; // On commence par la colonne la plus Ã  gauche
		// Pour chaque ligne du tableau
		while (ligne < ligneConf) {
			if (plateau[ligne][colonne] != null || plateau[ligne][colonne] != null) {
				if (plateau[ligne][colonne] != null && plateau[ligne][colonne].isCrapaud()) {
					nbPion++;
					colonne++;
				}
				if (plateau[ligne][colonne] != null && !plateau[ligne][colonneConf].isCrapaud()) {
					nbPion++;
					colonneConf--;
				}
			} else {
				ligne++;
			}
		}
		return nbPion == pionVictoire;
	}

	/**
	 * Vérifie si un pion dont les coordonnées sont placées en argument
	 * existe et s'il appartient à l'équipe dont c'est le tour
	 * @param equipe 0 sigifie l'équipe grnouille, 1 l'équipe crapaud
	 * @param ligne du potentiel pion
	 * @param colonne du potentiel pio
	 * @return true si le pion existe et appartient à la vonne équipe
	 */
	public static boolean pionValide(int equipe, int ligne, int colonne) {
		for (int x = 0 ; x < batracien[0].length ; x++) {
			if (batracien[equipe][x].getLigne() == ligne && 
					batracien[equipe][x].getColonne() == colonne &&
					!plateau[ligne][colonne].isBloque()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Crée un String qui représente le plateau de jeu
	 * avec les pions et leur type
	 */
	public static String afficherJeu() {
		StringBuilder plateauString = new StringBuilder();
		plateauString.append(" |");
		for (int z = 0 ; z < colonneConf ; z++) {
			plateauString.append(z+1 + " | ");
		}
		for (int x = 0 ; x < ligneConf ; x++) {
			plateauString.append("\n" + (x+1) + " |");
			for (int y = 0 ; y < colonneConf ; y++) {
				if (plateau[x][y] != null) {
					if (plateau[x][y].isCrapaud()) {
						plateauString.append("C|");
					} else if (!plateau[x][y].isCrapaud()) {
						plateauString.append("G|");
					}
				} else {
					plateauString.append("  |");
				}
			}
		}
		return plateauString.toString();
	}

	/**
	 * Lance une partie entre un joueur et
	 * soit un humain soit une IA
	 * Leurs demande de nommÃ© leur Ã©quipe puis
	 * Ã  tour de role il vont selectionner
	 * un pion de leur Ã©quipe Ã  dÃ©placer jusqu'Ã  ce que l'une des
	 * deux Ã©quipe soit bloquÃ©
	 * @param ordinateur dÃ©termine si le joueur joue contre un humain
	 * et si non, le niveau de difficultÃ© de l'IA
	 */
	public static int joueurVs(int tourEquipe, int ligne, int colonne) {
		if (tourEquipe == 0) {
			do {
				tourEquipe = tourJoueur(tourEquipe, ligne, colonne);
			} while(tourEquipe == 0);
		} else {
			do {
				if (choixAdversaire == 0) {
					tourEquipe = tourJoueur(tourEquipe, ligne, colonne);
				} else {
					// TODO : Yanis tu fous l'IA ici avec un movePion
					tourEquipe--;
				}
			} while(tourEquipe == 1);
		}
		return tourEquipe;
	}

	/**
	 * Effectue un tour en mode joueur vs entitÃ©
	 * ou en mode casse tÃªte
	 * @param tourEquipe le numÃ©ro de l'Ã©quipe.
	 * Si Ã©gal Ã  2, alors c'est un casse tÃªte
	 * @return
	 */
	public static int tourJoueur(int tourEquipe, int ligne, int colonne) {
		// Si le pion existe et qu'il n'est pas bloquÃ©
		if (pionValide(tourEquipe, ligne, colonne)) {
			// On bouge le pion
			movePion(plateau[ligne][colonne]);
			tourEquipe = tourEquipe == 0 ? 1 : 0;
		}
		return tourEquipe;
	}

	public static void casseTete(int ligne, int colonne) {
		// Si la grenouille existe et qu'elle n'est pas bloquÃ©e
		if (pionValide(0, ligne, colonne) || pionValide(1, ligne, colonne)) {
			// On bouge le pion
			movePion(plateau[ligne][colonne]);
		}
	}
}