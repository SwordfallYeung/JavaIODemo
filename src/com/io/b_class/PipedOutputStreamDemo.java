package com.io.b_class;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author y15079
 * @create 2017-11-06 13:23
 * @desc
 *
 * PipedOutputStream和PipedInputStream是管道输出流和管道输入流，配合使用可以实现线程间通信。
　　使用管道实现线程间通信的主要流程如下：建立输出流out和输入流in，将out和in绑定，out中写入的数据则会同步写入的in的缓冲区（实际情况是，out中写入数据就是往in的缓冲区写数据，out中没有数据缓冲区）。
 *
 **/
public class PipedOutputStreamDemo {

	public static void main(String[] args) throws Exception{
		/**
		 * 流程
		 * 1 建立输入输出流
		 * 2 绑定输入输出流
		 * 3 向缓冲区写数据
		 * 4 读取缓冲区数据
		 */
		PipedInputStream in=new PipedInputStream();
		PipedOutputStream out=new PipedOutputStream();
		Producer producer=new Producer(out);
		Consumer consumer=new Consumer(in);

		out.connect(in);
		producer.start();
		consumer.start();
	}

	/**
	 * 生产者线程
	 */
	public static class Producer extends Thread{
		//输出流
		private PipedOutputStream out;

		public Producer(PipedOutputStream out) {
			this.out = out;
		}

		@Override
		public void run() {
			StringBuilder sb=new StringBuilder("Hello world!");

			try {
				out.write(sb.toString().getBytes());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 消费者线程
	 */
	public static class Consumer extends Thread{
		//输入流，默认缓冲区大小为1024
		private PipedInputStream in;

		public Consumer(PipedInputStream in) {
			this.in = in;
		}

		@Override
		public void run() {
			byte[] buf=new byte[1024];

			try {
				int len=in.read(buf);
				System.out.println("缓冲区的内容为："+new String(buf,0,len));
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
