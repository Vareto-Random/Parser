import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Splitting {

	public static Document SplittingLeft(String path, Document doc)
			throws FileNotFoundException, UnsupportedEncodingException {

		NodeList imageList = doc.getElementsByTagName("image");
		for (int imageIndex = 0; imageIndex < imageList.getLength(); imageIndex++) {
			Node imageNode = imageList.item(imageIndex);

			if (imageNode.getNodeType() == Node.ELEMENT_NODE) {
				Element imageElement = (Element) imageNode;

				NodeList boxList = imageElement.getChildNodes();
				for (int boxIndex = 0; boxIndex < boxList.getLength(); boxIndex++) {
					Node boxNode = boxList.item(boxIndex);

					if (boxNode.getNodeType() == Node.ELEMENT_NODE) {
						Element boxElement = (Element) boxNode;

						NodeList partList = boxElement.getChildNodes();
						for (int partIndex = 0; partIndex < partList.getLength(); partIndex++) {
							Node partNode = partList.item(partIndex);

							if (partNode.getNodeType() == Node.ELEMENT_NODE) {
								Element leftElement = (Element) partNode;

								String element = leftElement.getAttribute("name");
								switch (element) {

								// left face outline
								case "00":
									leftElement.setAttribute("name", "00");
									break;
								case "01":
									leftElement.setAttribute("name", "01");
									break;
								case "02":
									leftElement.setAttribute("name", "02");
									break;
								case "03":
									leftElement.setAttribute("name", "03");
									break;
								case "04":
									leftElement.setAttribute("name", "04");
									break;
								case "05":
									leftElement.setAttribute("name", "05");
									break;
								case "06":
									leftElement.setAttribute("name", "06");
									break;
								case "07":
									leftElement.setAttribute("name", "07");
									break;
								case "08":
									leftElement.setAttribute("name", "08");
									break;

								// left eyebrow
								case "17":
									leftElement.setAttribute("name", "09");
									break;
								case "18":
									leftElement.setAttribute("name", "10");
									break;
								case "19":
									leftElement.setAttribute("name", "11");
									break;
								case "20":
									leftElement.setAttribute("name", "12");
									break;
								case "21":
									leftElement.setAttribute("name", "13");
									break;

								// left nose part
								case "27":
									leftElement.setAttribute("name", "14");
									break;
								case "28":
									leftElement.setAttribute("name", "15");
									break;
								case "29":
									leftElement.setAttribute("name", "16");
									break;
								case "30":
									leftElement.setAttribute("name", "17");
									break;
								case "31":
									leftElement.setAttribute("name", "20");
									break;
								case "32":
									leftElement.setAttribute("name", "19");
									break;
								case "33":
									leftElement.setAttribute("name", "18");
									break;

								// left eye
								case "36":
									leftElement.setAttribute("name", "21");
									break;
								case "37":
									leftElement.setAttribute("name", "22");
									break;
								case "38":
									leftElement.setAttribute("name", "23");
									break;
								case "39":
									leftElement.setAttribute("name", "24");
									break;
								case "40":
									leftElement.setAttribute("name", "25");
									break;
								case "41":
									leftElement.setAttribute("name", "26");
									break;

								// left mouth part
								case "48":
									leftElement.setAttribute("name", "33");
									break;
								case "49":
									leftElement.setAttribute("name", "34");
									break;
								case "50":
									leftElement.setAttribute("name", "35");
									break;
								case "51":
									leftElement.setAttribute("name", "27");
									break;
								case "57":
									leftElement.setAttribute("name", "30");
									break;
								case "58":
									leftElement.setAttribute("name", "31");
									break;
								case "59":
									leftElement.setAttribute("name", "32");
									break;
								case "60":
									leftElement.setAttribute("name", "38");
									break;
								case "61":
									leftElement.setAttribute("name", "36");
									break;
								case "62":
									leftElement.setAttribute("name", "28");
									break;
								case "66":
									leftElement.setAttribute("name", "29");
									break;
								case "67":
									leftElement.setAttribute("name", "37");
									break;

								default:
									NamedNodeMap attrs = leftElement.getAttributes();
									while (attrs.getLength() > 0) {
										attrs.removeNamedItem(attrs.item(0).getNodeName());
									}
								}
							}
						}
					}
				}
			}
		}
		return doc;
	}

	public static Document SplittingRight(String path, Document doc)
			throws FileNotFoundException, UnsupportedEncodingException {

		NodeList imageList = doc.getElementsByTagName("image");
		for (int imageIndex = 0; imageIndex < imageList.getLength(); imageIndex++) {
			Node imageNode = imageList.item(imageIndex);

			if (imageNode.getNodeType() == Node.ELEMENT_NODE) {
				Element imageElement = (Element) imageNode;

				NodeList boxList = imageElement.getChildNodes();
				for (int boxIndex = 0; boxIndex < boxList.getLength(); boxIndex++) {
					Node boxNode = boxList.item(boxIndex);

					if (boxNode.getNodeType() == Node.ELEMENT_NODE) {
						Element boxElement = (Element) boxNode;

						NodeList partList = boxElement.getChildNodes();
						for (int partIndex = 0; partIndex < partList.getLength(); partIndex++) {
							Node partNode = partList.item(partIndex);

							if (partNode.getNodeType() == Node.ELEMENT_NODE) {
								Element rightElement = (Element) partNode;

								String element = rightElement.getAttribute("name");
								switch (element) {

								// right face outline
								case "08":
									rightElement.setAttribute("name", "08");
									break;
								case "09":
									rightElement.setAttribute("name", "07");
									break;
								case "10":
									rightElement.setAttribute("name", "06");
									break;
								case "11":
									rightElement.setAttribute("name", "05");
									break;
								case "12":
									rightElement.setAttribute("name", "04");
									break;
								case "13":
									rightElement.setAttribute("name", "03");
									break;
								case "14":
									rightElement.setAttribute("name", "02");
									break;
								case "15":
									rightElement.setAttribute("name", "01");
									break;
								case "16":
									rightElement.setAttribute("name", "00");
									break;

								// right eyebrow
								case "22":
									rightElement.setAttribute("name", "09");
									break;
								case "23":
									rightElement.setAttribute("name", "10");
									break;
								case "24":
									rightElement.setAttribute("name", "11");
									break;
								case "25":
									rightElement.setAttribute("name", "12");
									break;
								case "26":
									rightElement.setAttribute("name", "13");
									break;

								// right nose part
								case "27":
									rightElement.setAttribute("name", "14");
									break;
								case "28":
									rightElement.setAttribute("name", "15");
									break;
								case "29":
									rightElement.setAttribute("name", "16");
									break;
								case "30":
									rightElement.setAttribute("name", "17");
									break;
								case "33":
									rightElement.setAttribute("name", "18");
									break;
								case "34":
									rightElement.setAttribute("name", "19");
									break;
								case "35":
									rightElement.setAttribute("name", "20");
									break;

								// right eye
								case "42":
									rightElement.setAttribute("name", "21");
									break;
								case "43":
									rightElement.setAttribute("name", "22");
									break;
								case "44":
									rightElement.setAttribute("name", "23");
									break;
								case "45":
									rightElement.setAttribute("name", "24");
									break;
								case "46":
									rightElement.setAttribute("name", "25");
									break;
								case "47":
									rightElement.setAttribute("name", "26");
									break;

								// right mouth part
								case "51":
									rightElement.setAttribute("name", "27");
									break;
								case "52":
									rightElement.setAttribute("name", "35");
									break;
								case "53":
									rightElement.setAttribute("name", "34");
									break;
								case "54":
									rightElement.setAttribute("name", "33");
									break;
								case "55":
									rightElement.setAttribute("name", "32");
									break;
								case "56":
									rightElement.setAttribute("name", "31");
									break;
								case "57":
									rightElement.setAttribute("name", "30");
									break;
								case "62":
									rightElement.setAttribute("name", "28");
									break;
								case "63":
									rightElement.setAttribute("name", "36");
									break;
								case "64":
									rightElement.setAttribute("name", "38");
									break;
								case "65":
									rightElement.setAttribute("name", "37");
									break;
								case "66":
									rightElement.setAttribute("name", "29");
									break;

								default:
									NamedNodeMap attrs = rightElement.getAttributes();
									while (attrs.getLength() > 0) {
										attrs.removeNamedItem(attrs.item(0).getNodeName());
									}
									break;
								}
							}
						}
					}
				}
			}
		}
		return doc;
	}

	public static final void saveXML(Document doc, String outputFile) {
		try {
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(outputFile));

			transformer.transform(source, result);
			System.out.println(outputFile + " file saved!");

		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}
