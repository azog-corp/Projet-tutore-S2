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
	 * Nom par d�faut de l'�quipe Crapaud
	 */
	private static String nomEquipe1Defaut = "Crapaud";

	/**
	 * Nom par d�faut de l'�quipe Grenouille
	 */
	private static String nomEquipe2Defaut = "Grenouille";

	/**
	 * Tableau contenant le nom des deux �quipes
	 * saisies par le ou les joueurs
	 */
	public static String[] equipe = new String[2];

	/**
	 * Plateau sur lequel sont plac�s et d�plac�s
	 * chaque pion des deux �quipes.
	 * Les dimensions de celui-ci ne sont
	 * pas necessairement celles de la configuaration
	 */
	public static Pion[][] plateau = new Pion[LIGNE_MAX][COLONNE_MAX];

	/**
	 * ArrayList contenant toutes les configurations cr��
	 * ainsi que la configuration par d�faut.
	 * Cette variable est enregistr� lorsque le joueur
	 * quitte l'application
	 */
	public static ArrayList<Configuration> listConfiguration;

	/**
	 * Configuration sur laquelle la partie en cours
	 * est jou�
	 */
	public static Configuration currentConfig;

	/**
	 * Tableau contenant toutes les instances de pions
	 * pr�sentent sur le plateau.
	 * La premi�re ligne contient tous les pion grenouilles
	 * et la seconde tous les crapaud
	 */
	public static Pion[][] batracien = new Pion[2][];

	/**
	 * Chemin du fichier bin dans lequel est enregistr�
	 * la ArryList listConfiguration
	 */
	private final static String CHEMIN_FICHIER = "/crapouille/configuration/listeConfiguration.bin";

	/**
	 * @return le nom de l'�quipe grenouille
	 */
	public static String getNomEquipe1Defaut() {
		return nomEquipe1Defaut;
	}

	/**
	 * @return le nom de l'�quipe crapaud
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
	 * @param choixAdversaire l'entit� contre laquelle
	 * le joueur veut faire une partie :
	 * - 0 pour un humain
	 * - 1 ou plus pour une IA
	 */
	public static void setChoixAdversaire(int choixAdversaire) {
		Partie.choixAdversaire = choixAdversaire;
	}

	/**
	 * @return l'entit� contre laquelle le joueur veut faire une partie
	 */
	public static int getChoixAdversaire() {
		return choixAdversaire;
	}

	/**
	 * @param choixModeDeJeu 0 pour joueur versus et 1 pour casse t�te
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
	 * @param choixConfig l'index de listConfiguration d��signant une
	 * configuration sp�cifique
	 */
	public static void setChoixConfig(int choixConfig) {
		Partie.choixConfig = choixConfig;
	}

	/**
	 * @param nbPion le nombre de pion pr�sent sur le plateau
	 */
	public static void setNbPion(int nbPion) {
		Partie.nbPion = nbPion;
	}

	/**
	 * @param equipe le nom de l'�quipe grenouille
	 */
	public static void setEquipe1(String equipe) {
		Partie.equipe[0] = equipe;
	}

	/**
	 * @param equipe le nom de l'�quipe crapaud
	 */
	public static void setEquipe2(String equipe) {
		Partie.equipe[1] = equipe;
	}

	/**
	 * R�cup�re la ArrayList contenant toutes les configurations
	 * qui ont �t� cr�es et celle par d�faut
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
	 * Sauvegarde en m�moire la ArrayList contenant toutes les configurations
	 */
	public static void saveConfig() {
		try(ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream(CHEMIN_FICHIER))) {
			fichier.writeObject(listConfiguration); 
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fonction appel� lors de la cr�ation d'une configuration
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
	 * Fonction appel� lors du chargement d'une configuration
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
	 * Associe un pion � une case du plateau
	 * @param pion, Le pion qui doit �tre associ�
	 */
	public static void setCase(Pion pion) {
		plateau[pion.getLigne()][pion.getColonne()] = pion;
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
	 * Cette fonction d�place un pion sur le plateau, puis change
	 * la colonne de celui-ci et enfin, r�initialise l'attribut
	 * bloque de chaque pion pr�sent sur la ligne du pion d�plac�
	 * @param pion le pion boug�
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
	 * Vérifie si toutes les grenouilles sont à droite
	 * et si tous les crapaud sont à gauche
	 * @return true si c'est vrai
	 */
	public static boolean victoireCasseTete() {
		int nbPion, // Nombre de pion bien placés
		colonne, // Colonne sur laquelle on fait une recherche
		pionVictoire = batracien[0].length*2, // Nombre total de pion
		ligne;
		nbPion = ligne = colonne = 0; // On commence par la colonne la plus à gauche
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
	 * V�rifie si un pion dont les coordonn�es sont plac�es en argument
	 * existe et s'il appartient � l'�quipe dont c'est le tour
	 * @param equipe 0 sigifie l'�quipe grnouille, 1 l'�quipe crapaud
	 * @param ligne du potentiel pion
	 * @param colonne du potentiel pio
	 * @return true si le pion existe et appartient � la vonne �quipe
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
	 * Cr�e un String qui repr�sente le plateau de jeu
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
	 * Leurs demande de nommé leur équipe puis
	 * à tour de role il vont selectionner
	 * un pion de leur équipe à déplacer jusqu'à ce que l'une des
	 * deux équipe soit bloqué
	 * @param ordinateur détermine si le joueur joue contre un humain
	 * et si non, le niveau de difficulté de l'IA
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
	 * Effectue un tour en mode joueur vs entité
	 * ou en mode casse tête
	 * @param tourEquipe le numéro de l'équipe.
	 * Si égal à 2, alors c'est un casse tête
	 * @return
	 */
	public static int tourJoueur(int tourEquipe, int ligne, int colonne) {
		// Si le pion existe et qu'il n'est pas bloqué
		if (pionValide(tourEquipe, ligne, colonne)) {
			// On bouge le pion
			movePion(plateau[ligne][colonne]);
			tourEquipe = tourEquipe == 0 ? 1 : 0;
		}
		return tourEquipe;
	}

	public static void casseTete(int ligne, int colonne) {
		// Si la grenouille existe et qu'elle n'est pas bloquée
		if (pionValide(0, ligne, colonne) || pionValide(1, ligne, colonne)) {
			// On bouge le pion
			movePion(plateau[ligne][colonne]);
		}
	}
}