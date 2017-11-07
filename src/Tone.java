import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;



public class Tone{

	
	public static final AudioFormat af = new AudioFormat(Note.SAMPLE_RATE, 8, 1, true, false);
	
	public static void main(String[] args) throws Exception {
	
	
		//Tone t = new Tone(af);
		//Note1 note1 = new Note1();		// t.playSong(song);
	}

//	private final AudioFormat af;
//
//	Tone(AudioFormat af) {
//		this.af = af;
//	
	//}

	// BellNote parse Note is what I call when I check it
/*	private static BellNote parseBellNote(String line) {
		String[] fields = line.split("\\s+");
		if (fields.length == 2) {
			return new BellNote(BellNote(fields[0]), parseNote(fields[1]));
		}
		return null;
	}*/

	//// List for the BellNote
	    /*List<BellNote> load(String filename) {
		final List<BellNote> music = new ArrayList<>();*/
	String filename = "MaryLamb.txt";
	
	
		
		
		ArrayList<String> arr = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String currentLine;
			While ((currentLine = br.readLine()) != null) { 
				arr.add(currentLine);
			}
		}catch (IOException e) {
		System.out.println("can't find the file");
			}
		private void While(boolean b) {
			
			
		}

		
				/*try (FileReader fileReader = new FileReader(file); BufferedReader br = new BufferedReader(fileReader)) {
				String line = null;
				while ((line = br.readLine()) != null) {
					BellNote bn = parseBellNote(line);
					if (bn != null) {
						music.add(bn);
					} else {
						System.err.println("Error: Invalid note '" + line + "'");
					}
				}
			}*/
			
		
//			} catch (IOException ignored) {
//			}
//		} else {
//			System.err.println("File '" + filename + "' not found");
//		}
//		return music;
//	}

	// parseNote try and catch
//	private static int parseNote(String num) {
//		try {
//			return Integer.parseInt(num);
//		} catch (NumberFormatException ignored) {
//		
//		return 0;}
	

	// do I need other classes or can I work with what I have///I have red in my
	// build file
	///////////////////////////// not sure what is wrong with parseNoteLength/
/*	private static int parseNoteLength(String num) {
       
		while (noteLength == null) {
            return noteLength.INVALID;
        }
*/
	// method for playing the song
/*	void playSong(List<BellNote> song) throws LineUnavailableException {
		try (final SourceDataLine line = AudioSystem.getSourceDataLine(af)) {
			line.open();
			line.start();

			for (BellNote bn : song) {
				playNote(line, bn);
			}
			line.drain();
		}
	}*/
/// you NEED THIS!!!!
//	private void playNote(SourceDataLine line, BellNote bn) {
//		final int ms = Math.min(bn.length.timeMs(), Note.MEASURE_LENGTH_SEC * 1000);
//		final int length = Note.SAMPLE_RATE * ms / 1000;
//		line.write(bn.note.sample(), 0, length);
//		line.write(Note.REST.sample(), 0, 50);
//	}

	


\\}




