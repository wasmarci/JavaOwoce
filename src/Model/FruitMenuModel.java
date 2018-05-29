package Model;

import java.util.LinkedList;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FruitMenuModel {
	
	// Lista dostêpnych owoców
	private LinkedList<Fruit> fruitList = new LinkedList<Fruit>();
	
	public LinkedList<Fruit> getFruitList() {
		return fruitList;
	}
	
	// tworzenie i dostêp do instancji
	private static FruitMenuModel instance = null;
	
	protected FruitMenuModel() {
		
		try {
			File fruitFile = new File("bin/Fruits.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document fruitDoc = dBuilder.parse(fruitFile);
			fruitDoc.getDocumentElement().normalize();
			NodeList list = fruitDoc.getElementsByTagName("fruit"); 
			
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i); 
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					fruitList.add(new Fruit(element.getAttribute("foto"), element.getAttribute("name")));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public static FruitMenuModel getInstance() {
		if (instance == null) {
			instance = new FruitMenuModel();
		}
		return instance;
	}
	
}
