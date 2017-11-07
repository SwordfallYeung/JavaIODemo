package com.io.b_class;

import java.io.StringWriter;

/**
 * @author y15079
 * @create 2017-11-07 14:12
 * @desc
 * 这两个类将String类适配到了Reader和Writer接口，在StringWriter类实现的过程中，
 * 真正使用的是StringBuffer,前面讲过，StringBuffer是一个可变类，由于Writer类中有许多字符串的操作，
 * 所以这个类用起来比较方便;在StringReader类中只定义一个String类即可，
 * 因为只涉及到类的读取，而没有修改等的操作，不会创建多个字符串而造成资源浪费。
 *
 **/
public class StringWriterDemo {
	public static void main(String[] args) {
		char[] x={'m','n'};
		StringWriter s=new StringWriter(20);
		s.write(x,0,1);

		s.write('a');
		s.write("bcd");
		s.write("012",1,2);
		System.out.println(s.toString());
	}
}
