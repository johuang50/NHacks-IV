package popups;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class ChoiceWindow {

	private ButtonData response;

	public ChoiceWindow(String title, String content, Alert.AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(content);
		ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
		ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
		ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(okButton, noButton, cancelButton);

		alert.showAndWait().ifPresent(type -> {
			response = type.getButtonData();
		});
	}

	public ChoiceWindow(String title, String content) {
		this(title, content, AlertType.NONE);
	}

	public ButtonData getResponseType() {
		return response;
	}

}
