package crapouille;

import crapouille.configuration.Configuration;
import crapouille.interfaceFx.InterfaceAppliController;

public class Outils {
	/** initialisation des constantes min/max lignes et colonnes */
	final static int MIN_LIGNE_PION = 1;
	final static int MAX_LIGNE_PION = 20;
	final static int MIN_COLONNE_PION = 1;
	final static int MAX_COLONNE_PION = 20;
	
	/** initialisation des constantes min/max lignes et colonnes */
	final static int MIN_LIGNE_TABLEAU = 1;
	final static int MAX_LIGNE_TABLEAU = 20;
	final static int MIN_COLONNE_TABLEAU = 3;
	final static int MAX_COLONNE_TABLEAU = 20;

	/** initialisation des constantes du format : XXX;XX */
	final static int NOM_PION = 0; // position du 1er chiffre de l'entier
	final static int PREMIER_CHIFFRE_LIGNE = 1; // position du 1er chiffre de l'entier
	final static int DEUXIEME_CHIFFRE_LIGNE = 2; // position du 2e chiffre de l'entier
	final static int DISTINCTION_1 = 3; // position du 1er caractère ';' dans le format parcourut
	final static int PREMIER_CHIFFRE_COLONNE = 4; // position du 1er chiffre de l'entier
	final static int DEUXIEME_CHIFFRE_COLONNE = 5; // position du 2e chiffre de l'entier
	public static String nomConfig;

	final static String MSGBOX_TITRE = "Crapauds & Grenouilles";
	final static String MSGBOX_TYPE = "Type non valide";
	final static String MSGBOX_LETTRE = "Les lettres / Symboles ne sont pas acceptées";
	final static String MSGBOX_NOMBRE = "Nombre trop grand ou trop petit vérifier votre saisie";
	final static String MSGBOX_VIDE = "Ne doit pas être vide";
	final static String MSBOX_CONFIG = "La configuration ne peut pas être vide";
	final static String MSGBOX_ENREGISTREE = "Votre confirmation a bien été enregistrée";
	final static String MSGBOX_NONVALIDE_CONF = "La configuration que vous avez crée n'est pas valide";


	final static String MESSAGE_ERREUR = "Les informations rentrés sont invalides : ";

	/**
	 * Verifie si le char correspond correspond a un crapaud
	 * Si se n'est pas le cas renvoit false se qui signifie que
	 * le pion est une grenouille. Cette fonction intervient lors
	 * de la creation du pion dans le tableau afin de definir son type
	 * Ainsi que apres toutes les verifications sur l'entree de l'utilisateur
	 * Se qui signifie que le pion a se moment ne pourra etre que C ou G
	 * @param choix char rentre par l'utilisateur qui definie le type du pion
	 */
	public static boolean recupType(char choix) {
		return choix == 'C' ? true : false;
	}
	
	/**
	 * Recupere le numero de la config 
	 * Et charge la configuration correspondant au numero demande
	 */
	public static void recupConfigurationPartie(int choixConfig) {
		Partie.loadConfig(choixConfig);
	}

	

	public static void attribuerNomJ1(String nomJ1) {
		if (estNonVide(nomJ1)) {
			Partie.setEquipe1(nomJ1);
		} else {
			Partie.setEquipe1(Partie.getNomEquipe1Defaut());
		}
	}

	public static void attribuerNomJ2(String nomJ2) {
		if (estNonVide(nomJ2)) {
			Partie.setEquipe2(nomJ2);
		} else {
			Partie.setEquipe2(Partie.getNomEquipe2Defaut());
		}
	}


	/**
	 * Recupere toutes les configs disponible et les renvoi sous forme
	 * de String pour etre afficher dans un label sur linterface
	 * @return La liste des configs et leur numero en String
	 */
	public static String afficherConfigDispo(){
		StringBuilder configs = new StringBuilder();
		for (int compteur = 0; compteur < Configuration.listConfiguration.size(); compteur++) {
			configs.append(compteur + " - ");
			configs.append(Configuration.listConfiguration.get(compteur).getNom());
			configs.append("\n");
		}
		return configs.toString();
	}


	/**
	 * Récupère le coordonnée de la ligne du pion
	 * @param coordonneePion est le coordonné du poin sur le plateau 
	 * @return le coordonné de la ligne du pion
	 */
	public static int recupereLignePion(String coordonneePion) {
		StringBuilder lignePion = new StringBuilder(); // lignePion est le coordonnée de la ligne du pion
		lignePion.append(coordonneePion.charAt(0));
		lignePion.append(coordonneePion.charAt(1));
		return Integer.parseInt(lignePion.toString());
	}

