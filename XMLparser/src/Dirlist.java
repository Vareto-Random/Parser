import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dirlist {
	public Dirlist() {
		this.stringArray = new ArrayList<>();
	}

	public final ArrayList<String> readDirlist(String fileName) {
		if (this.stringArray == null) {
			this.stringArray = new ArrayList<>();
		}

		try {
			File infile = new File(fileName);
			Scanner reader = new Scanner(infile);

			while (reader.hasNextLine()) {
				String name = reader.nextLine();
				this.stringArray.add(name);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return this.stringArray;
	}

	private ArrayList<String> stringArray;
}
