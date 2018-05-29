package application;

import java.io.IOException;
import java.util.LinkedList;

import Model.Fruit;
import Model.FruitMenuModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FruitMenuControler {
	
	private FruitMenuModel model = FruitMenuModel.getInstance(); 
	
	@FXML private Button actionButton;
	@FXML private FlowPane fruitContainer; 
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		
		Scene currentScene = actionButton.getScene();
		Stage window = (Stage) currentScene.getWindow();
		Parent root;
		
		//fruitContainer.getChildren();
				
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FruitMenuView.fxml"));
			Scene scene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {
		LinkedList<Fruit> list = model.getFruitList();
		
		for(int i = 0; i < list.size(); i++) {
			
			Fruit childItem = list.get(i);
			GridPane childContainer = new GridPane();
			Label label = new Label(childItem.getName());
			childContainer.add(label, 1, 0);
			try {
				ImageView foto = new ImageView(childItem.getFoto());
				foto.setFitHeight(50);
				foto.setFitWidth(50);
				childContainer.add(foto, 2, 0);
			}
			catch(Exception  e) {
				e.printStackTrace();
			}
			
			CheckBox box = new CheckBox();
			box.setId(childItem.getName());
			box.setSelected(childItem.getChosen());
			box.selectedProperty().addListener(new ChangeListener<Boolean>() {
                public void changed(ObservableValue ov, Boolean old_val, Boolean new_val) {
                	childItem.setChosen(new_val);
                        
                }
            });
			childContainer.add(box, 3, 0);
			fruitContainer.getChildren().add(childContainer);
			
		}
    }


	


}
	
