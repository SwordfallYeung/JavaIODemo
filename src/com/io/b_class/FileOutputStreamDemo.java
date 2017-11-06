package com.io.b_class;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author y15079
 * @create 2017-11-02 18:42
 * @desc
 **/
public class FileOutputStreamDemo {

	public static void main(String[] args) {
		try {
			//向文件中写入字节数组
			String font="输出流是用来写入数据的！";
			FileOutputStream fos=new FileOutputStream("resources/FOSDemo.txt");
			fos.write(font.getBytes());
			//关闭此文件输出流并释放与此流有关的所有系统资源，此文件输出流不能再用于写入字节。
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
