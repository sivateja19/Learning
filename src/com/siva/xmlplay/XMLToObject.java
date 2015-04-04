package com.siva.xmlplay;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class XMLToObject {

	public static void main(String args[]) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("Students.xml");
			NodeList studentslist = doc.getElementsByTagName("Student");
			for (int i = 0; i < studentslist.getLength(); i++) {
				Node node=studentslist.item(i);
				Element element= (Element) node;	
				NodeList student=element.getChildNodes();
				for(int j=0;j<student.getLength();j++){
					Node studentnode=student.item(j);
					if(studentnode.getNodeType()==Node.ELEMENT_NODE){
					Element studentelement=(Element) studentnode;
					if(studentelement.getTagName()=="id"|| studentelement.getTagName()=="name"){
					System.out.println(studentelement.getTagName()+" : "+studentelement.getTextContent());
					}
					if(studentelement.getTagName()=="marks"){
						NodeList marklist= studentelement.getChildNodes();
						for(int k=0;k<marklist.getLength();k++){
							Node marks=marklist.item(k);
							if(marks.getNodeType()==Node.ELEMENT_NODE){
							Element markselement=(Element) marks;
							System.out.println(markselement.getTagName()+" : "+markselement.getAttribute("subject")+" : "+markselement.getTextContent());
							}
						}	
					}
					
				}
			}
					
				}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
