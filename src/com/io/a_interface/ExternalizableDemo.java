package com.io.a_interface;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;

/**
 * @author y15079
 * @create 2017-09-28 11:13
 * @desc
 *
 * Externalizable 继承 Serializable接口
 *
 * Java默认的序列化机制非常简单，而且序列化后的对象不需要再次调用构造器重新生成，
 * 但是在实际中，我们可以会希望对象的某一部分不需要被序列化，或者说一个对象被还原之后，
 * 其内部的某些子对象需要重新创建，从而不必将该子对象序列化。
 *
 * 控制序列化字段还可以使用Externalizable接口替代Serializable借口。此时需要定义一个默认构造器，否则将为得到一个异常
 *还需要定义两个方法(writeExternal()和readExternal())来控制要序列化的字段。
 *
 * http://www.cnblogs.com/dukc/p/4817822.html
 **/
public class ExternalizableDemo {

	public static class Person implements Externalizable{
		private String name;
		private int age;
		/**
		 * 必须有无参数的构造器
		 */
		public Person() {
			System.out.println("无参数的构造器");
		}

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
			System.out.println("带参数的构造器");
		}

		@Override
		public String toString() {
			return "姓名是"+name+" 年龄是"+age;
		}

		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeObject(name);
			out.writeObject(age);
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.name=(String)in.readObject();
            this.age=(int)in.readObject();
		}
	}

	public static void main(String[] args) throws Exception{
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;

		try {
			fos=new FileOutputStream(new File("D:\\IDEA\\JavaIODemo\\resources\\test.txt"));
			oos=new ObjectOutputStream(fos);
			oos.writeObject(new Person("孙悟空",600));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oos!=null) {
				oos.close();
			}
		}

		try {
			fis=new FileInputStream(new File("D:\\IDEA\\JavaIODemo\\resources\\test.txt"));
			ois=new ObjectInputStream(fis);
			Person per=(Person)ois.readObject();
			System.out.println(per);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(ois!=null) {
				ois.close();
			}
		}
	}
}
