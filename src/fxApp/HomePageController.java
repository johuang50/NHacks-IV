package fxApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import logic.DataStorage;

public class HomePageController implements Initializable {
	private int numberOfProblems = 0;
	private long initialTime;
	private String netSeparator = ":", elapsedSeparator = ":";

	private long timeOffset = 0;
	Timeline elapsedTimeTimeline;

	private double alottedTime;

	private boolean lapButtonPressedOnce = false;

	private long previousNetTime;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timerLabel.setText("0:00");
		elapsedTimeLabel.setText("10");
		HomePageController.lapStatic = lapButton;
	}

	@FXML
	private void startButtonPressed() {
		System.out.println("Start Pressed");
		timerLabel.setText("0:00");
		DataStorage.spacebarPressed();
		initialTime = System.currentTimeMillis();

		elapsedTimeTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				long elapsedTime = (System.currentTimeMillis() - initialTime) / 1000;
				long netTime = -(System.currentTimeMillis() - initialTime) / 1000 + timeOffset;
				int elapsedTimeSeconds = Math.round(elapsedTime) % 60, netTimeSeconds = Math.round(netTime) % 60;
				// netSeparator = ":", elapsedSeparator = ":";

				elapsedTimeLabel.setText((int) elapsedTime / 60 + ":" + String.format("%02d", elapsedTimeSeconds));
				if (netTime <= 0) {
					timerLabel
							.setText("-" + (int) netTime / 60 + ":" + String.format("%02d", Math.abs(netTimeSeconds)));
				} else {
					timerLabel.setText((int) netTime / 60 + ":" + String.format("%02d", netTimeSeconds));
				}

			}
		}));
		elapsedTimeTimeline.setCycleCount(Timeline.INDEFINITE);
		elapsedTimeTimeline.play();

		// TimerTask task = new TimerTask() {
		// public void run() {

		//
		// }
		//
		// };
		// Timer timer = new Timer();
		// timer.scheduleAtFixedRate(task, 0, 1000l);

	}

	@FXML
	private void lapButtonPressed() {

		System.out.println("Lap Pressed");
		if (numberOfProblems < DataStorage.getTotalQuestions()) {
			numberOfProblems++;
			alottedTime = 60
					* ((DataStorage.getTotalTime() - DataStorage.getExtraTime()) / DataStorage.getTotalQuestions());
			System.out.println(alottedTime);
			DataStorage.spacebarPressed();
			// Countdown timer
			// if (!lapButtonPressedOnce) {
			// lapButtonPressedOnce = true;
			long netTime = -(System.currentTimeMillis() - initialTime) / 1000 + timeOffset;
			int netTimeSeconds = Math.round(netTime) % 60;
			timeOffset += alottedTime;
			if (netTime <= 0) {
				timerLabel.setText("-" + (int) netTime / 60 + ":" + String.format("%02d", Math.abs(netTimeSeconds)));
			} else {
				timerLabel.setText((int) netTime / 60 + ":" + String.format("%02d", netTimeSeconds));
			}
		} else {
			System.out.println("All questions havea already been done");
		}

	}

	private void stopButtonPressed() {
		elapsedTimeTimeline.stop();

	}

	@FXML
	private void startStopPressed() {
		if (startStopButton.getText().equals("Start")) {
			startStopButton.setText("Stop");
			startButtonPressed();
		} else {
			startStopButton.setText("Start");
			stopButtonPressed();
		}
	}

	public static void pressLap() {
		lapStatic.fire();
	}
	
	private static Button lapStatic;

	@FXML
	private Label timerLabel;

	@FXML
	private Label elapsedTimeLabel;

	@FXML
	private Button startStopButton, lapButton;

}
