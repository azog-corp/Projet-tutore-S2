package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class interfaceAppliController {

	@FXML
    private Label labelIA;
	
    @FXML
    private Label gameBoardString;

    @FXML
    private AnchorPane configuration;

    @FXML
    private AnchorPane backpanel;

    @FXML
    private ImageView btn_createur;

    @FXML
    private ImageView btn_mvp;

    @FXML
    private AnchorPane score;

    @FXML
    private Button quittermenu;

    @FXML
    private ToggleGroup lvlIA;

    @FXML
    private Slider sliderTaille;

    @FXML
    private AnchorPane createur;

    @FXML
    private AnchorPane gameBoard;

    @FXML
    private Button jouermenu;

    @FXML
    private Button confirmationJouer;

    @FXML
    private Button okgameBoard;

    @FXML
    private ImageView btn_quitter;

    @FXML
    private RadioButton lvl2;

    @FXML
    private RadioButton lvl3;

    @FXML
    private Button retourMenu;

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
    private Button aidemenu;

    @FXML
    private AnchorPane settingsBar;

    @FXML
    private Label lb_lvlIa;

    @FXML
    private Label nomMVP;

    @FXML
    private CheckBox chk_casseT;

    @FXML
    private TextField entreeUti;

    @FXML
    private Text scoreMVP;

    @FXML
    private GridPane gameBoardJeu;

    @FXML
    private RadioButton lvl1;



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
    void choixConf(MouseEvent Click) {
    	reinitialiser();
    	razConfig();
    	configuration.setVisible(true);
    }
    
    
    
    @FXML
    void reinitialiser() {
    	menu.setVisible(false);
    	configuration.setVisible(false);
    	score.setVisible(false);
    	gameBoard.setVisible(false);
    	createur.setVisible(false);
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
    	reinitialiser();
    	gameBoard.setVisible(true);
    	rafraichirJeu();
    }
    
    void rafrachirJeu() {
    	entreeUti.setText(Plateau.afficherJeu());
    }
    
    @FXML
    void recupererCoord() { // Se declanche avec appui sur ok
    	//entreeUti.getText().getCoordonees 
    	// TODO fonction recuperant les coordonnees du pion qui doit bouger et la ou il doit bouger; ( get chartAt + StringBuilder)
    	//TODO appel fonction bouger pion + verfication coordonnes donnees etc
    	//(les fonctions de mael)
    	//Quand deplacement fini afficher nouvelles positions sinon afficher message box
    }
    
    //TODO fonction pour placer chaque element dans le grid pane et le rendre iteractif
    //Idee recuperer coordonnées grid pane + largeur longueur la diviser par le nombre d'arguments et creer des des maps
    // Au click appel fonction pour deplacer au coordonnes
    // Probleme comment savoir quelle case correspond a quoi
    //Creer bouton a la place mais comment definir quel bouton et quoi
    
    

}
