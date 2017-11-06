package com.io.a_interface;

import java.io.File;
import java.io.FileFilter;

/**
 * @author y15079
 * @create 2017-09-28 11:42
 * @desc
 *
 * FileFilter接口 文件过滤，一般作为File[] fList=file.listFiles(fileFilter)参数
 *
 * http://www.cnblogs.com/hnrainll/archive/2012/10/23/2734934.html
 **/
public class FileFilterDemo {

	public static void main(String[] args) throws Exception{
		File f=new File("D:\\IDEA\\JavaIODemo\\resources");

		FileFilter ff=new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				String s=pathname.getName().toLowerCase();
				if (s.endsWith(".txt")){
					return true;
				}
				return false;
			}
		};

		File[] flist=f.listFiles(ff);

		if (flist==null){
			System.out.println("the flist is null");
			return;
		}

		for (File fs:flist){
			System.out.println(fs);
		}
	}
}
