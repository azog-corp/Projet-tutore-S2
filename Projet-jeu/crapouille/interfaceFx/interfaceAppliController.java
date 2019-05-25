/*
 * interfaceAppliController.java
 * Azog-corp 2019, droit d'auteur
 */
//TODO toutes les fonctions sans @FXML a mettre dans partie pour faire moin de ligne

package crapouille.interfaceFx;


import java.time.LocalDate;

import crapouille.Ordinateur;
import crapouille.Partie;
import crapouille.Pion;
import crapouille.Plateau;
import crapouille.configuration.Configuration;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class interfaceAppliController {


	/** initialisation des constantes min/max lignes et colonnes */
	final static int MIN_LIGNE_PION = 1;
	final static int MAX_LIGNE_PION = 20;
	final static int MIN_COLONNE_PION = 1;
	final static int MAX_COLONNE_PION = 20;

	/** initialisation des constantes du format : XXX;XX */
	final static int NOM_PION = 0; // position du 1er chiffre de l'entier
	final static int PREMIER_CHIFFRE_LIGNE = 1; // position du 1er chiffre de l'entier
	final static int DEUXIEME_CHIFFRE_LIGNE = 2; // position du 2e chiffre de l'entier
	final static int DISTINCTION_1 = 3; // position du 1er caractère ';' dans le format parcourut
	final static int PREMIER_CHIFFRE_COLONNE = 4; // position du 1er chiffre de l'entier
	final static int DEUXIEME_CHIFFRE_COLONNE = 5; // position du 2e chiffre de l'entier

	private String nom;
	private String nomConfig;

	final static String MESSAGE_ERREUR = "Les informations rentrés sont invalides : ";

	@FXML
	private AnchorPane gameBoard;

	@FXML
	private AnchorPane backpanel;

	@FXML
	private Label erreurSuppressionConfig;

	@FXML
	private Button btn_jouermenu;

	@FXML
	private ImageView btn_createur;

	@FXML
	private TextField tb_nbColonneConf;

	@FXML
	private TextField entreeColonne;

	@FXML
	private AnchorPane defaite;

	@FXML
	private AnchorPane score;

	@FXML
	private ToggleGroup lvlIA;

	@FXML
	private Button btn_quittermenu;

	@FXML
	private TextField tb_cordType;

	@FXML
	private AnchorPane createur;

	@FXML
	private Button confirmationJouer;

	@FXML
	private Label gameBoardString;

	@FXML
	private TextField tb_cordColonne;

	@FXML
	private TextField entreeLigne;

	@FXML
	private AnchorPane jeuEnCours;

	@FXML
	private ImageView btn_quitter;

	@FXML
	private TextField tb_idConf;

	@FXML
	private Button btn_ajouterConf;

	@FXML
	private TextField choixConfig;

	@FXML
	private AnchorPane placementConfig;

	@FXML
	private Button retourMenu;

	@FXML
	private CheckBox chk_vsIA;

	@FXML
	private Label NOM;

	@FXML
	private Label erreurPlacementPion;

	@FXML
	private AnchorPane choixConf;

	@FXML
	private AnchorPane settingsBar;

	@FXML
	private Button btn_aidemenu;

	@FXML
	private Label lb_lvlIa;

	@FXML
	private Label labelIA;

	@FXML
	private CheckBox chk_casseT;

	@FXML
	private ImageView btn_configuration;

	@FXML
	private AnchorPane supprimerConf;

	@FXML
	private TextField tb_nomConf;

	@FXML
	private Label erreurEntreePartie;

	@FXML
	private TextField tb_cordLigne;

	@FXML
	private AnchorPane initialisationConfig;

	@FXML
	private AnchorPane configuration;

	@FXML
	private Button okGameBoard;

	@FXML
	private TextField tb_nbLigneConf;

	@FXML
	private ImageView btn_mvp;

	@FXML
	private AnchorPane victoire;

	@FXML
	private Button btn_supprimerConf;

	@FXML
	private Button btn_validerTaille;

	@FXML
	private Label afficherConfig;

	@FXML
	private Label erreurCreationConfig;

	@FXML
	private Label lb_nomEquipeGagnante;

	@FXML
	private RadioButton lvl2;

	@FXML
	private RadioButton lvl3;

	@FXML
	private Button btn_supprimerConfig;

	@FXML
	private Button btn_validerConfig;

	@FXML
	private Label lb_nomJ1;

	@FXML
	private TextField tb_nomJ2;

	@FXML
	private ImageView btn_acceuil;

	@FXML
	private Label configAdel;

	@FXML
	private Label lb_nomJ2;

	@FXML
	private TextField tb_nomJ1;

	@FXML
	private AnchorPane menu;

	@FXML
	private Button btn_AjouterPion1;

	@FXML
	private Label listeConfigDispo;

	@FXML
	private Label nomMVP;

	@FXML
	private Button btn_AjouterPion;

	@FXML
	private Label erreurConfigPartie;

	@FXML
	private Text scoreMVP;

	@FXML
	private AnchorPane configurationPartie;

	@FXML
	private RadioButton lvl1;


	/* --------------------------------------------------------
	 * --------------- FONCTION NAVIGATION MENU --------------- 
	 * --------------------------------------------------------
	 */
	/**
	 * Si l'utilisateur clique sur l'un des boutons pour quitter l'application
	 * Appel cette fonction qui ferme l'application
	 * @param click
	 */
	@FXML
	void leave(MouseEvent click) {
		Platform.exit(); 
	}

	/**
	 * Avant de changer de page lorsque l'utilisateur navigue on fait 
	 * disparaitre toutes les autres pages avant de faire apparaitre celle 
	 * demandee par l'utilisateur
	 */
	@FXML
	void reinitialiser() {
		menu.setVisible(false);
		configurationPartie.setVisible(false);
		score.setVisible(false);
		gameBoard.setVisible(false);
		createur.setVisible(false);
		configuration.setVisible(false);
	}

	/**
	 * Appel la fonction pour faire disparaitre toutes les autres pages
	 * affiche la page qui affiche a l'utilisateur la personne qui
	 * possede le record sur le casse tete
	 * @param Click
	 */
	@FXML
	void showMVP(MouseEvent Click) {
		reinitialiser();
		score.setVisible(true);
	}
	/**
	 * Affiche la page des createurs apres avoir fait disparaitre 
	 * toutes les autres
	 * @param Click
	 */
	@FXML
	void showCreateur(MouseEvent Click) {
		reinitialiser();
		createur.setVisible(true);
	}

	/**
	 * Affiche le menu principal de l'application
	 * @param Click
	 */
	@FXML
	void showMenu(MouseEvent Click) {
		reinitialiser();
		menu.setVisible(true);
	}

	/**
	 * Affiche la configuration de la partie 
	 * @param Click
	 */
	@FXML
	void showConfigurationPartie(MouseEvent Click) {
		reinitialiser();
		razPartie();
		configurationPartie.setVisible(true);
		listeConfigDispo.setText(afficherConfigDispo());
	}

	/**
	 * Affiche la premiere page de la section de configuration
	 *  presentant le menu qui permet a l'utilisateur
	 * de choisir entre supprimer et ajouter des configurations
	 * lorsque celui ci clic sur la section configuration
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	void showConfiguration(MouseEvent Click) {
		reinitialiser();
		configuration.setVisible(true);
		initialisationConfig.setVisible(false);
		placementConfig.setVisible(false);
		supprimerConf.setVisible(false);
		choixConf.setVisible(true);
	}

	/**
	 * Fonction qui verifie si la case IA est check
	 * Si cest le cas appel la fonction appel la fonction caseIaCheck
	 * Qui fait disparaitre tous les élements liés a l'IA et affiche 
	 * la case pour entrer le nom du deuxieme joueur
	 * Sinon fait linverse fait apparaitre les elements de l'IA 
	 * et fait disparaitre la case du nom pour le J2
	 */
	@FXML
	void verificationCheck() {
		if (chk_vsIA.isSelected()) {
			caseIaCheck();
		} else {
			caseIaPasCheck();
		}
	}
	/**
	 * Fpnction qui verifie le mode de jeu selectionnee par lutilisateur
	 * Si celui si est le casse tete appel les fonctions pour faire disparaitre
	 * les elements correspondant a l'IA et la possibilite dentrer un nom de J2
	 * sinon fait linverse
	 */
	@FXML
	void verificationModeJeu() {
		if (chk_casseT.isSelected()) {
			casseTeteConf();
		} else {
			versusConf();
		}
	}

	/**
	 * Dans le cas ou l'utilisateur souhaite faire une partie en versus
	 * fait apparaitre l'IA et le J2
	 */
	@FXML
	void versusConf() {
		chk_vsIA.setVisible(true);
		labelIA.setVisible(true);
		lb_nomJ2.setVisible(true);
		tb_nomJ2.setVisible(true);
	}

	/**
	 * Fonction decoche toutes les cases correspondant a l'IA
	 */
	void razIa() {
		chk_vsIA.setSelected(false);
		lvl1.setSelected(false);
		lvl2.setSelected(false);
		lvl3.setSelected(false);
	}

	/**
	 * Lorsque l'utilisateur decide de faire un casse tete
	 * cache les elements de l'IA qui sont donc plus necessaire
	 * cache les elements du J2 qui sont eux aussi devenu non necessaire
	 * remet a zero les elements de l'Ia pour que si l'utilisateur
	 * change d'avis celle si soit remise a defaut
	 */
	@FXML
	void casseTeteConf() {
		cacherIa();
		cacherJ2();
		razIa();
		labelIA.setVisible(false);
		chk_vsIA.setVisible(false);
	}

	/**
	 * Cache les elements du J2
	 */
	@FXML
	void cacherJ2() {
		lb_nomJ2.setVisible(false);
		tb_nomJ2.setVisible(false);
		tb_nomJ2.setText("");
	}

	/**
	 * Remet tous les éléments de la page configurationPartie par defaut
	 * deselectionne les ccheckbox et lance une fonction qui permet
	 * de remettre la configuration par defaut
	 * (comme les checkbox ne sont pas coche considere que l'utilisateur 
	 * souhaite faire un versus contre une deuxieme joueur
	 */
	@FXML
	void razPartie() {
		tb_nomJ1.setText("");
		tb_nomJ2.setText("");
		choixConfig.setText("");
		chk_vsIA.setSelected(false);
		chk_casseT.setSelected(false);
		verificationCheck();
		verificationModeJeu();
	}

	/**
	 * Fonction qui cache les éléments de l'IA
	 */
	@FXML
	void cacherIa() {
		lvl1.setVisible(false);
		lvl2.setVisible(false);
		lvl3.setVisible(false);
		lb_lvlIa.setVisible(false);
	}

	/**
	 * Fonction qui cache tous les elements lies a l'IA et affiche
	 * tous les elements de J2
	 */
	@FXML
	void caseIaPasCheck() {
		cacherIa();
		razIa();
		lb_nomJ2.setVisible(true);
		tb_nomJ2.setVisible(true);
	}

	@FXML
	void caseIaCheck() {
		lvl1.setVisible(true);
		lvl2.setVisible(true);
		lvl3.setVisible(true);
		lb_lvlIa.setVisible(true);
		lvl1.setSelected(true);
		cacherJ2();
	}
	
	/**
	 * Si la config rentré par l'utilisateur est correct
	 * Si c'est le cas appel des fonction qui récupère :
	 * L'adversaire voulut, le mode de jeu, les noms des équipes s'il n'y en 
	 * a pas affecte un nom par défaut, la configuration
	 * Puis affiche le plateau de jeu
	 * @param Click
	 */
	@FXML
	void showGameBoard(MouseEvent Click) {
		if(configValide()) {
			recupAdversaire();
			recupModeJeu();
			recupNomEquipe();
			recupConfigurationPartie();
			reinitialiser();
			gameBoard.setVisible(true);
			jeuEnCours.setVisible(true);
			defaite.setVisible(false);
			victoire.setVisible(false);
			rafraichirJeu(Partie.getCurrentPlateau().toString());
			//TODO si mode de jeu = casse tete et recuperer le temps a la fin quand victoire
			Partie.setDepartPartie(LocalDate.now());
		}
	}

	/**
	 * 
	 * @param Click
	 */
	@FXML
	private void actualiserJeu(MouseEvent Click) {
		if (!entreeLigne.getText().isEmpty() &&
				!entreeColonne.getText().isEmpty()) {
			String ligne = entreeLigne.getText();
			String colonne = entreeColonne.getText();
			if (verificationLettre(ligne) && verificationLettre(colonne)) {
				erreurEntreePartie.setVisible(false);
				int colonnePion = recupereColonnePion(colonne);
				int lignePion = recupereLignePion(ligne);
				if (colonneEstValide(colonnePion) && ligneEstValide(lignePion)) {
					colonnePion--;
					lignePion--;
					Partie.tourEntite(lignePion, colonnePion);
					System.out.println(Partie.getCurrentPlateau().toString());
					rafraichirJeu(Partie.getCurrentPlateau().toString());
					Partie.setNbCoups(Partie.getNbCoups()+1); //TODO verif
				} else {
					erreurEntreePartie.setVisible(true);
					erreurEntreePartie.setText(MESSAGE_ERREUR
							+"Nombre trop grand ou trop petit vérifier votre saisie");
				}
			} else {
				erreurEntreePartie.setVisible(true);
				erreurEntreePartie.setText(MESSAGE_ERREUR
						+"Ne doit contenir que des chiffres");
			}
		} else {
			erreurEntreePartie.setVisible(true);
			erreurEntreePartie.setText(MESSAGE_ERREUR
					+"Ne doit pas être vide");
		}
		verifVictoire();
	}

	//TODO vérifier lequipe et afficher la quelle a gagner lb_nomEquipeGagnante
	private void verifVictoire() {
		if (Partie.currentPlateau.victoire(0) || 
				Partie.currentPlateau.victoire(1) || 
				Partie.currentPlateau.victoire(1)) {
			jeuEnCours.setVisible(false);
			victoire.setVisible(true);
		}
	}

	private void recupModeJeu() {
		if (chk_casseT.isSelected()) {
			Partie.setChoixModeDeJeu(0);
		} else { 
			/* Si le mode casse tete n'est pas selectionne cala signifie 
    	   que l'utilisateur souhaitre jouer un versus */
			Partie.setChoixModeDeJeu(1);
		}
	}
	//RECUPERE LE NUMERO DE LA CONFIG puis set
	private void recupConfigurationPartie() {
		int nConfig = Integer.parseInt(choixConfig.getText());
		Partie.loadConfig(nConfig);
	}
	//TODO
	private boolean configValide() {
		/* On vérifie que la la string n'est pas vide pour ne pas produire d'erreur par la suite */
		if (!choixConfig.getText().isEmpty()) {
			String configString = choixConfig.getText();
			if(verificationLettre(configString)) {
				int config = Integer.parseInt(choixConfig.getText());
				if (config >= 0 && config < Configuration.listConfiguration.size()) {
					erreurConfigPartie.setVisible(false);
					return true;
				} else {
					erreurConfigPartie.setVisible(true);
					erreurConfigPartie.setText(MESSAGE_ERREUR
							+ "Les lettres ne sont pas acceptées");
				}
			} else {
				erreurConfigPartie.setVisible(true);
				erreurConfigPartie.setText(MESSAGE_ERREUR
						+ "Le numéro saisi n'est pas valide");
			}
		} else {
			erreurConfigPartie.setVisible(true);
			erreurConfigPartie.setText(MESSAGE_ERREUR
					+ "La configuration ne peut pas être vide");
		}
		return false;
	}

	private void recupNomEquipe() {
		if (Partie.getChoixModeDeJeu() == 0 || Partie.getChoixAdversaire() != 0
				&& Partie.getChoixModeDeJeu() == 1) {
			attribuerNomJ1();
		} else {
			attribuerNomJ1();
			attribuerNomJ2();
		}
	}

	private void attribuerNomJ1() {
		if (tb_nomJ1.getText().isEmpty()) {
			Partie.setEquipe1(Partie.getNomEquipe1Defaut());
		} else {
			Partie.setEquipe1(tb_nomJ1.getText());
		}
	}

	private void attribuerNomJ2() {
		if (tb_nomJ2.getText().isEmpty()) {
			Partie.setEquipe2(Partie.getNomEquipe2Defaut());
		} else {
			Partie.setEquipe2(tb_nomJ2.getText());
		}
	}

	/**
	 * Recupere l'adversaire choisi par l'utilisateur
	 * Et modifie la variable definissant l'adversaire dans la classe Partie
	 * (Verifie si l'utilisateur souhaite jouer contre une ia et son niveau
	 * sinon defini l'adversaire comme etant humain)
	 */
	private void recupAdversaire() {
		if (chk_vsIA.isSelected()) {
			if (lvl1.isSelected()) {
				Partie.setChoixAdversaire(1);
			} else if (lvl2.isSelected()) {
				Partie.setChoixAdversaire(2);
			} else {
				Partie.setChoixAdversaire(3);
			}
		} else {
			Partie.setChoixAdversaire(0);
		}
	}


	public String afficherConfigDispo(){
		StringBuilder configs = new StringBuilder();
		for (int compteur = 0; compteur < Configuration.listConfiguration.size(); compteur++) {
			configs.append(compteur + " - ");
			configs.append(Configuration.listConfiguration.get(compteur).getNom());
			configs.append("\n");
		}
		System.out.println(configs.toString());
		return configs.toString();
	}


	public void rafraichirJeu(String plateauJeu) {
		gameBoardString.setText(plateauJeu);
	}

	/* ------------------------------------------------------
	 * --------------- FONCTION CONFIGURATION --------------- 
	 * ------------------------------------------------------
	 */

	/*--------------- FONCTION CONFIGURATION: TRAITEMENT DONNEES / AVANCEMENT  ---------------*/

	/**
	 * Fonction qui est declenche lorsque l'utilisateur souhaite acceder 
	 * au plateau pour le placement des pions lors de la creation d'une config
	 * Celle ci verifie que toutes les donnees rentre par l'utilisateur 
	 * sont correct si se n'est pas le cas reste sur la page actuelle
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	void configInitialisation(MouseEvent Click) {
		if (!tb_nbLigneConf.getText().isEmpty() 
				&& !tb_nbColonneConf.getText().isEmpty()) {
			if (verificationLettre(tb_nbColonneConf.getText()) 
					&& verificationLettre(tb_nbColonneConf.getText())) {
				int nbLigne = Integer.parseInt(tb_nbLigneConf.getText());
				int nbColonne = Integer.parseInt( tb_nbColonneConf.getText());
				if (ligneEstValide(nbLigne) && colonneEstValide(nbColonne)) {
					erreurCreationConfig.setVisible(false);
					Partie.setConfigPlateau(nbLigne, nbColonne);
					// TODO recupConf();
					showCreationConfig(); 
				} else {
					erreurCreationConfig.setVisible(true);
					erreurCreationConfig.setText(MESSAGE_ERREUR 
							+ "Nombres rentrés invalides trop grand ou trop petit");
				}
			} else {
				erreurCreationConfig.setVisible(true);
				erreurCreationConfig.setText(MESSAGE_ERREUR 
						+ "Ne doit contenir que des chiffres");
			}
		} else {
			erreurCreationConfig.setVisible(true);
			erreurCreationConfig.setText(MESSAGE_ERREUR 
					+ "Ne peut pas être vide");
		}
	}

	/**
	 * Recupere les coordonnees rentre par l'utilisateur lors de la creation 
	 * de la config. Puis verifie leur validite (Type,taille,position...)
	 * Si toutes les donnees sont valides ajoute au plateau le pion demander
	 * par l'utilisateur. Puis actualise le plateau sur l'interface
	 * Pour afficher le changement
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	//TODO corriger
	void ajoutPionConfig(MouseEvent Click) {
		if (!tb_cordColonne.getText().isEmpty() 
				&& !tb_cordLigne.getText().isEmpty()) {
			String colonne = tb_cordColonne.getText();
			String ligne = tb_cordLigne.getText();
			if (verificationLettre(ligne) && verificationLettre(colonne)) {
				int colonnePion = recupereColonnePion(colonne);
				int lignePion = recupereLignePion(ligne);
				colonnePion--;
				lignePion--;
				if (typeValide(tb_cordType.getText())) {
					erreurPlacementPion.setVisible(false);
					Pion placementUti = new Pion(lignePion,colonnePion,
							recupType(tb_cordType.getText().charAt(0)));
					Partie.getConfigPlateau().setCase(placementUti);
					rafraichirConf(Partie.getConfigPlateau().toString());
				} else {
					erreurPlacementPion.setVisible(true);
					erreurPlacementPion.setText(MESSAGE_ERREUR
							+ "Le type entré n'est pas correct");
				}
			} else {
				erreurPlacementPion.setVisible(true);
				erreurPlacementPion.setText(MESSAGE_ERREUR 
						+ "Nombres rentrés invalides");
			}
		} else {
			erreurPlacementPion.setVisible(true);
			erreurPlacementPion.setText(MESSAGE_ERREUR 
					+ "Ne peut pas être vide");
		}
	}


	@FXML
	void supprimerPionConfig(MouseEvent Click) {
		//TODO corriger / trouver une solution de fusion / comment supprimer
	}

	/**
	 * Fonction qui enregistre la configuration lorsque l'utilisateur souhaite
	 * l'enregistrer. (La sauvegarde dans la liste des configuration)
	 * Se declanche lorsque l'utilisateur clic sur le bouton valider
	 * Sur la page de placement des pions dans configuration
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	void enregistrerConfig(MouseEvent Click) {
		Configuration config = new Configuration (Partie.getConfigPlateau().getPlateau(), nomConfig);
		Configuration.listConfiguration.add(config);
	}

	/**
	 * Verifie si le char correspond correspond a un crapaud
	 * Si se n'est pas le cas renvoit false se qui signifie que
	 * le pion est une grenouille. Cette fonction intervient lors
	 * de la creation du pion dans le tableau afin de definir son type
	 * Ainsi que apres toutes les verifications sur l'entree de l'utilisateur
	 * Se qui signifie que le pion a se moment ne pourra etre que C ou G
	 * @param choix char rentre par l'utilisateur qui definie le type du pion
	 */
	private boolean recupType(char choix) {
		return choix == 'C' ? true : false;
	}

	/**
	 * Recupere le nom que l'utilisateur a entre dans la textBox de creation de 
	 * configuration si il est vide prend la valeur defaut
	 * (remplacera donc la configuration par defaut)
	 * @return nom Le nom de la configuration qui sera cree
	 */
	public void recupNomConf() {
		if (!tb_nomConf.getText().isEmpty()) {
			nomConfig = "Defaut";
		} else {
			nomConfig = tb_nomConf.getText();
		}
	}

	@FXML
	//TODO verification
	void deleteConfig(MouseEvent Click) {
		if (!tb_idConf.getText().isEmpty()) {
			String idConfig = tb_idConf.getText();
			if (verificationLettre(idConfig)) {
				erreurSuppressionConfig.setVisible(false);
				int index = Integer.parseInt(tb_idConf.getText());
				if (index >= 0 &&
						index < Configuration.listConfiguration.size()) {
					erreurSuppressionConfig.setVisible(false);
					Configuration.listConfiguration.remove(index);
				} else {
					erreurSuppressionConfig.setVisible(true);
					erreurSuppressionConfig.setText(MESSAGE_ERREUR
							+"Numéro ne correspond a aucune configuration");
				}
			} else {
				erreurSuppressionConfig.setVisible(true);
				erreurSuppressionConfig.setText(MESSAGE_ERREUR
						+"Ne doit pas contenir de lettre");
			}
		} else {
			erreurSuppressionConfig.setVisible(true);
			erreurSuppressionConfig.setText(MESSAGE_ERREUR
					+"Ne peut pas être vide");
		}
	}

	/*--------------- FONCTION CONFIGURATION: TRAITEMENT INTERFACE  ---------------*/

	/**
	 * Actualise le label affichant le plateau sur l'interface
	 * @param plateauJeu Plateau de la configuration converti en String
	 */
	public void rafraichirConf(String plateauJeu) {
		afficherConfig.setText(plateauJeu);
	}

	/**
	 * Lorsque l'utilisateur arrivera sur la page configuration
	 * Il aura le choix entre Supprimer ou ajouter des configs
	 * S'il choisi d'ajouter des configs cette fonction
	 * s'executera et fera disparaitre le menu,et les autres pages indesirables
	 */
	@FXML
	void showInitialisationConfig(MouseEvent Click) {
		choixConf.setVisible(false);
		initialisationConfig.setVisible(true);
	}

	@FXML
	void showSupprimerConfig(MouseEvent Click) {
		configAdel.setText(afficherConfigDispo());
		choixConf.setVisible(false);
		supprimerConf.setVisible(true);
	}

	/**
	 * Lorsque l'utilisateur clic sur valider apres avoir
	 * entree le nom de la configuration ainsi que le nombre de ligne/colonne
	 * et que les informations est toutes etaient valides precedemment
	 * affiche la page de placement des pions sur la config en creation
	 */
	@FXML
	void showCreationConfig() { 
		initialisationConfig.setVisible(false);
		placementConfig.setVisible(true);
		rafraichirConf(Partie.getConfigPlateau().toString());
	}



	/* ------------------------------------------------------
	 * --------------- FONCTION DE CONTRÔLE D'ERREUR / FORMAT / VALIDITE--------------- 
	 * ------------------------------------------------------
	 */

	/*--------------- FONCTION ESTVALIDE  ---------------*/

	public boolean verificationLettre(String aVerifier) {
		for (int compteur = 0; compteur < aVerifier.length(); compteur ++) {
			char tester = aVerifier.charAt(compteur);
			if (tester < '0' || tester >'9') {
				return false;
			}
		}
		return true;	
	}

	/**
	 * Détermine si les lignes du plateau sont corrects 
	 * avec le contrôle de la gestion d'erreur
	 * @param colonnePlateau est le nombre de colonnes pour le plateau 
	 * @param lignePlateau est le nombre de lignes pour le plateau
	 * @return un booleen égal a vrai si les lignes et colonnes plateau sont corrects
	 */
	public static boolean configPlateauEstValide(int lignePlateau, int colonnePlateau) {
		// vérification des entier ligne et colonne avec 
		// la taille max et min d'une ligne et d'une colonne
		// limité a 20 (pour l'instant)
		return (MIN_LIGNE_PION <= lignePlateau || lignePlateau <= MAX_LIGNE_PION) &&
				(MIN_COLONNE_PION <= colonnePlateau || colonnePlateau <=MAX_COLONNE_PION);
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
		return MIN_COLONNE_PION <= colonnePion && colonnePion < MAX_COLONNE_PION;
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

	private boolean typeValide(String type) {
		if (type.length() != 1 || (type.charAt(0) != 'C' || type.charAt(0) != 'G')) {
			return false;
		} else {
			return true;
		}
	}

}