package fxApp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import logic.DataStorage;
import logic.QuestionData;

public class StatsController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pc = this.pieChart;
	}

	public static void doGraph() {
		int count = 0;
		ArrayList<QuestionData> copy = (ArrayList<QuestionData>) DataStorage.getList().clone();
		if (copy.size() < DataStorage.getTotalQuestions()) {
			copy.remove(copy.size() - 1);
		}
		for (QuestionData o : DataStorage.getList()) {
			if (o.isCorrect()) {
				count++;
			}
		}

		double amount = (int) (100 * count / copy.size()); // correct

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList((new PieChart.Data("Incorrect", 100)), (new PieChart.Data("Correct", 0)));
		
//				(new PieChart.Data("Incorrect", 100 - amount)), (new PieChart.Data("Correct", amount)));
				


//		pc = new PieChart(pieChartData);
		
		pc.setData(pieChartData);
		System.out.println(amount);
	}

	@FXML
	private PieChart pieChart;

	private static PieChart pc;

}
