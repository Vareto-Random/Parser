import java.util.ArrayList;


public class Parser {

	public static void main(String[] args) {

		ArrayList<FaceBox> boxes;
		ArrayList<FaceLandmark> landmarks;
		
		ReadWrite gallery = new ReadWrite("notes_GalleryImages.txt", "matlab_GalleryImages.txt");
		ReadWrite probe = new ReadWrite("notes_ProbeImages.txt", "matlab_ProbeImages.txt");
		
		boxes = gallery.getBoxes();
		landmarks = gallery.getLandmarks();

		if (boxes.size() == landmarks.size()) {
			ReadWrite.saveXML(boxes, landmarks, "training_with_face_landmarks.xml");
		}
		
		boxes = probe.getBoxes();
		landmarks = probe.getLandmarks();
		
		if (boxes.size() == landmarks.size()) {
			ReadWrite.saveXML(boxes, landmarks, "testing_with_face_landmarks.xml");
		}
	}
}
