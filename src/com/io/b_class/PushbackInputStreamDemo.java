package com.io.b_class;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

/**
 * @author y15079
 * @create 2017-11-06 19:50
 * @desc
 *
 * 在JAVA IO中所有的数据都是采用顺序的读取方式，即对于一个输入流来讲都是采用从头到尾的顺序读取的，如果在输入流中某个不需要的内容被读取进来，
 * 则只能通过程序将这些不需要的内容处理掉，为了解决这样的处理问题，在JAVA中提供了一种回退输入流（PushbackInputStream、PushbackReader），
 * 可以把读取进来的某些数据重新回退到输入流的缓冲区之中。
 *
 * 使用PushbackInputStream完成回退操作
 *
 * 回退流同样分为字节流和字符流，此时还是以字节流为准。
 *
 * PushbackInputStream类的常用方法
	1、public PushbackInputStream(InputStream in) 构造方法 将输入流放入到回退流之中。
	2、public int read() throws IOException   普通  读取数据。
	3、public int read(byte[] b,int off,int len) throws IOException 普通方法 读取指定范围的数据。
	4、public void unread(int b) throws IOException 普通方法 回退一个数据到缓冲区前面。
	5、public void unread(byte[] b) throws IOException 普通方法 回退一组数据到缓冲区前面。
	6、public void unread(byte[] b,int off,int len) throws IOException 普通方法 回退指定范围的一组数据到缓冲区前面。
 *
 * http://blog.csdn.net/u013087513/article/details/52171078
 *
 **/
public class PushbackInputStreamDemo {
	public static void main(String[] args) throws Exception{
		String str="www.baidu.com";//定义字符串
		PushbackInputStream push=null;//定义回退流对象
		ByteArrayInputStream bai=null;//定义内存输入流
		bai=new ByteArrayInputStream(str.getBytes());//实例化内存输入流
		push=new PushbackInputStream(bai);//从内存中读取数据
		System.out.print("读取之后的数据为：");
		int temp=0;
		while ((temp=push.read())!=-1){
			//读取内容
			if (temp=='.'){//判断是否读取到了"."
				push.unread(temp);//放回到缓冲区之中
				temp=push.read();//再读一遍
				System.out.print("(退回"+(char)temp+") ");
			}else {
				System.out.print((char)temp);//输出内容
			}
		}
	}
}
