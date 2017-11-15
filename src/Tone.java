import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

//I had tutoring from Nate Williams with this code
public class Tone {

	public static final AudioFormat af = new AudioFormat(Note1.SAMPLE_RATE, 8, 1, true, false);

	// constructor for Tone
	public Tone(AudioFormat af2) {

	}

	// main method
	public static void main(String[] args) throws Exception {
		List<BellNote> music = null;
		if (args.length == 0) {
			System.out.println("No music provided");
			return;
		}
		music = loadMusic(args[0]);

		if (!validateData(music)) {
			System.err.println("music not valid");
			System.exit(-1);
		}
		final AudioFormat af = new AudioFormat(Note1.SAMPLE_RATE, 8, 1, true, false);
		Tone t = new Tone(af);
		t.playSong(music);

	}

	// method that will open the file and start the song(but needs the method
	// playNote as well)
	void playSong(List<BellNote> song) throws LineUnavailableException {
		try (final SourceDataLine line = AudioSystem.getSourceDataLine(af)) {
			line.open();
			line.start();

			for (BellNote bn : song) {
				playNote(line, bn);
			}
			line.drain();
		}
	}

	// method that plays the BellBote as well as controls the speed
	private void playNote(SourceDataLine line, BellNote bn) {
		final int ms = Math.min(bn.length.timeMs(), Note1.MEASURE_LENGTH_SEC * 1000);
		final int length = Note1.SAMPLE_RATE * ms / 1000;
		line.write(bn.note.sample(), 0, length);
		line.write(Note1.REST.sample(), 0, 50);
	}

	// method to validateData the Notes if they are invalid then they will get a
	// message that the note or the length is invalid
	private static boolean validateData(List<BellNote> music) {
		boolean success = true;

		for (BellNote bellNote : music) {
			if (bellNote == null) {
				System.err.println("Error: Invalid Bell Note");
				success = false;
			} else {
				if (bellNote.note == null) {
					System.err.println("Error: BellNote note is invalid");
					success = false;
				}
				if (bellNote.length == null) {
					System.err.println("Error: BellNote length is invalid");
					success = false;
				}

			}

		}
		return success;
	}

	// an array of music it will try the file reader and the buffer reader if it
	// can play it will
	private static List<BellNote> loadMusic(String filename) {
		final List<BellNote> music = new ArrayList<>();
		final File file = new File(filename);
		if (file.exists()) {
			try (FileReader fileReader = new FileReader(file); BufferedReader br = new BufferedReader(fileReader)) {
				String line = null;
				while ((line = br.readLine()) != null) {
					BellNote bn = parseBellNote(line);
					if (bn != null) {
						music.add(bn);
					} else {
						System.err.println("Error: Invalid move '" + line + "'");
					}
				}
			} catch (IOException ignored) {
			}
		} else {
			System.err.println("File '" + filename + "' not found");
		}
		return music;

	}

	// BellNote parse Note is what I call when I check fields 0 and 1
	private static BellNote parseBellNote(String line) {
		String[] fields = line.split("\\s+");
		if (fields.length == 2) {
			return new BellNote(parseNote1(fields[0]), parseNoteLength(fields[1]));
		}
		return null;
	}

	// method to parse the NoteLength//switch for the NoteLength/these are the
	// acceptable note lengths/ if invalid return null
	private static NoteLength parseNoteLength(String noteLength) {
		if (noteLength == null) {
			return null;
		}
		switch (noteLength.toUpperCase().trim()) {
		case "1":
			return NoteLength.WHOLE;

		case "2":
			return NoteLength.HALF;

		case "4":
			return NoteLength.QUARTER;

		case "8":
			return NoteLength.EIGTH;

		default:
			return null;
		}
		// return null;
	}

	// if statement that if the symbol is not valid then return null
	private static Note1 parseNote1(String symbol) {

		if (symbol == null) {
			return null;
		}
		// switch statement for the notes, and changes them to UpperCase if they
		// are not already/ return null if invalid
		switch (symbol.toUpperCase().trim()) {
		case "A5":
			return Note1.A5;

		case "A4":
			return Note1.A4;

		case "A4S":
			return Note1.A4S;

		case "B4":
			return Note1.B4;

		case "C4":
			return Note1.C4;

		case "C4S":
			return Note1.C4S;

		case "D4":
			return Note1.D4;

		case "D4S":
			return Note1.D4S;

		case "E4":
			return Note1.E4;

		case "F4":
			return Note1.F4;

		case "F4S":
			return Note1.F4S;

		case "G4":
			return Note1.G4;

		case "G4S":
			return Note1.G4S;

		default:
			return null;
		}
	}

	String filename = "MaryLamb.txt";

}
