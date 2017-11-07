package com.io.b_class;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author y15079
 * @create 2017-11-07 9:33
 * @desc
 *
 * SequenceInputStream合并流
 *
 * public SequenceInputStream(Enumeration<? extends InputStream> e)
	通过记住参数来初始化新创建的 SequenceInputStream，该参数必须是生成运行时类型为 InputStream 对象的 Enumeration 型参数。
    将按顺序读取由该枚举生成的输入流，以提供从此 SequenceInputStream 读取的字节。
    在用尽枚举中的每个输入流之后，将通过调用该流的 close 方法将其关闭。
	参数：
	e - 输入流的一个枚举。
	另请参见：
	Enumeration
	SequenceInputStream

 * public SequenceInputStream(InputStream s1,InputStream s2)
	通过记住这两个参数来初始化新创建的 SequenceInputStream（将按顺序读取这两个参数，先读取 s1，然后读取 s2），以提供从此 SequenceInputStream 读取的字节。
	参数：
	s1 - 要读取的第一个输入流。
	s2 - 要读取的第二个输入流。
 **/
public class SequenceInputStreamDemo {

	public static void main(String[] args) throws Exception {
//		test1();
		test2();
	}

	public static void test1() throws Exception{
		Vector<FileInputStream> v=new Vector<FileInputStream>();

		v.add(new FileInputStream("resources/file.txt"));
		v.add(new FileInputStream("resources/file1.txt"));
		v.add(new FileInputStream("resources/file2.txt"));

		Enumeration<FileInputStream> en=v.elements();

		SequenceInputStream sis=new SequenceInputStream(en);

		FileOutputStream fos=new FileOutputStream("resources/file3.txt");
		byte[] buf=new byte[1024];
		int len=0;
		while ((len=sis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}

	public static void test2() throws Exception{
		InputStream is1=null;
		InputStream is2=null;
		OutputStream os=null;
		SequenceInputStream sis=null;
		is1=new FileInputStream("resources/file.txt");
		is2=new FileInputStream("resources/file1.txt");
		os=new FileOutputStream("resources/file3.txt");
		sis=new SequenceInputStream(is1,is2);
		int temp=0;
		while ((temp=sis.read())!=-1){
			os.write(temp);
		}
		sis.close();
		is1.close();
		is2.close();
		os.close();
	}
}
