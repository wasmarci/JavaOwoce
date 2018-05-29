package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FruitMenuControler {
	
	
	
	@FXML private Button actionButton;
		
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		
		Scene currentScene = actionButton.getScene();
		Stage window = (Stage) currentScene.getWindow();
		Parent root;
				
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FruitSelectionView.fxml"));
			Scene scene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
