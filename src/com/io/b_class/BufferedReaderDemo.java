package com.io.b_class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author y15079
 * @create 2017-09-28 17:27
 * @desc
 *
 * BufferedReader 是缓冲字符输入流。它继承于Reader。
 * BufferedReader 的作用是为其他字符输入流添加一些缓冲功能。
 *
 * 构造方法：BufferedReader br = new BufferReader(Reader in);
   主要方法：int read();//读取单个字符。
   int read(char[] buf,int off,int len);//将字符读入到数组的某一部分。返回读取的字符数。达到尾部 ，返回-1。
   String readLine();                    //读取一个文本行。
   void close();                         //关闭该流。并释放与该流相关的所有资源。
 *
 * http://blog.csdn.net/liuhenghui5201/article/details/8279557
 **/
public class BufferedReaderDemo {
     private static final int LEN=5;

	public static void main(String[] args) {
		testBufferedReader();
	}

	/**
	 * BufferedReader的API测试函数
	 */
	private static void testBufferedReader(){
		//创建BufferedReader字符流，内容是ArrayLetters数组
		try {
			File file=new File("D:\\IDEA\\JavaIODemo\\resources\\bufferedInputStream.txt");
			BufferedReader in=new BufferedReader(new FileReader(file));
			//从字符流中读取5个字符。"abcde"
			for (int i=0;i<LEN;i++){
				//若能继续读取下一个字符，则读取下一个字符
				if (in.ready()){
					//读取"字符流的下一个字符"
					int tmp=in.read();
					System.out.printf("%d : %c\n",i,tmp);
				}
			}

			//若"字符流"不支持标记功能，则直接退出
			if (!in.markSupported()){
				System.out.printf("make not supported!");
				return;
			}

			// 标记“当前索引位置”，即标记第6个位置的元素--“f”
			// 1024对应marklimit
			in.mark(1024);
			// 跳过22个字符。
			in.skip(22);
			// 读取5个字符
			char[] buf = new char[LEN];
			in.read(buf, 0, LEN);
			System.out.printf("buf=%s\n", String.valueOf(buf));
			// 读取该行剩余的数据
			System.out.printf("readLine=%s\n", in.readLine());
			// 重置“输入流的索引”为mark()所标记的位置，即重置到“f”处。
			in.reset();
			// 从“重置后的字符流”中读取5个字符到buf中。即读取“fghij”
			in.read(buf, 0, LEN);
			System.out.printf("buf=%s\n", String.valueOf(buf));
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
