package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class TOpic_06_For_ForEach {


	public void TC01_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		for(int i=1;i<=a;i++) {
			System.out.print(i+" ");
		}
	}

	public void TC02_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		for(int i=a;i<=b;i++) {
			System.out.print(i+" ");
		}
	}

	public void TC03_BT() {
//		Scanner sc = new Scanner(System.in);
//		int a =sc.nextInt();
//		int b =sc.nextInt();
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
			
		}
	}

	public void TC04_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		int tong=0;
		for(int i=a;i<=b;i++) {
			tong=tong+i;
		}
		
		System.out.println(tong);
	}
	

	public void TC05_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int tong=0;
		for(int i=0;i<=a;i++) {
			if(i%2!=0) {
				tong=tong+i;
			}
		}
		System.out.println(tong);
	}

	public void TC06_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		for(int i=a;i<=b;i++) {
			if(i%3==0) {
				System.out.print(i+" ");
			}
		}
		
	}
	@Test
	public void TC07_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int giaiThua=1;
		for(int i=1;i<=a;i++) {
			giaiThua=giaiThua*i;
		}
		System.out.println(giaiThua);
	}
	

}
