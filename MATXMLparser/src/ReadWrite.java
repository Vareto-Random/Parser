import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	
	@SuppressWarnings("rawtypes")
	public static final void saveXML (ArrayList<FaceBox> _boxes, ArrayList<FaceLandmark> _landmarks, String outputFile) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// dataset
			Document doc = docBuilder.newDocument();
			Element dataset = doc.createElement("dataset");
			doc.appendChild(dataset);

			// images
			Element images = doc.createElement("images");
			dataset.appendChild(images);
			
			for(int outer = 0; outer < _boxes.size(); outer++) {
				FaceBox temporaryBox = _boxes.get(outer);
				FaceLandmark temporaryLandmark = _landmarks.get(outer);
				
				// image
				Element image = doc.createElement("image");
				images.appendChild(image);
				
				// set attribute to image element
				Attr imageAttr = doc.createAttribute("file");
				imageAttr.setValue(temporaryBox.getName());
				image.setAttributeNode(imageAttr);
				
				// box
				Element box = doc.createElement("box");
				image.appendChild(box);
				
				// set attribute to box element
				Attr boxtopAttr = doc.createAttribute("left");
				boxtopAttr.setValue(temporaryBox.getA());
				box.setAttributeNode(boxtopAttr);
				
				Attr boxleftAttr = doc.createAttribute("top");
				boxleftAttr.setValue(temporaryBox.getB());
				box.setAttributeNode(boxleftAttr);

				Attr boxheightAttr = doc.createAttribute("width");
				boxheightAttr.setValue(temporaryBox.getC());
				box.setAttributeNode(boxheightAttr);

				Attr boxwidthAttr = doc.createAttribute("height");
				boxwidthAttr.setValue(temporaryBox.getD());
				box.setAttributeNode(boxwidthAttr);
				
				
				ArrayList<Pair> temporaryPoints = temporaryLandmark.getPoints();
				for(int inner = 0; inner < temporaryPoints.size(); inner++) {
					// part
					Element part = doc.createElement("part");
					box.appendChild(part);

					// set attribute to image element
					Attr partAttr_name = doc.createAttribute("name");
					partAttr_name.setValue(Integer.toString(inner));
					part.setAttributeNode(partAttr_name);

					Attr partAttr_X = doc.createAttribute("x");
					partAttr_X.setValue( String.valueOf( (int) ((double) temporaryPoints.get(inner).getA())) );
					part.setAttributeNode(partAttr_X);

					Attr partAttr_Y = doc.createAttribute("y");
					partAttr_Y.setValue( String.valueOf( (int) ((double) temporaryPoints.get(inner).getB())) );
					part.setAttributeNode(partAttr_Y);
				}

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(outputFile));

			transformer.transform(source, result);
			System.out.println(outputFile + " file saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
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
