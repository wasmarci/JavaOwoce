package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class KontrolerJeden {
	@FXML private Text actiontarget;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		actiontarget.setText("Sign in buttion presesd");
	}
}
