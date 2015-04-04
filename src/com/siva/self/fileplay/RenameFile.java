package com.siva.self.fileplay;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class RenameFile {
	
	public static void main(String args[]) throws IOException{
		String filename="file.txt";
		String directory="C://Users//a522014//";
		int size=10485760;
		ByteBuffer bytebuf=ByteBuffer.allocateDirect(size);
		File oldfile, newfile;
		oldfile=new File(directory+"/"+filename);
		newfile=new File(directory+"/Processing_"+filename);
		boolean converted=oldfile.renameTo(newfile);
		if(converted){
			System.out.println("File is converted from"+oldfile+" to "+newfile);
		}
		else{
			System.out.println("not converted");
		}
		FileInputStream in=new FileInputStream(directory+"/Processing_"+filename);
		FileChannel ch=in.getChannel();
		System.out.println(ch);
		System.out.println(ch.size());
		System.out.println(ch.read(bytebuf));
		System.out.println(bytebuf.flip());
		System.out.println(bytebuf.position()+" "+bytebuf.limit()+" "+bytebuf.capacity());
		System.out.println(ch.position(2));
		String data="Sivateja mSest a guSy";
		System.out.println(data);
		String datas[]=data.split("S");
		for(int i=0;i<datas.length;i++){
			System.out.println(datas[i]);
			System.out.println(data.lastIndexOf("S"));
		}
		in.close();
	}
}
