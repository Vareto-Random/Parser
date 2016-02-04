import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {

	public static void main(String[] args) {
		if (args.length == 1) {
			String path = "/Users/Vareto/Documents/Datasets/RPV/FacialLandmarks/dlib/";
			String fileName = args[0];

			try {
				File file = new File(fileName);
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document doc = builder.parse(file);

				String imageFile;

				NodeList imageList = doc.getElementsByTagName("image");
				for (int imageIndex = 0; imageIndex < imageList.getLength(); imageIndex++) {
					Node imageNode = imageList.item(imageIndex);

					if (imageNode.getNodeType() == Node.ELEMENT_NODE) {
						Element imageElement = (Element) imageNode;
						imageFile = imageElement.getAttribute("file");

						NodeList boxList = imageElement.getChildNodes();
						for (int boxIndex = 0; boxIndex < boxList.getLength(); boxIndex++) {
							Node boxNode = boxList.item(boxIndex);

							if (boxNode.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println(path + imageFile);
								Element boxElement = (Element) boxNode;

								NodeList partList = boxElement.getChildNodes();
								for (int partIndex = 0; partIndex < partList.getLength(); partIndex++) {
									Node partNode = partList.item(partIndex);

									if (partNode.getNodeType() == Node.ELEMENT_NODE) {
										Element partElement = (Element) partNode;

										System.out.println(
												partElement.getAttribute("x") + " " + partElement.getAttribute("y"));
									}

								}
							}

						}

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("No parameter was set.");
		}
	}
}
