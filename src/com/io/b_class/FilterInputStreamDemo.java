package com.io.b_class;

/**
 * @author y15079
 * @create 2017-11-03 14:57
 * @desc
 *
 * 一个特殊的输入字节流：FilterInputStream，以及与之相随的一个经典的设计模式，装饰者模式。
 *
 * 在讲了FilterInputStream之后，就必须要提到一个设计模式：装饰者模式（decorator pattern）。
 * 装饰者模式在流里有广泛的应用。
 *
 * 装饰者模式，顾名思义，是对原有类进行了一定的装饰，装饰后的类必须和原有的类拥有相同的方法，当然，可以在原有类的基础上进行扩展。
 *
 * 这里的装饰者模式通过包含一个原有的Inputstream对象，并且将InputStream原有的方法或直接暴露，或进行装饰后暴露，又或者添加了新的特性，
 * 如DataInputStream中的readInt()，BufferedInputStream中的缓存功能。
 *
 * 其实这里还有一个话题，为什么InputStream选择装饰者模式，而非直接继承的方法来扩展，这就是装饰者模式VS继承。
 *
 * 重点：
   FilterInputStream 的作用是用来“封装其它的输入流，并为它们提供额外的功能”。它的常用的子类有BufferedInputStream和DataInputStream。
   BufferedInputStream的作用就是为“输入流提供缓冲功能，以及mark()和reset()功能”。
   DataInputStream 是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型”。

   应用程序可以使用DataOutputStream(数据输出流)写入由DataInputStream(数据输入流)读取的数据。
 *
 *
 **/

public class FilterInputStreamDemo {

}
