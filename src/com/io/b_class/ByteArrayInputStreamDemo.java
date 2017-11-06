package com.io.b_class;

import java.io.ByteArrayInputStream;

/**
 * @author y15079
 * @create 2017-09-28 20:31
 * @desc
 *
 *  ByteArrayInputSteam类从内存中的字节数组中读取数据，因此它的数据源是一个字节数组。
 *  构造方法:
 *  ByteArrayInputStream(byte[] buf)--------参数buf指定字节数组类型的数据源。
 *  ByteArrayInputStream(byte[] buf, int offset, int lenght)-----参数buf指定字节数组类型数据源，
         参数offset指定从数组中开始读取数据的起始下标位置，lenght指定从数组中读取的字节数。
 * ByteArrayInputStream类本身采用了适配器设计模式，它把字节数组类型转换为输入流类型，使得程序能够对字节数组进行读操作。
 *
 *http://zzhangyx.iteye.com/blog/1530923
 **/
public class ByteArrayInputStreamDemo {
	public static void main(String[] args) throws Exception{
		byte[] buff=new byte[]{2,15,67,-1,-9,9};
		ByteArrayInputStream in=new ByteArrayInputStream(buff,1,4);
		int data;
		while ((data=in.read())!=-1){
			System.out.print(data + " ");
		}
		System.out.println();
		in.close();// ByteArrayInputSystem 的close()方法实际上不执行任何操作
	}
	// 以上字节数组输入流从字节数组buff的下标为1的元素开始读，一共读取4个元素。对于读到的每一个字节类型的元素，都会转换为int类型。
    // 例如：对于字节类型的15，二进制形式为00001111，转换为int类型的二进制形式为
    // 00000000 00000000 00000000 00001111,因此字节类型的15 转换为int类型仍然是15；对于字节类型的-1，二进制形式为 11111111，
	// 转换为int类型的二进制形式为 00000000 00000000 00000000 11111111 ,因此字节类型的-1 转换为int类型是255；对于字节类型的-9，二进制形式为 11110111,
	// 转换为int类型的二进制形式为 00000000 00000000 00000000 11110111, 因此字节类型的-9转换为 int类型是 247。
}
