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
	
	private static String[] equipe = new String[2];

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

	public static void setChoixModeDeJeu(int choixModeDeJeu) {
		PartieV2.choixModeDeJeu = choixModeDeJeu;
	}

	public static void setChoixConfig(int choixConfig) {
		PartieV2.choixConfig = choixConfig;
	}

	public static void setNbPion(int nbPion) {
		PartieV2.nbPion = nbPion;
	}

	public static void setEquipe1(String equipe) {
		PartieV2.equipe[0] = equipe;
	}
	
	public static void setEquipe2(String equipe) {
		PartieV2.equipe[1] = equipe;
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
	 * Associe une case � un pion
	 * @param pion, Le pion qui doit �tre associ�
	 */
	public void setCase(Pion pion) {
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
	 * Fonction permettant d'avancer un pion et aussi v�rifiant si le pion n'est 
	 * pas bloqu� 
	 * @param pion, Le pion qu'on veut bouger
	 */
	public void movePion(Pion pion) {
		plateau[pion.getLigne()][pion.getColonne()] = null;
		pion.setColonne(plateau);
		plateau[pion.getLigne()][pion.getColonne()] = pion;
		for (int x = 0 ; x < pion.getLigne() ; x++) {
			if (plateau[pion.getLigne()][x] != null) {
				plateau[pion.getLigne()][x].setBloque(plateau);
			}
		}
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

	public static boolean pionValide(int equipe, int ligne, int colonne) {
        for (int x = 0 ; x < batracien[0].length ; x++) {
            if (batracien[equipe][x].getLigne() == ligne && batracien[equipe][x].getColonne() == colonne) {
                return true;
            }
        }
        return false;
    }
	
	/**
	 * Affiche le plateau
	 */
	public String afficherJeu() {
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
					plateauString.append(" |");
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
	public static void joueurVs(int ordinateur) {
		int tourEquipe = 0; // Numéro de l'équipe dont c'est le tour
		// Si aucun nom n'est rentré, le nom par défault est Grenouille
		equipe[0] = equipe[0].length() == 0 ? "Grenouille" : equipe[0];
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
						// TODO : Yanis tu fous l'IA ici avec un movePion
						tourEquipe--;
					}
				} while(tourEquipe == 1);
			}
		} while(!victoire(batracien[0]) || !victoire(batracien[1]));
	}
	
}
