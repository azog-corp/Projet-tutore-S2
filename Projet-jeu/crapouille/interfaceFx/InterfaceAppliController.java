/*
 * interfaceAppliController.java
 * Azog-corp 2019, droit d'auteur
 */

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
	final static String MSGBOX_LETTRE = "Les lettres ne sont pas acceptées";
	final static String MSGBOX_NOMBRE = "Nombre trop grand ou trop petit vérifier votre saisieMSG";
	final static String MSGBOX_VIDE = "Ne doit pas être vide";
	final static String MSBOX_CONFIG = "La configuration ne peut pas être vide";
	final static String MSGBOX_ENREGISTREE = "Votre modification a bien été enregistrée";
	final static String MSGBOX_NONVALIDE_CONF = "La configuration que vous avez entree n'est pas valide";


	final static String MESSAGE_ERREUR = "Les informations rentrés sont invalides : ";

	@FXML
	/** Fond de l'appli qui ontient toutes 
	 * les autres pages de l'application
	 */
	private AnchorPane backpanel;

	@FXML
	/** Page d'affichage des scores*/
	private AnchorPane score;

	@FXML
	/** Affiche le nom du meilleur joueur 
	 * Page MVP
	 */
	private Label nomMVP;

	@FXML
	/** Meilleur score obtenu
	 * Page MVP
	 */
	private Text scoreMVP;

	@FXML
	/**
	 * Contient les boutons pour naviguer entre les pages
	 * (Barre contenant les icones)
	 */
	private AnchorPane settingsBar;

	@FXML
	/**
	 * Image pour naviguer vers la page createur
	 * Page Settings Bar icone Utilisateur
	 */
	private ImageView btn_createur;

	@FXML
	/**
	 * Image pour naviguer vers le menu principal
	 * Page Settings Bar icone Play
	 */
	private ImageView btn_acceuil;

	@FXML
	/**
	 * Image pour quitter l'application
	 * Page Settings Bar icone Croix
	 */
	private ImageView btn_quitter;

	@FXML
	/**
	 * Image pour naviguer vers la page MVP
	 * Page Settings Bar icone personne
	 */
	private ImageView btn_mvp;

	@FXML
	/**
	 * Image pour naviguer vers la page de choix pour les configurations
	 * Page Settings Bar de roue dentee
	 */
	private ImageView btn_configuration;

	@FXML
	/**
	 * Page contenant les informations sur les createurs
	 */
	private AnchorPane createur;

	@FXML
	/**
	 * Menu principal et premiere page du jeu
	 */
	private AnchorPane menu;

	@FXML
	/**
	 * Bouton sur le menu Principal
	 * Permettant a l'utilisateur de naviguer vers 
	 * la page configurationPartie
	 */
	private Button btn_jouermenu;

	@FXML
	/**
	 * Bouton sur le menu Principal
	 * Permettant d'afficher des aides
	 */
	private Button btn_aidemenu;

	@FXML
	/**
	 * Bouton sur le menu Principal
	 * Pour quitter l'application
	 */
	private Button btn_quittermenu;

	@FXML
	/**
	 * Page permettant a l'utilisateur de parametrer sa partie
	 */
	private AnchorPane configurationPartie;

	@FXML
	/**
	 * Page Configuration Partie
	 * Lorsque l'utilisateur clique sur ce bouton verifie toutes ses entrees
	 * et appel la fonction affichant le plateau de jeu
	 */
	private Button confirmationJouer;

	@FXML
	/**
	 * Label affichant le choix a l'utilisateur
	 * "Chosir difficultee IA"
	 */
	private Label lb_lvlIa;

	@FXML
	/**
	 * Titre de section page configurationPartie
	 */
	private Label labelIA;

	@FXML
	/**
	 * Indication page configurationPartie
	 * Invitant l'utilisateur a rentrer un nom d'equipe
	 */
	private Label lb_nomJ1;

	@FXML
	/**
	 * Indication page configurationPartie
	 * Invitant l'utilisateur a rentrer un nom d'equipe
	 */
	private Label lb_nomJ2;

	@FXML
	/**
	 * Check Box definissant si le joueur veut jouer contre l'IA
	 * Si elle est cochee fait apparaitre les elements de l'IA
	 */
	private CheckBox chk_vsIA;

	@FXML
	/**
	 * RadioButton Si coche l'utilisateur souhaite jouer contre IA lvl1
	 */
	private RadioButton lvl1;

	@FXML
	/**
	 * Group contenant tous les radio buttons des IA
	 * pour permettre de n'avoir qu'un seul bouton coche
	 */
	private ToggleGroup lvlIA;

	@FXML
	/**
	 * RadioButton Si coche l'utilisateur souhaite jouer contre IA lvl2
	 */
	private RadioButton lvl2;

	@FXML
	/**
	 * RadioButton Si coche l'utilisateur souhaite jouer contre IA lvl3
	 */
	private RadioButton lvl3;

	@FXML
	/**
	 * TextField dans lequel l'utilisateur rentre le nom J2
	 */
	private TextField tb_nomJ2;

	@FXML
	/**
	 * TextField dans lequel l'utilisateur rentre le nom J1
	 */
	private TextField tb_nomJ1;

	@FXML
	/**
	 * Bouton pour revenir au menu
	 */
	private Button retourMenu;

	@FXML
	/**
	 * CheckBox si coche le joueur souhaite faire un casse tete
	 * Sinon souhaite faire un versus
	 */
	private CheckBox chk_casseT;

	@FXML
	/**
	 * Text Field contient la configuration choisie par l'utilisateur
	 */
	private TextField choixConfig;

	@FXML
	/**
	 * Label affichant les configs disponible a l'utilisateur
	 */
	private Label listeConfigDispo;

	@FXML
	/**
	 * Anchor pane conteanntr tous les autres anchor pane
	 * Permettant d'ajouter / supprimer une config
	 */
	private AnchorPane configuration;

	@FXML
	/**
	 *Page permettant l'initialisation de la creation d'une nouvelle config
	 */
	private AnchorPane initialisationConfig;

	@FXML
	/**
	 * TextField recuperant le nom de la configuration que veut creer l'utilisateur
	 */
	private TextField tb_nomConf;

	@FXML
	/**
	 * TextField recuperant le nombre de ligne de 
	 * la configuration que veut creer l'utilisateur
	 */
	private TextField tb_nbLigneConf;

	@FXML
	/**
	 * Bouton permettant d'appeller toutes les fonctions de verification
	 * ainsi que de les fonctiosn pour passer a la page de palcement des 
	 * pions
	 */
	private Button btn_validerTaille;

	@FXML

	/**
	 * TextField recuperant le nombre de colonne de 
	 * la configuration que veut creer l'utilisateur
	 */
	private TextField tb_nbColonneConf;

	@FXML
	/**
	 * Page d'acceuil de configuration permettant de choisir
	 * Entre supprimer et ajouteyr config
	 */
	private AnchorPane choixConf;

	@FXML
	/**
	 * Button pour se rendre dans la categorie pour ajouter des configs
	 */
	private Button btn_ajouterConf;

	@FXML
	/**
	 * Button pour se rendre dans la categorie pour Supprimer des configs
	 */
	private Button btn_supprimerConf;

	@FXML
	/**
	 * page de palcement des pions dans la configuration en cours de creation 
	 */
	private AnchorPane placementConfig;

	@FXML
	/**
	 * Affiche la config en cours de creation a l'utilisateur 
	 */
	private Label afficherConfig;

	@FXML
	/**
	 * Textfield contenant la ligne sur laquelle le joueur
	 * Entre le numero de la ligne sur laquelle il souhaite
	 * Ajouter un pion
	 */
	private TextField tb_cordLigne;

	@FXML
	/**
	 * Bouton page placement des pions
	 * Lorsque l'utilisateur clique dessu verifie que tous est valide
	 * et enregsitre la configuration
	 */
	private Button btn_validerConfig;

	@FXML
	/**
	 * Button page placement pion
	 * Appel les fonctions pour verifier que les entrees de l'utilisateur sont correctes
	 * Si correctes ajoute le pion au plateau sinon en informe lutilisateur
	 */
	private Button btn_AjouterPion;

	@FXML
	/**
	 * Textfield contenant la ligne sur laquelle le joueur
	 * Entre le numero de la ligne sur laquelle il souhaite
	 * Ajouter un pion
	 */
	private TextField tb_cordColonne;

	@FXML
	/**
	 * Button page placement pion
	 * Appel les fonctions pour verifier que les entrees de l'utilisateur sont correctes
	 * Si correctes supprime le pion du plateau sinon en informe lutilisateur
	 */
	private Button btn_SupprimerPion;

	@FXML
	/**
	 * Textfield contenant le type du pion que 
	 *  le joueur souhaite ajouter
	 */
	private TextField tb_cordType;

	@FXML
	/**
	 * Page pour supprimer une config
	 */
	private AnchorPane supprimerConf;

	@FXML
	/**
	 * Button declanchant la suppression d'une config 
	 * si les entrees de l'utilisateur sont correctes
	 */
	private Button btn_supprimerConfig;

	@FXML
	/**
	 * Id de la config a supprimer
	 * Que l'uti rentre dans le textfield
	 */
	private TextField tb_idConf;

	@FXML
	/**
	 * Liste des configurations possibles a la suppressions
	 */
	private Label configAdel;

	@FXML
	/**
	 * AnchorPane contenant toutes les pages correspodant
	 * A une partie en cours 
	 */
	private AnchorPane gameBoard;

	@FXML
	/**
	 * NON  UTILISE
	 * Page affiche lorsque l'utilisateur perd
	 */
	private AnchorPane defaite;

	@FXML
	/**
	 * Page pour afficher lequipe remportant la partie
	 */
	private AnchorPane victoire;

	@FXML
	/**
	 * Label contenant le nom de lequipe remportant la partie
	 */
	private Label lb_nomEquipeGagnante;

	@FXML
	/**
	 * Page d'affichage du jeu lorsque l'utilisateur joue
	 */
	private AnchorPane jeuEnCours;

	@FXML
	/**
	 * Label contenant le plateau de jeu en cours 
	 */
	private Label gameBoardString;

	@FXML
	/**
	 * Bouton sur la page de jeu
	 * lorsque l'utilisateur clic dessus verifie les donnees
	 * Etmet a jour le tableau si correct
	 */
	private Button okGameBoard;

	@FXML
	private TextField entreeLigne;

	@FXML
	private TextField entreeColonne;

	@FXML
	private Label tourDe;


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
	 * Fonction qui décoche toutes les radio button correspondant a l'IA
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
	 * Remet tous les éléments de la page configurationPartie par defaut
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
	 * Fonction qui cache les éléments de l'IA
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
	 * Si la case IA est coché
	 * affiche les différents radio button qui définissent le niveau de l'ordinateur
	 * et coche par défaut le niveau 1
	 * Cache aussi les éléments du J2 car ceux ci ne sont plus nécessaires
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
	 * Si la config rentré par l'utilisateur est correct
	 * Si c'est le cas appel des fonction qui récupère :
	 * L'adversaire voulut, le mode de jeu, les noms des équipes s'il n'y en 
	 * a pas affecte un nom par défaut, la configuration
	 * Puis affiche le plateau de jeu
	 * @param Click
	 */
	@FXML
	void showGameBoard(MouseEvent Click) {
		/* Vérifie que le numéro de config saisie par l'utilisateur est correct */
		if(Outils.configValide(choixConfig.getText())) { //Verifie que tous se que a rentre l'utilisateur est correct
			/*Si c'est le cas récupère toutes les informations nécessaires*/
			recupAdversaire(); //Recupere l'adversaire choisi par l'utilisateur
			recupModeJeu(); //Recupere le mode de jeu choisi par l'utilisateur
			recupNomEquipe(); //Recupere les/le nom dequipe choisi par l'utilisateur
			Outils.recupConfigurationPartie(Integer.parseInt(
											choixConfig.getText())); //Recupere la configuration choisie par l'utilisateur
			reinitialiser(); // Fait disparaitre toutes les autres pages
			/*Fait apparaitre le plateau de jeu */
			gameBoard.setVisible(true);
			jeuEnCours.setVisible(true);
			/* Fait disparaitre les pages defaite et victoire par précaution
			 * (ex: si une partie précédente c'est terminé l'interface
			 * sera sur la page de victoire pour empecher cela on force l'application 
			 * a revenir a son fonctionnement par défaut soit le plateau de jeu
			 */
			defaite.setVisible(false);
			victoire.setVisible(false);
			/* Met a jour l'affichage */
			rafraichirJeu(Partie.getCurrentPlateau().toString());
			afficherNomEquipe();
			//TODO si mode de jeu = casse tete et recuperer le temps a la fin quand victoire
			Partie.setDepartPartie(LocalDate.now());
		}
	}

	/**
	 * Lorsque le joueur est entrain de jouer une partie
	 * vérifie que toutes les entrées de l'utilisateur sont correctes
	 * Si c'est le cas appel la fonction pour deplacer le pion
	 * et met a jour l'affichage
	 * @param Click
	 */
	@FXML
	private void actualiserJeu(MouseEvent Click) {
		/* Vérifie que les TextField ne sont pas vide pour ne pas produire d'erreur */
		if (Outils.actualisationPlateau(entreeLigne.getText(),
				entreeColonne.getText())) {
			afficherNomEquipe();
			//TODO Partie.setNbCoups(Partie.getNbCoups()+1);
			rafraichirJeu(Partie.getCurrentPlateau().toString());

			/* Verifie que aucun des participants n'a gagne
			 * Si cest le cas affiche le panneau de victoire
			 */
			if (Outils.verifVictoire()) {
				afficherGagnant();
				jeuEnCours.setVisible(false);
				victoire.setVisible(true);
			}
		}
	}

	/**
	 * Affiche le nom de l'equipe qui doit jouer sur le plateau de jeu
	 */
	public void afficherNomEquipe() {
		tourDe.setText("Tour de l'équipe : " 
				+ Partie.getEquipe(Partie.getTourEquipe()));
	}
	
	/**
	 * Affiche le nom du gagnant lorsque le jeu se termine
	 */
	public void afficherGagnant() {
		if (Partie.currentPlateau.victoire(0)) {
			lb_nomEquipeGagnante.setText(Partie.getEquipe(0));
		} else {
			lb_nomEquipeGagnante.setText(Partie.getEquipe(1));
		}
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

	//TODO verifier validite MVC
	/**
	 * Recupere le nom des equipes et appel les fonctions 
	 * qui les attribues
	 */
	private void recupNomEquipe() {
		if (Partie.getChoixModeDeJeu() == 0 || Partie.getChoixAdversaire() != 0
				&& Partie.getChoixModeDeJeu() == 1) {
			Outils.attribuerNomJ1(tb_nomJ1.getText());
		} else {
			Outils.attribuerNomJ1(tb_nomJ1.getText());
			Outils.attribuerNomJ2(tb_nomJ2.getText());
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
			if (Outils.configIni(tb_nbLigneConf.getText(),
					tb_nbColonneConf.getText())) {
				recupNomConf(); //recupère le nom pour enregistrer
				razConfig();
				/* Affiche la page de creation de config */
				showCreationConfig();  
			}
		} else {
			/* Affichage erreur a l'uti */	
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
		String colonne = tb_cordColonne.getText();
		String ligne = tb_cordLigne.getText();
		String type = tb_cordType.getText();
		if(Outils.placementPion(ligne,colonne,type)) {
			rafraichirConf(Partie.configToString());
		}	
	}
	
	/** Cette fonction sera executé lorsque que l'utilisateur 
	 * souhaite supprimer un des piosn qu'il a positionné sur le plateau
	 * @param Click
	 */
	@FXML
	void supprimerPionConfig(MouseEvent Click) {
		String colonne = tb_cordColonne.getText();
		String ligne = tb_cordLigne.getText();
		if(Outils.suppressionPion(ligne,colonne)) {
			rafraichirConf(Partie.configToString());
		}	
	}

	/**
	 * Fonction qui supprime une des configurations enregistrées
	 * -> Si toutes les entrées de l'utilisateur sont correctes
	 * @param Click
	 */
	@FXML
	void deleteConfig(MouseEvent Click) {
		if(Outils.supprimerConf(tb_idConf.getText())) {
			showMsgbox(MSGBOX_TITRE, MSGBOX_ENREGISTREE, true);
			/* Retourne au menu*/
			reinitialiser();
			menu.setVisible(true);
		} else {
			showMsgbox(MSGBOX_TITRE, MSGBOX_NONVALIDE_CONF, false);
		}
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
		/* Vérifie que bon nombre de pion crapaud = grenouille
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
			Outils.nomConfig = "Configuration n°" + Configuration.listConfiguration.size();
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
	 * et qui affiche toutes les configurations actuellement crées
	 * @param Click
	 */
	@FXML
	void showSupprimerConfig(MouseEvent Click) {
		/*Affiche toutes les configurations disponibles*/
		configAdel.setText(Outils.afficherConfigDispo());
		/* Cache la page de sélection ajouter / supprimer config et affiche supprimer config */
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
	 * --------------- FONCTION DE CONTRÔLE D'ERREUR / FORMAT / VALIDITE--------------- 
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
	public static void showMsgbox(String titreFenetre, String texteFenetre, boolean typeFenetre) {
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