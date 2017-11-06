package com.io.b_class;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * @author y15079
 * @create 2017-11-06 20:05
 * @desc
 *
 * java.io.PushbackReader
 * 1.  java.io.PushbackReader与前面提到的PushbackInputStream类似，都拥有一个PushBack缓冲区，只不过PushbackReader所处理的是字符。
 * 从这个对象读出数据后，如果愿意的话，只要PushBack缓冲区没有满，就可以使用unread()将数据推回流的前端。
   2. 下面的示例示范了可以将文本文件中的一些数学符号：<,>,<=,>=,!=,=转换为BIG5码中的对应字符：
 *
 * http://blog.csdn.net/fwch1982/article/details/7878542
 **/
public class PushbackReaderDemo {
	public static void main(String[] args) throws Exception{
		char[] symbols={'<','>', '≦', '≧', '≠', '＝'};
		try {
			PushbackReader pushbackReader=new PushbackReader(new FileReader("resources/file.txt"));
			FileWriter fileWriter=new FileWriter("resources/file1.txt");
			int c=0;
			while ((c=pushbackReader.read())!=-1){
                int poss=-1;
                switch (c){
                    case '<':
                        poss=0;break;
                    case '>':
                        poss=1;break;
                    case '!':
                        poss=2;break;
                    case '=':
                        poss=5;break;
                    default:
                        fileWriter.write(c);
                }
                if (poss!=-1){
                    if ((c=pushbackReader.read())=='='){
                        fileWriter.write(symbols[poss+2]);
                        fileWriter.write(' ');
                    }else {
                        pushbackReader.unread(c);
                        fileWriter.write(symbols[poss]);
                    }
                }
            }
			pushbackReader.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
