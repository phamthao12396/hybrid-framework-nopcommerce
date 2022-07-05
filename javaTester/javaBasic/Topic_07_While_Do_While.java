package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_While_Do_While {

	public void TC01_BT() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		while (a < 100) {

			if (a % 2 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	public void TC02_BT() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		while (a < b) {
			if ((a % 3 == 0) && (a % 5 == 0)) {
				System.out.println(a);
			}
			a++;
		}
	}

	public void TC03_BT() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int n = 0;
		int tong = 0;
		while (n <= a) {
			if (n % 2 != 0) {
				tong = tong + n;
			}
			n++;
		}
		System.out.println(tong);
	}

	public void TC04_BT() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		while (a <= b) {
			if (a % 3 == 0) {
				System.out.println(a);
			}
			a++;
		}

	}

	public void TC05_BT() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int i = 1;
		int giaithua = 1;
		while (i <= a) {
			giaithua = giaithua * i;
			i++;
		}
		System.out.println(giaithua);

	}

	@Test
	public void TC06_BT() {
		int i = 1;
		while (i <= 10) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}

	}
}
