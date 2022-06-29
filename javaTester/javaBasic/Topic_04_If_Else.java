package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_If_Else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static void TC_01_BT1() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("nhap n:");
		int a = scanner.nextInt();
		if(a/2==0) {
			System.out.println("n la so chan");
		}
		else {
			System.out.println("n la so le");
		}
	}

	public static void TC_02_BT2() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("nhap a:");
		int a = scanner.nextInt();
		System.out.println("nhap b:");
		int b= scanner.nextInt();
		if(a>=b) {
			System.out.println("a lon hon hoac bang b");
		}else {
			System.out.println("a nho hon b");
			
		}
	}

	public static void TC_03_BT3() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("nhap a:");
		String a = scanner.nextLine();
		System.out.println("nhap b:");
		String b = scanner.nextLine();
		if(a.equalsIgnoreCase(b)) {
			System.out.println("2 nguoi cung ten");
		}else {
			System.out.println("2 nguoi khac ten");
			
		}
	}

	public static void TC_04_BT4() {
		Scanner scanner =new Scanner(System.in);
		int a = scanner.nextInt();
		int c = scanner.nextInt();
		int b = scanner.nextInt();
		if((a>b)&&(a>c)) {
			System.out.println("a lon nhat");
		}else if(b>c) {
			System.out.println("b lon nhat");
			
		}else {
			System.out.println("c lon nhat");
		}
	}

	public static void TC_05_BT5() {
		Scanner scanner =new Scanner(System.in);
		int a = scanner.nextInt();
		if((a>=10)&&(a<=100)) {
			System.out.println(a+" nam trong[10,100]");
		}else {
			System.out.println(a+" khong nam trong[10,100]");
		}
	}

	public static void TC_06_BT6() {
		Scanner scanner =new Scanner(System.in);
		float a = scanner.nextFloat();
		if((a>=0)&&(a<5)) {
			System.out.println("diem D");
		}else if ((a>=5)&&(a<7.5)){
			System.out.println("diem C");
		}else if ((a>=7.5)&&(a<8.5)){
			System.out.println("diem B");
		}else if ((a>=8.5)&&(a<=10)){
			System.out.println("diem A");
		}else {
			System.out.println("diem khong hop le");
		}
	}

	public static void TC_07_BT7() {
		Scanner scanner =new Scanner(System.in);
		int a = scanner.nextInt();
		if(a==1||a==3||a==5||a==7||a==8||a==10||a==12) {
			System.out.println("thang" +a + "cos 31 ngay");
		}else if (a==2){
			System.out.println("thang" +a + "co 28/ 29 ngay");
		}else if (a==4||a==6||a==9||a==11){
			System.out.println("thang" +a + "co 30 ngay");
		}else {
			System.out.println("nhap sai thang");
		}
	}
	
}
