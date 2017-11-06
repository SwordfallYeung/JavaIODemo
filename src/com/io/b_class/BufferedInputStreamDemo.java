package com.io.b_class;

import java.io.*;

/**
 * @author y15079
 * @create 2017-09-28 15:50
 * @desc
 *
 * BufferedInputStream 是缓冲输入流 继承FilterInputStream (处理字节流)
 *
 *  BufferedInputStream类继承了FilterInputStream对象，是inputStream的修饰者类。能够将输入流先进行缓存，避免每次都需要进行实质性的I/O操作。
   第一次会缓存8192字节的数据，然后会成倍增长。
 *
 * BufferedInputStream 的作用是为另一个输入流添加一些功能，例如，提供“缓冲功能”以及支持“mark()标记”和“reset()重置方法”。
 *
 * 通过预先读入一整段原始输入流数据至缓冲区中，而外界对BufferedInputStream的读取操作实际上是在缓冲区上进行，
   如果读取的数据超过了缓冲区的范围，那么BufferedInputStream负责重新从原始输入流中载入下一截数据填充缓冲区，然后外界继续通过缓冲区进行数据读取。
  这样的设计的好处是：避免了大量的磁盘IO，因为原始的InputStream类实现的read是即时读取的，即每一次读取都会是一次磁盘IO操作（哪怕只读取了1个字节的数据），
  可想而知，如果数据量巨大，这样的磁盘消耗非常可怕。而通过缓冲区的实现，读取可以读取缓冲区中的内容，当读取超过缓冲区的内容后再进行一次磁盘IO，载入一段数据填充缓冲，
  那么下一次读取一般情况下就直接可以从缓冲区读取，减少了磁盘IO。
 *
 *
 * http://blog.csdn.net/wuwenxiang91322/article/details/8042725
 *
 **/
public class BufferedInputStreamDemo {

	private static final int LEN=5;

	public static void main(String[] args) {
		testBufferedInputStream();
	}

	/**
	 * BufferedInputStream的API测试函数
	 */
	private static void testBufferedInputStream(){
		//创建BufferedInputStream字节流，内容是ArrayLetters数组
		try {
			File file=new File("D:\\IDEA\\JavaIODemo\\resources\\bufferedInputStream.txt");
			InputStream in=new BufferedInputStream(new FileInputStream(file),512);

			//从字节流中读取5个字节。‘abcde’，a对应0x61，b对应0x62，依次类推...
			for (int i=0;i<LEN;i++){
				//若能继续读取下一个字节，则读取下一个字节
				if (in.available()>=0){
					// 读取“字节流的下一个字节”
					int tmp=in.read();
					System.out.printf("%d : 0x%s\n", i, Integer.toHexString(tmp)+" "+tmp);
				}
			}

			// 若“该字节流”不支持标记功能，则直接退出
			if (!in.markSupported()){
				System.out.println("make out supported!");
				return;
			}

			//标记“当前索引位置”，即标记第6个位置的元素--“f”
			//1024对应marklimit
			in.mark(1024);

			// 跳过22个字节。
			in.skip(22);

			//读取5个字节
			byte[] buf=new byte[LEN];
			in.read(buf,0,LEN);
			//将buf转换为String字符串
			String str1 = new String(buf);
			System.out.printf("str1=%s\n", str1);

			// 重置“输入流的索引”为mark()所标记的位置，即重置到“f”处。
			in.reset();
			// 从“重置后的字节流”中读取5个字节到buf中。即读取“fghij”
			in.read(buf, 0, LEN);
			// 将buf转换为String字符串。
			String str2 = new String(buf);
			System.out.printf("str2=%s\n", str2);

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
