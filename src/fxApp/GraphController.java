package fxApp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import logic.DataStorage;
import logic.QuestionData;

public class GraphController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// barchart.setTitle();
		GraphController.bc = barchart;
		GraphController.lc = timeQuestionGraph;
		GraphController.lc2 = timePerQuestionGraph;

	}

	public static void graph() {
		ArrayList<QuestionData> copy = (ArrayList<QuestionData>) DataStorage.getList().clone();

		double cumulativeSum = 0;

		if (copy.size() < DataStorage.getTotalQuestions()) {
			copy.remove(copy.size() - 1);
		}

		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();

		for (QuestionData o : copy) {
			cumulativeSum += o.getDuration() / 1000.0;
			series1.getData().add(new XYChart.Data<String, Number>("Q" + o.getNumber(), o.getDuration() / 1000.0));
			series2.getData()
					.add(new XYChart.Data<String, Number>(Integer.toString(o.getNumber()), o.getDuration() / 1000.0));
			series3.getData().add(new XYChart.Data<String, Number>(Integer.toString(o.getNumber()), cumulativeSum));
			System.out.println(cumulativeSum);

		}

		bc.setAnimated(false);
		bc.getData().clear();
		bc.getData().addAll(series1);
		bc.setLegendVisible(true);

		// copy.get(1).setCorrect(true);
		long timeRequirement = (long) (1000 * 60
				* ((DataStorage.getTotalTime() - DataStorage.getExtraTime()) / DataStorage.getTotalQuestions()));

		for (int i = 0; i < copy.size(); i++) {

			long duration = copy.get(i).getDuration();
			Node n = bc.lookup(".data" + i + ".chart-bar");
			if (copy.get(i).isCorrect() && duration <= timeRequirement) {

				n.setStyle("-fx-bar-fill: green");
			} else if (copy.get(i).isCorrect() && duration > timeRequirement) {
				n.setStyle("-fx-bar-fill: yellow");

			} else if (!copy.get(i).isCorrect() && duration <= timeRequirement) {
				n.setStyle("-fx-bar-fill: orange");
			} else if (!copy.get(i).isCorrect() && duration > timeRequirement) {
				n.setStyle("-fx-bar-fill: red");

			} else {
				n.setStyle("-fx-bar-fill: red");
			}
		}

		lc.setAnimated(false);
		lc.getData().clear();
		lc.getData().addAll(series2);

		lc2.setAnimated(false);
		lc2.getData().clear();
		lc2.getData().addAll(series3);
		// setAxisBounds(lc, 2);

	}

	public static void setAxisBounds(LineChart<Number, Number> myChart, double min) {
		NumberAxis axis;

		axis = (NumberAxis) myChart.getXAxis();

		// axis.setAutoRanging(false);
		axis.setTickUnit(1.0);
		axis.setLowerBound(min);

	}

	@FXML
	private BarChart<String, Number> barchart;

	private static BarChart<String, Number> bc;
	@FXML
	private LineChart<String, Number> timeQuestionGraph;

	private static LineChart<String, Number> lc;

	@FXML
	private LineChart<String, Number> timePerQuestionGraph;
	private static LineChart<String, Number> lc2;

}
