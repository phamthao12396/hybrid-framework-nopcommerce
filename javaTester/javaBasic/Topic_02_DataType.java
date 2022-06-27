package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_DataType {
	public static void main(String[] args) {
		byte a = 6, b = 2;
		byte p1 = (byte) (a + b);
		int p2 = a - b;
		int p3 = a * b;
		int p4 = a / b;
		System.out.println("a+b: " + p1);
		System.out.println("a-b: " + p2);
		System.out.println("a*b: " + p3);
		System.out.println("a/b: " + p4);
		a &= 3;
		System.out.println("a: " + a);

	}

	@Test
	public static void TC_02_BT2() {
		float length = 7.5f, width = 8.3f;
		float P = length * width;
		System.out.println("Area =" + P);
	}
	@Test
	public static void TC_03_BT3() {
		String name="Automation Testing";
		System.out.println("hello "+name);
	}

}
