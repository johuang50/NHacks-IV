package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import logic.DataStorage;

public class DataController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	private void doCalc() {
		String[] stringArray = textField.getText().split(",");
		for (String str : stringArray) {
			DataStorage.getList().get(Integer.parseInt(str.trim()) - 1).setCorrect(false);
		}
	}

	@FXML
	private TextField textField;

}
