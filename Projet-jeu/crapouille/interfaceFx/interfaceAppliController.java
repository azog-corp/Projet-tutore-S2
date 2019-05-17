/*
 * interfaceAppliController.java
 * Azog-corp 2019, droit d'auteur
 */


package crapouille.interfaceFx;


import java.time.LocalDate;

import crapouille.Pion;
import crapouille.configuration.Configuration;
import crapouille.game.Partie;
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
    @FXML
    void leave(MouseEvent click) {
    	Platform.exit(); 
    }
    
    @FXML
    void showMVP(MouseEvent Click) {
    	reinitialiser();
    	score.setVisible(true);
    }
    
    @FXML
    void showCreateur(MouseEvent Click) {
    	reinitialiser();
    	createur.setVisible(true);
    }
    
    @FXML
    void showMenu(MouseEvent Click) {
    	reinitialiser();
    	razMenu();
    	menu.setVisible(true);
    }
    
    @FXML
    void razMenu() {
    	tb_nomJ1.setText("");
    	tb_nomJ2.setText("");
    	choixConfig.setText("");
    	chk_casseT.setSelected(false);
    	chk_vsIA.setSelected(false);
    }
  
    
    @FXML
    void showConfigurationPartie(MouseEvent Click) {
    	reinitialiser();
    	razConfig();
    	configurationPartie.setVisible(true);
    }
    
    

    @FXML
    void reinitialiser() {
    	menu.setVisible(false);
    	configurationPartie.setVisible(false);
    	score.setVisible(false);
    	gameBoard.setVisible(false);
    	createur.setVisible(false);
    	configuration.setVisible(false);
    }
    
    @FXML
    void verificationCheck() {
    	if (chk_vsIA.isSelected()) {
    		caseIaCheck();
    	} else {
    		caseIaPasCheck();
    	}
    }
    @FXML
    void verificationModeJeu() {
    	if (chk_casseT.isSelected()) {
    		casseTeteConf();
    	} else {
    		versusConf();
    	}
    }
    @FXML
    void versusConf() {
    	chk_vsIA.setVisible(true);
    	labelIA.setVisible(true);
    	lb_nomJ2.setVisible(true);
		tb_nomJ2.setVisible(true);
    }
    
    void razIa() {
    	chk_vsIA.setSelected(false);
    	lvl1.setSelected(false);
    	lvl2.setSelected(false);
    	lvl3.setSelected(false);
    }
    
    @FXML
    void casseTeteConf() {
    	cacherIa();
		cacherJ2();
		razIa();
		labelIA.setVisible(false);
		chk_vsIA.setVisible(false);
    }
    
    @FXML
    void cacherJ2() {
    	lb_nomJ2.setVisible(false);
		tb_nomJ2.setVisible(false);
    }
    
    @FXML
    void razConfig() {
    	chk_vsIA.setSelected(false);
    	chk_casseT.setSelected(false);
    	verificationCheck();
    }
    @FXML
    void cacherIa() {
    	lvl1.setVisible(false);
		lvl2.setVisible(false);
		lvl3.setVisible(false);
		lb_lvlIa.setVisible(false);
    }
    
    @FXML
    void montrerIA() {
    	lvl1.setVisible(true);
		lvl2.setVisible(true);
		lvl3.setVisible(true);
		lb_lvlIa.setVisible(true);
    }
    
    @FXML
    void caseIaPasCheck() {
    	cacherIa();
    	razIa();
    	lb_nomJ2.setVisible(true);
    	tb_nomJ2.setVisible(true);
    }
    
    @FXML
    void caseIaCheck() {
    	montrerIA();
		cacherJ2();
    }
    
    @FXML
    void afficherJeu(MouseEvent Click) {
    	recupAdversaire();
    	recupModeJeu();
    	recupNomEquipe();
    	recupConfiguration();
    	reinitialiser();
    	gameBoard.setVisible(true);
    	rafraichirJeu(Partie.afficherJeu());
    	//Lancer chrono
    }
    
    
    @FXML
    void actualiserJeu(MouseEvent Click) {
    	//Recuperer et valider coordonees
    	Partie.movePion(Partie.plateau[ligne][colonne]); //joueur joue nbcoup++
    	//move pion doit changer le tour equipe
    	if (Partie.tourEquipe == 2 && Partie.getChoixAdversaire() != 0) {
    		Ordinateur.ChoixOrdinateur();
    	} //Sinon rien faire et attendre que lautre equipe joue
    	rafraichirJeu(Partie.afficherJeu());
    }
    
    private void recupModeJeu() {
    	if (chk_casseT.isSelected()) {
    		Partie.setChoixModeDeJeu(0);
    	} else {
    		Partie.setChoixModeDeJeu(1);
    	}
    }
    
    private void recupConfiguration() {
    	if (!choixConfig.getText().isEmpty()) {
    		//regarder s'il la configuration existe
    	} else {
    		Partie.setChoixConfig(0);
    	}
    }
	
    private boolean chercherConfig(String config) {
    	Partie.listConfiguration.length
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
    
    
    public void rafraichirJeu(String plateauJeu) {
    	gameBoardString.setText(plateauJeu);
    }
    
    @FXML
    void showConfiguration(MouseEvent Click) {
    	reinitialiser();
    	configuration.setVisible(true);
    	//TODO rajouter supprimer
    	showInitialisationConfig();
    	
    }
    
    @FXML
    void configInitialisation(MouseEvent Click) {
    	boolean test = tb_nbLigneConf.getText().isEmpty();
    	System.out.println(test);
    	if (!tb_nbLigneConf.getText().isEmpty() && !tb_nbColonneConf.getText().isEmpty()) {
    		//TODO verifier que il sagit bien de nombre
    		int nbLigne = Integer.parseInt(tb_nbLigneConf.getText());
    		int nbColonne = Integer.parseInt( tb_nbColonneConf.getText());
    		if (nbLigne < 20 && nbColonne < 20) {
    			Partie.setLigneConf(nbLigne);
    			Partie.setColonneConf(nbLigne);
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
    
    @FXML
    void showCreationConfig() { 
    	initialisationConfig.setVisible(false);
    	placementConfig.setVisible(true);
    	rafraichirConf(Partie.afficherJeu());
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
     * @param Click clique de l'utilisateur declanchant l'appel de la fonction
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
    	Partie.plateau[lignePion][colonnePion] = placementUti;
    	rafraichirConf(Partie.afficherJeu());
    	//TODO verifier coordonnees  
    	//TODO si correct modifier plateau + actualiser plateau
    	//TODO msg Box pas correct
    }
    
    /**
     * Fonction qui enregistre la configuration lorsque l'utilisateur souhaite
     * l'enregistrer. (La sauvegarde dans la liste des configuration)
     * @param Click clique de l'utilisateur declanchant l'appel de la fonction
     */
    @FXML
    void enregistrerConfig(MouseEvent Click) {
    	Configuration config = new Configuration (Partie.plateau, nomConfig);
    	Partie.listConfiguration.add(config);
    	Partie.saveConfig();
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
    
    /*--------------- FONCTION CONFIGURATION: TRAITEMENT INTERFACE  ---------------*/
    
    /**
     * Actualise le label affichant le plateau sur l'interface
     * @param plateauJeu Plateau de la configuration converti en String
     */
    public void rafraichirConf(String plateauJeu) {
    	afficherConfig.setText(plateauJeu);
    }
    
    /**
     * Lorsque l'utilisateur clique sur valider apres avoir
     * entree le nom de la configuration ainsi que le nombre de ligne/colonne
     * affiche la page de placement des pions sur la config en creation
     */
    @FXML
    void showInitialisationConfig() {
    	initialisationConfig.setVisible(true);
    	placementConfig.setVisible(false);
    }
}
