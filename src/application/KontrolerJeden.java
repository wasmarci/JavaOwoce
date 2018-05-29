package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KontrolerJeden {
	
	private Stage thestage;
	
	private Parent root;
	
	@FXML private Text actiontarget;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		actiontarget.setText("Sign in buttion presesd");
		
		thestage = (Stage) actiontarget.getScene().getWindow();
		
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("Widok2.fxml"));
			Scene scene = new Scene(root);
			thestage.setScene(scene);
			thestage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
