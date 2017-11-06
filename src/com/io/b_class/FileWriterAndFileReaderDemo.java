package com.io.b_class;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author y15079
 * @create 2017-11-03 13:29
 * @desc
 **/
public class FileWriterAndFileReaderDemo {

	public static void main(String[] args) throws Exception{
		FileReader fr=null;
		FileWriter fw=null;

		try {
			fr=new FileReader("file.txt");
			fw=new FileWriter("file1.txt");

			//读一个字符，写一个字符方法
		/*int ch=0;

		while ((ch=fr.read())!=-1){
			fw.write(ch);
		}*/

			char[] buf=new char[1024];
			int len=0;
			//读一个数组大小，写一个数组大小方法
			while((len=fr.read(buf))!=-1){
				fw.write(buf,0,len);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (Exception e2) {
					throw new RuntimeException("关闭失败！");
				}
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败！");
				}
		}


	}
}
