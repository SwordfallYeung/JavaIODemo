package com.io.b_class;

import java.io.FileReader;

/**
 * @author y15079
 * @create 2017-11-03 11:14
 * @desc
 *
 *  1，构造方法
	  FileReader fr = new FileReader(String fileName);//使用带有指定文件的String参数的构造方法。创建该输入流对象。并关联源文件。
	2，主要方法
      int read(); // 读取单个字符。返回作为整数读取的字符，如果已达到流末尾，则返回 -1。
      int read(char []cbuf);//将字符读入数组。返回读取的字符数。如果已经到达尾部，则返回-1。
      void close();//关闭此流对象。释放与之关联的所有资源。
 *
 **/
public class FileReaderDemo {

	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("resources/file.txt");
		/**
		 * 用Reader中的read方法读取字符char。
		 */
		/*int ch=fr.read();
		System.out.println(ch+" "+(char)ch);
		int ch1=fr.read();
		System.out.println(ch1+" "+(char)ch1);
		int ch2=fr.read();
		System.out.println(ch2+" "+(char)ch2);*/
		int ch=0;
		while ((ch=fr.read())!=-1){
			System.out.println((char)ch);
		}
		fr.close();

	}
}
