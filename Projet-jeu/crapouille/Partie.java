package crapouille;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

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
	 * ArrayList contenant toutes les configurations créé
	 * ainsi que la configuration par défaut.
	 * Cette variable est enregistré lorsque le joueur
	 * quitte l'application
	 */
	public static ArrayList<Configuration> listConfiguration = new ArrayList<Configuration>();

	/**
	 * copie d'un plateau de listConfiguration
	 */
	private static Plateau currentPlateau;
	
	private static Plateau configPlateau;

	private static int tourEquipe = 0;

	/**
	 * Chemin du fichier bin dans lequel est enregistré
	 * la ArryList listConfiguration
	 */
	private final static String CHEMIN_FICHIER = "crapouille/configuration/listConfiguration.bin";

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

	public static void setConfigPlateau(int ligne, int colonne) {
		Pion[][] config = new Pion[ligne][colonne];
		configPlateau = new Plateau(config);
	}
	
	public static Plateau getConfigPlateau() {
		return configPlateau;
	}
	
	public static void setCasePlateau(Pion pion) {
		configPlateau.setCase(pion);
	}

	public LocalDate getDepartPartie() {
		return departPartie;
	}

	public static void setDepartPartie(LocalDate debut) {
		departPartie = debut;
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
			currentPlateau = new Plateau(listConfiguration.get(0).getConfigPlateau());
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

	public static void loadConfig(int choixConfig) {
		if (listConfiguration.get(choixConfig) != null) {
			currentPlateau = new Plateau(listConfiguration.get(choixConfig).getConfigPlateau());
			tourEquipe = 0;
		}
	}
	
	public static void createConfig() {
		
	}

	public static void tourEntite(int ligne, int colonne) {
		if (currentPlateau.pionValide(tourEquipe, ligne, colonne)) {
			currentPlateau.movePion(currentPlateau.getPlateau()[ligne][colonne]);
			tourEquipe = tourEquipe == 0 ? 1 : 0;
		}
	}


}