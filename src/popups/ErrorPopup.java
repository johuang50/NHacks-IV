package popups;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class ErrorPopup {

	private ButtonType response;
	private AlertType alertType = Alert.AlertType.NONE;

	public ErrorPopup(String title, String content) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(content);
		ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);

		alert.getButtonTypes().setAll(okButton);

		alert.showAndWait().ifPresent(type -> {
			response = type;
		});
	}
	
	public ErrorPopup(String content) {
		this("Error Popup", content);
	}

	public ButtonType getResponseType() {
		return response;
	}

}
