package com.io.b_class;

import java.io.*;

/**
 * @author y15079
 * @create 2017-11-06 14:00
 * @desc
 *
 * PrintStream
PrintStream在OutputStream基础之上提供了增强的功能，即可以方便地输出各种类型的数据（而不仅限于byte型）的格式化表示形式。
PrintStream的方法从不抛出IOEceptin
 **/
public class PrintStreamDemo {

	public static void main(String[] args) throws Exception{
		try {
			byte[] sim= {(byte)0xbc, (byte)0xf2, // 简
						(byte)0xcc, (byte)0xe5, // 体
						(byte)0xd6, (byte)0xd0, // 中
						(byte)0xce, (byte)0xc4}; // 文
			InputStreamReader inputStreamReader=new InputStreamReader(new ByteArrayInputStream(sim),"utf-8");
			PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(System.out,"utf-8"));
			PrintStream printStream=new PrintStream(System.out,true,"utf-8");

			int in;
			while ((in=inputStreamReader.read())!=-1){
				printWriter.println((char)in);
				printStream.println((char)in);
			}

			inputStreamReader.close();
			printWriter.close();
			printStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
