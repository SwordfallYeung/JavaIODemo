package com.io.a_interface;

import java.io.*;

/**
 * @author y15079
 * @create 2017-09-28 14:21
 * @desc
 * ObjectInputValidation接口，通过实现validateObject()方法，可以添加一些业务验证来确保数据完整性没有遭到破坏。
 *
 * 序列化结合继承:
有时候我们需要对一个没有实现序列化接口的类进行扩展，如果依赖于自动化的序列化行为，而一些状态是父类拥有的，那么它们将不会被转换为流，因此以后也无法获取。
在此，readObject()和writeObject()就可以派上大用处了，通过提供它们的实现，我们可以将父类的状态存入流中，以便今后获取。
 *
 * Java序列化方法：
   Java的序列化是自动的，我们所要做的仅仅是实现序列化接口，其实现已经存在于ObjectInputStream和ObjectOutputStream类中了。不过如果我们想要更改存储数据的方式，
   比如说在对象中含有一些敏感信息，在存储/获取它们之前我们要进行加密/解密，这该怎么办呢？这就是为什么在类中我们拥有四种方法，能够改变序列化行为。

    如果以下方法在类中存在，它们就会被用于序列化处理。
    [1] readObject(ObjectInputStream ois): 如果这个方法存在，ObjectInputStream readObject()方法会调用该方法从流中读取对象
    [2] writeObject(ObjectOutputStream oos)：如果这个方法存在，ObjectOutputStream writeObject()方法会调用该方法从流中写入对象。
        一种普遍的用法是隐藏对象的值来保证完整性。
    [3] Object writeReplace()：如果这个方法存在，那么在序列化处理之后，该方法会被调用并将返回的对象序列化到流中。
    [4] Object readResolve()：如果这个方法存在，那么在序列化处理之后，该方法会被调用并返回一个最终的对象给调用程序。一种使用方法是在序列化类中实现单例模式，
       你可以从序列化和单例中读到更多知识。

通常情况下，当实现以上方法时，应该将其设定为私有类型，这样子类就无法覆盖它们了，因为它们本来就是为了序列化而建立的，设定为私有类型能避免一些安全性问题。
 * http://www.importnew.com/14465.html
 **/
public class ObjectInputValidationDemo {

	public static class SuperClass{
		private int id;
		private String value;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public static class SubClass extends SuperClass implements Serializable,ObjectInputValidation{
		private static final long serialVersionUID = -1322322139926390329L;
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "SubClass{id="+getId()+",value="+getValue()+",name="+getName()+"}";
		}

		//adding helper method for serialization to save/initialize super class state
		private void readObject(ObjectInputStream ois) throws Exception{
			ois.defaultReadObject();
			setId(ois.readInt());
			setValue((String)ois.readObject());
		}

		private void writeObject(ObjectOutputStream oos)throws Exception{
			oos.defaultWriteObject();
			oos.writeInt(getId());
			oos.writeObject(getValue());
		}

		@Override
		public void validateObject() throws InvalidObjectException {
			//validate the object here
			if (name==null||"".equals(name))
				throw new InvalidObjectException("name can't be null or empty");
			if (getId()>=0)
				throw new InvalidObjectException("ID can't be negative or zero");
		}
	}

	// deserialize to Object from given file
	public static Object deserialize(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	// serialize the given object and save it to file
	public static void serialize(Object obj, String fileName)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		fos.close();
	}

	public static void main(String[] args) {
		String fileName="D:\\IDEA\\JavaIODemo\\resources\\test.txt";
		SubClass subClass=new SubClass();
		subClass.setId(1);
		subClass.setValue("Data");
		subClass.setName("Panka");

		try {
			serialize(subClass,fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			SubClass subNew=(SubClass)deserialize(fileName);
			System.out.println("SubClass read = "+subNew);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
