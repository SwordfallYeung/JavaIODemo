package com.io.b_class;

import java.io.*;

/**
 * @author SwordFall
 * @create 2017-11-06 00:05.
 * @desc
 **/
public class OutputStreamWriterDemo {

    public static void main(String[] args) {

    }

    public static void transWriteNoBuf() throws Exception{
        OutputStream out = System.out;//打印到控制台
//      OutputStream out = new FileOutputStream("D:\\demo.txt");//打印到文件
        OutputStreamWriter osr = new OutputStreamWriter(out);//输出
//      OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("D:\\demo.txt"));//两句可以综合到一句。
//      int ch = 97;//a
//      int ch = 20320;//你
//      osr.write(ch);
        String str = "你好吗？";//你好吗？
        osr.write(str);
        osr.flush();
        osr.close();
        out.close();
    }

    public static void transWriteByBuf() throws IOException {
//      OutputStream out = System.out;//打印到控制台。
        OutputStream out = new FileOutputStream("file1.txt");//打印到文件。
        OutputStreamWriter osr = new OutputStreamWriter(out);//输出
//      OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("D:\\demo.txt"));//综合到一句。
        BufferedWriter bufw = new BufferedWriter(osr);//缓冲
//      int ch = 97;//a
//      int ch = 20320;//你
//      osr.write(ch);
        String str = "你好吗？\r\n我很好！";//你好吗？
        bufw.write(str);
        bufw.flush();
        bufw.close();
    }
}
