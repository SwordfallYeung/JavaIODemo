package com.io.b_class;

import java.io.StringReader;

/**
 * @author y15079
 * @create 2017-11-07 14:06
 * @desc
 * StringReader是装饰Reader的类，其用法是读取一个String字符串
 * 感觉好鸡肋，其他流式处理也能实现，也是只读一个字符，而不是字符串
 **/
public class StringReaderDemo {
	public static void main(String[] args) throws Exception{
		StringReader in=new StringReader("我是yangyang,你搞毛呀");
		int s;
		String sb="";
		while ((s=in.read())!=-1){
			sb+=(char)s;
		}
		in.close();
		System.out.println(sb);

	}
}
