/*
 * interfaceAppliController.java
 * Azog-corp 2019, droit d'auteur
 */
//TODO toutes les fonctions sans @FXML a mettre dans partie pour faire moin de ligne

package crapouille.interfaceFx;


import java.time.LocalDate;

import crapouille.Outils;
import crapouille.Partie;
import crapouille.Pion;
import crapouille.Plateau;
import crapouille.configuration.Configuration;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class InterfaceAppliController {
	final static String MSGBOX_TITRE = "Crapauds & Grenouilles";
	final static String MSGBOX_TYPE = "Type non valide";
	final static String MSGBOX_LETTRE = "Les lettres ne sont pas accept�es";
	final static String MSGBOX_NOMBRE = "Nombre trop grand ou trop petit v�rifier votre saisieMSG";
	final static String MSGBOX_VIDE = "Ne doit pas �tre vide";
	final static String MSBOX_CONFIG = "La configuration ne peut pas �tre vide";
	final static String MSGBOX_ENREGISTREE = "Votre confirmation a bien �t� enregistr�e";
	final static String MSGBOX_NONVALIDE_CONF = "La configuration que vous avez cr�e n'est pas valide";


	final static String MESSAGE_ERREUR = "Les informations rentr�s sont invalides : ";

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
	 * Et cache toutes les autres pages
	 * @param Click
	 */
	@FXML
	void showMenu(MouseEvent Click) {
		reinitialiser();
		menu.setVisible(true);
	}

	/**
	 * Affiche la page de la configuration de la partie 
	 * Reinitialise les elements de la page pour eviter de memoriser
	 * Si l'utilisateur a deja fait uen partie
	 * @param Click
	 */
	@FXML
	void showConfigurationPartie(MouseEvent Click) {
		reinitialiser();
		razPartie();
		configurationPartie.setVisible(true);
		listeConfigDispo.setText(Outils.afficherConfigDispo());
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
	 * Qui fait disparaitre tous les �lements li�s a l'IA et affiche 
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
	 * Fonction qui verifie le mode de jeu selectionnee par l'utilisateur
	 * Si celui si est casse tete appel les fonctions pour faire disparaitre
	 * les elements correspondant a l'IA et la possibilitee d'entrer un nom de J2
	 * sinon fait l'inverse
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
	 * Fonction qui d�coche toutes les radio button correspondant a l'IA
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
	 * Cache les elements du J2.
	 * (Label / text Field)
	 */
	@FXML
	void cacherJ2() {
		lb_nomJ2.setVisible(false);
		tb_nomJ2.setVisible(false);
		tb_nomJ2.setText("");
	}

	/**
	 * Remet tous les �l�ments de la page configurationPartie par defaut
	 * deselectionne les checkbox et lance une fonction qui permet
	 * de remettre la configuration par defaut
	 * (comme les checkbox ne sont pas coche considere que l'utilisateur 
	 * souhaite faire un versus contre un deuxieme joueur
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
	 * Fonction qui cache les �l�ments de l'IA
	 * Label et TextField
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

	/**
	 * Si la case IA est coch�
	 * affiche les diff�rents radio button qui d�finissent le niveau de l'ordinateur
	 * et coche par d�faut le niveau 1
	 * Cache aussi les �l�ments du J2 car ceux ci ne sont plus n�cessaires
	 * dans le cas d'une partie contre un ordi
	 */
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
	 * Si la config rentr� par l'utilisateur est correct
	 * Si c'est le cas appel des fonction qui r�cup�re :
	 * L'adversaire voulut, le mode de jeu, les noms des �quipes s'il n'y en 
	 * a pas affecte un nom par d�faut, la configuration
	 * Puis affiche le plateau de jeu
	 * @param Click
	 */
	@FXML
	void showGameBoard(MouseEvent Click) {
		/* V�rifie que le num�ro de config saisie par l'utilisateur est correct */
		if(configValide()) { //Verifie que tous se que a rentre l'utilisateur est correct
			/*Si c'est le cas r�cup�re toutes les informations n�cessaires*/
			recupAdversaire(); //Recupere l'adversaire choisi par l'utilisateur
			recupModeJeu(); //Recupere le mode de jeu choisi par l'utilisateur
			recupNomEquipe(); //Recupere les/le nom dequipe choisi par l'utilisateur
			recupConfigurationPartie(); //Recupere la configuration choisie par l'utilisateur
			reinitialiser(); // Fait disparaitre toutes les autres pages
			/*Fait apparaitre le plateau de jeu */
			gameBoard.setVisible(true);
			jeuEnCours.setVisible(true);
			/* Fait disparaitre les pages defaite et victoire par pr�caution
			 * (ex: si une partie pr�c�dente c'est termin� l'interface
			 * sera sur la page de victoire pour empecher cela on force l'application 
			 * a revenir a son fonctionnement par d�faut soit le plateau de jeu
			 */
			defaite.setVisible(false);
			victoire.setVisible(false);
			/* Met a jour l'affichage */
			rafraichirJeu(Partie.getCurrentPlateau().toString());
			//TODO si mode de jeu = casse tete et recuperer le temps a la fin quand victoire
			Partie.setDepartPartie(LocalDate.now());
		}
	}

	/**
	 * Lorsque le joueur est entrain de jouer une partie
	 * v�rifie que toutes les entr�es de l'utilisateur sont correctes
	 * Si c'est le cas appel la fonction pour deplacer le pion
	 * et met a jour l'affichage
	 * @param Click
	 */
	@FXML
	private void actualiserJeu(MouseEvent Click) {
		/* V�rifie que les TextField ne sont pas vide pour ne pas produire d'erreur */
		if (!entreeLigne.getText().isEmpty() &&
				!entreeColonne.getText().isEmpty()) { 
			/* R�cup�re dans des string la ligne et la colonne entr�e par l'utilisateur */
			String ligne = entreeLigne.getText();
			String colonne = entreeColonne.getText();
			/* V�rifie s'il n'y a pas de lettre avant de convertir en int les entr�es
			 * pour ne pas produire d'erreur
			 */
			if (Outils.verificationLettre(ligne) 
					&& Outils.verificationLettre(colonne)) {
				/*Conversion en int des entr�es texte de l'utilisateur */
				int colonnePion = Integer.parseInt(colonne);
				int lignePion = Integer.parseInt(ligne);
				if (Outils.colonneEstValide(colonnePion) 
						&& Outils.ligneEstValide(lignePion)) {
					colonnePion--;
					lignePion--;
					Partie.tourEntite(lignePion, colonnePion);
					afficherNomEquipe();
					//TODO Partie.setNbCoups(Partie.getNbCoups()+1);
					rafraichirJeu(Partie.getCurrentPlateau().toString());
		/* Affichage des messages d'erreurs a l'utilisateur pour lui siganler le probleme */
				} else {
					showMsgbox(MSGBOX_TITRE, MESSAGE_ERREUR
							+ MSGBOX_NOMBRE,false);
				}
			} else {
				showMsgbox(MSGBOX_TITRE,MESSAGE_ERREUR
						+MSGBOX_LETTRE,
						false);
			}
		} else {
			showMsgbox(MSGBOX_TITRE,MESSAGE_ERREUR
					+ MSGBOX_VIDE,
					false);
		}
		/* Verifie que aucun des participants n'a gagne
		 * Si cest le cas affiche le panneau de victoire
		 */
		//TODO mettre le nom de lequipe gagnante
		if (Outils.verifVictoire()) {
			jeuEnCours.setVisible(false);
			victoire.setVisible(true);
		}
	}
	
	//TODO
	public void afficherNomEquipe() {
		String nomEquipe[] = Partie.getEquipe();
		tourDe.setText("Tour de l'�quipe : " + nomEquipe[Partie.getTourEquipe()]);
	}
	
	/**
	 * Recupere le mode de jeu celon se que l'utilisateur a selectionnee
	 * Et le defini dans le fichier Partie
	 */
	private void recupModeJeu() {
		if (chk_casseT.isSelected()) {
			Partie.setChoixModeDeJeu(0);
		} else { 
			/* Si le mode casse tete n'est pas selectionne cala signifie 
    	   que l'utilisateur souhaitre jouer un versus */
			Partie.setChoixModeDeJeu(1);
		}
	}
	/**
	 * Recupere le numero de la config 
	 * Et charge la configuration correspondant au numero demande
	 */
	private void recupConfigurationPartie() {
		int nConfig = Integer.parseInt(choixConfig.getText());
		Partie.loadConfig(nConfig);
	}

	/**
	 * Verifie si la configuration entree par lutilisateur dans la page de configurationde partie
	 * Verifie que le textField contenant le numero n'est pas vide
	 * Qu'il n'y a pas de lettres et que et le numero existe
	 * @return true si tous les tests sont correctes'
	 *         false si un seul test ne passe pas9
	 */
	private boolean configValide() {
		/* On v�rifie que la la string n'est pas vide pour ne pas produire d'erreur par la suite */
		if (!choixConfig.getText().isEmpty()) { 
			String configString = choixConfig.getText();
			/* Verification qu'il n'y a pas de lettre dans lentree */
			if(Outils.verificationLettre(configString)) {
				int config = Integer.parseInt(choixConfig.getText());
				/* Verification que le numero existe et correspond a uen configuration */
				if (config >= 0 && config < Configuration.listConfiguration.size()) {
					erreurConfigPartie.setVisible(false);
					return true;
		/** Affichage des differents message d'erreur selon le cas */
				} else {
					showMsgbox(MESSAGE_ERREUR, MSGBOX_LETTRE, false);
				}
			} else {
				showMsgbox(MESSAGE_ERREUR, MSGBOX_NOMBRE, false);
			}
		} else {
			showMsgbox(MESSAGE_ERREUR, MSGBOX_VIDE, false);
		}
		return false;
	}

	//TODO verfier validite MVC
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
	/**
	 * Met a jour le label affichant le plateau de jeu
	 * Apres action de l'utilisateur
	 * @param plateauJeu contient le nouveau tableau de jeu sous la forme
	 * dun String
	 */
	public void rafraichirJeu(String plateauJeu) {
		gameBoardString.setText(plateauJeu);
	}

	/* ------------------------------------------------------
	 * --------------- FONCTION CONFIGURATION --------------- 
	 * ------------------------------------------------------
	 */

	/*--------------- FONCTION CONFIGURATION: TRAITEMENT DONNEES / AVANCEMENT  ---------------*/
	
	/** Remet a zero tous les elements de la page de creation
	 * de configuration a 0
	 */
	private void razConfig() {
		tb_nbColonneConf.setText("");
		tb_nbLigneConf.setText("");
		tb_nomConf.setText("");
	}
	
	/**
	 * Fonction qui est declenche lorsque l'utilisateur souhaite acceder 
	 * au plateau pour le placement des pions lors de la creation d'une config
	 * Celle ci verifie que toutes les donnees rentre par l'utilisateur 
	 * sont correct si se n'est pas le cas reste sur la page actuelle
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	void configInitialisation(MouseEvent Click) {
		/* Verification que non vide */
		if (!tb_nbLigneConf.getText().isEmpty() 
				&& !tb_nbColonneConf.getText().isEmpty()) { 
			/* Verification qu'il n'y pas de lettre*/
			if (Outils.verificationLettre(tb_nbColonneConf.getText()) 
					&& Outils.verificationLettre(tb_nbColonneConf.getText())) {
				/* Conversion en int */
				int nbLigne = Integer.parseInt(tb_nbLigneConf.getText());
				int nbColonne = Integer.parseInt( tb_nbColonneConf.getText());
				/* Verification que la ligne est la colonne est valide */
				if (Outils.ligneEstValide(nbLigne) 
						&& Outils.colonneEstValide(nbColonne)) {
					erreurCreationConfig.setVisible(false);
					/* Initialise le tableau a la taille choisie par l'uti */
					Partie.config = new Pion[nbLigne][nbColonne];
					recupNomConf(); //recup�re le nom pour enregistrer
					razConfig();
					showCreationConfig();  //Affiche la page de creation de config
		/* Affichage des differentes erreurs */	
				} else {
					showMsgbox(MSGBOX_TITRE, MESSAGE_ERREUR 
							+ MSGBOX_NOMBRE,
							false);
				}
			} else {
				showMsgbox(MSGBOX_TITRE,MESSAGE_ERREUR 
						+ MSGBOX_LETTRE,
						false);
			}
		} else {
			showMsgbox(MSGBOX_TITRE,
					MESSAGE_ERREUR + MSGBOX_VIDE,
					false);
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
	void ajoutPionConfig(MouseEvent Click) {
		System.out.println(tb_cordColonne.getText());
		/* Verification que non vide */
		if (!tb_cordColonne.getText().isEmpty() 
				&& !tb_cordLigne.getText().isEmpty()) {
			String colonne = tb_cordColonne.getText();
			String ligne = tb_cordLigne.getText();
			/* Verification qu'il n'y pas de lettre*/
			if (Outils.verificationLettre(ligne) 
					&& Outils.verificationLettre(colonne)) {
				int colonnePion = Integer.parseInt(colonne);
				int lignePion = Integer.parseInt(ligne);
				colonnePion--;
				lignePion--;
				/* Verification que les coordonnes corresponde bien a une coordonnes
				 * dans le tableau de jeu
				 */
				if (Outils.cordOk(lignePion,colonnePion)) {
					/* Verification le type entre par l'uti est valide */
					if (Outils.typeValide(tb_cordType.getText())) {
						erreurPlacementPion.setVisible(false);
						Outils.placementPion(lignePion,colonnePion,
								Outils.recupType(tb_cordType.getText().charAt(0)));
						rafraichirConf(Partie.configToString());
		/* Affichage des differentes erreurs */
					} else {
						showMsgbox(MSGBOX_TITRE,
								MESSAGE_ERREUR + MSGBOX_TYPE, false);
					}
				} else {
					showMsgbox(MSGBOX_TITRE,
							MESSAGE_ERREUR + MSGBOX_NOMBRE, false);
				}
			} else {
				showMsgbox(MSGBOX_TITRE,
						MESSAGE_ERREUR + MSGBOX_LETTRE, false);
			}
		} else {
			showMsgbox(MSGBOX_TITRE,
					MESSAGE_ERREUR + MSGBOX_VIDE,false);
		}
	}

	/**
	 * Fonction qui supprime une des configurations enregistr�es
	 * -> Si toutes les entr�es de l'utilisateur sont correctes
	 * @param Click
	 */
	@FXML
	//TODO verification
	void deleteConfig(MouseEvent Click) {
		/* V�rifie que le textfield n'est pas vide pour ne pas produire d'erreur
		 * Si c'est le cas affiche un message d'erreur
		 */
		if (!tb_idConf.getText().isEmpty()) {
			String idConfig = tb_idConf.getText();
			/* V�rifie que tous les caract�res de l'information rentr�es par l'utilisateur
			 * sont bien des chiffres
			 */
			if (Outils.verificationLettre(idConfig)) {
				/* Converti en int le String correspondant au num�ro de la config devant �tre supprim� */
				int index = Integer.parseInt(tb_idConf.getText());
				/*V�rifie que le num�ro rentr� par l'utilisateur correspond bien 
				 * a une configuration existante
				 */
				if (index >= 0 &&
						index < Configuration.listConfiguration.size()) {
					erreurSuppressionConfig.setVisible(false);
					Configuration.listConfiguration.remove(index);
					/* Affichage de message d'erreur si l'une des conditions n'est pas respect�e
					 * Informant l'utilisateur de l'erreur qu'il a commise 
					 */
				} else {
					showMsgbox(MSGBOX_TITRE, MESSAGE_ERREUR
							+"Num�ro ne correspond a aucune configuration",
							false);
				}
			} else {
				showMsgbox(MSGBOX_TITRE, 
						MESSAGE_ERREUR + "Ne doit pas contenir de lettre",
						false);
			}
		} else {
			showMsgbox(MSGBOX_TITRE,
					MESSAGE_ERREUR + "Ne peut pas �tre vide", false);

		}
	}

	/** Cette fonction sera execut� lorsque que l'utilisateur 
	 * souhaite supprimer un des piosn qu'il a positionn� sur le plateau
	 * @param Click
	 */
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
	//TODO commenter
	@FXML
	void enregistrerConfig(MouseEvent Click) {
		/* V�rifie que bon nombre de pion crapaud = grenouille
		 * au moin 1 pion de chaque  sur ligne
		 */
		if (Plateau.plateauEstValide(Partie.config)) {
			Outils.sauvegarder();
			/* Indique a l'utilisateur que sa config a bien ete enregistree */
			showMsgbox(MSGBOX_TITRE, MSGBOX_ENREGISTREE, true);
			reinitialiser();
			/* Retourne au menu*/
			menu.setVisible(true);
		} else {
			showMsgbox(MSGBOX_TITRE, MSGBOX_NONVALIDE_CONF, false);
		}
	}

	/**
	 * Recupere le nom que l'utilisateur a entre dans la textBox de creation de 
	 * configuration si il est vide prend la valeur defaut
	 * (remplacera donc la configuration par defaut)
	 * @return nom Le nom de la configuration qui sera cree
	 */
	public void recupNomConf() {
		if (tb_nomConf.getText().isEmpty()) {
			/* Si lutilisateur na rien rentre definit un format par defaut soit
			 * Configuration + le numero que prendra la configuration dans letat actuel du systeme
			 */
			Outils.nomConfig = "Configuration n�" + Configuration.listConfiguration.size();
		} else {
			Outils.nomConfig = tb_nomConf.getText();
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

	/**Fonction qui affiche la page supprimer config
	 * et qui affiche toutes les configurations actuellement cr�es
	 * @param Click
	 */
	@FXML
	void showSupprimerConfig(MouseEvent Click) {
		/*Affiche toutes les configurations disponibles*/
		configAdel.setText(Outils.afficherConfigDispo());
		/* Cache la page de s�lection ajouter / supprimer config et affiche supprimer config */
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
		rafraichirConf(Partie.configToString());
	}



	/* ------------------------------------------------------
	 * --------------- FONCTION DE CONTR�LE D'ERREUR / FORMAT / VALIDITE--------------- 
	 * ------------------------------------------------------
	 */

	/*--------------- FONCTION AFFICHAGE ERREUR  ---------------*/
	/**
	 * Affiche les messages voulu dans des message box a l'utilisateur
	 * @param titreFenetre Le titre de la messagebox
	 * @param texteFenetre Le meesage a afficher a l'utilisateur
	 * @param typeFenetre Le type de la fenetre false pour erreur 
	 * 											true pour information
	 */
	private void showMsgbox(String titreFenetre, String texteFenetre, boolean typeFenetre) {
		Alert msgUti;
		if (typeFenetre) {
			msgUti = new Alert(AlertType.INFORMATION);
		} else {
			msgUti = new Alert(AlertType.ERROR);
		}
		msgUti.setTitle(titreFenetre);
		msgUti.setContentText(texteFenetre);
		msgUti.showAndWait();
	}


}