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

public class PartieV2 {

	private final static int LIGNE_MAX = 20;

	private final static int COLONNE_MAX = 20;

	private static int ligneConf,
	colonneConf,
	choixAdversaire,
	choixModeDeJeu,
	choixConfig,
	nbPion;

	private static Pion[][] plateau = new Pion[LIGNE_MAX][COLONNE_MAX];

	public static ArrayList<Configuration> listConfiguration;

	public static Configuration currentConfig;
	
	public static Pion[][] batracien = new Pion[2][];

	private final static String CHEMIN_FICHIER = "/crapouille/configuration/listeConfiguration.bin";
	
	public static void setLigneConf(int ligneConf) {
		PartieV2.ligneConf = ligneConf;
	}

	public static void setColonneConf(int colonneConf) {
		PartieV2.colonneConf = colonneConf;
	}

	public static void setChoixAdversaire(int choixAdversaire) {
		PartieV2.choixAdversaire = choixAdversaire;
	}

	public static void setChoixConfig(int choixConfig) {
		PartieV2.choixConfig = choixConfig;
	}

	public static void setNbPion(int nbPion) {
		PartieV2.nbPion = nbPion;
	}

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

	public static void saveConfig() {
		try(ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream(CHEMIN_FICHIER))) {

			fichier.writeObject(listConfiguration); 

		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initBloque() {
		for (int x = 0 ; x < ligneConf ; x++) {
			for (int y = 0 ; y < colonneConf ; y++) {
				if (plateau[x][y] != null) {
					plateau[x][y].setBloque(plateau);
				}
			}
		}
	}
	
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

}
