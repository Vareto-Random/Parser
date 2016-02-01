import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {
	public ReadWrite() {
		this.boxes = new ArrayList<>();
		this.landmarks = new ArrayList<>();
	}

	public ReadWrite(String _notesFile, String _matlabFile) {
		this.boxes = new ArrayList<>();
		this.landmarks = new ArrayList<>();

		this.readAnnotations(_notesFile);
		this.readLandmarks(_matlabFile);
	}

	public void readAnnotations(String _notesFile) {
		try {
			File infile = new File(_notesFile);
			Scanner reader = new Scanner(infile);

			while (reader.hasNext()) {
				FaceBox temporary = new FaceBox();

				temporary.setName(reader.next());
				temporary.setA(reader.next());
				temporary.setB(reader.next());
				temporary.setC(reader.next());
				temporary.setD(reader.next());

				this.boxes.add(temporary);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readLandmarks(String _matlabFile) {
		try {
			File infile = new File(_matlabFile);
			Scanner reader = new Scanner(infile);

			while (reader.hasNext()) {
				FaceLandmark temporary = new FaceLandmark();

				temporary.setName(reader.next());
				while (reader.hasNextDouble()) {
					Pair<Double, Double> point = new Pair<>(reader.nextDouble(), reader.nextDouble());
					temporary.addPoints(point);
				}

				this.landmarks.add(temporary);
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public final ArrayList<FaceBox> getBoxes() {
		return boxes;
	}

	public final ArrayList<FaceLandmark> getLandmarks() {
		return landmarks;
	}

	private ArrayList<FaceBox> boxes;
	private ArrayList<FaceLandmark> landmarks;
}
