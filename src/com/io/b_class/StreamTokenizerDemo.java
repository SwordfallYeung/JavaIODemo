package com.io.b_class;

import java.io.*;

/**
 * @author y15079
 * @create 2017-11-07 13:25
 * @desc
 *
 * 1、类java.io.StreamTokenizer可以获取输入流并将其分析为Token（标记）。
StreamTokenizer的nextToken方法读取下一个标记
 *
 * 2、默认情况下，StreamTokenizer认为下列内容是Token:字母、数字、除c和c++注释符号以外的其他符号。
如符号“/”不是Token，注释后的内容也不是，而"/"是Token。单引号和双引号以及其总的内容，只能算一个Token。
 *
 * 要统计文件的字符数，不能简单地统计Token数，因为字符数不等于Token，按照Token的规定，引号中的内容就算是10页也算是一个Token。
 * 如果希望引号和引号中的内容都算作Token，应该通过StreamTokenizer的ordinaryCha()方法将单引号和双引号当做普通字符处理。
 *
 * st.ordinaryChar('\'');  //将单引号设为普通字符
 * st.ordinaryChar('\"');    //将双引号设为普通字符
 **/
public class StreamTokenizerDemo {
	public static void main(String[] args) {
		String file="resources/file.txt";
		statis(file);
	}

	public static long statis(String fileName){
		FileReader fileReader=null;

		try {
			fileReader =new FileReader(fileName);
			//创建分析给定字符流的标记生成器
			StreamTokenizer st=new StreamTokenizer(new BufferedReader(fileReader));

			//ordinaryChar方法指定字符参数在此标记生成器中是"普通"字符。
			//下面指定单引号、双引号和注释符号是普通字符
			st.ordinaryChar('\'');
			st.ordinaryChar('\"');
			st.ordinaryChar('/');

			String s;
			int numberSum=0;
			int wordSum=0;
			int symbolSum=0;
			int total=0;
			//nextToken方法读取下一个Token.
			//IT_EOF指示已读到流末尾的常量。
			while (st.nextToken()!=StreamTokenizer.TT_EOF){
				//在调用nextToken方法之后，ttype字段将包含刚读取的标记的类型
				switch (st.ttype){
					//TT_EOL指示已读到行末尾的常量
					case StreamTokenizer.TT_EOF:
						break;
					//TT_NUMBER指示已读到一个数字标记的常量
					case StreamTokenizer.TT_NUMBER:
						//如果当前标记是一个数字，nval字段将包含该数字的值
						s=String.valueOf(st.nval);
						System.out.println(s);
						numberSum+=s.length();
						break;
						//TT_WORD指示已读到一个文字标记的常量
					case StreamTokenizer.TT_WORD:
						//如果当前标记是一个文字标记，sval字段包含一个给出该文字标记的字符的字符串
						s=st.sval;
						wordSum+=s.length();
						break;
					default:
						//如果以上3种类型都不是，则为英文的标点符号
						s=String.valueOf((char)st.ttype);
						symbolSum+=s.length();
				}
			}
			System.out.println("sum of number = " + numberSum);
			System.out.println("sum of word = " + wordSum);
			System.out.println("sum of symbol = " + symbolSum);
			total = symbolSum + numberSum + wordSum;
			System.out.println("Total = " + total);
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
