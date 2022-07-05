package javaBasic;

import org.testng.annotations.Test;

public class Topic_09_Array {

	public void TC01_BT() {
		int arr[] = { 2, 7, 6, 8, 9 };
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[0] < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}

	public void TC02_BT() {
		int arr[] = { 2, 7, 6, 8, 11 };
		System.out.println(arr[0] + arr[arr.length - 1]);
	}

	public void TC03_BT() {
		int arr[] = { 2, 7, 6, 8, 11, 15, 22, 24, 31 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
	}

	public void TC04_BT() {
		int arr[] = { 0, 2, 7, -5, 6, 8, 11, 15, 22, 24, 31 };
		int tong = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 && arr[i] > 0) {
				tong = tong + arr[i];
			}
		}
		System.out.println(tong);
	}

	public void TC05_BT() {
		int arr[] = { 0, 2, 7, -5, 6, 8, 11, 15, 22, 24, 31 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 10 && arr[i] >= 0) {
				System.out.println(arr[i]);
			}
		}

	}

	public void TC06_BT() {
		int arr[] = { 0, 2, 7, -5, 6, 8, 11, 15, 22, 24, 31, 44 };
		int tong = 0;
		for (int i = 0; i < arr.length; i++) {
			tong = tong + arr[i];
		}
		System.out.println(tong / (arr.length));

	}

}
