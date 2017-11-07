package com.io.b_class;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author y15079
 * @create 2017-11-07 14:15
 * @desc
 **/
public class WriterDemo {
	public static void main(String[] args) throws Exception{
		File f2=new File("resources/hello.txt");
		FileWriter fw=new FileWriter(f2);
		fw.write("大家好，我是SwordFall");
//		fw.flush();
		fw.close();

		FileReader fr=new FileReader(f2);
		char [] cbuf=new char[1024]; //字符数组
		int len=fr.read(cbuf);
		System.out.println(new String(cbuf,0,len));
		fr.close();
	}
}
