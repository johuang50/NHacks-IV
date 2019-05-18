package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;

public class TabController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			tabChanged(tabPane.getSelectionModel().getSelectedItem().toString());
		});
	}

	private void tabChanged(String tabName) {
		if (tabName.equals("javafx.scene.control.Tab@5de25226")) {
			System.out.println("Trying to graph");
			GraphController.graph();
		} else {
			System.out.println("Not graphing");
			System.out.println(tabName);
		}
	}

	@FXML
	private TabPane tabPane;

}
