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

	private long timeOffset = 0;
	Timeline elapsedTimeTimeline;

	private double alottedTime;

	public int increment = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		countdownTimer.setText((int) DataStorage.getTotalTime() + ":00");
		timerLabel.setText("0:00");
		elapsedTimeLabel.setText("0:00");
		HomePageController.lapStatic = lapButton;

		elapsedTimeTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				increment++;
				// long difference = 0;
				// if (paused) {
				// difference = System.currentTimeMillis() - pauseTime;

				// }

				alottedTime = 60
						* ((DataStorage.getTotalTime() - DataStorage.getExtraTime()) / DataStorage.getTotalQuestions());
				// long elapsedTime = (System.currentTimeMillis() - initialTime) / 1000;
				long elapsedTime = increment;

				long netTime = Math.round(-elapsedTime + timeOffset + alottedTime);
				int elapsedTimeSeconds = Math.round(elapsedTime) % 60, netTimeSeconds = Math.round(netTime) % 60;
				// netSeparator = ":", elapsedSeparator = ":";

				double timeLeft = DataStorage.getTotalTime() * 60 - elapsedTime;

				int timeLeftSeconds = (int) (Math.round(timeLeft) % 60);

				System.out.println(timeLeft);

				elapsedTimeLabel.setText((int) elapsedTime / 60 + ":" + String.format("%02d", elapsedTimeSeconds));

				countdownTimer.setText((int) timeLeft / 60 + ":" + String.format("%02d", timeLeftSeconds));

				if (netTime <= 0) {
					timerLabel
							.setText("-" + (int) netTime / 60 + ":" + String.format("%02d", Math.abs(netTimeSeconds)));
				} else {
					timerLabel.setText((int) netTime / 60 + ":" + String.format("%02d", netTimeSeconds));
				}

			}
		}));
		elapsedTimeTimeline.setCycleCount(Timeline.INDEFINITE);
	}

	@FXML
	private void startButtonPressed() {

		System.out.println("Start Pressed");

		DataStorage.spacebarPressed();
		initialTime = System.currentTimeMillis();

		elapsedTimeTimeline.play();

		lapButton.requestFocus();

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
		if (lapButton.getText().equals("Next Question")) {

			if (numberOfProblems < DataStorage.getTotalQuestions()) {
				numberOfProblems++;
				alottedTime = 60
						* ((DataStorage.getTotalTime() - DataStorage.getExtraTime()) / DataStorage.getTotalQuestions());
				System.out.println(alottedTime);
				DataStorage.spacebarPressed();
				// Countdown timer
				// if (!lapButtonPressedOnce) {
				// lapButtonPressedOnce = true;
				long netTime = Math
						.round(-(System.currentTimeMillis() - initialTime) / 1000 + timeOffset + alottedTime);
				int netTimeSeconds = Math.round(netTime) % 60;
				timeOffset += alottedTime;
				if (netTime <= 0) {
					timerLabel
							.setText("-" + (int) netTime / 60 + ":" + String.format("%02d", Math.abs(netTimeSeconds)));
				} else {
					timerLabel.setText((int) netTime / 60 + ":" + String.format("%02d", netTimeSeconds));
				}
			} else {
				System.out.println("All questions have already been done");
			}
		} else if (lapButton.getText().equals("Reset")) {
			reset();
			lapButton.setDisable(true);
		}

	}

	private void stopButtonPressed() {
		elapsedTimeTimeline.pause();
	}

	private void reset() {
		elapsedTimeTimeline.stop();
		timeOffset = 0;
		increment = 0;

		countdownTimer.setText((int) DataStorage.getTotalTime() + ":00");
		timerLabel.setText("0:00");
		elapsedTimeLabel.setText("0:00");
	}

	@FXML
	private void startStopPressed() {
		if (startStopButton.getText().equals("Start")) {
			lapButton.setDisable(false);
			startStopButton.setText("Stop");
			lapButton.setText("Next Question");
			startButtonPressed();
		} else {
			startStopButton.setText("Start");
			lapButton.setText("Reset");
			stopButtonPressed();
			elapsedTimeTimeline.pause();
		}

		/*
		 * if(startStopButton.getText().equals("Stop")) { }
		 * startStopButton.setText("Start and reset"); startButtonPressed();
		 * 
		 * } else if(startStopButton.getText().equals("Start and reset")) {
		 * startStopButton.setText("Start"); stopButtonPressed(); }
		 */
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

	@FXML
	private Label countdownTimer;

}
