package logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataStorage {
	private static int index = 0;
	// private LapTimer timer = new LapTimer();
	private static boolean initialized = false;
	private static ArrayList<QuestionData> array = new ArrayList<QuestionData>();

	private static int totalQuestions = 2;

	// public void populate(int numberOfQuestions) {
	// int initializationIndex = 0;
	// array.add((new QuestionData(0)));
	// index++;
	//
	// while (initializationIndex < numberOfQuestions) {
	// array.add(new QuestionData(initializationIndex));
	// }
	// }

	// public QuestionData getNextObject() {
	// index++;
	// if(index == 0) {
	// array.get(i).
	// }
	//
	//
	// return array.get(index);
	// }

	public static void spacebarPressed() {
		if (!initialized) {
			// timer.start();
			array.add(new QuestionData(1, System.currentTimeMillis()));
			initialized = true;
			index++;
		} else if (index <= totalQuestions) {
			// The final problem will be problem number (number), and index will be (number
			// - 1)
			// When the spacebar is pressed the last time, the problem number will be one
			// more
			if (index < totalQuestions) {
				array.add(new QuestionData(index+1)); // in the spot of index, add a problem number (number + 1)
			}
			array.get(index - 1).calculateDuration(System.currentTimeMillis());

			index++;

		}
	}

	public void exportData() throws FileNotFoundException {
		File file = new File("export.txt");
		file.getParentFile().mkdirs();

		PrintWriter printWriter = new PrintWriter(file);
		for (QuestionData o : array) {
			printWriter.println(o.getNumber() + "," + o.getDuration() + "," + o.isCorrect());
		}
		printWriter.close();
	}

	public static void main(String[] args) {
		spacebarPressed();
		try {
			Thread.sleep(419);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		spacebarPressed();
		
		try {
			Thread.sleep(68);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		spacebarPressed();
		for(QuestionData o:array) {
			System.out.println("Problem number: " + o.getNumber() + ", duration: " + o.getDuration());
		}
		

	}

}
