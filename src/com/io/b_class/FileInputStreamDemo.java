package com.io.b_class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author y15079
 * @create 2017-11-02 17:05
 * @desc
 **/
public class FileInputStreamDemo {

	public static void main(String[] args) {
		try {
			//使用FileInputStream和FileOutputStream进行文件复制
			FileInputStream fis=new FileInputStream("resources/file.txt");
			FileOutputStream fos=new FileOutputStream("resources/file1.txt");

			int read;
			byte[] b=new byte[1024];
			//读取文件，存入字节数组b,返回读取到的字符数，存入read，默认每次将将b数组装满
			/*read=fis.read(b);*/
			while ((read=fis.read(b))!=-1){
				fos.write(b, 0 ,read);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
