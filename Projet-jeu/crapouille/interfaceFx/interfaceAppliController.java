/*
 * interfaceAppliController.java
 * Azog-corp 2019, droit d'auteur
 */


package crapouille.interfaceFx;


import crapouille.Pion;
import crapouille.Plateau;
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
	
	Plateau config;

    @FXML
    private Label lb_cord;

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
    private Label lb_nbColonne;

    @FXML
    private ToggleGroup lvlIA;

    @FXML
    private Button btn_validerTaille;

    @FXML
    private Button btn_quittermenu;

    @FXML
    private Label afficherConfig;

    @FXML
    private AnchorPane createur;

    @FXML
    private Button confirmationJouer;

    @FXML
    private Label gameBoardString;

    @FXML
    private Button btn_validerCord;

    @FXML
    private ImageView btn_quitter;

    @FXML
    private RadioButton lvl2;

    @FXML
    private Label lb_nbLigne;

    @FXML
    private RadioButton lvl3;

    @FXML
    private TextField choixConfig;

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
    	menu.setVisible(true);
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
    	backpanel.setVisible(false);
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
    	Partie.setChoixConfiguration(0);
    	Partie.crapouille();
    	reinitialiser();
    	gameBoard.setVisible(true);
    	rafraichirJeu(Partie.plateau.afficherJeu());
    }
    
    
    public void rafraichirJeu(String plateauJeu) {
    	entreeUti.setText(plateauJeu);
    }
    
    public void rafraichirConf(String plateauJeu) {
    	afficherConfig.setText(plateauJeu);
    }
    
    @FXML
    void showConfiguration(MouseEvent Click) {
    	reinitialiser();
    	configuration.setVisible(true);
    	//TODO rajouter supprimer
    	showInitialisationConfig();
    	
    }
    
    @FXML
    void creationInitialisation(MouseEvent Click) {
    	int nbLigne = Integer.parseInt(tb_nbLigneConf.getText());
    	int nbColonne = Integer.parseInt(tb_nbColonneConf.getText());
    	int ligne = 0,
    	  colonne = 0,
    	  nbPion = 0;
    	boolean isCrapaud = true;
    	String nom = tb_nomConf.getText();
    	//TODO FAIRE VERIFICATION VALIDITE
    	//SI BON FAIRE
    	Plateau config = new Plateau(nbLigne,nbColonne);
		Pion[] batracien = new Pion[nbPion];
		for (int x = 0; x < nbPion; x++) {
			// Donné une valeur à ligne et colonne
			Pion pion = new Pion(ligne, colonne, isCrapaud);
			config.setCase(pion);
			batracien[x] = pion;
		}
		for (int x = 0; x < nbPion; x++) {
			batracien[x].setBloque(config.getPlateau());
		}
    	Configuration nouvelleConfig = new Configuration(config.getPlateau(), nom);
    	Partie.listConfiguration.add(nouvelleConfig);
    	showCreationConfig(); 	
    	//SINON TEXTBOX / label avertir
    }
    
    @FXML
    void showCreationConfig() {
    	lb_nbColonne.setVisible(false);
    	lb_nbLigne.setVisible(false);
    	tb_nbLigneConf.setVisible(false);
    	tb_nbColonneConf.setVisible(false);
    	btn_validerTaille.setVisible(false);
    	lb_cord.setVisible(true);
    	tb_cord.setVisible(true);
    	btn_validerCord.setVisible(true);
    	btn_validerConfig.setVisible(true);
    }
    
    @FXML
    void showInitialisationConfig() {
    	lb_nbColonne.setVisible(true);
    	lb_nbLigne.setVisible(true);
    	tb_nbLigneConf.setVisible(true);
    	tb_nbColonneConf.setVisible(true);
    	btn_validerTaille.setVisible(true);
    	lb_cord.setVisible(false);
    	tb_cord.setVisible(false);
    	btn_validerCord.setVisible(false);
    	btn_validerConfig.setVisible(false);
    }
    
    @FXML
    void actualiserConfig(MouseEvent Click) {
    	StringBuilder recupCord = new StringBuilder(); 
    	recupCord.append(tb_cord.getText().charAt(1));
    	recupCord.append(tb_cord.getText().charAt(2));
    	int lignePion = Integer.parseInt(recupCord.toString());
    	StringBuilder recupCo = new StringBuilder(); 
    	recupCo.append(tb_cord.getText().charAt(4));
    	recupCo.append(tb_cord.getText().charAt(5));
    	int colonnePion = Integer.parseInt(recupCo.toString());
    	Pion placementUti = new Pion(lignePion,colonnePion,true);
    	config.setCase(placementUti);
    	rafraichirConf(config.afficherJeu());
    	
    	//TODO verifier coordonnees  
    	//TODO si correct modifier plateau + actualiser plateau
    	//TODO msg Box pas correct
    	
    }

}
