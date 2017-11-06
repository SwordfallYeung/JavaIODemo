package com.io.b_class;

import java.io.*;

/**
 * @author y15079
 * @create 2017-09-28 15:50
 * @desc
 *
 * ObjectInputStream与ObjectOutputStream类所读写的对象必须实现Serializable接口，
 * 对象中的transient和static类型成员变量不会被读取和写入
 *
 *
 *
 **/
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws Exception{
        Student s1=new Student("张三",1,15,"化学");
        Student s2=new Student("李四",2,19,"生物");

        FileOutputStream fout=new FileOutputStream("student.txt");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.writeObject(s2);
        out.close();
        FileInputStream fin=new FileInputStream("student.txt");
        ObjectInputStream in=new ObjectInputStream(fin);

        s1=(Student)in.readObject();
        s2=(Student)in.readObject();

        in.close();
        System.out.print("name:"+s1.name);
        System.out.print(" id:"+s1.id);
        System.out.print(" age:"+s1.age);
        System.out.println(" department:"+s1.department);
        System.out.print("name:"+s2.name);
        System.out.print(" id:"+s2.id);
        System.out.print(" age:"+s2.age);
        System.out.println(" department:"+s2.department);
    }

    public static class Student implements Serializable{
        String name;
        int id;
        int age;
        String department;

        public Student(String name, int id, int age, String department) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.department = department;
        }
    }
}
