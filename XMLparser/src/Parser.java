
import java.io.File;
import java.util.ArrayList;

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

@SuppressWarnings({ "unused", "rawtypes" })
public class Parser {

	private static final double INCREASE = 1.05;
	private static final double DECREASE = 0.95;

	public static void main(String[] args) {
		String path = args[0];

		Dirlist reader = new Dirlist();
		ArrayList<String> directory = reader.readDirlist(path + "dirlist.txt");

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

			Metadata info = new Metadata();
			for (String element : directory) {
				ArrayList<Double> distance = new ArrayList<>();
				ArrayList<Pair> landmarks = info.readMetadata(path + element + ".pts");

				for (int index = 0; index < landmarks.size() - 1; index++) {
					distance.add(Mathematics.distance2points(landmarks.get(index), landmarks.get(index + 1)));
				}
				double average = Mathematics.arrayAverage(distance);
				Pair min = Mathematics.minimumValues(landmarks);
				Pair max = Mathematics.maximumValues(landmarks);

				int left = (int) ((double) min.getA() * DECREASE);
				int top = (int) ((double) min.getB() * DECREASE);
				int right = (int) ((double) max.getA() * INCREASE);
				int bottom = (int) ((double) max.getB() * INCREASE);
				int height = bottom - top;
				int width = right - left;
				
				if(left < 1) {
					left = 1;
				}
				if(top < 1) {
					top = 1;
				}

				// image
				Element image = doc.createElement("image");
				images.appendChild(image);

				// set attribute to image element
				Attr imageAttr = doc.createAttribute("file");
				imageAttr.setValue(element + ".jpg");
				image.setAttributeNode(imageAttr);

				// box
				Element box = doc.createElement("box");
				image.appendChild(box);

				// set attribute to box element
				Attr boxtopAttr = doc.createAttribute("top");
				boxtopAttr.setValue(Integer.toString(top));
				box.setAttributeNode(boxtopAttr);
				
				Attr boxleftAttr = doc.createAttribute("left");
				boxleftAttr.setValue(Integer.toString(left));
				box.setAttributeNode(boxleftAttr);
				
				Attr boxwidthAttr = doc.createAttribute("width");
				boxwidthAttr.setValue(Integer.toString(width));
				box.setAttributeNode(boxwidthAttr);
				
				Attr boxheightAttr = doc.createAttribute("height");
				boxheightAttr.setValue(Integer.toString(height));
				box.setAttributeNode(boxheightAttr);

				for (int index = 0; index < landmarks.size(); index++) {
					// part
					Element part = doc.createElement("part");
					box.appendChild(part);

					// set attribute to image element
					Attr partAttr_name = doc.createAttribute("name");
					partAttr_name.setValue(Integer.toString(index));
					part.setAttributeNode(partAttr_name);

					Attr partAttr_X = doc.createAttribute("x");
					partAttr_X.setValue( String.valueOf( (int) ((double) landmarks.get(index).getA())) );
					part.setAttributeNode(partAttr_X);

					Attr partAttr_Y = doc.createAttribute("y");
					partAttr_Y.setValue( String.valueOf( (int) ((double) landmarks.get(index).getB())) );
					part.setAttributeNode(partAttr_Y);
				}

				landmarks.clear();
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("training_with_face_landmarks.xml"));

			transformer.transform(source, result);
			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
