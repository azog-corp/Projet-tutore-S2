/*
 * 
 * 
 */
package crapouille;

import java.io.Serializable;
import java.time.LocalDate;

import crapouille.configuration.Configuration;

/**
 * A compléter.
 * @author Maël
 *
 */
public class Partie implements Serializable {

	/** ID de la serialisation */
	private static final long serialVersionUID = 5319670181574630732L;

	/**
	 * Lorsque le joueur lance la partie
	 * recupere le temps afin de determiner
	 * le temps mis par le joueur pour resoudre le casse tete
	 * Le temps est uniquement mesuree sur la config par defaut
	 */
	private static LocalDate departPartie;

	/** Adversaire choisi par l'utilisateur
	 * 0 = humain
	 * 1 = ia niveau 1
	 */
	private static int choixAdversaire;

	/**
	 * Mode de jeu choisi par l'adversaire
	 * 0 = casse tete
	 * 1 = versus
	 */
	private static int choixModeDeJeu;

	/**
	 * Nom par dÃ©faut de l'Ã©quipe Crapaud
	 */
	private static String nomEquipe1Defaut = "Grenouille";

	/**
	 * Nom par dÃ©faut de l'Ã©quipe Grenouille
	 */
	private static String nomEquipe2Defaut = "Crapaud";

	/**
	 * Tableau contenant le nom des deux Ã©quipes
	 * saisies par le ou les joueurs
	 */
	private static String[] equipe = new String[2];

	/**
	 * Copie d'un plateau de listConfiguration
	 * et sur lequel se joue une partie.
	 * Sert égalemen à la création de configuration.
	 */
	public static Plateau currentPlateau;

	public static Pion[][] config;

	/**
	 * Indique l'équipe de laquelle c'est le tour:
	 * 0 : grenouille
	 * 1 : Crapaud
	 */
	private static int tourEquipe = 0;

	/**
	 * Indique le nombre de coup réalisé
	 * pour terminer un casse tête
	 */
	private static int nbCoups;

	/**
	 * @return Le nombre de coup effectué
	 */
	public static int getNbCoups() {
		return nbCoups;
	}

	/**
	 * Modifie nbCoup
	 * @param nbCoupsPartie la nouvelle valeur de nbCoups
	 */
	public static void setNbCoups(int nbCoupsPartie) {
		nbCoups = nbCoupsPartie;
	}

	/**
	 * @return le nom de l'Ã©quipe grenouille
	 */
	public static String getNomEquipe1Defaut() {
		return nomEquipe1Defaut;
	}

	/**
	 * @return le nom de l'Ã©quipe crapaud
	 */
	public static String getNomEquipe2Defaut() {
		return nomEquipe2Defaut;
	}

	/**
	 * Modifie la nature de l'adversaire
	 * @param choixAdversaire l'entitÃ© contre laquelle
	 * le joueur veut faire une partie :
	 * - 0 pour un humain
	 * - 1 ou plus pour une IA
	 */
	public static void setChoixAdversaire(int choixAdversaire) {
		Partie.choixAdversaire = choixAdversaire;
	}

	/**
	 * @return l'entitÃ© contre laquelle le joueur veut faire une partie
	 */
	public static int getChoixAdversaire() {
		return choixAdversaire;
	}

	/**
	 * Change le mode de jeu
	 * @param choixModeDeJeu 0 pour joueur versus et 1 pour casse tÃªte
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
	 * @param equipe le nom de l'Ã©quipe grenouille
	 */
	public static void setEquipe1(String equipe) {
		Partie.equipe[0] = equipe;
	}

	/**
	 * @param equipe le nom de l'Ã©quipe crapaud
	 */
	public static void setEquipe2(String equipe) {
		Partie.equipe[1] = equipe;
	}
	
	public static String getEquipe(int tour) {
		return equipe[tour];
	}

	/**
	 * @return le plateau en cours
	 */
	public static Plateau getCurrentPlateau() {
		return currentPlateau;
	}

	/**
	 * @return le temps
	 */
	public LocalDate getDepartPartie() {
		return departPartie;
	}

	/**
	 * @param debut la nouvelle valeur de departPartie
	 */
	public static void setDepartPartie(LocalDate debut) {
		departPartie = debut;
	}

	/**
	 * @return le numéro de l'équipe qui joue
	 */
	public static int getTourEquipe() {
		return tourEquipe;
	}

	public static String configToString() {
		StringBuilder configString = new StringBuilder();
		configString.append("  | ");
		for (int z = 0 ; z < config[0].length ; z++) {
			configString.append(z+1 + "  | ");
		}
		for (int x = 0 ; x < config.length ; x++) {
			if (x+1 < 0) {
				configString.append("\n" + (x+1) + "  |");
			} else {
				configString.append("\n" + (x+1) + " |");
			}
			for (int y = 0 ; y < config[0].length ; y++) {
				if (config[x][y] != null) {
					if (config[x][y].isCrapaud()) {
						configString.append(" C |");
					} else if (!config[x][y].isCrapaud()) {
						configString.append(" G |");
					}
				} else {
					configString.append("   |");
				}
			}
		}
		return configString.toString();
	}

	/**
	 * Initialise le plateau avec une des configuration existatantes
	 * et met tourEquipe à 0
	 * @param choixConfig l'indice de la config à initialiser
	 */
	public static void loadConfig(int choixConfig) {
		currentPlateau = new Plateau(Configuration.listConfiguration.get(choixConfig).getConfigPlateau());
		tourEquipe = 0;
	}

	
	/**
	 * Bouge un pion en fonction du tour de l'adversaire ou du mode
	 * de jeu tout en vérifiant que le pion existe
	 * @param ligne du pion à vérifié et déplacé
	 * @param colonne du pion à vérifié et déplacé
	 * @return true si un pion à été déplacé
	 * @throws InterruptedException 
	 */
	public static Boolean tourEntite(int ligne, int colonne) {
		boolean tourFait = false;
		if (choixModeDeJeu == 1) {
			if (currentPlateau.pionValide(tourEquipe, ligne, colonne) != null) {
				currentPlateau.movePion(currentPlateau.pionValide(tourEquipe, ligne, colonne));
				tourEquipe = tourEquipe == 0 ? 1 : 0;
				tourFait = true;
			}
			if (choixAdversaire != 0 && tourFait) {
				Ordinateur.choixOrdi(currentPlateau, 
						currentPlateau.getBatracien(), 
						choixAdversaire);
				tourEquipe = 0;
			}
		} else { 
			if ((choixModeDeJeu == 0 && currentPlateau.pionValide(0, ligne, colonne) != null)) {
				currentPlateau.movePion(currentPlateau.pionValide(0, ligne, colonne));
			}
			if ((choixModeDeJeu == 0 && currentPlateau.pionValide(0, ligne, colonne) != null)) {
				currentPlateau.movePion(currentPlateau.pionValide(1, ligne, colonne));
			}
		}
		return tourFait;
	}
}
