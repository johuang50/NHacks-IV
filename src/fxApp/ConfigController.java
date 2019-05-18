package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class ConfigController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		numQuestionField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0, 1));
		numQuestionField.focusedProperty().addListener((obs, oldValue, newValue) -> {
			fieldChanged();
		});
	}

	@FXML
	private void fieldChanged() {
		String txt = Double.toString(Double.parseDouble(totalTimeField.getText())/(numQuestionField.getValue().intValue()));
		timePerQuestionField.setText(txt);
	}
	
	@FXML
	private Spinner<Integer> numQuestionField;

	@FXML
	private TextField totalTimeField;
	@FXML
	private TextField timePerQuestionField;
}
