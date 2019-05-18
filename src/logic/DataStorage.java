package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class DataStorage {
	private static int index = 0;
	// private LapTimer timer = new LapTimer();
	private static boolean initialized = false;
	private static ArrayList<QuestionData> array = new ArrayList<QuestionData>();

	private static int totalQuestions, totalTime, extraTime;

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
		System.out.println("test");
		if (!initialized) {
			System.out.println("Question " + (index + 1) + " initialized");
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
				array.add(new QuestionData(index + 1)); // in the spot of index, add a problem number (number + 1)
			}
			array.get(index - 1).calculateDuration(System.currentTimeMillis());
			System.out.println("Question " + (index) + " completed with time of " + array.get(index - 1).getDuration());

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
		for (QuestionData o : array) {
			System.out.println("Problem number: " + o.getNumber() + ", duration: " + o.getDuration());
		}

	}

	public static int getTotalTime() {
		return totalTime;
	}

	public static void setTotalTime(int totalTime) {
		DataStorage.totalTime = totalTime;
	}

	public static int getExtraTime() {
		return extraTime;
	}

	public static void setExtraTime(int extraTime) {
		DataStorage.extraTime = extraTime;
	}

	public static int getTotalQuestions() {
		return totalQuestions;
	}

	public static void setTotalQuestions(int totalQuestions) {
		DataStorage.totalQuestions = totalQuestions;
	}

	public ArrayList<QuestionData> getSorted() {
		ArrayList<QuestionData> sorted = (ArrayList<QuestionData>) array.clone();
		Collections.sort(sorted);
		return sorted;
	}

	public double getQuartilePercentCorrect(int quartile) {
		ArrayList<QuestionData> sorted = getSorted();
		double totalCount = 0;
		double correctCount = 0;
		for (int i = (quartile - 1) * (sorted.size() / 2); i < (quartile) * (sorted.size() / 2); i++) {
			totalCount++;
			if (sorted.get(i).isCorrect()) {
				correctCount++;
			}
		}

		return correctCount * 100 / totalCount;

	}

}
