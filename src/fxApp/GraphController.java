package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import logic.DataStorage;
import logic.QuestionData;

public class GraphController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// barchart.setTitle();
		GraphController.bc = barchart;
	}

	public static void graph() {
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();

		for (QuestionData o : DataStorage.getList()) {
			series1.getData().add(new XYChart.Data<String, Number>("Q" + o.getNumber(), o.getDuration()/1000.0));
		}

		bc.setAnimated(false);
		bc.getData().clear();
		bc.getData().addAll(series1);
		
		
//		DataStorage.getList().get(1).setCorrect(true);
		for(int i = 0; i < DataStorage.getList().size(); i ++) {
			Node n = bc.lookup(".data" + i +".chart-bar");
			if(DataStorage.getList().get(i).isCorrect()) {
				
				n.setStyle("-fx-bar-fill: green");
			} else {
				n.setStyle("-fx-bar-fill: red");
			}
		}

	}

	@FXML
	private BarChart<String, Number> barchart;

	private static BarChart<String, Number> bc;
}
