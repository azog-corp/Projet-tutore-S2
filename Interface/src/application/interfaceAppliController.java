package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class interfaceAppliController {
    @FXML
    private AnchorPane backpanel;

    @FXML
    private AnchorPane score;

    @FXML
    private AnchorPane menu;

    @FXML
    private AnchorPane createur;

    @FXML
    private AnchorPane plateau;

    @FXML
    private AnchorPane jouer;

    @FXML
    private Button jouermenu;

    @FXML
    private Button aidemenu;

    @FXML
    private Button quittermenu;
    @FXML
    void choixDiffi(ActionEvent event) {
    	jouer.setVisible(false);
    	plateau.setVisible(true);
    }
    
    @FXML
    void leave(ActionEvent quitter) {
    	Platform.exit(); 
    }
    

    @FXML
    void quitterparimg(MouseEvent quitterimg) {
    	Platform.exit(); 
    }
    
    /*
    @FXML
    void jouerClick(ActionEvent evt) {
    	System.out.println("Bouton cliquer");
    	jouer.setVisible(false);
    }
    */
}
