import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {

	public ReadWrite() {
		this.files = new ArrayList<>();
		this.notes = new ArrayList<>();
	}

	public ReadWrite(String _files, String _notes) {
		this.files = new ArrayList<>();
		this.notes = new ArrayList<>();

		this.readFiles(_files);
		this.readNotes(_notes);
	}

	public void readFiles(String _files) {
		try {
			File infile = new File(_files);
			Scanner reader = new Scanner(infile);

			while (reader.hasNextLine()) {
				String file = reader.nextLine();
				this.files.add(file);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readNotes(String _notes) {
		try {
			File infile = new File(_notes);
			Scanner reader = new Scanner(infile);

			while (reader.hasNext()) {
				MetaData temporary = new MetaData();

				temporary.setName(reader.next());
				temporary.setA(reader.next());
				temporary.setB(reader.next());
				temporary.setC(reader.next());
				temporary.setD(reader.next());

				notes.add(temporary);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void splitNotes() {
		ArrayList<MetaData> testSet = new ArrayList<>();
		ArrayList<MetaData> trainSet = new ArrayList<>();
		
		for (int f = 0, n = 0; f < this.files.size() && n < this.notes.size(); n++) {
			if(this.notes.get(n).getName().equals(this.files.get(f))) {
				trainSet.add(this.notes.get(n));
				f++;
			} else {
				testSet.add(this.notes.get(n));
			}
		}
		
		try {
			PrintWriter testWriter = new PrintWriter("annotations_ProbeImages.txt", "UTF-8");
			for(MetaData data : testSet) {
				testWriter.println(data.toString());
			}
			testWriter.close();
			
			PrintWriter trainWriter = new PrintWriter("annotations_GalleryImages.txt", "UTF-8");
			for(MetaData data : trainSet) {
				trainWriter.println(data.toString());
			}
			trainWriter.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
	}

	private ArrayList<MetaData> notes = null;
	private ArrayList<String> files = null;
}
