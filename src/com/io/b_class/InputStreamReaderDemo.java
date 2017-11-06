package com.io.b_class;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author y15079
 * @create 2017-11-03 15:54
 * @desc
 *
 *InputStreamReader 将字节流转换为字符流。是字节流通向字符流的桥梁。如果不指定字符集编码，该解码过程将使用平台默认的字符编码，如：GBK。
 *
 * 主要方法：
   int read();//读取单个字符。
   int read(char []cbuf);//将读取到的字符存到数组中。返回读取的字符数。
 *
 **/
public class InputStreamReaderDemo {

	public static void main(String[] args) throws Exception {
			transReadNoBuf();
			System.out.println();
			transReadByBuf();
	}

	public static void transReadNoBuf() throws Exception{
		/**
		 * 没有缓冲区，只能使用read()方法。
		 */
		//读取字节流
        //InputStream in = System.in;//读取键盘的输入。

		InputStream in =new FileInputStream("file.txt");

		//将字节流向字符流的转换，要启用从字节到字符的有效转换，可以提前从底层流读取更多的字节。
		InputStreamReader isr=new InputStreamReader(in);//读取

		char[] cha=new char[1024];
		int len=isr.read(cha);
		System.out.println(new String(cha,0,len));
		isr.close();
	}

	public static void transReadByBuf() throws Exception{
		/*
		 * 使用缓冲区可以使用缓冲区对象的read() 和 readLine()方法。
		 * */
		//读取字节流
		//InputStream in=System.in;//读取键盘上的数据
		InputStream in=new FileInputStream("file.txt");//读取文件上的数据
		//将字节流向字符流的转换
		InputStreamReader isr=new InputStreamReader(in);//读取
		//创建字符流缓冲区
		BufferedReader bufr=new BufferedReader(isr);//缓冲

		String line=null;
		while ((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		isr.close();

	}
}
