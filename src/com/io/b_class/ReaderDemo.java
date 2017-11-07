package com.io.b_class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author y15079
 * @create 2017-11-07 9:19
 * @desc
 **/
public class ReaderDemo {
	public static void main(String[] args) {
		try {
			InputStream in=new FileInputStream("resources/file.txt");
			InputStreamReader reader=new InputStreamReader(in, Charset.forName("utf-8"));

			char[] buf=new char[100];
			int length=reader.read(buf);
			System.out.println("the length is "+length);

			for (int i=0;i<length;i++){
				System.out.println("char ["+i+"] is "+buf[i]);
			}

			System.out.println("the content is "+String.valueOf(buf,0,length));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
