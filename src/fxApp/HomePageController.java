package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HomePageController implements Initializable  {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		timerLabel.setText("BIG GAY ~ Abhishek");
	}
	
	@FXML
	private Label timerLabel;

}
