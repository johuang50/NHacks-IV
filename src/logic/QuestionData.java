package logic;

public class QuestionData implements Comparable<QuestionData> {
	private int number;
	private boolean correct = true;
	private long timeSpent, timeStamp; // durations are in milliseconds

	public QuestionData(int number) {
		this.number = number;
		timeStamp = System.currentTimeMillis();

	}

	public QuestionData(int number, long initialTime) {
		timeStamp = initialTime;
		this.number = number;
	}

	public void calculateDuration(long endTime) {
		timeSpent = endTime - timeStamp;
	}

	public long getTimestamp() {
		return timeStamp;
	}

	public int getNumber() {
		return number;
	}

	public long getDuration() {
		return timeSpent;
	}

	public boolean isCorrect() {
		return correct;
	}
	
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@Override
	public int compareTo(QuestionData arg0) {
		return (int) (getDuration() - arg0.getDuration());

	}
	
	

}
