package com.siva.xmlplay;

public class Data {
	String id;
	String name;
	String[] subject=new String[2];
	int[] marks=new int[2];

	public Data student1() {
		Data data = new Data();
		data.id = "1";
		data.name ="siva";
		data.subject[0]="English";
		data.subject[1]="Science";
		data.marks[0] = 98;
		data.marks[1] = 100;
		
		return data;
	}

	public Data student2() {
		Data data = new Data();
		data.id = "2";
		data.name = "teja";
		data.subject[0] = "English";
		data.subject[1] = "Science";
		data.marks[0] = 95;
		data.marks[1] = 96;
		
		return data;
	}

	public Data student3() {
		Data data = new Data();
		data.id = "3";
		data.name = "sivateja";
		data.subject[0] = "English";
		data.subject[1] = "Science";
		data.marks[0] = 92;
		data.marks[1] = 80;
		return data;
	}
}
