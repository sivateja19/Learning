package com.siva.xmlplay;

import java.io.File;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ObjectToXML {

	public static void main(String[] args) {
		Data data = new Data();
		HashMap<String, Data> hm = new HashMap<String, Data>();
		hm.put(data.student1().id, data.student1());
		hm.put(data.student2().id, data.student2());
		hm.put(data.student3().id, data.student3());
		createXML(hm,data);
	}

	private static void createXML(HashMap<String, Data> hm,Data data) {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.newDocument();
			Element Students=doc.createElement("Students");
			doc.appendChild(Students);
			Element Student1=doc.createElement("Student");
			Students.appendChild(Student1);
//			Attr attr=doc.createAttribute("id");
	//		Student.setAttributeNode(attr);
			Student1.setAttribute("id", data.student1().id);
			Element name1=doc.createElement("name");
			Student1.appendChild(name1);
			name1.setTextContent(data.student1().name);
			for(int i=0;i<data.student1().subject.length;i++){
			Element subject1=doc.createElement("Subject");
			Student1.appendChild(subject1);
			subject1.setAttribute("subjectname", data.student1().subject[i]);
			Element marks=doc.createElement("Marks");
			subject1.appendChild(marks);
			marks.setTextContent(Integer.toString(data.student1().marks[i]));
			}
			Element Student2=doc.createElement("Student");
			Students.appendChild(Student2);
//			Attr attr=doc.createAttribute("id");
	//		Student.setAttributeNode(attr);
			Student2.setAttribute("id", data.student2().id);
			Element name2=doc.createElement("name");
			Student2.appendChild(name2);
			name2.setTextContent(data.student2().name);
			for(int i=0;i<data.student2().subject.length;i++){
			Element subject2=doc.createElement("Subject");
			Student2.appendChild(subject2);
			subject2.setAttribute("subjectname", data.student2().subject[i]);
			Element marks2=doc.createElement("Marks");
			subject2.appendChild(marks2);
			marks2.setTextContent(Integer.toString(data.student2().marks[i]));
			}
			Element Student3=doc.createElement("Student");
			Students.appendChild(Student3);
//			Attr attr=doc.createAttribute("id");
	//		Student.setAttributeNode(attr);
			Student3.setAttribute("id", data.student3().id);
			Element name3=doc.createElement("name");
			Student3.appendChild(name3);
			name3.setTextContent(data.student3().name);
			for(int i=0;i<data.student3().subject.length;i++){
			Element subject3=doc.createElement("Subject");
			Student3.appendChild(subject3);
			Attr nameattr=doc.createAttribute("subjectname");
			nameattr.setValue(data.student3().subject[i]);
			subject3.setAttributeNode(nameattr);
//			subject3.setAttribute("name", data.student3().subject[i]);
			Element marks3=doc.createElement("Marks");
			subject3.appendChild(marks3);
			marks3.setTextContent(Integer.toString(data.student3().marks[i]));
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\Users\\a522014\\workspace\\Learning\\Studentmarks.xml"));
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
