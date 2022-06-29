package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_05_Swith_Case {


	public void TC_01_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
			
		default:
			System.out.println("so vua nhap khong nam trong khoang [1,10]");
			break;
		}
	}


	public void TC_02_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		int b =sc.nextInt();
		sc.nextLine();
		String toanTu =sc.nextLine();
		switch (toanTu) {
		case "+":
			System.out.println("Tong: "+ (a+b));
			break;
		case "-":
			System.out.println("Hieu: "+ (a-b));
			break;
		case "*":
			System.out.println("tich: "+ (a*b));
			break;
		case "/":
			System.out.println("chia lay nguyen: "+ (a/b));
			break;
		case "%":
			System.out.println("chia lay du: "+ (a%b));
			break;
		default:
			System.out.println("khong dung dinh dang toan tu");
			break;
		}
	}
	
	@Test
	public void TC_03_BT() {
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		switch (a) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("thang "+a+" co 31 ngay");
			break;
		case 2:
			System.out.println("thang "+a+" co 28 -29 ngay");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("thang "+a+" co 30 ngay");
			break;
		default:
			System.out.println("thang nhap khong hop le");
			break;
		}
		}
}
