package com.io.a_interface;

/**
 * @author y15079
 * @create 2017-09-28 10:06
 * @desc
 *
 * DataInput 为接口
 *
 * DataInput接口提供了从二进制流读字节数据并重建数据为任何Java原始类型的功能，也提供了修改utf8格式编码
 *
 * java 8种基础数据类型都有涉猎
 * 接口方法：
   [1]  readBoolean  读取一个输入字节，如果该字节为非零，则返回true，如果该字节为零，则返回false。这个方法适用于读取DataOutput接口的writeBoolean方法所写的字节数据。
   [2]  readByte     读取并返回一个输入字节。字节被视为一个范围在- 128至127的有符号值。
   [3]  readUnsignedByte   读取一个输入的字节，zero-extends到int类型，并返回范围在0到255的结果。
   [4]  readShort     读取两个输入字节，并返回一个short类型的值。假如a是读取的第一个字节，b是读取的第二个字节，则返回的值是：
                      (short)((a << 8) | (b & 0xff))
   [5]  readChar      读取两个输入字节，并返回一个char类型的值。
        readLine       读取字符串
   [6]  readInt       读取四个输入字节，并返回一个int类型的值。
   [7]  readLong      读取八个输入字节，并返回一个int类型的值。
   [8]  readFloat     读取四个输入字节，并返回一个float类型的值。
   [9]  readDouble    读取八个输入字节，并返回一个double类型的值。
   [10] readFully     从输入流中读取一些字节，并将它们存储到缓冲区数组b。读取的字节数等于b的长度。
   [11] void readFully(byte[] b,int off,int len)   从输入流读取len个字节。
   [12] skipBytes(int n)   试图跳过从输入流中的n个字节，丢弃跳过的n个字节
   [13] readUTF       读取一个已经由utf8格式编码的字符串。
 *
 **/
public class DataInputDemo {
}
