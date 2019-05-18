package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import logic.DataStorage;
import logic.QuestionData;

public class GraphController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// barchart.setTitle();

	}

	@FXML
	private static BarChart<String, Number> barchart;

	public static void graph() {
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("fuck this");

		for (QuestionData o : DataStorage.getList()) {
			series1.getData().add(new XYChart.Data(o.getNumber(), o.getDuration()));
		}
		
		barchart.getData().add(series1);

	}

}
