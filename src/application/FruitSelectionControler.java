package application;

import java.io.IOException;
import java.util.LinkedList;

import Model.Fruit;
import Model.FruitMenuModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FruitSelectionControler {
	
	private FruitMenuModel model = FruitMenuModel.getInstance(); 
	
	@FXML private Button actionButton1;
	@FXML private Button actionButton2;
	@FXML private Text targetText;
	
	@FXML protected void handleFinishButtonAction(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML protected void handleBackButtonAction(ActionEvent event) {
			
		Scene currentScene = actionButton2.getScene();
		Stage window = (Stage) currentScene.getWindow();
		Parent root;
		
					
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FruitMenuView.fxml"));
			Scene scene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());
			scene.getStylesheets().add("style.css");
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {
		LinkedList<Fruit> list = model.getFruitList();
		LinkedList<String> chosenFruits = new LinkedList<String>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getChosen()) {
				chosenFruits.add(list.get(i).getName());
			}
		}
		
		String text = new String();
		if (chosenFruits.size() == 0) {
			text = "Nie wybrano �adnych owoc�w";
		}
		else {
			text = "Wybrano: \n";
			for(int i = 0; i < chosenFruits.size(); i++) {
				text = text + chosenFruits.get(i) + ", ";
			}
		}
		/**
		String selected = new String();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getChosen()) {
				selected = selected + ' ' + list.get(i).getName() + ',';
			}
		}
		*/
		targetText.setText(text);

	}
	

}
