package crapouille.interfaceFx;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/crapouille/interfaceFx/interfaceAppli.fxml"));
			Scene scene = new Scene(root,519,606);
			scene.getStylesheets().add(getClass().getResource("/crapouille/interfaceFx/application.css").toExternalForm());
			primaryStage.setScene(scene);
			Media media = new Media("file:///crapouille/musique/test.mp3");
		    MediaPlayer player = new MediaPlayer(media); 
		    player.play();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}