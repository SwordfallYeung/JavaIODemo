package com.io.b_class;

import java.io.*;
import java.util.Scanner;

/**
 * @author y15079
 * @create 2017-09-28 16:52
 * @desc
 * BufferedOutputStream 是缓冲输出流。它继承于FilterOutputStream。 (处理字节流)
 *
 *
 * http://www.jb51.net/article/86993.htm
 **/
public class BufferedOutputStreamDemo {

	// 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
	private static final byte[] ArrayLetters = {
			0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
			0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
	};

	public static void main(String[] args) {
		testBufferedOutputStream();
	}

	/**
	 * BufferedOutputStream的API测试函数
	 */
	private static void testBufferedOutputStream() {
		// 创建“文件输出流”对应的BufferedOutputStream
		// 它对应缓冲区的大小是16，即缓冲区的数据>=16时，会自动将缓冲区的内容写入到输出流。
		try {
			File file = new File("D:\\IDEA\\JavaIODemo\\resources\\out.txt");
			if (file.exists()) file.delete();
			OutputStream out =
					new BufferedOutputStream(
							new FileOutputStream(file), 16);

			// 将ArrayLetters数组的前10个字节写入到输出流中
			out.write(ArrayLetters, 0, 10);
			// 将“换行符\n”写入到输出流中
			out.write('\n');

			//flush()操作，它的作用是将缓冲区的数据写入到输出流中。
			// TODO!
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
