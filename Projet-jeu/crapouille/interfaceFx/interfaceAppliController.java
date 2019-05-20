/*
 * interfaceAppliController.java
 * Azog-corp 2019, droit d'auteur
 */


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

	private String nom;

	//private LocalDate debutCasseTete;

	@FXML
	private AnchorPane initialisationConfig;

	@FXML
	private AnchorPane gameBoard;

	@FXML
	private AnchorPane configuration;

	@FXML
	private AnchorPane backpanel;

	@FXML
	private Button okGameBoard;

	@FXML
	private Button btn_jouermenu;

	@FXML
	private TextField tb_nbLigneConf;

	@FXML
	private ImageView btn_createur;

	@FXML
	private ImageView btn_mvp;

	@FXML
	private TextField tb_nbColonneConf;

	@FXML
	private AnchorPane score;

	@FXML
	private ToggleGroup lvlIA;

	@FXML
	private Button btn_validerTaille;

	@FXML
	private Label afficherConfig;
	
	@FXML
	private Label listeConfigDispo;

	@FXML
	private Button btn_quittermenu;

	@FXML
	private AnchorPane createur;

	@FXML
	private Button confirmationJouer;

	@FXML
	private Label gameBoardString;

	@FXML
	private ImageView btn_quitter;

	@FXML
	private RadioButton lvl2;

	@FXML
	private RadioButton lvl3;

	@FXML
	private TextField choixConfig;

	@FXML
	private AnchorPane placementConfig;

	@FXML
	private Button retourMenu;

	@FXML
	private Button btn_validerConfig;

	@FXML
	private Label lb_nomJ1;

	@FXML
	private TextField tb_nomJ2;

	@FXML
	private ImageView btn_acceuil;

	@FXML
	private Label lb_nomJ2;

	@FXML
	private CheckBox chk_vsIA;

	@FXML
	private TextField tb_nomJ1;

	@FXML
	private AnchorPane menu;

	@FXML
	private AnchorPane settingsBar;

	@FXML
	private Label lb_lvlIa;

	@FXML
	private Button btn_aidemenu;

	@FXML
	private Label labelIA;

	@FXML
	private Label nomMVP;

	@FXML
	private CheckBox chk_casseT;

	@FXML
	private TextField tb_cord;

	@FXML
	private TextField entreeUti;

	@FXML
	private Text scoreMVP;

	@FXML
	private ImageView btn_configuration;

	@FXML
	private AnchorPane configurationPartie;

	@FXML
	private RadioButton lvl1;

	@FXML
	private TextField tb_nomConf;

	private String nomConfig;

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
	 * TODO creer la page de selection + fonction navigation
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	void showConfiguration(MouseEvent Click) {
		reinitialiser();
		configuration.setVisible(true);
		//TODO rajouter supprimer
		showInitialisationConfig();
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
	 * Fonction qui cqche les éléments de l'IA
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

	@FXML
	void showGameBoard(MouseEvent Click) {
		if(chercherConfig()) {
			recupAdversaire();
			recupModeJeu();
			recupNomEquipe();
			recupConfiguration();
			reinitialiser();
			gameBoard.setVisible(true);
			rafraichirJeu(Partie.currentPlateau.toString());
		}
		//Lancer chrono
	}


	@FXML
	void actualiserJeu(MouseEvent Click) {
		//Recuperer et valider coordonees
		int ligne = 0,
				colonne = 0;
		if ((Partie.tourEquipe == 0 ) || (Partie.tourEquipe == 1 && Partie.getChoixAdversaire() == 0)) {
			Partie.currentPlateau.movePion(Partie.currentPlateau.getPlateau()[ligne][colonne]);
		} else {
			Partie.currentPlateau.movePion(Ordinateur.choixOrdi(Partie.currentPlateau, 
					Partie.currentPlateau.getBatracien(), 
					Partie.getChoixAdversaire()));
		}
		Partie.tourEquipe = Partie.tourEquipe == 0 ? 1 : 0;
		rafraichirJeu(Partie.currentPlateau.toString());
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

	private void recupConfiguration() {
		if (!choixConfig.getText().isEmpty()) {
			//regarder s'il la configuration existe
		} else { //Sinon choisi la configuration par defaut
			Partie.setChoixConfig(0);
		}
	}
	//TODO
	private boolean chercherConfig() {
		if (!choixConfig.getText().isEmpty()) {
			int config = Integer.parseInt(choixConfig.getText());
			if (config < 0) { //TODO  || config > Partie.listConfiguration.length-1
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
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
	    	for (int compteur = 0; compteur < Partie.listConfiguration.size(); compteur++) {
	    		configs.append(compteur + " - ");
	    		configs.append(Partie.listConfiguration.get(compteur).getNom());
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
	 * Recupere les coordonnees rentre par l'utilisateur lors de la creation 
	 * de la config. Puis verifie leur validite (Type,taille,position...)
	 * Si toutes les donnees sont valides ajoute au plateau le pion demander
	 * par l'utilisateur. Puis actualise le plateau sur l'interface
	 * Pour afficher le changement
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	void actualiserConfig(MouseEvent Click) {
		StringBuilder recupCord = new StringBuilder(); 
		recupCord.append(tb_cord.getText().charAt(1));
		recupCord.append(tb_cord.getText().charAt(2));
		int lignePion = Integer.parseInt(recupCord.toString());
		StringBuilder recupCo = new StringBuilder(); 
		recupCo.append(tb_cord.getText().charAt(4));
		recupCo.append(tb_cord.getText().charAt(5));
		//TODO Verifier que coordonnees valides ligne et colonne pas superieur et > 0
		//TODO verifier char 3 -
		//TODO verifier char c ou g si tous bon continuer	
		int colonnePion = Integer.parseInt(recupCo.toString());
		colonnePion--;
		lignePion--;
		Pion placementUti = new Pion(lignePion,colonnePion,
				recupType(tb_cord.getText().charAt(0)));
		//TODO SI TOUS TEST VALIDE +1 nb Pion
		Partie.currentPlateau.setCase(placementUti);
		rafraichirConf(Partie.currentPlateau.toString());
		//TODO verifier coordonnees  
		//TODO si correct modifier plateau + actualiser plateau
		//TODO msg Box pas correct
	}

	/**
	 * Fonction qui est declenche lorsque l'utilisateur souhaite acceder 
	 * au plateau pour le placement des pions lors de la creation d'une config
	 * Celle ci verifie que toutes les donnees rentre par l'utilisateur 
	 * sont correct si se n'est pas le cas reste sur la page actuelle
	 * TODO et lui indique ses erreurs
	 * @param Click clic de l'utilisateur declanchant l'appel de la fonction
	 */
	@FXML
	void configInitialisation(MouseEvent Click) {
		boolean test = tb_nbLigneConf.getText().isEmpty();
		System.out.println(test);
		if (!tb_nbLigneConf.getText().isEmpty() && !tb_nbColonneConf.getText().isEmpty()) {
			//TODO verifier que il sagit bien de nombre
			int nbLigne = Integer.parseInt(tb_nbLigneConf.getText());
			int nbColonne = Integer.parseInt( tb_nbColonneConf.getText());
			if (nbLigne < 20 && nbColonne < 20) {
				Pion[][] newPlateau = new Pion[nbLigne][nbColonne];
				Partie.currentPlateau = new Plateau(newPlateau);
				recupNom();
				showCreationConfig(); 
			} else {
				//TODO afficher label ne peut pas etre superieur a 20
			}
		} else {
			//TODO afficher label ne peut pas etre vide
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
		Configuration config = new Configuration (Partie.currentPlateau.getPlateau(), nomConfig);
		Partie.listConfiguration.add(config);
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
		return choix == 'C' || choix == 'c' ? true : false;
	}

	/**
	 * Recupere le nom que l'utilisateur a entre dans la textBox de creation de 
	 * configuration si il est vide prend la valeur defaut
	 * (remplacera donc la configuration par defaut)
	 * @return nom Le nom de la configuration qui sera cree
	 */
	public String recupNom() {
		if (tb_nomConf.getText() != "") {
			nom = tb_nomConf.getText();
		} else {
			nom = "Defaut";
		}
		return nom;
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
	void showInitialisationConfig() {
		initialisationConfig.setVisible(true);
		placementConfig.setVisible(false);
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
		rafraichirConf(Partie.currentPlateau.toString());
	}
}