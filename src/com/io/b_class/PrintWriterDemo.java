package com.io.b_class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author y15079
 * @create 2017-11-06 14:02
 * @desc
 *
 * PrintWriter
PrintWriter提供了PrintStream的所有打印方法，其方法也从不抛出IOException。
与PrintStream的区别：作为处理流使用时，PrintStream只能封装OutputStream类型的字节流，而PrintWriter既可以封装OutputStream类型的字节流，还能够封装Writer类型的字符输出流并增强其功能。
 *
 **/
public class PrintWriterDemo {
	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("resources/file.txt");
		BufferedReader br=new BufferedReader(fr);
		FileWriter fw=new FileWriter("resources/file1.txt");
		PrintWriter pw=new PrintWriter(fw);

		String s=br.readLine();
		while (null!=s){
			//PrintWriter的println方法 相当于
			//BufferedWriter 的write() + newLine()
			pw.println(s);
			s=br.readLine();
		}
		br.close();
		pw.close();
	}
}
