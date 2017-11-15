// an enum of note lengths that are acceptable
public enum NoteLength {

	WHOLE(1.0f), HALF(0.5f), QUARTER(0.25f), EIGTH(0.125f);

	private final int timeMs;

	// constructor for NoteLength
	private NoteLength(float length) {
		timeMs = (int) (length * Note1.MEASURE_LENGTH_SEC * 1000);
	}

	// method to return time in Milliseconds
	public int timeMs() {
		return timeMs;
	}
}
