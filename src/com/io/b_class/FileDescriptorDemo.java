package com.io.b_class;

import java.io.*;

/**
 * @author y15079
 * @create 2017-11-02 13:32
 * @desc
 *
 * FileDescriptor 文件描述符，可以被用来表示开放文件、开放套接字等。
 * 以FileDescriptor表示文件来说：当FileDescriptor表示某文件时，我们可以通俗的将FileDescriptor看成是该文件。
 * 但是，我们不能直接通过FileDescriptor对该文件进行操作；若需要通过FileDescriptor对该文件进行操作，则需要新创建FileDescriptor对应的FileOutputStream，再对文件进行操作。
 *
 * in, out, err介绍

	(01) in  -- 标准输入(键盘)的描述符
	(02) out -- 标准输出(屏幕)的描述符
	(03) err -- 标准错误输出(屏幕)的描述符
 *
 * out 的作用和原理：（封装为System.out.print()）
 * out就代表了标准输出(屏幕)。若我们要输出信息到屏幕上，即可通过out来进行操作；但是，out又没有提供输出信息到屏幕的接口(因为out本质是FileDescriptor对象，而FileDescriptor没有输出接口)。怎么办呢？
   很简单，我们创建out对应的“输出流对象”，然后通过“输出流”的write()等输出接口就可以将信息输出到屏幕上。
 *
 *
 **/
public class FileDescriptorDemo {

	private static final String FileName="file.txt";
	private static final String OutText = "Hi FileDescriptor";

	public static void main(String[] args) {
		testWrite();
		testRead();
		testStandFD() ;
	}

	/**
	 * FileDscriptor.out程序
	 *
	 * 该程序的效果 等价于System.out.println(OutText)
	 */
	private static void testStandFD(){
		//创建FileDescriptor.out 对应的PrintStream
		PrintStream out=new PrintStream(new FileOutputStream(FileDescriptor.out));
		//在屏幕上输出“Hi FileDescriptor”
		out.println(OutText);
		out.close();
	}

	/**
	 * FileDescriptor写入示例程序
	 *
	 * (01) 为了说明，"通过文件名创建FileOutputStream"与“通过文件描述符创建FileOutputStream”对象是等效的
	 * (02) 该程序会在“该源文件”所在目录新建文件"file.txt"，并且文件内容是"Aa"。
	 */
	private static void testWrite(){
		try {
			//新建文件“file.txt”对应的FileOutputStream对象
			FileOutputStream out1=new FileOutputStream(FileName);
			//获取文件“file.txt”对应的“文件描述符”
			FileDescriptor fdout=out1.getFD();
			//根据“文件描述符”创建“FileOutputStream”对象
			FileOutputStream out2=new FileOutputStream(fdout);

			out1.write('A');//通过out1向“file.txt”中写入‘A’
			out2.write('a');//通过out2向“file.txt”中写入‘a’

			if (fdout!=null){
				System.out.printf("fdout(%s) is %s \n", fdout, fdout.valid());
			}

			out1.close();
			out2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 68      * FileDescriptor读取示例程序
	 69      *
	 70      * 为了说明，"通过文件名创建FileInputStream"与“通过文件描述符创建FileInputStream”对象是等效的
	 71      */
    private static void testRead() {
		         try {
			             // 新建文件“file.txt”对应的FileInputStream对象
			             FileInputStream in1 = new FileInputStream(FileName);
			             // 获取文件“file.txt”对应的“文件描述符”
			             FileDescriptor fdin = in1.getFD();
			             // 根据“文件描述符”创建“FileInputStream”对象
			             FileInputStream in2 = new FileInputStream(fdin);

			             System.out.println("in1.read():"+(char)in1.read());
			             System.out.println("in2.read():"+(char)in2.read());

			             if (fdin!=null)
				                System.out.printf("fdin(%s) is %s\n", fdin, fdin.valid());
			            in1.close();
			            in2.close();
			        } catch(IOException e) {
			            e.printStackTrace();
			        }
		     }
}
