package com.io.b_class;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author y15079
 * @create 2017-11-06 11:05
 * @desc
 *
 * Java里的管道输入流PipedInputStream与管道输出流PipedOutputStream实现了类似管道的功能，用于不同线程之间的相互通信
 * java的管道输入与输出实际上使用的是一个循环缓冲数组来实现，这个数组默认大小为1024字节。
 *
 * 输入流PipedInputStream从这个循环缓冲数组中读数据，输出流PipedOutputStream往这个循环缓冲数组中写入数据。
 *
 *当这个缓冲数组已满的时候，输出流PipedOutputStream所在的线程将阻塞；当这个缓冲数组首次为空的时候，输入流PipedInputStream所在的线程将阻塞。
 *
 * 但是在实际用起来的时候，却会发现并不是那么好用。
 *
 * Java在它的jdk文档中提到不要在一个线程中同时使用PipeInpuStream和PipeOutputStream，这会造成死锁
 *
 * 管道流:
	PipedInputStream
	void connect(PipedOutputStream src)
	使此管道输入流连接到管道输出流 src

	PipedOutputStream
	void connect(PipedInputStream snk)

	在JDK我们看到PipedInputStream中有管道缓冲区,用来接收数据

	管道流内部在实现时还有大量的对同步数据的处理
	管道输出流和管道输入流执行时不能互相阻塞,所以一般要开启独立线程分别执行
	顺便复习了多线程操作
 *
 * http://blog.csdn.net/zlp1992/article/details/50298195
 * http://xouou.iteye.com/blog/1333475
 **/
public class PipedInputStreamDemo {
	public static void main(String[] args) throws Exception{
		PipedInputStream pin=new PipedInputStream();
		PipedOutputStream pout=new PipedOutputStream();
		pin.connect(pout);//输入流与数据流连接

		ReadThread readThread=new ReadThread(pin);
		WriteThread writeThread=new WriteThread(pout);
		new Thread(readThread).start();
		new Thread(writeThread).start();
	}

	public static class ReadThread implements Runnable{

		private PipedInputStream pin;

		public ReadThread(PipedInputStream pin) {
			this.pin = pin;
		}

		@Override
		public void run() {

			try {
				sop("R:读取前没有数据，阻塞中...等待数据传过来再输出到控制台...");
				byte[] buf=new byte[1024];
				int len=pin.read(buf);//read阻塞
				sop("R:读取数据成功，阻塞解除...");

				String s=new String(buf,0,len);
				sop(s);//将读取的数据流用字符串以字符串打印出来
				pin.close();
			} catch (IOException e) {
				throw new RuntimeException("R:管道读取流失败!");
			}
		}
	}

	public static class WriteThread implements Runnable{

		private PipedOutputStream pout;

		public WriteThread(PipedOutputStream pout) {
			this.pout = pout;
		}

		@Override
		public void run() {
			try {
				sop("W:开始将数据写入：但等个5秒让我们观察...");
				Thread.sleep(5000);
				pout.write("W:writePiped 数据...".getBytes());//管道输出流
				pout.close();
			} catch (Exception e) {
				throw new RuntimeException("W:WriteThread写入失败...");
			}
		}
	}

	public static void sop(Object obj) //打印
	{
		System.out.println(obj);
	}
}
