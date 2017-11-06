package com.io.b_class;

import java.io.RandomAccessFile;

/**
 * @author SwordFall
 * @create 2017-11-07 00:18.
 * @desc
 *
 * RandomAccessFile是用来访问那些保存数据记录的文件的，你就可以用seek( )方法来访问记录，并进行读写了。这些记录的大小不必相同；
 * 但是其大小和位置必须是可知的。但是该类仅限于操作文件。
 *
 * RandomAccessFile不属于InputStream和OutputStream类系的。
 * 它是一个完全独立的类，所有方法(绝大多数都只属于它自己)都是从零开始写的。
 *
 * 基本上，RandomAccessFile的工作方式是，把DataInputStream和DataOutputStream结合起来，再加上它自己的一些方法，
 * 比如定位用的getFilePointer( )，在文件里移动用的seek( )，以及判断文件大小的length( )、skipBytes()跳过多少字节数。此外，它的构造函数还要一个表示以只读方式("r")，
 * 还是以读写方式("rw")打开文件的参数 (和C的fopen( )一模一样)。它不支持只写文件。

只有RandomAccessFile才有seek搜寻方法，而这个方法也只适用于文件。BufferedInputStream有一个mark( )方法，你可以用它来设定标记(把结果保存在一个内部变量里)，
然后再调用reset( )返回这个位置，但是它的功能太弱了，而且也不怎么实用。

RandomAccessFile的绝大多数功能，但不是全部，已经被JDK 1.4的nio的"内存映射文件(memory-mapped files)"给取代了，
你该考虑一下是不是用"内存映射文件"来代替RandomAccessFile了。
 *
 * http://blog.csdn.net/akon_vm/article/details/7429245
 *
 **/
public class RandomAccessFileDemo {

    public static void main(String[] args) throws Exception {
        RandomAccessFile rf=new RandomAccessFile("resources/file2.txt","rw");
        for (int i=0;i<10;i++){
            //寫入基本类型double数据
            rf.writeDouble(i*1.414);
            System.out.println("Value "+i+" "+i*1.414);
        }
        rf.close();
        rf=new RandomAccessFile("resources/file2.txt","rw");
        //直接将文件指针移到第5个double数据后面
        rf.seek(5*8);
        //覆盖第6个double数据
        rf.writeDouble(47.0001);
        rf.close();
        rf=new RandomAccessFile("resources/file2.txt","r");
        System.out.println("--");
        for (int i=0;i<10;i++){
            System.out.println("Value "+i+": "+rf.readDouble());
        }
        rf.close();
    }
}
