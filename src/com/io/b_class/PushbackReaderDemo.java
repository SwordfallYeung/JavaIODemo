package com.io.b_class;

/**
 * @author y15079
 * @create 2017-11-06 20:05
 * @desc
 *
 * java.io.PushbackReader
 * 1.  java.io.PushbackReader与前面提到的PushbackInputStream类似，都拥有一个PushBack缓冲区，只不过PushbackReader所处理的是字符。
 * 从这个对象读出数据后，如果愿意的话，只要PushBack缓冲区没有满，就可以使用unread()将数据推回流的前端。
   2. 下面的示例示范了可以将文本文件中的一些数学符号：<,>,<=,>=,!=,=转换为BIG5码中的对应字符：
 *
 * http://blog.csdn.net/fwch1982/article/details/7878542
 **/
public class PushbackReaderDemo {
	public static void main(String[] args) {
		char[] symbols={'<','>', '≦', '≧', '≠', '＝'};
		
	}
}
