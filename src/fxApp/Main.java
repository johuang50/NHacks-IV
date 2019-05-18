package fxApp;

import com.sun.javafx.application.LauncherImpl;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class Main extends Application {
	public static Stage stage;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainDisplay.fxml"));
			scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.setTitle("Exam Chief");
			setPercentDone(0.95);
//			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("frogForce.png")));


			
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
				}
			});

			setPercentDone(1.0);
			primaryStage.show();

			stage = primaryStage;


			PauseTransition wait = new PauseTransition(Duration.hours(1.5));
			wait.setOnFinished((e) -> {
				primaryStage.close();
				wait.playFromStart();
			});
			wait.play();

//			previewJFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//			previewJFrame.setSize(1080, 540);
//			new Thread(new FieldClicker()).start();
//			previewJFrame.setTitle("Graph With Field");
//			previewJFrame.setLocationRelativeTo(null);
//			previewJFrame.setIconImage(new javax.swing.ImageIcon(getClass().getResource("frogForce.png")).getImage());
//			previewJFrame.setResizable(false);
//			previewJFrame.addMouseListener(new FieldClicker());
//			previewJFrame.addMouseMotionListener(new FieldClicker());
		} catch (Exception e) {
		}
	}

	@Override
	public void init() throws Exception {
		setPercentDone(0.33);
		Parent root = FXMLLoader.load(getClass().getResource("MainDisplay.fxml"));
		setPercentDone(0.75);
		scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		KeyCode[] numberKeyCodes = { KeyCode.DIGIT0, KeyCode.DIGIT1, KeyCode.DIGIT2, KeyCode.DIGIT3, KeyCode.DIGIT4,
				KeyCode.DIGIT5, KeyCode.DIGIT6, KeyCode.DIGIT7, KeyCode.DIGIT8, KeyCode.DIGIT9 };
		setPercentDone(0.90);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				for (int i = 0; i < numberKeyCodes.length; i++) {
					KeyCombination contrlKeyComb = new KeyCodeCombination(numberKeyCodes[i],
							KeyCodeCombination.CONTROL_DOWN);
					if (contrlKeyComb.match(event)) {
					}
				}
			}
		});

	}

	public static void main(String[] args) throws Exception {
//		LauncherImpl.launchApplication(Main.class, PreloaderPage.class, args);
		launch(args);
	}

	private void setPercentDone(double percent) {
//		LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(percent));
	}

}