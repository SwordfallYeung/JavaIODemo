package com.io.b_class;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author y15079
 * @create 2017-09-29 9:08
 * @desc Java ByteArrayOutputStream 内存输出流
 *
 * 此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据
 *
 * 方法	说明
   write(int b)	将指定的字节写入此 byte 数组输出流
   write(byte[] b, int off, int len)	将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte 数组输出流
   toByteArray()	创建一个新分配的 byte 数组
   toString()	使用平台默认的字符集，通过解码字节将缓冲区内容转换为字符串
   toString(String charsetName)	使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
 *
 *
 *
 **/
public class ByteArrayOutputStreamDemo {
	static FileInputStream input = null;

	public static void main(String[] args) throws Exception{
		try {
			//创建输入流和内存输出流
			input=new FileInputStream("D:\\IDEA\\JavaIODemo\\resources\\bufferedInputStream2.txt");
			ByteArrayOutputStream output=new ByteArrayOutputStream();

			int b;
			//从文件读取数据，并写入到内存缓冲区中
			while ((b=input.read())>0){
				output.write(b);
			}

			//第一种获得数据的方式，调用toByteArray方法，返回内存中的数据
			byte[] bytes=output.toByteArray();
			System.out.println(new String(bytes));

			//第二种获得数据的方式：调用toString方法，将内存中的数据解码成字符串
			String content=output.toString();
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				// 关闭输入流
				if(input != null) {
					input.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
