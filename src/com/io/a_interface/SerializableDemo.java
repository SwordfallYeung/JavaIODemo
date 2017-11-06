package com.io.a_interface;

import java.io.*;

import static com.io.a_interface.ObjectInputValidationDemo.serialize;
import static com.io.a_interface.ObjectInputValidationDemo.deserialize;

/**
 * @author y15079
 * @create 2017-09-28 15:33
 * @desc
 *
 * 如果你希望一个类对象是可序列化的，你所要做的是实现java.io.Serializable接口。
    序列化一种标记接口，不需要实现任何字段和方法，这就像是一种选择性加入的处理，通过它可以使类对象成为可序列化的对象。
 * 序列化处理是通过ObjectInputStream和ObjectOutputStream实现的，
   因此我们所要做的是基于它们进行一层封装，要么将其保存为文件，要么将其通过网络发送。
 *
 *这是一个简单的java bean，拥有一些属性以及getter-setter方法，如果你想要某个对象属性不被序列化成流，
 * 你可以使用transient关键字，正如示例中在salary变量上的做法那样。
 *
 * http://www.importnew.com/14465.html
 **/
public class SerializableDemo {

	public static class Employee implements Serializable{
		private String name;
		private int id;
		transient private int salary;

		@Override
		public String toString() {
			return "Employee{name="+name+",id="+id+",salary="+salary+"}";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}
	}

	public static void main(String[] args) {
		String fileName="D:\\IDEA\\JavaIODemo\\resources\\test.txt";
		Employee emp=new Employee();
		emp.setId(100);
		emp.setName("Pankaj");
		emp.setSalary(5000);

		try {
			serialize(emp,fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Employee empNew = null;
		try {
			empNew=(Employee) deserialize(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("emp Object::"+emp);
		System.out.println("empNew Object::"+empNew);
		//由于salary是一个transient变量，它的值不会被存入文件中，因此也不会在新的对象中被恢复。
		// 类似的，静态变量的值也不会被序列化，因为他们是属于类而非对象的
	}
}
