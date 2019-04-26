package application;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class interfaceAppliController {

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
	    private Slider sliderTaille;

	    @FXML
	    private AnchorPane createur;

	    @FXML
	    private AnchorPane plateau;

	    @FXML
	    private Button jouermenu;

	    @FXML
	    private Button confirmationJouer;

	    @FXML
	    private ImageView btn_quitter;

	    @FXML
	    private RadioButton lvl2;

	    @FXML
	    private RadioButton lvl3;

	    @FXML
	    private Button retourMenu;

	    @FXML
	    private Label lb_nomJ1, lb_lvlIa;

	    @FXML
	    private TextField tb_nomJ2;

	    @FXML
	    private ImageView btn_acceuil;

	    @FXML
	    private Label lb_nomJ2;

	    @FXML
	    private TextField tb_nomJ1;

	    @FXML
	    private AnchorPane menu;

	    @FXML
	    private Button aidemenu;

	    @FXML
	    private AnchorPane settingsBar;

	    @FXML
	    private Label nomMVP;

	    @FXML
	    private Text scoreMVP;

	    @FXML
	    private RadioButton lvl1;
	    
	    @FXML
	    private CheckBox chk_vsIA;

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
    void retourMenu(MouseEvent Click) {
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
    	plateau.setVisible(false);
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
    void razConfig() {
    	chk_vsIA.setSelected(false);
    	verificationCheck();
    }
    
    @FXML
    void caseIaPasCheck() {
    	lvl1.setVisible(false);
		lvl2.setVisible(false);
		lvl3.setVisible(false);
		lb_lvlIa.setVisible(false);
		lb_nomJ2.setVisible(true);
		tb_nomJ2.setVisible(true);
    }
    
    @FXML
    void caseIaCheck() {
    	lvl1.setVisible(true);
		lvl2.setVisible(true);
		lvl3.setVisible(true);
		lb_lvlIa.setVisible(true);
		lb_nomJ2.setVisible(false);
		tb_nomJ2.setVisible(false);
    }
    
    @FXML
    void afficherJeu(MouseEvent Click) {
    	reinitialiser();
    	plateau.setVisible(true);
    }

}
