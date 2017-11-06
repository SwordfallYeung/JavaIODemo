package com.io.a_interface;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author y15079
 * @create 2017-09-28 13:31
 * @desc
 *
 * FilenameFilter是文件名过滤器，用来过滤不符合规格的文件名，并返回合格的文件；
 *
 * 一般地：
   (1)String[] fs = f.list();
   (2)File[] fs = f.listFiles();
   这两个方法返回f下的所有文件或目录；
   FilenameFilter用来把符合要求的文件或目录返回；
   因此可以调用：
   (1)String []fs = f.list(FilenameFilter filter);;
   (2)File[]fs = f.listFiles(FilenameFilter filter);
 *
 * 文件名过滤器一般用法
   1.实现FilenameFilter接口；
   2.实现boolean accept(File dir,String name);   //dir表示文件的当前目录，name表示文件名；
 *
 * http://blog.csdn.net/xiazdong/article/details/6928455
 **/
public class FilenameFilterDemo {

	public static void main(String[] args) throws Exception{
		File f=new File("D:\\IDEA\\JavaIODemo\\resources");
		MyFilter myFilter=new MyFilter(".txt");
		String[] files=f.list(myFilter);
		for (String a:files){
			System.out.println("文件名："+a);
		}
		File[] files1=f.listFiles(myFilter);
		for (File f1:files1){
			System.out.println(f1);
		}

	}

	public static class MyFilter implements FilenameFilter{
		private String type;

		public MyFilter(String type) {
			this.type = type;
		}

		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(type);
		}
	}
}
