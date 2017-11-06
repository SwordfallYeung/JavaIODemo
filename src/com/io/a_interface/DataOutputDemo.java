package com.io.a_interface;

/**
 * @author y15079
 * @create 2017-09-28 10:28
 * @desc
 *
 * DataOutput 接口
 *java 8种基础数据类型都有涉猎
 * 接口方法：
   [1]  writeBoolean(boolean v)  写布尔值
   [2]  writeByte(int v)        Writes to the output stream the eight low- order bits of the argument v.
   [3]  writeBytes(String s)    Writes a string to the output stream.
   [4]  writeShort     Writes two bytes to the output stream to represent the value of the argument.
   [5]  writeChar      Writes a char value, which is comprised of two bytes, to the output stream.
        writeChars     Writes every character in the string s, to the output stream,
   [6]  writeInt       Writes an int value,
   [7]  writeLong      Writes a long value
   [8]  writeFloat     Writes a float value,
   [9]  writeDouble    Writes a double value
   [10] write(对应readFully)
   [11] write(byte[] b,int off,int len)(对应readFully(byte[] b,int off,int len)   写到输入流len个字节。
        write(int b)
   [13] writeUTF       写一个已经由utf8格式编码的字符串。
 *
 **/
public class DataOutputDemo {
}
