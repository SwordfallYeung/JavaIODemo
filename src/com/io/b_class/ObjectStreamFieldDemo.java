package com.io.b_class;

import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.util.Calendar;

/**
 * @author SwordFall
 * @create 2017-11-05 23:25.
 * @desc
 *
 * 这个类主要用来提取序列化过程中某个对象内的字段【成员属性】元数据信息，包括字段的类型、类型代码、签名等
 *
 * 该类实现了接口Comparable<T>，这个接口主要用于“对象比较”，一旦实现了这个接口过后就必须实现接口中的方法compareTo，
 * 先看看在ObjectStreamField类中的compareTo的实现：
 *
 **/
public class ObjectStreamFieldDemo {

    public static void main(String[] args) {
//        compareTo();
        getName();
    }

    public static void compareTo(){
        //create a new object stream class for Integers
        ObjectStreamClass osc=ObjectStreamClass.lookupAny(Integer.class);

        //get the field value from Integer class
        ObjectStreamField field=osc.getField("value");

        // create a new object stream class for floats
        ObjectStreamClass osc2 = ObjectStreamClass.lookupAny(Float.class);

        // get the field value from Integer class
        ObjectStreamField field2 = osc.getField("value");

        // compare with another field
        System.out.println("" + field.compareTo(field2));
    }

    public static void getName(){
        // create a new object stream class for Integers
        ObjectStreamClass osc = ObjectStreamClass.lookup(Integer.class);

        // get the field value from Integer class
        ObjectStreamField field = osc.getField("value");

        // get the name of the field
        System.out.println("" + field.getName());

        // create a new object stream class for calendar
        ObjectStreamClass osc2 = ObjectStreamClass.lookup(Calendar.class);

        // get the field value from Calendar class
        ObjectStreamField field2 = osc2.getField("lenient");

        // get the name of the field2
        System.out.println("" + field2.getName());
    }

}