	/**
	 * Récupère le coordonnée de la colonne du pion
	 * @param coordonneePion est le coordonné du poin sur le plateau 
	 * @return la coordonné de la colonne du pion
	 */
	public static int recupereColonnePion(String coordonneePion) {
		StringBuilder colonnePion = new StringBuilder(); // lignePion est le coordonnée de la ligne du pion
		colonnePion.append(coordonneePion.charAt(0));
		colonnePion.append(coordonneePion.charAt(1));
		return Integer.parseInt(colonnePion.toString());
	}

	/*--------------- FONCTION ESTVALIDE  ---------------*/

	/**
	 * Verifie si le type entree par l'utilisateur est valide
	 * @param type Type entree par l'utilisateur
	 * @return un boolean definissant si le type est valide
	 * true = Type valide
	 * False = Erreur dans les tests le type n'est pas valide
	 */
	public static boolean typeValide(String type) {
		if (type.length() != 1 || (type.charAt(0) != 'C' 
				&& type.charAt(0) != 'G')) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Fonction qui vérifie si uen chaine de caractère ne contient que des chiffres
	 * @param aVerifier String a verifier la validité ( pas de nombre)
	 * @return false si la string aVerifier contient une lettre
	 * 		   true si la String ne contient aucune lettre
	 */
	public static boolean verificationLettre(String aVerifier) {
		for (int compteur = 0; compteur < aVerifier.length(); compteur ++) {
			char tester = aVerifier.charAt(compteur);
			if (tester < '0' || tester > '9') {
				return false;
			}
		}
		return true;	
	}

	/**
	 * Détermine si le coordonée de la ligne du pion est correct  
	 * avec le contrôle de la gestion d'erreur
	 * @param coordonneePion est le coordonné du poin sur le plateau 
	 * @return un booleen égal a vrai si la ligne du pion est correct
	 */
	public static boolean ligneEstValide(int lignePion) {
		// La ligne du pion doit être supérieur à 0 et inférieure ou égal à 20  
		return MIN_LIGNE_PION <= lignePion && lignePion < MAX_LIGNE_PION;
	}

	/**
	 * Détermine si la coordonée de la colonne du pion est correct  
	 * avec le contrôle de la gestion d'erreur
	 * @param coordonneePion est le coordonné du poin sur le plateau 
	 * @return un booleen égal a vrai si la colonne du pion est correct
	 */
	public static boolean colonneEstValide(int colonnePion) {
		// La ligne du pion doit être supérieur à 0 et inférieure ou égal à 20  
		return MIN_COLONNE_PION <= colonnePion 
				&& colonnePion < MAX_COLONNE_PION;
	}	



	/**
	 * Verifie que el nombre rentree par l'uti 
	 * est une nombre correspondant a 
	 */
	public static boolean cordOk(int ligne, int colonne) {
		return ligne < Partie.config.length && 
				colonne < Partie.config[0].length &&
				ligne >= 0 && colonne >= 0;
	}

	/**
	 * Détermine si les lignes du plateau sont corrects 
	 * avec le contrôle de la gestion d'erreur
	 * @param colonnePlateau est le nombre de colonnes pour le plateau 
	 * @param lignePlateau est le nombre de lignes pour le plateau
	 * @return un booleen égal a vrai si les lignes et colonnes plateau sont corrects
	 */
	public static boolean configPlateauEstValide(int lignePlateau, int colonnePlateau) {
		/* vérification des entier ligne et colonne avec 
		 * la taille max et min d'une ligne et d'une colonne
		 * limité a 20 (pour l'instant)
		 */
		return (MIN_LIGNE_TABLEAU <= lignePlateau 
				|| lignePlateau <= MAX_LIGNE_TABLEAU) &&
				(MIN_COLONNE_TABLEAU <= colonnePlateau 
				|| colonnePlateau <=MAX_COLONNE_TABLEAU);
	}

	/**
	 * Verifie si l'une des equipes a gagne
	 * @return true si l'une des equipes a gagne
	 * 		   false si aucun equipe a gagne et que le jeu peut continuer
	 */
	public static boolean verifVictoire() {
		if (Partie.getChoixModeDeJeu() == 1 &&
				Partie.currentPlateau.victoire(0) ||
				Partie.currentPlateau.victoire(1)) {
			return true;
		} else if (Partie.getChoixModeDeJeu() == 0 &&
				Partie.currentPlateau.victoireCasseTete()) {
			return true;
		}
		return false;
	}
	
	public static boolean estNonVide(String aVerifier) {
		if (aVerifier.equals("")) {
			return false;
		} else {
			return true;
		}
	}


	public static boolean configIni(String ligne, String colonne) {
		if(estNonVide(ligne) && estNonVide(colonne)) {
			if (Outils.verificationLettre(colonne) 
					&& Outils.verificationLettre(ligne)) {
				/* Conversion en int */
				int nbLigne = Integer.parseInt(ligne);
				int nbColonne = Integer.parseInt(colonne);
				if (Outils.ligneEstValide(nbLigne) 
						&& Outils.colonneEstValide(nbColonne)) {
					/* Initialise le tableau a la taille choisie par l'uti */
					Partie.config = new Pion[nbLigne][nbColonne];
					return true;
				} else {
					InterfaceAppliController.showMsgbox(MSGBOX_TITRE, MESSAGE_ERREUR 
							+ MSGBOX_NOMBRE,
							false);
				}
			} else {
				InterfaceAppliController.showMsgbox(MSGBOX_TITRE,MESSAGE_ERREUR 
						+ MSGBOX_LETTRE,
						false);
			}
		} else {
			InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
					MESSAGE_ERREUR + MSGBOX_VIDE,false);
		}
		return false;
	}

