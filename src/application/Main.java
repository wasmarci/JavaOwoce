package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application {
	
	Stage thestage;
	
	
	@Override
	public void start(Stage primaryStage) {
		thestage = primaryStage;
		try {
			
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Widok1.fxml"));
			
			
			
			Scene scene = new Scene(root,400,400);
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
