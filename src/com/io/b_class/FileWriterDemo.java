package com.io.b_class;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author y15079
 * @create 2017-11-03 13:21
 * @desc
 **/
public class FileWriterDemo {

	public static void main(String[] args) throws Exception{
		FileWriter fw=null;
		try {
			fw=new FileWriter("resources/file.txt");
			fw.write("hello world!");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			if (fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败！");
				}
		}
		fw.close();
	}
}
