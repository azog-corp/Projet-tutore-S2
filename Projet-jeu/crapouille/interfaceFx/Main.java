package crapouille.interfaceFx;

import crapouille.configuration.Configuration;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.initStyle(StageStyle.UNDECORATED);
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/crapouille/interfaceFx/interfaceAppli.fxml"));
			Scene scene = new Scene(root,519,606);
			scene.getStylesheets().add(getClass().getResource("/crapouille/interfaceFx/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Configuration.initConfig();
		launch(args);
		Configuration.saveConfig();
	}
}