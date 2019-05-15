/*
 * interfaceAppliController.java
 * Azog-corp 2019, droit d'auteur
 */


package crapouille.interfaceFx;


import crapouille.Pion;
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
    	Partie.setChoixConfig(0);
    	reinitialiser();
    	gameBoard.setVisible(true);
    	//rafraichirJeu(Partie.plateau.afficherJeu());
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
    void configInitialisation(MouseEvent Click) {
    	boolean test = tb_nbLigneConf.getText().isEmpty();
    	System.out.println(test);
    	if (!tb_nbLigneConf.getText().isEmpty() && !tb_nbColonneConf.getText().isEmpty()) {
    		//TODO verifier que il sagit bien de nombre
    		int nbLigne = Integer.parseInt(tb_nbLigneConf.getText());
    		int nbColonne = Integer.parseInt( tb_nbColonneConf.getText());
    		if (nbLigne < 20 && nbColonne < 20) {
    			//Partie.setligneConf(nbLigne);
    				//Partie.setcolonneConf(nbLigne);
    			recupNom();
    			showCreationConfig(); 
    		} else {
    			//TODO afficher label ne peut pas etre superieur a 20
    		}
    	} else {
    		//TODO afficher label ne peut pas etre vide
    	}
    }
	
	//Config config = new Config(Partie.tableau, nom
	//Partie.arr.add
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
    }
    
    @FXML
    void showInitialisationConfig() {
    	initialisationConfig.setVisible(true);
    	placementConfig.setVisible(false);
    }
	
    private boolean recupType(char choix) {
        return choix == 'C' || choix == 'c' ? true : false;
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
    	//TODO Verifier que coordonnees valides
    	//TODO verifier char 3 -
    	//TODO verifier char c ou g si tous bon continuer	
    	int colonnePion = Integer.parseInt(recupCo.toString());
    	Pion placementUti = new Pion(lignePion,colonnePion,recupType(tb_cord.getText().charAt(0)));
    	//TODO SI TOUS TEST VALIDE +1 nb Pion
    	//Partie.plateau[lignePion][colonnePion]= placementUti;
    	//rafraichirConf(Partie.plateau.afficherJeu());
    	
    	//TODO verifier coordonnees  
    	//TODO si correct modifier plateau + actualiser plateau
    	//TODO msg Box pas correct
    	
    }
    @FXML
    void enregistrerConfig(MouseEvent Click) {
    	//TODO ENVOYER LA CONFIG
    }

}
