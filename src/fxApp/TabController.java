package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TabPane;
import logic.DataStorage;
import logic.QuestionData;

public class TabController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			tabChanged(tabPane.getSelectionModel().getSelectedItem().toString());
		});
	}

	private void tabChanged(String tabName) {
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("fuck this");

		if (tabName.equals("Graphs")) {
			for (QuestionData o : DataStorage.getList()) {
				series1.getData().add(new XYChart.Data(o.getNumber(), o.getDuration()));
			}
		}
	}

	@FXML
	private TabPane tabPane;

}
