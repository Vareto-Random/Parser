import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class Parser {
	
	public static void main(String[] args) {
		if (args.length == 1) {
			String path = "/Users/Vareto/Documents/Datasets/RPV/FaceLandmarks/dlib+icbrw/";
			String fileName = args[0];

			try {
				File file = new File(fileName);
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document docL = builder.parse(file);
				Document docR = builder.parse(file);
				
				Document docLeft = Splitting.SplittingLeft(path, docL);
				Splitting.saveXML(docLeft, "testing_with_face_landmarks_LEFT.xml");	
				
				Document docRight = Splitting.SplittingRight(path, docR);
				Splitting.saveXML(docRight, "testing_with_face_landmarks_RIGHT.xml");			
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("No parameter was set.");
		}
	}
}
