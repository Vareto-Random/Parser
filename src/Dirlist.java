import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dirlist {
	public Dirlist() {
		this.stringSet = new ArrayList<>();
	}

	public final ArrayList<String> readDirlist(String fileName) {
		if (stringSet == null) {
			stringSet = new ArrayList<>();
		}
		
		try {
			File infile = new File(fileName);
			Scanner reader = new Scanner(infile);

			while (reader.hasNextLine()) {
				String name = reader.nextLine();
				stringSet.add(name);
				System.out.println(name);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return stringSet;
	}

	private ArrayList<String> stringSet;
}
