package crapouille;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import crapouille.configuration.Configuration;

public class Partie {

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

	public static Plateau currentPlateau;


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
					Ordinateur.ChoixOrdinateur(choixAdversaire,currentPlateau);
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
			movePion(currentPlateau[ligne][colonne]);
			tourEquipe = tourEquipe == 0 ? 1 : 0;
		}
		return tourEquipe;
	}

	public static void casseTete(int ligne, int colonne) {
		// Si la grenouille existe et qu'elle n'est pas bloquÃ©e
		if (pionValide(0, ligne, colonne) || pionValide(1, ligne, colonne)) {
			// On bouge le pion
			movePion(currentPlateau[ligne][colonne]);
		}
	}
}
