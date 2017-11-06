package com.io.b_class;

import java.io.*;

/**
 * @author y15079
 * @create 2017-11-03 16:36
 * @desc
 *
 * LineNumberReader比BufferedReader多了个功能，就是可以返回当前行号。
 * 另外setLineNumber能改变行号，却不能改变读的位置。
 *
 **/
public class LineNumberReaderDemo {

	public static void main(String[] args) throws Exception{
		testLineNumberReader();
	}

	public static void testLineNumberReader() throws Exception{
		LineNumberReader lineNumberReader=null;
		FileReader fileReader=null;

		try {
			fileReader=new FileReader("file.txt");
			lineNumberReader =new LineNumberReader(fileReader);
			String line=null;
			while ((line=lineNumberReader.readLine())!=null){
				System.out.println(lineNumberReader.getLineNumber()+": "+line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(lineNumberReader);
			close(fileReader);
		}
	}

	private static void close(Closeable closeable){
		if (closeable!=null){
			try {
				closeable.close();
				closeable=null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
