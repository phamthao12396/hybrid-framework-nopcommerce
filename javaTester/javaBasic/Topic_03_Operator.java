package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_03_Operator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Age is: ");
		int age = scanner.nextInt();
		System.out.println("name is: ");
		String name = scanner.nextLine();
		

		
		System.out.println("After 15 years, age of "+name + " will be "+(age +15));
	}

	@Test
	public static void TC_02_BT1() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("nhap a:");
		int a = scanner.nextInt();
		System.out.println("nhap b:");
		int b= scanner.nextInt();
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Sau khi hoan doi, gia trij cua a la:"+ a+" b la:"+b);
	}
	@Test
	public static void TC_03_BT2() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("nhap a:");
		int a = scanner.nextInt();
		System.out.println("nhap b:");
		int b= scanner.nextInt();
		boolean result = (a>=b)? true : false;
		System.out.println(result);
	}

}
