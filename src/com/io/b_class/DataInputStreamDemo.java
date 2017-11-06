package com.io.b_class;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

/**
 * @author y15079
 * @create 2017-10-30 17:29
 * @desc
 *
 * DataInputStream和DataOutputStream是FilterInputStream和FilterOutputStream的子类，
 * 分别实现了DataInput和DataOutput接口，属于包装流（处理流），为被包装的流提供额外的功能。
 *
 * 它们所提供的额外功能是：直接从流中读写基本数据类型的数据
 *
 **/
public class DataInputStreamDemo {

	public static void main(String[] args) throws Exception{
		method();
	}

	//使用DataInputStream和DataOutputStream读写基本数据类型的数据
	public static void method() throws Exception{
		ByteArrayInputStream bais=null;
		ByteArrayOutputStream baos=null;
		DataInputStream dis=null;
		DataOutputStream dos=null;

		baos=new ByteArrayOutputStream();
		dos=new DataOutputStream(baos);
		dos.writeByte(1);
		dos.writeBytes("你");
		dos.writeShort(2);
		dos.writeInt(3);
		dos.writeLong(4L);
		dos.writeDouble(0.1F);
		dos.writeBoolean(true);
		dos.writeChar('你');//[96]  仅仅写入了'你'的后8位
		dos.writeChars("你");// [96, 79, 96]  把'你'分成2个字节全部写入流中


//		System.out.println(Arrays.toString(baos.toByteArray()));
		bais=new ByteArrayInputStream(baos.toByteArray());
		dis=new DataInputStream(bais);
		//1 2 3 4 0.1 0.2 true 你
		System.out.println(dis.readByte()+" "+dis.readShort()+" "+dis.readInt()+" "
				+" "+dis.readDouble()+" "
				+dis.readBoolean()+" "+dis.readChar()+" "
				+dis.readLong()+" ");

		if (bais!=null){
			bais.close();
		}
		if (baos!=null){
			baos.close();
		}
		if (dis!=null){
			dis.close();
		}
		if (dos!=null){
			dos.close();
		}
	}
}