	public static boolean placementPion(String ligne,String colonne,String type) {
		if (estNonVide(ligne) && estNonVide(colonne) && estNonVide(type)) {
			/* Verification qu'il n'y pas de lettre*/
			if (verificationLettre(ligne) && verificationLettre(colonne)) {
				int colonnePion = Integer.parseInt(colonne);
				int lignePion = Integer.parseInt(ligne);
				colonnePion--;
				lignePion--;
				/* Verification que les coordonnes corresponde bien a une coordonnes
				 * dans le tableau de jeu
				 */
				if (Outils.cordOk(lignePion,colonnePion)) {
					/* Verification le type entre par l'uti est valide */
					if (Outils.typeValide(type)) {
						Outils.placementPion(lignePion,colonnePion,
								Outils.recupType(type.charAt(0)));
						return true;
						/* Affichage des differentes erreurs */
					} else {
						InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
								MESSAGE_ERREUR + MSGBOX_TYPE, false);
					}
				} else {
					InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
							MESSAGE_ERREUR + MSGBOX_NOMBRE, false);
				}
			} else {
				InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
						MESSAGE_ERREUR + MSGBOX_LETTRE, false);
			}
		} else {
			InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
					MESSAGE_ERREUR + MSGBOX_VIDE, false);
		}
		return false;
	}

	/**
	 * Verifie si la configuration entree par lutilisateur dans la page de configuration de partie
	 * Verifie que le textField contenant le numero n'est pas vide
	 * Qu'il n'y a pas de lettres et que et le numero existe
	 * @return true si tous les tests sont correctes'
	 *         false si un seul test ne passe pas9
	 */
	public static boolean configValide(String choixConf) {
		/* On vérifie que la la string n'est pas vide pour ne pas produire d'erreur par la suite */
		if (estNonVide(choixConf)) { 
			/* Verification qu'il n'y a pas de lettre dans lentree */
			if(Outils.verificationLettre(choixConf)) {
				int config = Integer.parseInt(choixConf);
				/* Verification que le numero existe et correspond a uen configuration */
				if (configExiste(config)) {
					return true;
					/** Affichage des differents message d'erreur selon le cas */
				} else {
					InterfaceAppliController.showMsgbox(MESSAGE_ERREUR,
							MSGBOX_NOMBRE, false);
				}
			} else {
				InterfaceAppliController.showMsgbox(MESSAGE_ERREUR,
						MSGBOX_LETTRE, false);
			}
		} else {
			InterfaceAppliController.showMsgbox(MESSAGE_ERREUR,
					MSGBOX_VIDE, false);
		}
		return false;
	}

	private static boolean configExiste(int config) {
		return config >= 0 && config < Configuration.listConfiguration.size();
	}

	public static boolean actualisationPlateau(String ligne, String colonne) {
		if (estNonVide(ligne) && estNonVide(colonne)) { 
			/* Vérifie s'il n'y a pas de lettre avant de convertir en int les entrées
			 * pour ne pas produire d'erreur
			 */
			if (Outils.verificationLettre(ligne) 
					&& Outils.verificationLettre(colonne)) {
				/*Conversion en int des entrées texte de l'utilisateur */
				int colonnePion = Integer.parseInt(colonne);
				int lignePion = Integer.parseInt(ligne);
				if (Outils.colonneEstValide(colonnePion) 
						&& Outils.ligneEstValide(lignePion)) {
					/* Decremente de 1 car les numeros rentres et afficher sur le plateau 
					 * sont augmenter de 1 pour corerspondre a une bonne notation de 
					 * (de 1 a 20 et non de 0 a 19) plus confortable pour l'utilisateur
					 */
					colonnePion--;
					lignePion--;
					/* Si toutes les entrees sont correctes lance le tour du joueur */
					Partie.tourEntite(lignePion, colonnePion);
					return true;
					/* Affichage des messages d'erreurs a l'utilisateur pour lui siganler le probleme */
				} else {
					InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
							MESSAGE_ERREUR+ MSGBOX_NOMBRE,false);
				}
			} else {
				InterfaceAppliController.showMsgbox(MSGBOX_TITRE,MESSAGE_ERREUR
						+MSGBOX_LETTRE,
						false);
			}
		} else {
			InterfaceAppliController.showMsgbox(MSGBOX_TITRE,MESSAGE_ERREUR
					+ MSGBOX_VIDE,
					false);
		}
		return false;
	}

	/**
	 * 
	 * @param lignePion int: ligne ou se trouve le pion a ajouter/ placer
	 * @param colonnePion int: colonne ou se trouve le pion a ajouter/ placer
	 * @param recupType boolean: type du pion a placer (Crapaud ou grenouille)
	 */
	public static void placementPion(int lignePion, int colonnePion,
			boolean type) {
		Pion placementUti = new Pion(lignePion,colonnePion,type);
		Partie.config[lignePion][colonnePion] = placementUti;
	}
	/**
	 * Enregistre la configuration cree par l'utilisateur dans l'arrays 
	 * qui contient toutes les configurations
	 */
	public static void enregistrerArray() {
		Plateau config = new Plateau(Partie.config);
		Configuration newConfig = new Configuration (
				config.getPlateau(),nomConfig);
		Configuration.listConfiguration.add(newConfig);
	}

	public static void sauvegarder() {
		Plateau config = new Plateau(Partie.config);
		/* Sauvegarde la configuration */
		Configuration newConfig = new Configuration (
				config.getPlateau(), Outils.nomConfig);
		Configuration.listConfiguration.add(newConfig);
		Outils.enregistrerArray();
	}

	public static boolean supprimerConf(String idConfig) {
		/* Vérifie que le textfield n'est pas vide pour ne pas produire d'erreur
		 * Si c'est le cas affiche un message d'erreur
		 */
		if (estNonVide(idConfig)) {
			/* Vérifie que tous les caractères de l'information rentrées par l'utilisateur
			 * sont bien des chiffres
			 */
			if (Outils.verificationLettre(idConfig)) {
				/* Converti en int le String correspondant au numéro de la config devant être supprimé */
				int index = Integer.parseInt(idConfig);
				/*Vérifie que le numéro rentré par l'utilisateur correspond bien 
				 * a une configuration existante
				 */
				if (index >= 0 &&
						index < Configuration.listConfiguration.size()) {
					Configuration.listConfiguration.remove(index);
					return true;
					/* Affichage de message d'erreur si l'une des conditions n'est pas respectée
					 * Informant l'utilisateur de l'erreur qu'il a commise 
					 */
				} else {
					InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
							MESSAGE_ERREUR
							+ MSGBOX_NONVALIDE_CONF,
							false);
				}
			} else {
				InterfaceAppliController.showMsgbox(MSGBOX_TITRE, 
						MESSAGE_ERREUR + MSGBOX_LETTRE,
						false);
			}
		} else {
			InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
					MESSAGE_ERREUR + MSGBOX_VIDE, false);

		}
		return false;
		
	}

	public static boolean suppressionPion(String ligne, String colonne) {
		if (estNonVide(ligne) && estNonVide(colonne)) {
			/* Verification qu'il n'y pas de lettre*/
			if (verificationLettre(ligne) && verificationLettre(colonne)) {
				int colonnePion = Integer.parseInt(colonne);
				int lignePion = Integer.parseInt(ligne);
				colonnePion--;
				lignePion--;
				/* Verification que les coordonnes corresponde bien a une coordonnes
				 * dans le tableau de jeu
				 */
				if (Outils.cordOk(lignePion,colonnePion)) {
					/* Verification le type entre par l'uti est valide */
						Partie.config[lignePion][colonnePion] = null;
						return true;
						/* Affichage des differentes erreurs */
				} else {
					InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
							MESSAGE_ERREUR + MSGBOX_NOMBRE, false);
				}
			} else {
				InterfaceAppliController.showMsgbox(MSGBOX_TITRE,
						MESSAGE_ERREUR + MSGBOX_LETTRE, false);
			}
		}
		return false;
	}
}