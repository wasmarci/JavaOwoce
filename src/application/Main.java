package application;
	
import java.io.IOException;

import Model.FruitMenuModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	
	FruitMenuModel model = FruitMenuModel.getInstance();
	Stage window;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		
		try {
									
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FruitMenuView.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add("style.css");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
