/*
 * GestionPartieInterface.java
 * Azcop 2019, droit d'auteur
 */
package crapouille.interfaceFx;

import crapouille.configuration.Configuration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
/**
 * A compléter.
 * @author Azog
 *
 */
public class GestionPartieInterface extends Application {
	/**
	 * Dimension de l'interface.
	 */
	private static final int HAUTEUR = 519,
			LARGEUR = 606;
	/**
	 * test.
	 */
	@Override
	public void start(final Stage primaryStage) {
		try {
			primaryStage.initStyle(StageStyle.UNDECORATED);
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/crapouille/interfaceFx/application.css"));
			Scene scene = new Scene(root, HAUTEUR, LARGEUR);
			scene.getStylesheets().add(getClass().getResource("/crapouille/interfaceFx/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main principal.
	 * @param args non utilisés
	 */
	public static void main(final String[] args) {
		Configuration.initConfig();
		launch(args);
		Configuration.saveConfig();
	}
}
