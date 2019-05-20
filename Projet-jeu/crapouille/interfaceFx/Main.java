package crapouille.interfaceFx;



import crapouille.Partie;
import crapouille.Pion;
import crapouille.Plateau;
import crapouille.configuration.Configuration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/crapouille/interfaceFx/interfaceAppli.fxml"));
			Scene scene = new Scene(root,519,606);
			scene.getStylesheets().add(getClass().getResource("/crapouille/interfaceFx/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// Partie.initConfig();
		Pion pion = new Pion(0, 1, false);
		Pion pion1 = new Pion(1, 0, false);
		Pion pion2 = new Pion(3, 2, false);
		Pion[][] p = {{null, pion, null},{pion1, null, null},{null, null, pion2}};
		Plateau ps = new Plateau(p);
		ps.initBloque();
		Configuration d = new Configuration(p, "Défault");
		Partie.listConfiguration.add(d);
		Partie.saveConfig();
		launch(args);
		Partie.saveConfig();
	}
}