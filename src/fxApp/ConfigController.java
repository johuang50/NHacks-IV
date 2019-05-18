package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class ConfigController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		numQuestionField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0, 1));
	}

	@FXML
	private Spinner<Integer> numQuestionField;

}
