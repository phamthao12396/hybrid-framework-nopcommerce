package javaBasic;

import java.util.Scanner;

public class Topic_11_String {

	public static void main(String[] args) {
		String text = "xpath=//div[contains(@class,'account-navigation')]//li[a[text()='Orders']]";
		String textID = "Id=Email";

		if (textID.startsWith("id") || textID.startsWith("Id")) {
			System.out.println(textID.substring(3));

		}

	}

	public void TC01_BT() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int countLower = 0;
		int countUpper = 0;
		int countNumber = 0;
		int countChar = 0;
		char arr[] = str.toCharArray();
		for (char item : arr) {
			if (item <= 'z' && item >= 'a') {
				countLower = countLower + 1;
			}
			if (item <= 'Z' && item >= 'A') {
				countUpper = countUpper + 1;
			}
			if (item <= '9' && item >= '0') {
				countNumber = countNumber + 1;
			}
			if (item == 'a') {
				countChar = countChar + 1;
			}

		}
		System.out.println(countLower);
		System.out.println(countUpper);
		System.out.println(countNumber);
		System.out.println("count a: " + countChar);
		System.out.println("is contains Testing: " + str.contains("Testing"));
		System.out.println("is start with Automation: " + str.startsWith("Automation"));
		System.out.println("is end with Online: " + str.endsWith("Online"));
		System.out.println("index of char Test: " + str.indexOf("Test"));
		System.out.println("replace: " + str.replace("Test", "Play"));
		System.out.println("length: " + str.length());
	}

	public void TC02_BT() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char arr[] = str.toCharArray();
		for (int i = arr.length; i > 0; i--) {
			System.out.print(arr[i - 1]);
		}
	}
}
