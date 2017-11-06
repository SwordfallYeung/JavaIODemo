package com.io.b_class;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author y15079
 * @create 2017-11-06 13:37
 * @desc
 *
 * PipedReader和PipedWriter即管道输入流和输出流，可用于线程间管道通信。
 * 它们和PipedInputStream/PipedOutputStream区别是前者操作的是字符后者是字节。
 *
 * http://blog.csdn.net/sk199048/article/details/51260757
 **/
public class PipedWriterDemo {
	public static void main(String[] args) throws Exception{
		/**
		 * 管道流通信核心是,Writer和Reader公用一块缓冲区,缓冲区在Reader中申请,
		 * 由Writer调用和它绑定的Reader的Receive方法进行写.
		 *
		 * 线程间通过管道流通信的步骤为
		 * 1 建立输入输出流
		 * 2 绑定输入输出流
		 * 3 Writer写
		 * 4 Reader读
		 */
		PipedReader reader=new PipedReader();
		PipedWriter writer=new PipedWriter();
		Producer producer=new Producer(writer);
		Consumer consumer=new Consumer(reader);

		writer.connect(reader);
		producer.start();
		consumer.start();
	}

	/**
	 * 写线程
	 */
	public static class Producer extends Thread{
		//输出流
		private PipedWriter writer=new PipedWriter();

		public Producer(PipedWriter writer) {
			this.writer = writer;
		}

		@Override
		public void run() {
			try {
				StringBuilder sb=new StringBuilder();
				sb.append("Hello world!");
				writer.write(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取线程
	 */
	public static class Consumer extends Thread{
		//输入流
		private PipedReader reader=new PipedReader();

		public Consumer(PipedReader reader) {
			this.reader = reader;
		}

		@Override
		public void run() {
			try {
				char[] buf=new char[20];
				reader.read(buf,0,buf.length);
				System.out.println("管道流中的数据为: " + new String(buf));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
