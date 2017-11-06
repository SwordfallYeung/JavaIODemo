package com.io.b_class;

import java.io.File;
import java.io.FilePermission;
import java.security.PermissionCollection;

/**
 * @author y15079
 * @create 2017-11-02 18:53
 * @desc  文件权限
 **/
public class FilePermissionDemo {
	public static void main(String[] args) {
//		equals();
		getActions();
	}

	public static void equals(){
		FilePermission fp=null;
		FilePermission fp1=null;
		FilePermission fp2=null;
		FilePermission fp3=null;
		boolean bool=false;

		//create new file permissions
		fp=new FilePermission("resources/file.txt","read");
		fp1=new FilePermission("resources/file1.txt","read");
		fp2=new FilePermission("resources/file.txt","write");
		fp3=new FilePermission("resources/file.txt","read");

		//checks two file permission objects for equality
		bool=fp.equals(fp1);

		//prints
		System.out.println(bool);

		//checks two file permission objects for equality
		bool=fp.equals(fp2);

		//prints
		System.out.println(bool);

		//checks two file permission objects for equality
		bool=fp.equals(fp3);

		//prints
		System.out.print(bool);
	}

	//获取权限
	public static void getActions(){
		FilePermission fp=null;

		//create new file permissions
		fp=new FilePermission("resources/file.txt","read");

		//the canonical string representation of the action
		String s=fp.getActions();

		//prints
		System.out.println("Action: "+s);
	}

	//是否包含
	public static void implies(){
		FilePermission fp=null;
		FilePermission fp1=null;
		FilePermission fp2=null;
		FilePermission fp3=null;

		boolean bool=false;

		//create new file permission
		fp=new FilePermission("resources/file.txt","read");
		fp1=new FilePermission("resources/file.txt","write");
		fp2=new FilePermission("resources/file1.txt","read");
		fp3=new FilePermission("resources/file.txt","read");

		//tests if implied by this object
		bool=fp.implies(fp1);

		//print
		System.out.println(bool);

		bool=fp.implies(fp2);
		System.out.println(bool);

		bool=fp.implies(fp3);
		System.out.println(bool);
	}

	//权限集合
	public static void PermissionCollection(){
		FilePermission fp=null;
		PermissionCollection pc = null;

		//create new file permissions
		fp = new FilePermission("resources/file.txt", "read");

		// create new permission collection
		pc = fp.newPermissionCollection();

		// add permission to the permission collection
		pc.add(fp);

		if(pc.implies(new FilePermission("resources/file.txt", "read"))) {
			System.out.println("Permission for \"file.txt\" is read");
		}
	}
}
