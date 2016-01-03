import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({"unused","rawtypes"})
public class Metadata {
	public Metadata() {
		this.points = new ArrayList<>();
	}

	public final ArrayList<Pair> readMetadata(String fileName) {
		try {
			this.file = fileName;

			File infile = new File(fileName);
			Scanner reader = new Scanner(infile);

			// version
			if (reader.hasNext()) {
				reader.next();
				this.version = reader.nextInt();
			}

			// numLandmarks
			if (reader.hasNext()) {
				reader.next();
				this.numPoints = reader.nextInt();
			}

			// skip {
			reader.next();

			// 68 points
			while (reader.hasNextDouble()) {
				Pair<Double, Double> tuple = new Pair<>(reader.nextDouble(), reader.nextDouble());
				this.points.add(tuple);
			}

			// skip }
			reader.next();

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return this.points;
	}

	private String file;
	private int version;
	private int numPoints;
	private ArrayList<Pair> points;
}
