package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HomePageController implements Initializable  {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timerLabel.setText("\"BIG GAY\" ~ Abhishek");
	}
	
	@FXML
	private void startButtonPressed() {
		
	}
	
	@FXML
	private void lapButtonPressed() {
		
	}
	
	@FXML
	private void stopButtonPressed() {
			
	}
	
	@FXML
	private Label timerLabel;

}
