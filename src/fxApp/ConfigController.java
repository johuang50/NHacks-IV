package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import logic.DataStorage;

public class ConfigController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		numQuestionField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0, 1));
	}

	@FXML
	private void fieldChanged() {
		DataStorage.setExtraTime(Integer.parseInt(extraTimeField.getText()));
		DataStorage.setTotalQuestions(Integer.parseInt(numQuestionField.getText()));
		DataStorage.setTotalTime(Integer.parseInt(totalTimeField.getText()));
		System.out.println(DataStorage.getTotalQuestions());
		System.out.println(DataStorage.getTotalTime());
		System.out.println(DataStorage.getExtraTime());

	}

	@FXML
	private TextField numQuestionField;

	@FXML
	private TextField totalTimeField;

	@FXML
	private TextField extraTimeField;
}