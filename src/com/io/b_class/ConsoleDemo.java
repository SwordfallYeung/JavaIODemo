package com.io.b_class;

import java.io.Console;

/**
 * @author y15079
 * @create 2017-10-30 11:45
 * @desc
 **/
public class ConsoleDemo {
	public static void main(String[] args) {
		//以下代码运行不了
		Console c=System.console();
		String username=c.readLine("User name:");
		c.printf("user:"+username+"\n");
		char []password=c.readPassword("Password");
		c.printf(String.valueOf(password));
	}
}
