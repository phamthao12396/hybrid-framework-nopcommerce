package javaBasic;

import java.util.Scanner;

public class Topic_10_Array_Obj {

	String name;
	int age;
	float score;

	public Topic_10_Array_Obj(String name, int age, float score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Score: " + score);
	}

	public static void main(String[] args) {
		Topic_10_Array_Obj[] students = new Topic_10_Array_Obj[3];
		Scanner sc = new Scanner(System.in);
		String name1 = sc.nextLine();
		int a = sc.nextInt();
		float x = sc.nextFloat();
		students[0] = new Topic_10_Array_Obj(name1, a, x);
		students[1] = new Topic_10_Array_Obj("Dung", 34, 9.5f);
		students[2] = new Topic_10_Array_Obj("An", 35, 9.7f);
		for (int i = 0; i < 3; i++) {
			students[i].display();
		}
	}

}
