package crapouille;

import java.io.Serializable;
import java.time.LocalDate;

import crapouille.configuration.Configuration;

public class Partie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5319670181574630732L;

	/**
	 * Lorsque le joueur lance la partie recupere le temps afin de determiner
	 * le temps mis par le joueur pour resoudre le casse tete
	 * Le temps est uniquement mesuree sur la config par defaut
	 */
	private static LocalDate departPartie;

	/** Adversaire choisi par l'utilisateur
	 * 0 = humain
	 * 1 = ia niveau 1
	 * 2 = ia niveau 2
	 */
	private static int choixAdversaire;

	/**
	 * Mode de jeu choisi par l'adversaire
	 * 0 = casse tete
	 * 1 = versus
	 */
	private static int choixModeDeJeu;

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
	private static String[] equipe = new String[2];

	/**
	 * copie d'un plateau de listConfiguration
	 */
	public static Plateau currentPlateau;


	private static int tourEquipe = 0;

	private static int nbCoups;

	public static int getNbCoups() {
		return nbCoups;
	}

	public static void setNbCoups(int nbCoupsPartie) {
		nbCoups = nbCoupsPartie;
	}

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

	public static Plateau getCurrentPlateau() {
		return currentPlateau;
	}

	public static void setCurrentPlateau(int ligne, int colonne) {
		Pion[][] plateau = new Pion[ligne][colonne];
		Partie.currentPlateau = new Plateau(plateau);
	}

	public LocalDate getDepartPartie() {
		return departPartie;
	}

	public static void setDepartPartie(LocalDate debut) {
		departPartie = debut;
	}

	public static int getTourEquipe() {
		return tourEquipe;
	}

	public static void loadConfig(int choixConfig) {
		currentPlateau = new Plateau(Configuration.listConfiguration.get(choixConfig).getConfigPlateau());
		tourEquipe = 0;
	}

	public static Boolean tourEntite(int ligne, int colonne) {
		boolean tourFait = false;
		System.out.println(tourEquipe);
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
				System.out.println("yess");
			}
		} else if ((choixModeDeJeu == 0 && currentPlateau.pionValide(0, ligne, colonne) != null)) {
			currentPlateau.movePion(currentPlateau.pionValide(0, ligne, colonne));
		} else if ((choixModeDeJeu == 0 && currentPlateau.pionValide(0, ligne, colonne) != null)) {
			currentPlateau.movePion(currentPlateau.pionValide(1, ligne, colonne));
		}
		return tourFait;
	}
}